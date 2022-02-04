package com.example.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.nohorang.suryongfootprint.SettingActivity
import kr.co.nohorang.suryongfootprint.databinding.ActivityMainBinding
import kr.co.nohorang.suryongfootprint.databinding.ActivityMypageEditBinding

class MypageEditActivity : AppCompatActivity() {
    val binding by lazy { ActivityMypageEditBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //확인버튼
        binding.confirmBtn.setOnClickListener() {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)

            //글 저장하기
        }
    }
}