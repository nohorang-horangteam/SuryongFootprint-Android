package kr.co.nohorang.suryongfootprint

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import kr.co.nohorang.suryongfootprint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 오늘의 챌린지 텍스트 앞으로 이동
        binding.dailyChallengeText.bringToFront()


        // 오늘의 챌린지 버튼 - 액티비티 이동
        binding.dailyChallengeBtn.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }

        // 인기순 챌린지 버튼(1위 ~ 5위) - 액티비티 이동
        binding.mainChallengeBtn1.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }
        binding.mainChallengeBtn2.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }
        binding.mainChallengeBtn3.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }
        binding.mainChallengeBtn4.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }
        binding.mainChallengeBtn5.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }

        // 다른 챌린지 보기 버튼 - 액티비티 이동
        binding.viewMoreChallengeBtn.setOnClickListener {
            val intent = Intent(this, ChallengeViewActivity::class.java)
            startActivity(intent)
        }

        // 메인메뉴 버튼 - 액티비티 이동 (+ 마이페이지 액티비티)
        binding.approvalMenuBtn.setOnClickListener {
            val intent = Intent(this, ApprovalActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        binding.rankingMenuBtn.setOnClickListener {
            val intent = Intent(this, RankingActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}