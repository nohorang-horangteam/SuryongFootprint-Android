package com.example.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.suryongfootprint.databinding.ActivityMypageEditBinding
import com.example.suryongfootprint.databinding.ActivityMypageMainBinding

class MypageEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMypageEditBinding.inflate(layoutInflater)
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