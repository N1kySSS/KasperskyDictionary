package com.ortin.kasperskydictionary.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "translate_table")
data class TranslateEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val search: String?,
    val meaning: String?
)
