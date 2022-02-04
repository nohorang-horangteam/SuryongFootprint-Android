package kr.co.nohorang.suryongfootprint

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kr.co.nohorang.suryongfootprint.data.Challenge
import kr.co.nohorang.suryongfootprint.data.Post
import kr.co.nohorang.suryongfootprint.data.PostCreationDTO
import kr.co.nohorang.suryongfootprint.data.User
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
                    var all_challenges : List<Challenge>? = arrayListOf<Challenge>()
                    all_challenges = response.body()
                    Log.d("GET_CH_T", "response : " + all_challenges?.toString())
                }

                //request, response 실패
                override fun onFailure(call: Call<List<Challenge>>, t: Throwable) {
                    t.message?.let { Log.e("GET_CH_F", it) }
                }
            })

        }

        // 챌린지 참여하기(포스트 올리기) 테스트
        binding.uploadPostBtn.setOnClickListener {
            //이미지 형식 Blob으로 되어있음. (data/Post.kt 참고)
            var p_dto = PostCreationDTO("","","","","")

            //response로 가져올 data 선언
            var responsePost: Post?=null

            //Retrofit 통신 - getChallenges
            RetrofitBuilder.challenge_api.createPost(p_dto).enqueue(object : Callback<Post> {
                //request, response 정상 수행
                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    //업로드한 Post 정보
                    responsePost=response.body()
                    Log.d("CREATE_POST_T", "response : " + responsePost?.toString())
                }

                //request, response 실패
                override fun onFailure(call: Call<Post>, t: Throwable) {
                    t.message?.let { Log.e("CREATE_POST_F", it) }
                }
            })

        }
    }
}