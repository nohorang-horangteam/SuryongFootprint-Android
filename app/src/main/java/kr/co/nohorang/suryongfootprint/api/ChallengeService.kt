package kr.co.nohorang.suryongfootprint.api

import kr.co.nohorang.suryongfootprint.data.Challenge
import kr.co.nohorang.suryongfootprint.data.Post
import kr.co.nohorang.suryongfootprint.data.PostCreationDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ChallengeService {

    //전체 챌린지 가져오기
    @GET("/s-footprint/challenge")
    fun getChallenges():Call<List<Challenge>>

    // 챌린지 참여 createPost
    @POST("/s-footprint/challenge/post")
    fun createPost(@Body pcd : PostCreationDTO): Call<Post>


}