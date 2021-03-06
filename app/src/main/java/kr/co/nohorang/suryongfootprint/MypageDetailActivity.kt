package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.co.nohorang.suryongfootprint.databinding.ActivityMypageDetailBinding
import java.text.SimpleDateFormat

class MypageDetailActivity : AppCompatActivity() {
    val binding by lazy { ActivityMypageDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val current_user_id=intent.getStringExtra("current_user_id")


        //날짜불러오기
        val date = binding.toolbarTitle.text
        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(date)
        binding.toolbarTitle.text = formattedDate


        // 툴바 뒤로가기 버튼 - 액티비티 종료
        binding.backBtn.setOnClickListener {
            finish()
        }
        //수정하기 버튼
        binding.editBtn.setOnClickListener() {
            //수정페이지로
            val intent = Intent(this, MypageEditActivity::class.java)
            intent.putExtra("current_user_id", current_user_id)

            startActivity(intent)

            Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }

        //삭제하기 버튼
        binding.deleteBtn.setOnClickListener() {
            Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
            intent.putExtra("current_user_id", current_user_id)
            finish()
            //서버에서 글 삭제

        }
    }
}