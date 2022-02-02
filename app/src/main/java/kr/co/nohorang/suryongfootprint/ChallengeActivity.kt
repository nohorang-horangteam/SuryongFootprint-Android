package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.nohorang.suryongfootprint.databinding.ActivityChallengeBinding
import kr.co.nohorang.suryongfootprint.databinding.ActivityMainBinding

class ChallengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChallengeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 확인 버튼 - 액티비티 이동
        binding.postBtn.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }
    }
}