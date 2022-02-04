package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.nohorang.suryongfootprint.SettingActivity
import kr.co.nohorang.suryongfootprint.databinding.ActivityMypageMydetailBinding

class MypageMydetailActivity : AppCompatActivity() {
    val binding by lazy { ActivityMypageMydetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 툴바 뒤로가기 버튼 - 액티비티 종료
        binding.backBtn.setOnClickListener {
            finish()
        }
        //수정하기 버튼
        binding.confirm.setOnClickListener() {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            //글 수정하기
        }

        //삭제하기 버튼
        binding.delete.setOnClickListener() {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            //글 삭제하기
        }
    }
}