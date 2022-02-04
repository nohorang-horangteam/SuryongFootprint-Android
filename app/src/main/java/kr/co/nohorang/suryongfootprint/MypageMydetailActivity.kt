package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.co.nohorang.suryongfootprint.SettingActivity
import kr.co.nohorang.suryongfootprint.databinding.ActivityMypageMydetailBinding

class MypageMydetailActivity : AppCompatActivity() {
    val binding by lazy { ActivityMypageMydetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //날짜불러오기

        // 툴바 뒤로가기 버튼 - 액티비티 종료
        binding.backBtn.setOnClickListener {
            finish()
        }
        //수정하기 버튼
        binding.confirm.setOnClickListener() {
            //수정페이지로
            val intent = Intent(this, MypageEditActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }

        //삭제하기 버튼
        binding.delete.setOnClickListener() {
            Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
            //서버에서 글 삭제
        }
    }
}