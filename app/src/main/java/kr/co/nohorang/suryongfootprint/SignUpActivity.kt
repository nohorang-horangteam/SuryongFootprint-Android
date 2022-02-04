package kr.co.nohorang.suryongfootprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
        var nicknameCheck=0//중복확인 버튼 변수
        var idCheck=0
        var emailCheck=0

        binding.signupNicknameText.addTextChangedListener { //editText에 글자가 입력되면 중복확인 변수 0으로 초기화
            nicknameCheck=0
            binding.nicknameCheckResult.setText("중복 확인을 해주세요")
        }
        binding.signupIdText.addTextChangedListener {
            idCheck=0
            binding.idCheckResult.setText("중복 확인을 해주세요")
        }
        binding.signupEmailText.addTextChangedListener {
            emailCheck=0
            binding.emailCheckResult.setText("중복 확인을 해주세요")
        }


        binding.nicknameCheckBtn.setOnClickListener { //중복 확인 버튼 누를 시 쿼리문 실행, 결과에 따라 CheckResult 문장 변화, 색
            //쿼리문
            nicknameCheck=1
            binding.nicknameCheckResult.setText("사용 가능한 닉네임입니다.")
        }
        binding.idCheckBtn.setOnClickListener { //중복 확인 버튼 누를 시 쿼리문 실행
            //쿼리문
            idCheck=1
            binding.idCheckResult.setText("사용 가능한 아이디입니다.")
        }
        binding.emailCheckBtn.setOnClickListener { //중복 확인 버튼 누를 시 쿼리문 실행
            //쿼리문
            emailCheck=1
            binding.emailCheckResult.setText("사용 가능한 이메일입니다.")
        }


        binding.signupBtn.setOnClickListener {
            //request로 전송할(회원가입할) user 정보 받아오기(id, email, pw, name, nickname)
            var id=binding.signupIdText.text.toString().trim()
            var email=binding.signupEmailText.text.toString().trim()
            var pw=binding.signupPasswordText.text.toString().trim()
            var repw=binding.signupRePasswordText.toString().trim()
            var name=binding.signupNameText.text.toString().trim()
            var nickname= binding.signupNicknameText.text.toString().trim()
            if(!id.isEmpty()&&!email.isEmpty()&&!pw.isEmpty()&&!name.isEmpty()&&!nickname.isEmpty())//모든 항목 작성
            {
                if(nicknameCheck==1&&idCheck==1&&emailCheck==1)//중복 확인 완료
                {
                    if(pw==repw)//비밀번호 같은지 확인
                    {
                        var newUser = User(id, email, pw, name, nickname)

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
                    else{//비밀번호 다른 경우
                        Toast.makeText(this,"비밀번호를 다시 입력해주세요.",Toast.LENGTH_LONG).show()
                    }
                }
                else{//중복 확인 안됨
                    Toast.makeText(this,"중복 확인을 해주세요.",Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this,"모든 항목을 작성해주세요.",Toast.LENGTH_LONG).show()
            }

        }

    }
}