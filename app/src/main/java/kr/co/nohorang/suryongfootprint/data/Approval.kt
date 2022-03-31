package kr.co.nohorang.suryongfootprint.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Approval(@SerializedName("countId")var count_id: Int?,
                      @SerializedName("userId")var user_id: String?
) : Serializable {
}
