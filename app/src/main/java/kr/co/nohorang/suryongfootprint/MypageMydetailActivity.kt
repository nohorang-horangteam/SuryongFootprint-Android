package com.example.suryongfootprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.suryongfootprint.databinding.ActivityMypageMainBinding
import com.example.suryongfootprint.databinding.ActivityMypageMydetailBinding

class MypageMydetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMypageMydetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //수정하기 버튼
        binding.confirm.setOnClickListener() {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            //글 수정하기
        }

        //삭제하기 버튼
        binding.delete.setOnClickListener() {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            //글 삭제하기
        }
    }
}