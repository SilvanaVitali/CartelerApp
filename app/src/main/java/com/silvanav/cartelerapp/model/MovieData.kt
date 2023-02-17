package com.silvanav.cartelerapp.model

import com.google.gson.annotations.SerializedName

data class MovieData(

	@field:SerializedName("items")
	val items: List<Movie>,

	@field:SerializedName("errorMessage")
	val errorMessage: String

)

data class Movie(

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

	@field:SerializedName("genreList")
	val genreList: List<GenreListItem>,

	@field:SerializedName("metacriticRating")
	val metacriticRating: String,

	@field:SerializedName("directorList")
	val directorList: List<DirectorListItem>,

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

	@field:SerializedName("starList")
	val starList: List<StarListItem>,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("releaseState")
	val releaseState: String
)

data class GenreListItem(

	@field:SerializedName("value")
	val value: String,

	@field:SerializedName("key")
	val key: String
)

data class StarListItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
)

data class DirectorListItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
)
