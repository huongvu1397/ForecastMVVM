package com.solar.file.forecastmvvm.data.network

import androidx.lifecycle.LiveData
import com.solar.file.forecastmvvm.data.network.response.CurrentWeatherResponse

/**
 * Created by MARS on 6/26/2019 at 4:49 PM.
 */
interface WeatherNetworkDataSource {
    val downloadedCurrentWeather:LiveData<CurrentWeatherResponse>
    suspend fun fetchCurrentWeather(
        location:String,
        languageCode:String
    )
}