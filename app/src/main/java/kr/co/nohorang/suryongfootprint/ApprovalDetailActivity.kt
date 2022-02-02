package kr.co.nohorang.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.co.nohorang.suryongfootprint.databinding.ActivityApprovalDetailBinding

class ApprovalDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityApprovalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.approvalBtn.setOnClickListener{
            Toast.makeText(this, "승인하였습니다.", Toast.LENGTH_SHORT).show()
        }

        binding.reportBtn.setOnClickListener {
            Toast.makeText(this, "신고하였습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}