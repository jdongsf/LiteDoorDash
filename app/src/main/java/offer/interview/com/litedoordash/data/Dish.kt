package offer.interview.com.litedoordash.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dish(
        val id: Int,
        val price: Int,
        val name: String,
        val img_url: String,
        val description: String
) : Parcelable