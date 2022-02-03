package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kr.co.nohorang.suryongfootprint.data.LoginRequestDTO
import kr.co.nohorang.suryongfootprint.data.User
import kr.co.nohorang.suryongfootprint.databinding.ActivityLoginBinding
import kr.co.nohorang.suryongfootprint.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy { ActivityLoginBinding.inflate(layoutInflater)}
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 로그인 테스트
        binding.loginBtn.setOnClickListener{
            //request로 전송할(회원가입할) user 정보 받아오기(id, password)
            var id=binding.loginIdText.text.toString()
            var pwd=binding.loginPasswordText.text.toString()
            id=id.trim()
            pwd=pwd.trim()
            if(!id.isEmpty()&&!pwd.isEmpty())
            {
                var loginInfo = LoginRequestDTO(id, pwd)

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
                        else {
                            Log.d("LOGIN_T", "no user defined")
                            Toast.makeText(this@loginActivity, "Hello World!", Toast.LENGTH_LONG).show()
                        }
                    }
                    // 통신 오류
                    override fun onFailure(call : Call<User>, t: Throwable) {
                        t.message?.let { Log.e("LOGIN_F", it) }
                    }
                })
            }
            else{
                Toast.makeText(this@loginActivity, "Hello World!", Toast.LENGTH_LONG).show()
            }

        }
        binding.loginFindIdBtn.setOnClickListener{
            Log.d("clicktest", "click findid suc")
            val intent= Intent(this, FindIdActivity::class.java)
            startActivity(intent)
        }
        binding.loginFindPasswordBtn.setOnClickListener{
            Log.d("clicktest", "click findpassword suc")
            val intent=Intent(this,FindPasswordActivity::class.java)
            startActivity(intent)
        }
        binding.loginSignupBtn.setOnClickListener{
            Log.d("clicktest", "click signup suc")
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}