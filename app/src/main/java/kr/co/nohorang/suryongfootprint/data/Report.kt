package kr.co.nohorang.suryongfootprint.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Report(@SerializedName("CountId")var count_id: Int?,
                      @SerializedName("userId")var user_id: String?
) : Serializable {
}
