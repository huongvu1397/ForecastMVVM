package com.solar.file.forecastmvvm.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.solar.file.forecastmvvm.data.network.response.CurrentWeatherResponse
import com.solar.file.forecastmvvm.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(private val apixuWeatherApiService: ApixuWeatherApiService) :
    WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse> get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchedCurrentWeather = apixuWeatherApiService
                .getCurrentWeather(location,languageCode)
                .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        }catch (e:NoConnectivityException){
            Log.e("Connectivity","No internet connection. $e")
        }
    }
}