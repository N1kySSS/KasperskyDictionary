package com.ortin.kasperskydictionary.domain.repository

import com.ortin.kasperskydictionary.domain.model.WordModel

interface TranslateRepository {
    suspend fun getMeaning(
        search: String,
        page: Int? = null,
        pageSize: Int? = null
    ): Result<List<WordModel>>
}
