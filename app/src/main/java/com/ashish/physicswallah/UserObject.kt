package com.ashish.physicswallah

import com.google.gson.annotations.SerializedName


data class UserObject(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("subjects")
    val subjects: List<String>,
    @SerializedName("qualification")
    val qualification: List<String>,
    @SerializedName("profileImage")
    val profileImage: String
)