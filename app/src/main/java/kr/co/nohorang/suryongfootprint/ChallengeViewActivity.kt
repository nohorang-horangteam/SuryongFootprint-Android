package kr.co.nohorang.suryongfootprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kr.co.nohorang.suryongfootprint.data.TestChallenge
import kr.co.nohorang.suryongfootprint.databinding.ActivityChallengeViewBinding

class ChallengeViewActivity : AppCompatActivity() {
    val binding by lazy { ActivityChallengeViewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 테스트용 챌린지 데이터 생성
        val data:MutableList<TestChallenge> = loadTestChallengeData()
        // 어댑터 생성 후 데이터 저장
        var adapter = ChallengeAdapter()
        adapter.listData = data
        // 어댑터 연결
        binding.recycler.adapter = adapter
        // 레이아웃 매니저 연결
        binding.recycler.layoutManager = GridLayoutManager(this, 2)

        // 종료 버튼 앞으로 이동
        binding.challengeViewExitBtn.bringToFront()

        // 종료 버튼 - 액티비티 종료
        binding.challengeViewExitBtn.setOnClickListener {
            finish()
        }
    }

    // 테스트용 챌린지 데이터 생성 함수
    fun loadTestChallengeData(): MutableList<TestChallenge> {
        val data: MutableList<TestChallenge> = mutableListOf()

        for (no in 1..100) {
            val challenge_id = no
            val title = "챌린지${no} 도전"
            val info = "챌린지${no}에 대한 인증 사진을 찍어 첨부하세요!"
            val condition = no
            val participants = 0
            var testChallenge = TestChallenge(challenge_id, title, info, condition, participants)
            data.add(testChallenge)
        }
        return data
    }
}