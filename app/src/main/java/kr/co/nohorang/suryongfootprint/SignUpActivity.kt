package kr.co.nohorang.suryongfootprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import kr.co.nohorang.suryongfootprint.data.User
import kr.co.nohorang.suryongfootprint.databinding.ActivitySignUpBinding
import kr.co.nohorang.suryongfootprint.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy {ActivitySignUpBinding.inflate(layoutInflater)}
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 회원가입 테스트

        binding.signupBtn.setOnClickListener {
            //request로 전송할(회원가입할) user 정보 받아오기(id, email, pw, name, nickname)
            var newUser = User(binding.signupIdText.text.toString(), binding.signupEmailText.text.toString(), binding.signupPasswordText.text.toString(), binding.signupNameText.text.toString(), binding.signupNicknameText.text.toString())

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

    }
}