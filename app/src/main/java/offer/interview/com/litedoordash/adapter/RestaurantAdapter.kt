package offer.interview.com.litedoordash.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import offer.interview.com.litedoordash.R
import offer.interview.com.litedoordash.data.Restaurant
import offer.interview.com.litedoordash.viewmodel.RestaurantViewModel

class RestaurantAdapter(var restaurants: ArrayList<Restaurant>, val vm: RestaurantViewModel) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.name?.text = restaurants[position].name
        holder?.status?.text = restaurants[position].status
        holder?.description?.hint = restaurants[position].description
        Glide.with(holder?.coverImg.context).load(restaurants[position].cover_img_url).into(holder?.coverImg);

        // endless scrolling
        if (position == itemCount - 1) {
            vm.loadMoreRestaurants(itemCount)
        }
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v);
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)
        val status = itemView.findViewById<TextView>(R.id.status)
        val coverImg = itemView.findViewById<ImageView>(R.id.cover_img)
        val description = itemView.findViewById<TextView>(R.id.description)
    }
}