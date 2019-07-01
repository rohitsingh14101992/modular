package demo.m.base.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Long,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String,
    @SerializedName("site_admin") val siteAdmin: Boolean,
    @SerializedName("name") val name: String?,
    @SerializedName("location") val location: String?,
    @SerializedName("score") val score: Float
) : Parcelable