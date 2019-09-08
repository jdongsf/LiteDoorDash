package offer.interview.com.litedoordash.service

import offer.interview.com.litedoordash.util.AppConstants.BASE_URL

object Repository {
    val restaurantApi by lazy { RetrofitFactory.retrofit(BASE_URL).create(RestaurantApi::class.java) }
}