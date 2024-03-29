package com.solar.file.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.solar.file.forecastmvvm.R
import com.solar.file.forecastmvvm.data.network.ApixuWeatherApiService
import com.solar.file.forecastmvvm.data.network.ConnectivityInterceptorImpl
import com.solar.file.forecastmvvm.data.network.WeatherNetworkDataSource
import com.solar.file.forecastmvvm.data.network.WeatherNetworkDataSourceImpl
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        val apiService = ApixuWeatherApiService(ConnectivityInterceptorImpl(this.context!!))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)
        weatherNetworkDataSource.downloadedCurrentWeather.observe(this, Observer {
            if (it != null) {
                londonText.text = it.currentWeatherEntry.toString()
            }
        })
        GlobalScope.launch(Dispatchers.Main) {
            //            val currentWeatherResponse = apiService.getCurrentWeather("London").await()
//
//            if (londonText != null) {
//                   londonText.text = it.currentWeatherEntry.toString()
//            }
            weatherNetworkDataSource.fetchCurrentWeather("London", "en")
        }
    }

}
