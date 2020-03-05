package offer.interview.com.litedoordash.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(
        val id: Int,
        val delivery_fee: Int,
        val name: String,
        val status: String,
        val description: String,
        val cover_img_url: String,
        val menus: List<Items>
) : Parcelable
