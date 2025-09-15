package com.ortin.kasperskydictionary.domain.model

data class WordModel(
    val id: Int,
    val text: String,
    val meanings: List<MeaningModel>
)

data class MeaningModel(
    val id: Int,
    val partOfSpeechCode: String,
    val translation: TranslationModel,
    val previewUrl: String,
    val imageUrl: String,
    val transcription: String,
    val soundUrl: String
)

data class TranslationModel(
    val text: String,
    val note: String?
)
