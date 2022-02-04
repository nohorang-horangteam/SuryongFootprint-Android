package kr.co.nohorang.suryongfootprint

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kr.co.nohorang.suryongfootprint.data.TestChallenge
import kr.co.nohorang.suryongfootprint.databinding.ListitemChallengeBinding

class ChallengeAdapter: RecyclerView.Adapter<ChallengeHolder>() {
    // 실제 데이터로 변환 필요
    var listData = mutableListOf<TestChallenge>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeHolder {
        val binding = ListitemChallengeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChallengeHolder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(challengeHolder: ChallengeHolder, position: Int) {
        val challenge = listData.get(position)
        challengeHolder.setChallenge(challenge)
    }
}

class ChallengeHolder(val binding: ListitemChallengeBinding): RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, ChallengeActivity::class.java)
            startActivity(binding.root.context, intent, null)
        }
    }

    // testChallenge 대신 실제 데이터로 변환 필요
    fun setChallenge(testChallenge: TestChallenge) {
        binding.viewChallengeBtn.text = "${testChallenge.title}".replace(" ", "\n")
        when (testChallenge.challenge_id % 4) {
            0, 1 -> binding.viewChallengeBtn.setBackgroundColor(Color.parseColor("#537BC4"))
            2, 3 -> binding.viewChallengeBtn.setBackgroundColor(Color.parseColor("#87A3D6"))
        }
    }
}