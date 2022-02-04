package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.nohorang.suryongfootprint.databinding.ActivityRankingBinding

class RankingActivity : AppCompatActivity() {
    val binding by lazy { ActivityRankingBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 메인메뉴 버튼 - 액티비티 이동 (+ 마이페이지 액티비티)
        binding.approvalMenuBtn.setOnClickListener {
            val intent = Intent(this, ApprovalActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        binding.homeMenuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}