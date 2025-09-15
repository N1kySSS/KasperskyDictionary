package com.ortin.kasperskydictionary.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortin.kasperskydictionary.data.room.MainDB
import com.ortin.kasperskydictionary.data.room.entity.FavouriteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteScreenViewModel @Inject constructor(
    private val database: MainDB
): ViewModel() {
    val favourites = database.favouriteDAO.getAllFavourites()

    fun removeFromFavourite(favouriteEntity: FavouriteEntity) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                database.favouriteDAO.deleteFavourite(favouriteEntity)
            }
        } catch (e: Exception) {
            Log.d("FavouriteScreenViewModel", "removeFromFavourite: ОШИБКА", e)
        }
    }
}
