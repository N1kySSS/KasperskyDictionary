package com.ortin.kasperskydictionary.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortin.kasperskydictionary.data.room.MainDB
import com.ortin.kasperskydictionary.data.room.entity.FavouriteEntity
import com.ortin.kasperskydictionary.data.room.entity.TranslateEntity
import com.ortin.kasperskydictionary.domain.usecase.GetMeaningUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TranslateScreenViewModel @Inject constructor(
    private val getMeaningUseCase: GetMeaningUseCase,
    private val database: MainDB
): ViewModel() {

    val isFromRussianToEnglish = mutableStateOf(false)

    val isOnFavouriteClicked = mutableStateOf(false)

    val searchText = mutableStateOf("")

    val meaningText = mutableStateOf("")

    fun getMeaning() {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                getMeaningUseCase(
                    search = searchText.value,
                    page = 1,
                    pageSize = 10
                    /* можно будет брать остальные переводы, если такие имеются
                    * и отображать их под основным переводом на экарне с текстом
                    * "другие варианты" */
                )
            }.onSuccess { resultModel ->
                val result = resultModel.getOrNull(0)
                val text = result?.let {
                    if (isFromRussianToEnglish.value) {
                        it.text
                    } else {
                        it.meanings.getOrNull(0)?.translation?.text
                    }
                } ?: ""
                addToHistory()
                meaningText.value = text
            }.onFailure { error ->
                Log.e("PersonalAccountScreenViewModel", "restoreAnnouncementFromArchive: ОШИБКА", error)
            }
        }
    }

    fun addToFavourite() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                database.favouriteDAO.insertFavourite(
                    FavouriteEntity(
                        search = searchText.value,
                        meaning = meaningText.value
                    )
                )
            }
        } catch (e: Exception) {
            Log.d("PersonalAccountScreenViewModel", "addToFavourite: ОШИБКА", e)
        }
    }

    private fun addToHistory() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                database.translateDAO.insertTranslate(
                    TranslateEntity(
                        search = searchText.value,
                        meaning = meaningText.value
                    )
                )
            }
        } catch (e: Exception) {
            Log.d("PersonalAccountScreenViewModel", "addToHistory: ОШИБКА", e)
        }
    }
}
