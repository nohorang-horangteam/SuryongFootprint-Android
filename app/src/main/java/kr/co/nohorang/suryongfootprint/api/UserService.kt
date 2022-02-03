package kr.co.nohorang.suryongfootprint.api

import kr.co.nohorang.suryongfootprint.data.LoginRequestDTO
import kr.co.nohorang.suryongfootprint.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//사용할 HTTP CRUD 동작들을 정의한 인터페이스
interface UserService {
    //회원가입 - 정상 수행됨
    //request body - 회원가입할 User 정보
    @POST("/s-footprint/user")
    fun createUser(@Body user : User):Call<User>

    //로그인
    //request body - 아이디, 비밀번호
    @POST("/s-footprint/user/login")
    fun doLogin(@Body loginInfo : LoginRequestDTO): Call<User>

}