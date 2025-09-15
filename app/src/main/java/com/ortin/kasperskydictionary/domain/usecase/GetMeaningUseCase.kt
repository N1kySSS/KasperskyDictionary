package com.ortin.kasperskydictionary.domain.usecase

import com.ortin.kasperskydictionary.domain.model.WordModel
import com.ortin.kasperskydictionary.domain.repository.TranslateRepository
import javax.inject.Inject

class GetMeaningUseCase @Inject constructor(
    private val repository: TranslateRepository
) {
    suspend operator fun invoke(
        search: String,
        page: Int? = null,
        pageSize: Int? = null
    ): Result<List<WordModel>> {
        return try {
            repository.getMeaning(
                search = search,
                page = page,
                pageSize = pageSize
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
