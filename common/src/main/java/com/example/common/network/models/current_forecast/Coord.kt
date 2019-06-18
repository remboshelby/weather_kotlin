package com.example.common.network.models.current_forecast

import com.google.gson.annotations.SerializedName

data class Coord(

	@field:SerializedName("lon")
	val lon: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
)