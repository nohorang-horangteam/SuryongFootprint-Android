package kr.co.nohorang.suryongfootprint.api

import kr.co.nohorang.suryongfootprint.data.*
import retrofit2.Call
import retrofit2.http.*

interface ApprovalService {

    //COUNT에 대한 USER의 승인 여부 가져오기 (버튼 비활성화용) -> 승인 여부 반환
    @GET("/s-footprint/approval/count/{count_id}/user/{user_id}")
    fun getUserApproval(@Path("count_id") count_id:Int,
                        @Path("user_id") user_id:String):Call<Approval>

    //COUNT에 대한 USER의 신고 여부 가져오기(버튼 비활성화용)
    @GET("/s-footprint/report/count/{count_id}/user/{user_id}")
    fun getUserReport(@Path("count_id") count_id:Int,
                      @Path("user_id") user_id:String):Call<Report>

    //승인하기
    @POST("/s-footprint/approval")
    fun userApproveCount(
        @Body approval:Approval
    ):Call<String>

    //신고하기
    @POST("/s-footprint/report")
    fun userReportCount(
        @Body report:Report
    ):Call<String>
}