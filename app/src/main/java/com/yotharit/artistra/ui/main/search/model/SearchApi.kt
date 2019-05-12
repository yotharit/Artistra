package com.yotharit.artistra.ui.main.search.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("json/events/search")
    fun searchByKeyword(
        @Query("app_key") app_key: String,
        @Query("keywords") keywords: String
    ): Single<QueryModel>

    @GET("json/events/search")
    fun searchByDate(
        @Query("app_key") app_key: String,
        @Query("keywords") keywords: String,
        @Query("date") date: String,
        @Query("page_size") size: Int
    ): Single<QueryModel>

    @GET("json/events/search")
    fun autoSearch(
        @Query("app_key") app_key: String,
        @Query("date") date: String,
        @Query("page_size") size: Int
    ): Single<QueryModel>

    @GET("json/events/search")
    fun searchThai(
        @Query("app_key") app_key: String,
        @Query("location") location: String,
        @Query("date") date: String,
        @Query("page_size") page_size: Int

    ): Single<QueryModel>

}