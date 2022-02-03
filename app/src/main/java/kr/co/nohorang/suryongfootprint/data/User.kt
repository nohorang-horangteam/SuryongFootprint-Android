package kr.co.nohorang.suryongfootprint.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

// JSON 타입 변환에 사용될 객체(DTO)
// request의 편의성을 고려해서 선언할 것.
data class User (@SerializedName("user_id")var user_id: String?,
                 @SerializedName("user_email")var user_email: String?,
                 @SerializedName("user_pw")var user_pw: String?,
                 @SerializedName("user_name")var user_name: String?,
                 @SerializedName("user_nickname")var user_nickname:String?) :Serializable {
}

data class LoginRequestDTO(@SerializedName("user_id") var user_id: String?,
                           @SerializedName("user_pw") var user_pw: String?) :Serializable {
}
