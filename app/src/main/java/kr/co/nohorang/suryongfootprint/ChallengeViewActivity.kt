package kr.co.nohorang.suryongfootprint

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kr.co.nohorang.suryongfootprint.databinding.ActivityChallengeViewBinding

class ChallengeViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChallengeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 종료 버튼 - 액티비티 종료 (클릭 안 됨)
        binding.challengeViewExitBtn.setOnClickListener {
            Toast.makeText(this,"버튼 클릭됨", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}