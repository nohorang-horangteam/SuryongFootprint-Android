package kr.co.nohorang.suryongfootprint


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.annotation.RequiresApi
import kr.co.nohorang.suryongfootprint.databinding.ActivityMypageBinding

class MypageActivity : AppCompatActivity() {
    val binding by lazy { ActivityMypageBinding.inflate(layoutInflater) }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val current_user_id=intent.getStringExtra("current_user_id")

        // 닉네임 표시
        binding.nickname.text = current_user_id;

        // 메인메뉴 버튼 - 액티비티 이동 (+ 마이페이지 액티비티)
        binding.homeMenuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("current_user_id", current_user_id)
            startActivity(intent)
        }
        binding.approvalMenuBtn.setOnClickListener {
            val intent = Intent(this, ApprovalActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("current_user_id", current_user_id)
            startActivity(intent)
        }

        binding.rankingMenuBtn.setOnClickListener {
            val intent = Intent(this, RankingActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("current_user_id", current_user_id)
            startActivity(intent)
        }

        //세팅 버튼
        binding.settingBtn.setOnClickListener() {
            val intent = Intent(this, SettingActivity::class.java)
            intent.putExtra("current_user_id", current_user_id)
            startActivity(intent)
        }

        //뱃지 버튼
        binding.badgeBtn.setOnClickListener() {
            val intent = Intent(this, BadgeActivity::class.java)
            intent.putExtra("current_user_id", current_user_id)
            startActivity(intent)
        }

        //spinning(드롭다운)
        val adapter = binding.spinner.adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        // 완료전 승인대기 완료 버튼
        val color = getColor(R.color.btn_grey)
        val whitecolor = getColor(R.color.white)
        val button1: Button = findViewById(R.id.int_btn)
        val button2: Button = findViewById(R.id.wait_btn)
        val button3: Button = findViewById(R.id.fin_btn)

        button1.setOnClickListener {
            button1.setBackgroundColor(color)
            button2.setBackgroundColor(whitecolor)
            button3.setBackgroundColor(whitecolor)

        }

        button2.setOnClickListener {
            button2.setBackgroundColor(color)
            button1.setBackgroundColor(whitecolor)
            button3.setBackgroundColor(whitecolor)
        }

        button3.setOnClickListener {
            button3.setBackgroundColor(color)
            button1.setBackgroundColor(whitecolor)
            button2.setBackgroundColor(whitecolor)
        }
    }
}