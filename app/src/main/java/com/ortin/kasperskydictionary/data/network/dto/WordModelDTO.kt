package com.ortin.kasperskydictionary.data.network.dto

import com.ortin.kasperskydictionary.domain.model.MeaningModel
import com.ortin.kasperskydictionary.domain.model.TranslationModel
import com.ortin.kasperskydictionary.domain.model.WordModel

data class WordDto(
    val id: Int,
    val text: String,
    val meanings: List<MeaningDto>
)

data class MeaningDto(
    val id: Int,
    val partOfSpeechCode: String,
    val translation: TranslationDto,
    val previewUrl: String,
    val imageUrl: String,
    val transcription: String,
    val soundUrl: String
)

data class TranslationDto(
    val text: String,
    val note: String?
)

fun TranslationDto.toModel() = TranslationModel(
    text = text,
    note = note
)

fun MeaningDto.toModel() = MeaningModel(
    id = id,
    partOfSpeechCode = partOfSpeechCode,
    translation = translation.toModel(),
    previewUrl = previewUrl,
    imageUrl = imageUrl,
    transcription = transcription,
    soundUrl = soundUrl
)

fun WordDto.toModel() = WordModel(
    id = id,
    text = text,
    meanings = meanings.map { it.toModel() }
)
