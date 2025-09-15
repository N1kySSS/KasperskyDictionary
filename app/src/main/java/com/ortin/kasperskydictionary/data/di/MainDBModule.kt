package com.ortin.kasperskydictionary.data.di

import android.content.Context
import com.ortin.kasperskydictionary.data.room.MainDB
import com.ortin.kasperskydictionary.data.room.dao.FavouriteDAO
import com.ortin.kasperskydictionary.data.room.dao.TranslateDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainDBModule {
    
    @Provides
    @Singleton
    fun provideMainDB(@ApplicationContext context: Context): MainDB {
        return MainDB.createDB(context)
    }
    
    @Provides
    fun provideTranslateDAO(database: MainDB): TranslateDAO {
        return database.translateDAO
    }
    
    @Provides
    fun provideFavouriteDAO(database: MainDB): FavouriteDAO {
        return database.favouriteDAO
    }
}
