package com.example.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.suryongfootprint.databinding.ActivityMypageMainBinding
import kr.co.nohorang.suryongfootprint.SettingActivity
import kr.co.nohorang.suryongfootprint.databinding.ActivityMypageMainBinding

class MypageMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMypageMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
        binding.dropdown.adapter = adapter
        binding.dropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //발자국 불러오기
            }

            //완료전 승인대기 완료 버튼
        }
    }
}