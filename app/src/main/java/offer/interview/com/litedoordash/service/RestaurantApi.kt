package offer.interview.com.litedoordash.service

import offer.interview.com.litedoordash.data.Restaurant
import offer.interview.com.litedoordash.util.AppConstants.LAT
import offer.interview.com.litedoordash.util.AppConstants.LIMIT
import offer.interview.com.litedoordash.util.AppConstants.LNG
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RestaurantApi {

    @GET("restaurant/")
    suspend fun getRestaurants(@Query("lat") lat: String = LAT,
                               @Query("lng") lng: String = LNG,
                               @Query("offset") offset: Int = 0,
                               @Query("limit") limit: Int = LIMIT): List<Restaurant>
}