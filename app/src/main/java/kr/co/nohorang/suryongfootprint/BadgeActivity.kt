package com.example.suryongfootprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.nohorang.suryongfootprint.databinding.ActivityBadgeBinding

class BadgeActivity : AppCompatActivity() {
    val binding by lazy { ActivityBadgeBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //뱃지 개수 받아오기

        //뱃지 멘트 불러오기

        //뱃지 사진 불러오기(뱃지 개수대로, 완료한 챌린지 제목)
    }
}