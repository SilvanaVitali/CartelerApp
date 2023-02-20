package com.silvanav.cartelerapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MovieData(

	@field:SerializedName("items")
	val items: List<Movie>,

	@field:SerializedName("errorMessage")
	val errorMessage: String

)

@Parcelize
@Entity
data class Movie(

	@field:SerializedName("id")
	@PrimaryKey val id: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("stars")
	val stars: String,

	@field:SerializedName("plot")
	val plot: String,

	@field:SerializedName("releaseState")
	val releaseState: String,

	@field:SerializedName("errorMessage")
	val errorMessage: String?

): Parcelable
