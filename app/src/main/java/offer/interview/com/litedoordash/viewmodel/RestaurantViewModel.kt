package offer.interview.com.litedoordash.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import offer.interview.com.litedoordash.data.Restaurant
import offer.interview.com.litedoordash.service.Repository
import offer.interview.com.litedoordash.util.AppConstants.LAT
import offer.interview.com.litedoordash.util.AppConstants.LIMIT
import offer.interview.com.litedoordash.util.AppConstants.LNG

class RestaurantViewModel : ViewModel() {

    val scope by lazy { CoroutineScope(Job() + Dispatchers.IO) }

    val restaurantsLiveData: MutableLiveData<ArrayList<Restaurant>> by lazy { MutableLiveData<ArrayList<Restaurant>>() }

    fun fetchRestaurants() {
        scope.launch {
            try {
                val restaurants = Repository.restaurantApi.getRestaurants()
                restaurantsLiveData.postValue(restaurants as ArrayList<Restaurant>)
            } catch (e: Throwable) {
                Log.e(RestaurantViewModel::class.simpleName, e.message.toString())
            }
        }
    }

    fun loadMoreRestaurants(offSet: Int) {
        scope.launch {
            try {
                val moreRestaurants = Repository.restaurantApi.getRestaurants(LAT, LNG, offSet, LIMIT)
                restaurantsLiveData.postValue(moreRestaurants as ArrayList<Restaurant>)
            } catch (e: Throwable) {
                Log.e(RestaurantViewModel::class.simpleName, e.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}
