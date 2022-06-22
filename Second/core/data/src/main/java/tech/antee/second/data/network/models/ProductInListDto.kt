package tech.antee.second.data.network.models

import com.google.gson.annotations.SerializedName

data class ProductInListDto(
    @SerializedName("guid")
    val guid: String,
    @SerializedName("image")
    val image: String,
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
