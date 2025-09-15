package com.ortin.kasperskydictionary.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ortin.kasperskydictionary.data.room.entity.TranslateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TranslateDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTranslate(translateEntity: TranslateEntity)

    @Delete
    suspend fun deleteTranslate(translateEntity: TranslateEntity)

    @Query("SELECT * FROM translate_table")
    fun getAllTranslates(): Flow<List<TranslateEntity>>
}
