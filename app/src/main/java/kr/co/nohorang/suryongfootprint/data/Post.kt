package kr.co.nohorang.suryongfootprint.data

import android.net.Uri
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URI

// JSON 타입 변환에 사용될 객체(DTO)
// request의 편의성을 고려해서 선언할 것.
data class Post (@SerializedName("postId")var post_id: Int?,
                 @SerializedName("userId")var user_id: String?,
                 @SerializedName("challengeId")var challenge_id: Int?,
                 @SerializedName("countId")var count_id: Int?,
                 @SerializedName("img")var img: String?,
                 @SerializedName("content")var content:String?,
) :Serializable {}

data class PostCreationDTO(
    @SerializedName("userId")var user_id: String?,
    @SerializedName("challengeId")var challenge_id: Int?,
    @SerializedName("img")var img: String?,
    @SerializedName("content")var content:String?
):Serializable{}

data class PostUpdateDTO(
    @SerializedName("content")var content:String
):Serializable{}