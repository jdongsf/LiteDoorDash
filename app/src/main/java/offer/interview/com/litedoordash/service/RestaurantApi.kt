package offer.interview.com.litedoordash.service

import offer.interview.com.litedoordash.data.Restaurant
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantApi {

    @GET("restaurant/")
    suspend fun getRestaurants(@Query("lat") lat: String = "37.422740",
                       @Query("lng") lng: String = "-122.139956",
                       @Query("offset") offset: Int = 0,
                       @Query("limit") limit: Int = 50): List<Restaurant>
}