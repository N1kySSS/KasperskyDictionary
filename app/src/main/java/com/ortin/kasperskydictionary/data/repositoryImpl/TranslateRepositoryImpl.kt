package com.ortin.kasperskydictionary.data.repositoryImpl

import com.ortin.kasperskydictionary.data.network.api.TranslateApi
import com.ortin.kasperskydictionary.data.network.dto.toModel
import com.ortin.kasperskydictionary.domain.model.WordModel
import com.ortin.kasperskydictionary.domain.repository.TranslateRepository
import javax.inject.Inject

class TranslateRepositoryImpl @Inject constructor(
    private val translateApi: TranslateApi
): TranslateRepository {
    override suspend fun getMeaning(
        search: String,
        page: Int?,
        pageSize: Int?
    ): Result<List<WordModel>> {
        return try {
            val response = translateApi.getMeaning(search = search, page = page, pageSize = pageSize)
            if (response.isSuccessful && response.body() != null) {
                val wordList = response.body()!!.map { it.toModel() }
                Result.success(wordList)
            } else {
                Result.failure(Throwable("Произошла ошибка при переводе слова. Повторите попытку позже"))
            }
        } catch (e: Exception) {
            Result.failure(Throwable(message = e.message))
        }
    }
}
