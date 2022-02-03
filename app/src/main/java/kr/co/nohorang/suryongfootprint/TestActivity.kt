package kr.co.nohorang.suryongfootprint;
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.nohorang.suryongfootprint.data.LoginRequestDTO
import kr.co.nohorang.suryongfootprint.data.User
import kr.co.nohorang.suryongfootprint.databinding.ActivityTestBinding
import kr.co.nohorang.suryongfootprint.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//api test
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 회원가입 테스트
        binding.SignupTestBtn.setOnClickListener {
            //request로 전송할(회원가입할) user 정보 받아오기
            var newUser = User("test_id123", "abcd123@gmail.com", "1234123@", "coco", "coconut")

            //response로 가져올 data 선언
            var responseUser: User?=null

            //Retrofit 통신 - createUser
            RetrofitBuilder.api.createUser(newUser).enqueue(object : Callback<User> {
                //request, response 정상 수행
                override fun onResponse(call : Call<User>, response: Response<User>){
                    responseUser=response.body()
                    Log.d("SIGNUP_T","response : "+responseUser?.toString())
                    Log.d("SIGNUP_T","New user_id : "+responseUser?.user_id)
                    Log.d("SIGNUP_T","New user_pw : "+responseUser?.user_pw)
                }
                //request, response 실패
                override fun onFailure(call : Call<User>, t: Throwable) {
                    t.message?.let { Log.e("SIGNUP_F", it) }
                }
            })

        }

        // 로그인 테스트
        binding.LoginTestBtn.setOnClickListener{
            //request로 전송할(회원가입할) user 정보 받아오기
            var loginInfo = LoginRequestDTO("test_id123", "1234123@")

            //response로 가져올 data 선언
            var responseUser: User?=null

            //Retrofit 통신 - doLogin
            RetrofitBuilder.api.doLogin(loginInfo).enqueue(object : Callback<User> {
                // 통신 성공
                override fun onResponse(call : Call<User>, response: Response<User>){
                    responseUser=response.body()
                    if (responseUser!=null) { //로그인 성공
                        Log.d("LOGIN_T", "Login user : " + responseUser?.user_id)
                        Log.d("LOGIN_T", "Login user : " + responseUser?.user_pw)
                    }
                    else
                        Log.d("LOGIN_T","no user defined")
                }
                // 통신 오류
                override fun onFailure(call : Call<User>, t: Throwable) {
                    t.message?.let { Log.e("LOGIN_F", it) }
                }
            })
        }

        //닉네임 변경
        binding.updateNicknameTestBtn.setOnClickListener {
            //user id와 변경할 닉네임 정보 받아오기
            var newNickUser = User("test_id123", "", "", "", "coconut")
            var user_id = "test_id123"
            //response로 가져올 data 선언
            var responseUser: User?=null

            //Retrofit 통신 - updateNickname
            RetrofitBuilder.api.updateNickname(user_id,newNickUser).enqueue(object : Callback<User> {
                //request, response 정상 수행
                override fun onResponse(call : Call<User>, response: Response<User>){
                    responseUser=response.body()
                    Log.d("UPDATE_NICKNAME_T","response : "+responseUser?.toString())
                    Log.d("UPDATE_NICKNAME_T","user_id : "+responseUser?.user_id)
                    Log.d("UPDATE_NICKNAME_T","New user_nickname : "+responseUser?.user_nickname)
                }
                //request, response 실패
                override fun onFailure(call : Call<User>, t: Throwable) {
                    t.message?.let { Log.e("UPDATE_NICKNAME_F", it) }
                }
            })

        }

        //비밀번호 변경
        binding.updatePasswordTestBtn.setOnClickListener {
            //user id와 변경할 pw 정보 받아오기
            var newNickUser = User("test_id123", "", "1234", "", "")
            var user_id = "test_id123"
            //response로 가져올 data 선언
            var responseUser: User?=null

            //Retrofit 통신 - updatePw
            RetrofitBuilder.api.updatePW(user_id,newNickUser).enqueue(object : Callback<User> {
                //request, response 정상 수행
                override fun onResponse(call : Call<User>, response: Response<User>){
                    responseUser=response.body()
                    Log.d("UPDATE_PASSWORD_T","response : "+responseUser?.toString())
                    Log.d("UPDATE_PASSWORD_T","user_id : "+responseUser?.user_id)
                    Log.d("UPDATE_PASSWORD_T","New user_pw : "+responseUser?.user_pw)
                }
                //request, response 실패
                override fun onFailure(call : Call<User>, t: Throwable) {
                    t.message?.let { Log.e("UPDATE_PASSWORD_F", it) }
                }
            })

        }
    }
}