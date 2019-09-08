package offer.interview.com.litedoordash.data

data class Restaurant(
        val id: Int,
        val delivery_fee: Int,
        val name: String,
        val status: String,
        val description: String,
        val cover_img_url: String
)
