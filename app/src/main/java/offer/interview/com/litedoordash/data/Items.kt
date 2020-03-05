package offer.interview.com.litedoordash.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items(
        val id: Int,
        val name: String,
        val subtitle: String,
        val is_catering: Boolean,
        val popular_items: List<Dish>
) : Parcelable