package kr.co.nohorang.suryongfootprint

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import kr.co.nohorang.suryongfootprint.data.User
import kr.co.nohorang.suryongfootprint.databinding.ActivityChangeNicknameBinding
import kr.co.nohorang.suryongfootprint.databinding.ActivityChangePasswordBinding
import kr.co.nohorang.suryongfootprint.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePasswordActivity : AppCompatActivity() {
    // 비밀번호 확인 여부
    var isOldFine: Boolean = false
    var isNewFine: Boolean = false
    var isPasswordFine: Boolean = false

    val binding by lazy { ActivityChangePasswordBinding.inflate(layoutInflater) }
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

        // 기존 비밀번호 확인 버튼 클릭
        binding.confirmBtn1.setOnClickListener {
            binding.oldStateText.visibility = View.VISIBLE

//            // 잘못된 입력인 경우
//            binding.oldStateText.text = "잘못된 비밀번호입니다."
//            binding.oldStateText.setTextColor(Color.parseColor("#ED5555"))
//            isOldFine = false

            // 올바른 입력인 경우
            binding.oldStateText.text = "사용 가능한 닉네임입니다."
            binding.oldStateText.setTextColor(Color.parseColor("#ACC236"))
            isOldFine = true
            if (isOldFine && isNewFine) {
                binding.pwdChangeBtn.isEnabled = true
                binding.pwdChangeBtn.setBackgroundColor(Color.parseColor("#537BC4"))
            }
        }

        // 새 비밀번호 확인 버튼 클릭
        binding.confirmBtn2.setOnClickListener {
            binding.newStateText.visibility = View.VISIBLE

            if (binding.newPwdEdit1.text.toString() != binding.newPwdEdit2.text.toString()) {
                // 잘못된 입력인 경우
                binding.newStateText.text = "잘못된 비밀번호입니다."
                binding.newStateText.setTextColor(Color.parseColor("#ED5555"))
                isNewFine = false
            } else {
                // 올바른 입력인 경우
                binding.newStateText.text = "사용 가능한 닉네임입니다."
                binding.newStateText.setTextColor(Color.parseColor("#ACC236"))
                isNewFine = true
            }
            if (isOldFine && isNewFine) {
                binding.pwdChangeBtn.isEnabled = true
                binding.pwdChangeBtn.setBackgroundColor(Color.parseColor("#537BC4"))
            }
        }

        // 확인 버튼 클릭 - 닉네임 변경 (+ 중복 확인 여부)
        binding.pwdChangeBtn.setOnClickListener {
            //user id와 변경할 pw 정보 받아오기
            val userIdData = "Name"
            val userPwdData = binding.newPwdEdit1.text.toString()
            var newNickUser = User(userIdData, "", userPwdData, "", "")

            //response로 가져올 data 선언
            var responseUser: User? = null

            //Retrofit 통신 - updatePw
            RetrofitBuilder.api.updatePW(userIdData, newNickUser).enqueue(object : Callback<User> {
                //request, response 정상 수행
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    responseUser = response.body()
                    Log.d("UPDATE_PASSWORD_T", "response : " + responseUser?.toString())
                    Log.d("UPDATE_PASSWORD_T", "user_id : " + responseUser?.user_id)
                    Log.d("UPDATE_PASSWORD_T", "New user_pw : " + responseUser?.user_pw)
                }

                //request, response 실패
                override fun onFailure(call: Call<User>, t: Throwable) {
                    t.message?.let { Log.e("UPDATE_PASSWORD_F", it) }
                }
            })
        }
    }

    // 키보드 비활성화 함수
    fun hideKeyboard() {
        val editText1 = binding.oldPwdEdit
        val editText2 = binding.newPwdEdit1
        val editText3 = binding.newPwdEdit2
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText1.windowToken, 0)
        imm.hideSoftInputFromWindow(editText2.windowToken, 0)
        imm.hideSoftInputFromWindow(editText3.windowToken, 0)
    }
}