package kr.co.nohorang.suryongfootprint

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kr.co.nohorang.suryongfootprint.data.User
import kr.co.nohorang.suryongfootprint.databinding.ActivitySignUpBinding
import kr.co.nohorang.suryongfootprint.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    var isNicknameFine: Boolean = false
    var isIdfine: Boolean = false
    var isEmailFine: Boolean = false
    var isPasswordFine: Boolean = false

    val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 툴바 뒤로가기 버튼 - 액티비티 종료
        binding.backBtn.setOnClickListener {
            finish()
        }

        // EditText 입력 중 외부 터치 시 키보드 내리기
        binding.layout.setOnClickListener {
            hideKeyboard()
        }

        // 닉네임 중복 확인 버튼
        binding.nicknameCheckBtn.setOnClickListener {
            binding.nicknameCheckText.visibility = View.VISIBLE
            // 중복인 경우
//            binding.nicknameCheckText.setTextColor(Color.parseColor("#ED5555"))
//            binding.nicknameCheckText.text = "중복된 닉네임입니다."

            // 중복이 아닌 경우
            binding.nicknameCheckText.setTextColor(Color.parseColor("#ACC236"))
            binding.nicknameCheckText.text = "사용 가능한 닉네임입니다."
            isNicknameFine = true
        }

        // 아이디 중복 확인 버튼
        binding.idCheckBtn.setOnClickListener {
            binding.idCheckText.visibility = View.VISIBLE
            // 중복인 경우
//            binding.idCheckText.setTextColor(Color.parseColor("#ED5555"))
//            binding.idCheckText.text = "중복된 아이디입니다."

            // 중복이 아닌 경우
            binding.idCheckText.setTextColor(Color.parseColor("#ACC236"))
            binding.idCheckText.text = "사용 가능한 아이디입니다."
            isIdfine = true
        }

        // 이메일 중복 확인 버튼
        binding.emailCheckBtn.setOnClickListener {
            binding.emailCheckText.visibility = View.VISIBLE
            // 중복인 경우
//            binding.emailCheckText.setTextColor(Color.parseColor("#ED5555"))
//            binding.emailCheckText.text = "중복된 이메일입니다."

            // 중복이 아닌 경우
            binding.emailCheckText.setTextColor(Color.parseColor("#ACC236"))
            binding.emailCheckText.text = "사용 가능한 이메일입니다."
            isEmailFine = true
        }

        // 회원가입 테스트
        binding.signupBtn.setOnClickListener {
            //request로 전송할(회원가입할) user 정보 받아오기(id, email, pw, name, nickname)
            var id = binding.signupIdText.text.toString().trim()
            var email = binding.signupEmailText.text.toString().trim()
            var pw = binding.signupPasswordText.text.toString().trim()
            var name = binding.signupNameText.text.toString().trim()
            var nickname = binding.signupNicknameText.text.toString().trim()
            if (!id.isEmpty() && !email.isEmpty() && !pw.isEmpty() && !name.isEmpty() && !nickname.isEmpty())//회원가입 시도
            {
                isPasswordFine = binding.signupPasswordText.text.toString() == binding.signupRePasswordText.text.toString()
                if (isNicknameFine && isIdfine && isEmailFine && isPasswordFine) {
                    var newUser = User(id, email, pw, name, nickname)

                    //response로 가져올 data 선언
                    var responseUser: User? = null

                    //Retrofit 통신 - createUser
                    RetrofitBuilder.api.createUser(newUser).enqueue(object : Callback<User> {
                        //request, response 정상 수행
                        override fun onResponse(call: Call<User>, response: Response<User>) {
                            responseUser = response.body()
                            Log.d("SIGNUP_T", "response : " + responseUser?.toString())
                            Log.d("SIGNUP_T", "New user_id : " + responseUser?.user_id)
                            Log.d("SIGNUP_T", "New user_pw : " + responseUser?.user_pw)

                            Toast.makeText(this@SignUpActivity, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                            finish()
                        }

                        //request, response 실패
                        override fun onFailure(call: Call<User>, t: Throwable) {
                            t.message?.let { Log.e("SIGNUP_F", it) }
                            Toast.makeText(this@SignUpActivity, "오류가 발생하였습니다.", Toast.LENGTH_SHORT).show()
                        }
                    })
                } else {
                    Toast.makeText(this, "사용할 수 없는 항목이 있습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "모든 항목을 작성해주세요.", Toast.LENGTH_SHORT).show()
            }

        }

    }

    // 키보드 비활성화 함수
    fun hideKeyboard() {
        val editText1 = binding.signupNicknameText
        val editText2 = binding.signupIdText
        val editText3 = binding.signupEmailText
        val editText4 = binding.signupNameText
        val editText5 = binding.signupPasswordText
        val editText6 = binding.signupRePasswordText
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText1.windowToken, 0)
        imm.hideSoftInputFromWindow(editText2.windowToken, 0)
        imm.hideSoftInputFromWindow(editText3.windowToken, 0)
        imm.hideSoftInputFromWindow(editText4.windowToken, 0)
        imm.hideSoftInputFromWindow(editText5.windowToken, 0)
        imm.hideSoftInputFromWindow(editText6.windowToken, 0)
    }
}