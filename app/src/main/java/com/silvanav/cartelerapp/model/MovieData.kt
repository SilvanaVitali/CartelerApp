package com.silvanav.cartelerapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue

data class MovieData(

	@field:SerializedName("items")
	val items: List<Movie>,

	@field:SerializedName("errorMessage")
	val errorMessage: String

)

@Entity
data class Movie(


	@field:SerializedName("id")
	@PrimaryKey val id: String,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("fullTitle")
	val fullTitle: String,

	@field:SerializedName("runtimeMins")
	val runtimeMins: String,

	@field:SerializedName("year")
	val year: String,

	@field:SerializedName("directors")
	val directors: String,

	@Embedded
	@field:SerializedName("genreList")
	val genreList: @RawValue GenreListItem,

	@field:SerializedName("metacriticRating")
	val metacriticRating: String,

	@Embedded
	@field:SerializedName("directorList")
	val directorList: @RawValue DirectorListItem,

	@field:SerializedName("stars")
	val stars: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("imDbRating")
	val imDbRating: String,

	@field:SerializedName("runtimeStr")
	val runtimeStr: String,

	@field:SerializedName("imDbRatingCount")
	val imDbRatingCount: String,

	@field:SerializedName("plot")
	val plot: String,

	@field:SerializedName("genres")
	val genres: String,

	@field:SerializedName("contentRating")
	val contentRating: String,

	@Embedded
	@field:SerializedName("starList")
	val starList: @RawValue StarListItem,

	@field:SerializedName("releaseState")
	val releaseState: String,

	@field:SerializedName("errorMessage")
	val errorMessage: String?

)

data class GenreListItem(

	@field:SerializedName("value")
	val value: String,

	@field:SerializedName("key")
	val key: String
)

data class StarListItem(

	@field:SerializedName("name")
	val nameStarList: String,

	@field:SerializedName("id")
	val idStarList: String
)

data class DirectorListItem(

	@field:SerializedName("name")
	val nameDirectorList: String,

	@field:SerializedName("id")
	val idDirectorList: String
)
