package com.solar.file.forecastmvvm.data.db.unitlocalized

/**
 * Created by MARS on 6/26/2019 at 4:17 PM.
 */
interface UnitSpecificCurrentWeatherEntry {
    val temp: Double
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}