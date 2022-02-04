package kr.co.nohorang.suryongfootprint


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kr.co.nohorang.suryongfootprint.databinding.ActivityMypageMainBinding

class MypageMainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMypageMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 메인메뉴 버튼 - 액티비티 이동 (+ 마이페이지 액티비티)
        binding.homeMenuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
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
        //세팅 버튼
        binding.settingBtn.setOnClickListener() {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        //뱃지 버튼
        binding.badgeBtn.setOnClickListener() {
            val intent = Intent(this, BadgeActivity::class.java)
            startActivity(intent)
        }

        //spinning(드롭다운)
        //완료한 챌린지 불러오는거 연결 필요
//        binding.dropdown.adapter = adapter
//        binding.dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                //발자국 불러오기
//            }
//
//            //완료전 승인대기 완료 버튼
//        }
    }
}