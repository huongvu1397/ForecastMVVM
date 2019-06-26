package com.solar.file.forecastmvvm.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
const val CURRENT_WEATHER_ID = 0
@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    @SerializedName("temp_c")
    val temp_c: Double,
    @SerializedName("temp_f")
    val temp_f: Double,
    @SerializedName("is_day")
    val is_day: Int,
    @Embedded(prefix = "condition_")
    val condition: Condition,
    @SerializedName("wind_mph")
    val wind_mph: Double,
    @SerializedName("wind_kph")
    val wind_kph: Double,
    @SerializedName("wind_dir")
    val wind_dir: String,
    @SerializedName("precip_mm")
    val precip_mm: Double,
    @SerializedName("precip_in")
    val precip_in: Double,
    @SerializedName("feelslike_c")
    val feelslike_c: Double,
    @SerializedName("feelslike_f")
    val feelslike_f: Double,
    @SerializedName("vis_km")
    val vis_km: Double,
    @SerializedName("vis_miles")
    val vis_miles: Double
){
    @PrimaryKey(autoGenerate = false)
    var id:Int = CURRENT_WEATHER_ID
}