/*
 * Copyright (c) 2021/  4/ 17.  Created by Hashim Tahir
 */

package com.hashim.hiltdependencyinjection.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hashim.hiltdependencyinjection.RetroService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/*
* Interfaces are not the only case where constructor-injection is not possible.
*  Constructor injection is also not possible when one dosent the class
* because it comes from an external library (classes like Retrofit,
* OkHttpClient, or Room databases), or if instances must be created with the builder pattern.
*
*
* Say we need retrofit to be injected. This should be done with @Provides annotation.
*
*   The annotated function supplies the following information to Hilt:
*       The function return type tells Hilt what type the function provides instances of.
*       The function parameters tell Hilt the dependencies of the corresponding type.
*       The function body tells Hilt how to provide an instance of the corresponding
*       type. Hilt executes the function body every time it needs to provide an instance of that type.
*  */
@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule1 {

    @Provides
    fun hProvidesGson(): Gson {
        return GsonBuilder()
            .setPrettyPrinting()
            .setLenient()
            .create()
    }


    @Provides
    fun hProvidesLogginInterceptor() =
        HttpLoggingInterceptor()


    /*LogginInterceptor here is provied by the function defined above*/
    @Provides
    fun hProvidesHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(4, TimeUnit.SECONDS)
            .connectTimeout(4, TimeUnit.SECONDS)
            .addInterceptor(
                loggingInterceptor.setLevel(
                    HttpLoggingInterceptor.Level.BODY
                )
            )
            .build()
    }


    /*Clinet is provided by the above function*/
    @Provides
    fun hProvidesRetrofitService(
        httpClient: OkHttpClient,
        gson: Gson
    ): RetroService {
        return Retrofit.Builder()
            .baseUrl("https://your.api.url/")
            .addConverterFactory(
                GsonConverterFactory.create(
                    gson
                )
            )
            .client(httpClient)
            .build()
            .create(RetroService::class.java)

    }

}