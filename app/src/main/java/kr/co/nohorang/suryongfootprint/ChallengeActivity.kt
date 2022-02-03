package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.nohorang.suryongfootprint.databinding.ActivityChallengeBinding
import kr.co.nohorang.suryongfootprint.databinding.ActivityMainBinding

class ChallengeActivity : AppCompatActivity() {
    val binding by lazy { ActivityChallengeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 툴바 뒤로가기 버튼 - 액티비티 종료
        binding.backBtn.setOnClickListener {
            finish()
        }

        // 확인 버튼 - 액티비티 이동
        binding.postBtn.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }
    }
}