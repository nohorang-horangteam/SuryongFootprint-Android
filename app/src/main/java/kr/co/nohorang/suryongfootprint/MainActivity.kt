package kr.co.nohorang.suryongfootprint

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import kr.co.nohorang.suryongfootprint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dailyChallengeText.bringToFront()

        // 다른 챌린지 보기 버튼 - 액티비티 이동
        binding.viewMoreChallengeBtn.setOnClickListener {
            val intent = Intent(this, ChallengeViewActivity::class.java)
            startActivity(intent)
        }
    }
}