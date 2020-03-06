package offer.interview.com.litedoordash.service

import offer.interview.com.litedoordash.data.TokenData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {

    @FormUrlEncoded
    @POST("auth/token/")
    suspend fun login(@Field("email") email: String,
                      @Field("password") password: String): TokenData
}