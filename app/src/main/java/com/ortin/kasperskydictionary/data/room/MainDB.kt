package com.ortin.kasperskydictionary.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ortin.kasperskydictionary.data.room.dao.FavouriteDAO
import com.ortin.kasperskydictionary.data.room.dao.TranslateDAO
import com.ortin.kasperskydictionary.data.room.entity.FavouriteEntity
import com.ortin.kasperskydictionary.data.room.entity.TranslateEntity

@Database(
    entities = [TranslateEntity::class, FavouriteEntity::class],
    version = 1
)
abstract class MainDB: RoomDatabase() {
    abstract val translateDAO: TranslateDAO
    abstract val favouriteDAO: FavouriteDAO

    companion object {
        fun createDB(context: Context): MainDB {
            return Room.databaseBuilder(
                context = context,
                klass = MainDB::class.java,
                name = "main.db"
            ).build()
        }
    }
}
