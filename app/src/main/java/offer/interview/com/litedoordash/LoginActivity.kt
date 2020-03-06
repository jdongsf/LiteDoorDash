package offer.interview.com.litedoordash

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_login.*
import offer.interview.com.litedoordash.data.TokenData
import offer.interview.com.litedoordash.service.RetrofitFactory
import offer.interview.com.litedoordash.util.AppConstants.DOOR_DASH
import offer.interview.com.litedoordash.util.AppConstants.TOKEN
import offer.interview.com.litedoordash.viewmodel.LoginViewModel
import okhttp3.OkHttpClient

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preferences = getSharedPreferences(DOOR_DASH, Context.MODE_PRIVATE)
        val token = preferences.getString(TOKEN, "")
        if (token.isNullOrEmpty()) {
            setContentView(R.layout.activity_login)
            val vm = ViewModelProviders.of(this).get(LoginViewModel::class.java)
            vm.tokenDataLiveData.observe(this, Observer<TokenData> { tokenData ->
                preferences.edit().putString(TOKEN, tokenData.token).apply()
                addAuthHeaderAndGoToMainActivity(tokenData.token)
            })
            submitButton.setOnClickListener {
                vm.login(nameInput.text.toString(), passwordInput.text.toString())
            }
        } else {
            addAuthHeaderAndGoToMainActivity(token)
        }
    }

    private fun addAuthHeaderAndGoToMainActivity(token: String) {
        RetrofitFactory.client = OkHttpClient().newBuilder()
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                            .addHeader("Authorization", "JWT $token")
                            .build()
                    chain.proceed(request)
                }
                .build()
        MainActivity.startActivity(this)
        finish()
    }
}