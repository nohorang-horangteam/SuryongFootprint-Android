package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.co.nohorang.suryongfootprint.SettingActivity
import kr.co.nohorang.suryongfootprint.databinding.ActivityMainBinding
import kr.co.nohorang.suryongfootprint.databinding.ActivityMypageEditBinding

class MypageEditActivity : AppCompatActivity() {
    val binding by lazy { ActivityMypageEditBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val current_user_id=intent.getStringExtra("current_user_id")
        Toast.makeText(this,"유저 아이디"+current_user_id,Toast.LENGTH_LONG).show()
        //확인버튼
        binding.confirmBtn.setOnClickListener() {
            val intent = Intent(this, SettingActivity::class.java)
            intent.putExtra("current_user_id", current_user_id)
            startActivity(intent)

            //글 저장하기
        }
    }
}