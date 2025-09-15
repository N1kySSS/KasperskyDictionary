package com.ortin.kasperskydictionary.data.network.api

import com.ortin.kasperskydictionary.data.network.dto.WordDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateApi {

    @GET("/api/public/v1/words/search")
    suspend fun getMeaning(
        @Query("search") search: String,
        @Query("page") page: Int? = null,
        @Query("pageSize") pageSize: Int? = null
    ): Response<List<WordDto>>
}
