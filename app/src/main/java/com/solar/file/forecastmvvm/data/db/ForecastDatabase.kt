package com.solar.file.forecastmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.solar.file.forecastmvvm.data.db.entity.CurrentWeatherEntry

/**
 * Created by MARS on 6/26/2019 at 4:29 PM.
 */

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
abstract class ForecastDatabase:RoomDatabase(){
    abstract fun currentWeatherDao():CurrentWeatherDao

    companion object{
        @Volatile private var instance:ForecastDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context:Context) = Room.databaseBuilder(context.applicationContext,
            ForecastDatabase::class.java,"forecast.db")
            .build()
    }
}