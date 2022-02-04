package kr.co.nohorang.suryongfootprint

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
                    override fun onResponse(
                        call: Call<List<Challenge>>,
                        response: Response<List<Challenge>>
                    ) {
                        // 리스트의 challengeNum 번째 객체 선택)
                        var challengeNum = 0

                        // 전체 챌린지 받아오기
                        var all_challenges: List<Challenge>? = arrayListOf<Challenge>()
                        all_challenges = response.body()
                        // 챌린지 속성값 받아오기
                        val challengeId = all_challenges?.get(challengeNum)?.challenge_id
                        val title = all_challenges?.get(challengeNum)?.title
                        val info = all_challenges?.get(challengeNum)?.info
                        val condition = all_challenges?.get(challengeNum)?.condition
                        val participants = all_challenges?.get(challengeNum)?.participants

                        // 로그 테스트
                        Log.d("GET_CH_T", "response : " + all_challenges?.toString())
                        Log.d("GET_CH_T", " challenge_id : " + challengeId.toString())
                        Log.d("GET_CH_T", " title : " + title)
                        Log.d("GET_CH_T", " info : " + info)
                        Log.d("GET_CH_T", " condition : " + condition.toString())
                        Log.d("GET_CH_T", " participants : " + participants.toString())
                    }

                    //request, response 실패
                    override fun onFailure(call: Call<List<Challenge>>, t: Throwable) {
                        t.message?.let { Log.e("GET_CH_F", it)
                        Log.d("GET_CH_T", "챌린지 정보 가져오기 실패")
                        }
                    }
                })
        }

//        // 챌린지 참여하기(포스트 올리기) 테스트
//        binding.uploadPostBtn.setOnClickListener {
//            //이미지 형식 Blob으로 되어있음. (data/Post.kt 참고)
//            var p_dto = PostCreationDTO("","","","","")
//
//            //response로 가져올 data 선언
//            var responsePost: Post?=null
//
//            //Retrofit 통신 - getChallenges
//            RetrofitBuilder.challenge_api.createPost(p_dto).enqueue(object : Callback<Post> {
//                //request, response 정상 수행
//                override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                    //업로드한 Post 정보
//                    responsePost=response.body()
//                    Log.d("CREATE_POST_T", "response : " + responsePost?.toString())
//                }
//
//                //request, response 실패
//                override fun onFailure(call: Call<Post>, t: Throwable) {
//                    t.message?.let { Log.e("CREATE_POST_F", it) }
//                }
//            })
//
//        }
    }
}