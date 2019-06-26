package com.solar.file.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

/**
 * Created by MARS on 6/26/2019 at 4:20 PM.
 */
data class MetricCurrentWeatherEntry(
    @ColumnInfo(name = "temp_c")
    override val temp: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val conditionIconUrl: String,
    @ColumnInfo(name = "wind_kph")
    override val windSpeed: Double,
    @ColumnInfo(name = "wind_dir")
    override val windDirection: String,
    @ColumnInfo(name = "precip_mm")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike_c")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "vis_miles")
    override val visibilityDistance: Double
):UnitSpecificCurrentWeatherEntry {

}