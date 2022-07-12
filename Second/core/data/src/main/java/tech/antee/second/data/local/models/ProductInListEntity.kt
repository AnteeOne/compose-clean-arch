package tech.antee.second.data.local.models

import com.google.gson.annotations.SerializedName

data class ProductInListEntity(
    @SerializedName("guid")
    val guid: String,
    @SerializedName("image")
    val image: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("isFavourite")
    val isFavorite: Boolean,
    @SerializedName("isInCart")
    val isInCart: Boolean
)
