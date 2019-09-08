package offer.interview.com.litedoordash.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import offer.interview.com.litedoordash.data.Restaurant
import offer.interview.com.litedoordash.service.Repository
import offer.interview.com.litedoordash.util.AppConstants.LAT
import offer.interview.com.litedoordash.util.AppConstants.LIMIT
import offer.interview.com.litedoordash.util.AppConstants.LNG

class RestaurantViewModel : androidx.lifecycle.ViewModel() {

    val scope by lazy {
        CoroutineScope(Job() + Dispatchers.Default)
    }

    val restaurantsLiveData: MutableLiveData<ArrayList<Restaurant>> by lazy {
        MutableLiveData<ArrayList<Restaurant>>()
    }

    fun fetchRestaurants() {
        scope.launch {
            try {
                val restaurants = Repository.restaurantApi.getRestaurants()
                withContext(Dispatchers.Main) {
                    restaurantsLiveData.value = restaurants as ArrayList<Restaurant>
                }
            } catch (e: Throwable) {
                Log.e(RestaurantViewModel::class.simpleName, e.localizedMessage);
            }
        }
    }

    fun loadMoreRestaurants(offSet:Int) {
        scope.launch {
            try {
                val moreRestaurants = Repository.restaurantApi.getRestaurants(LAT, LNG, offSet, LIMIT)
                withContext(Dispatchers.Main) {
                    restaurantsLiveData.value = moreRestaurants as ArrayList<Restaurant>
                }
            } catch (e: Throwable) {
                Log.e(RestaurantViewModel::class.simpleName, e.localizedMessage);
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.coroutineContext.cancel();
    }
}


