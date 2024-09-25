package com.gini.di

import android.content.Context
import androidx.room.Room
import com.gini.weather.local.WeatherDao
import com.gini.weather.local.WeatherDatabase
import com.gini.weather.remote.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Database
    private const val WEATHER_DB = "weather_db"

    //API
    private const val HTTP_API_KEY = "key"
    private const val API_KEY = "UJH6ZGVX78L8HPD7QQLPEEXX2"
    private const val API_ENDPOINT = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/"

    @Singleton
    @Provides
    fun provideWeatherDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        WeatherDatabase::class.java,
        WEATHER_DB
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideWeatherDao(
        database: WeatherDatabase,
    ): WeatherDao = database.weatherDao()

    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(
        retrofit: Retrofit
    ): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOksHttpClient(
        okHttpLogger: HttpLoggingInterceptor,
        apiKeyInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(okHttpLogger)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpNetworkInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request();
            val url = request.url.newBuilder()
                .addQueryParameter(HTTP_API_KEY, API_KEY)
                .build();
            val newRequest = request.newBuilder().url(url).build();
            chain.proceed(newRequest)
        }
    }

    @Singleton
    @Provides
    fun provideHttpLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }
}