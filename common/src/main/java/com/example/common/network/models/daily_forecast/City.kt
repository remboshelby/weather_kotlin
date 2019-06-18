package com.example.common.network.models.daily_forecast

import com.google.gson.annotations.SerializedName

data class City(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("lon")
	val lon: Double? = null,

	@field:SerializedName("iso2")
	val iso2: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("lat")
	val lat: Double? = null,

	@field:SerializedName("geoname_id")
	val geonameId: Int? = null,

	@field:SerializedName("population")
	val population: Int? = null
)