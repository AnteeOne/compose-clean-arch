package tech.antee.second.data.local.models

import com.google.gson.annotations.SerializedName

data class ProductEntity(
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
    @SerializedName("InCartItemCount")
    val inCartItemCount: Int,
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
    @SerializedName("viewCount")
    val viewCount: Int
)
