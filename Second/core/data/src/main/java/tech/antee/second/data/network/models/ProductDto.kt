package tech.antee.second.data.network.models

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("guid")
    val guid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("isFavourite")
    val isFavorite: Boolean,
    @SerializedName("isInCart")
    val isInCart: Boolean,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("weight")
    val weight: Double?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("availableCount")
    val availableCount: Int?,
    @SerializedName("additionalParams")
    val additionalParams: Map<String, String>,
)
