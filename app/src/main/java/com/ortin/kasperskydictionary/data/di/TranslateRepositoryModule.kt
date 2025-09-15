package com.ortin.kasperskydictionary.data.di

import com.ortin.kasperskydictionary.data.repositoryImpl.TranslateRepositoryImpl
import com.ortin.kasperskydictionary.domain.repository.TranslateRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TranslateRepositoryModule {
    @Binds
    abstract fun bindTranslateRepo(
        impl: TranslateRepositoryImpl
    ): TranslateRepository
}
