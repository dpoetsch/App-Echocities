package com.example.echocities.data

import com.google.gson.annotations.SerializedName

data class Map(
    @SerializedName("cd_mapea")
    var cd_mapea : Int,
    @SerializedName("nm_mapea")
    var nm_mapea : String,
    @SerializedName("dt_inicio_map")
    var dt_inicio_map : String,
    @SerializedName("nm_fantasia")
    var nm_fantasia : String
)