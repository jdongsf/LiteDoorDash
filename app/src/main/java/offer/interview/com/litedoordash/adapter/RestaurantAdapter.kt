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

class RestaurantAdapter(internal var restaurants: ArrayList<Restaurant>,
                        private val loadMore: (Int) -> Unit,
                        private val onClick: (Int) -> Unit) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = restaurants[position].name
        holder.status.text = restaurants[position].status
        holder.description.hint = restaurants[position].description
        Glide.with(holder.coverImg.context).load(restaurants[position].cover_img_url).into(holder.coverImg)

        // endless scrolling
//        if (position == itemCount - 1) {
//            loadMore.invoke(itemCount)
//        }
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v, onClick)
    }

    class ViewHolder(itemView: View, onClick: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val status: TextView = itemView.findViewById(R.id.status)
        val coverImg: ImageView = itemView.findViewById(R.id.cover_img)
        val description: TextView = itemView.findViewById(R.id.description)

        init {
            itemView.setOnClickListener {
                onClick.invoke(adapterPosition)
            }
        }
    }
}
