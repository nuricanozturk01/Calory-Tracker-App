package nuricanozturk.dev.tracker_domain.remote.dto

import com.google.gson.annotations.SerializedName
import nuricanozturk.dev.tracker_domain.remote.dto.Nutriments

data class Product(
    @SerializedName("image_front_thumb_url")
    val imageFrontThumbUrl: String?,
    val nutriments: Nutriments,
    @SerializedName("product_name")
    val productName: String?
)