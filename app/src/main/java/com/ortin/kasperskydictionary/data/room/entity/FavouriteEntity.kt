package com.ortin.kasperskydictionary.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_table")
data class FavouriteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val search: String?,
    val meaning: String?
)
