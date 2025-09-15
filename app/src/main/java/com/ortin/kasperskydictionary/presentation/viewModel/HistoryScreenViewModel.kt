package com.ortin.kasperskydictionary.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortin.kasperskydictionary.data.room.MainDB
import com.ortin.kasperskydictionary.data.room.entity.FavouriteEntity
import com.ortin.kasperskydictionary.data.room.entity.TranslateEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryScreenViewModel @Inject constructor(
    private val database: MainDB
): ViewModel() {
    val history = database.translateDAO.getAllTranslates()

    fun removeFromHistory(translateEntity: TranslateEntity) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                database.translateDAO.deleteTranslate(translateEntity)
            }
        } catch (e: Exception) {
            Log.d("HistoryScreenViewModel", "removeFromHistory: ОШИБКА", e)
        }
    }
}
