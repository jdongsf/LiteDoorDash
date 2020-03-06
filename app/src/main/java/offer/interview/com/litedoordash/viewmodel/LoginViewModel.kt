package offer.interview.com.litedoordash.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import offer.interview.com.litedoordash.data.TokenData
import offer.interview.com.litedoordash.service.Repository

class LoginViewModel : ViewModel() {

    val tokenDataLiveData: MutableLiveData<TokenData> by lazy { MutableLiveData<TokenData>() }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val token = Repository.loginAPi.login(email, password)
                tokenDataLiveData.postValue(token)
            } catch (e: Throwable) {
                Log.e(RestaurantViewModel::class.simpleName, e.message.toString())
            }
        }
    }

}