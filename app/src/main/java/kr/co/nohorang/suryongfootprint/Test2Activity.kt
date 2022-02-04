package kr.co.nohorang.suryongfootprint

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.nohorang.suryongfootprint.data.Challenge
import kr.co.nohorang.suryongfootprint.databinding.ActivityTest2Binding
import kr.co.nohorang.suryongfootprint.databinding.ActivityTestBinding
import kr.co.nohorang.suryongfootprint.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전체 챌린지 받아오기 테스트
        binding.getChallengeBtn.setOnClickListener {

            //Retrofit 통신 - getChallenges
            RetrofitBuilder.challenge_api.getChallenges().enqueue(object : Callback<List<Challenge>> {
                //request, response 정상 수행
                override fun onResponse(call: Call<List<Challenge>>, response: Response<List<Challenge>>) {
                    //전체 챌린지 받아오기
                    var all_challenges : List<Challenge> = arrayListOf<Challenge>()
                    all_challenges = response.body()
                    Log.d("GET_CH_T", "response : " + all_challenges?.toString())
                }

                //request, response 실패
                override fun onFailure(call: Call<List<Challenge>>, t: Throwable) {
                    t.message?.let { Log.e("GET_CH_F", it) }
                }
            })

        }
    }
}