package com.solar.file.forecastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.solar.file.forecastmvvm.data.db.entity.CURRENT_WEATHER_ID
import com.solar.file.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.solar.file.forecastmvvm.data.db.unitlocalized.ImperialCurrenWeatherEntry
import com.solar.file.forecastmvvm.data.db.unitlocalized.MetricCurrentWeatherEntry

/**
 * Created by MARS on 6/26/2019 at 4:25 PM.
 */
@Dao
interface CurrentWeatherDao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry:CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric() :LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial() :LiveData<ImperialCurrenWeatherEntry>

}