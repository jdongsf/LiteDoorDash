package offer.interview.com.litedoordash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*
import offer.interview.com.litedoordash.data.Restaurant

class RestaurantDetailFragment : Fragment() {

    companion object {
        private const val TAG = "RestaurantDetailFragment"
        @JvmStatic
        fun newInstance(restaurant: Restaurant) = RestaurantDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(TAG, restaurant)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        val restaurant = arguments?.getParcelable<Restaurant>(TAG)
        name.text = restaurant?.name
        status.text = restaurant?.status
        description.hint = restaurant?.description
        context?.let { Glide.with(it).load(restaurant?.cover_img_url).into(cover_img) }
    }

}
