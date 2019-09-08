package offer.interview.com.litedoordash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import offer.interview.com.litedoordash.adapter.RestaurantAdapter
import offer.interview.com.litedoordash.data.Restaurant
import offer.interview.com.litedoordash.viewmodel.RestaurantViewModel

class RestaurantListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = activity?.let { ViewModelProviders.of(it).get(RestaurantViewModel::class.java) }!!
        vm.restaurantsLiveData.observe(this, Observer<ArrayList<Restaurant>> { restaurants ->
            when (list.adapter) {
                null -> {
                    progress.visibility = View.GONE
                    list.adapter = RestaurantAdapter(restaurants, vm)
                    list.layoutManager = LinearLayoutManager(context)
                }
                is RestaurantAdapter -> {
                    val adapter = list.adapter as RestaurantAdapter
                    restaurants.forEach { restaurant ->
                        adapter.restaurants.add(restaurant)
                        adapter.notifyItemInserted(adapter.restaurants.size)
                        Log.d(RestaurantListFragment::class.simpleName, "insert : " + adapter.restaurants.size)
                    }
                }
            }
        })
        vm.fetchRestaurants()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

}