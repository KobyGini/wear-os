package com.gini.weatherapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Database
    private const val MOVIE_DB = "movie_db"

    //API
    private const val HTTP_API_KEY = "key"
    private const val API_KEY = "UJH6ZGVX78L8HPD7QQLPEEXX2"
    private const val API_ENDPOINT = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata"

//    @Singleton
//    @Provides
//    fun provideMovieDatabase(
//        @ApplicationContext context: Context
//    ) = Room
//        .databaseBuilder(
//            context.applicationContext,
//            LoginSystemDatabase::class.java,
//            MOVIE_DB
//        )
//        .fallbackToDestructiveMigration()
//        .build()


//    @Singleton
//    @Provides
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(API_ENDPOINT)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//    }

//    @Singleton
//    @Provides
//    fun provideOksHttpClient(
//        okHttpLogger: HttpLoggingInterceptor,
////        apiKeyInterceptor: Interceptor
//    ): OkHttpClient {
//        return OkHttpClient.Builder()
////            .addInterceptor(apiKeyInterceptor)
//            .addInterceptor(okHttpLogger)
//            .build()
//    }
//
//    @ExperimentalPagingApi
//    @Singleton
//    @Provides
//    fun provideOkHttpNetworkInterceptor(): Interceptor {
//        return Interceptor { chain ->
//            val request = chain.request();
//            val url = request.url.newBuilder()
//                .addQueryParameter(HTTP_API_KEY, API_KEY)
//                .build();
//            val newRequest = request.newBuilder().url(url).build();
//            chain.proceed(newRequest)
//        }
//    }
//
//    @ExperimentalPagingApi
//    @Singleton
//    @Provides
//    fun provideHttpLogger(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BASIC
//        }
//    }
//
//    @ExperimentalPagingApi
//    @Singleton
//    @Provides
//    fun provideRepository(
//        remoteDataSource: RemoteDataSource,
//        localDataSource: LocalDataSource,
//        loginSystemDatabase: LoginSystemDatabase
//    ): Repository = RepositoryImpl(
//        remoteDataSource,
//        localDataSource,
//        loginSystemDatabase
//    )
//
//    @Singleton
//    @Provides
//    fun provideLocalDataSource(
//        fileHelper: FileHelper,
//        @ApplicationContext context: Context,
//        sharedPrefManager: SharedPrefManager,
//        database: LoginSystemDatabase
//    ): LocalDataSource = LocalDataSource(
//        fileHelper,
//        sharedPrefManager,
//        context,
//        database
//    )
//
//
//    @Singleton
//    @Provides
//    fun provideIoDispatcher() = Dispatchers.IO
//
//    @Singleton
//    @Provides
//    fun provideAuthService(repository: Repository): AuthService {
//        return AuthServiceImpl(repository)
//    }


}