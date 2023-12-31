package com.example.Lab2.models

import com.google.gson.annotations.SerializedName

data class ToolRequest(
    @SerializedName("title") val title: String = "",
    @SerializedName("subtitle") val subtitle: String = "",
    @SerializedName("img") val img: String? = null,
    @SerializedName("hasBag") val hasBag: String? = null,
    @SerializedName("isCircle") val isCircle: Boolean? = null
)
