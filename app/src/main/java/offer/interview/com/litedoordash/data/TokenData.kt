package offer.interview.com.litedoordash.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TokenData(
        val token: String
) : Parcelable