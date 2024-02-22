package com.news.app.di

import android.app.Application
import com.news.app.data.manager.LocalUserManagerImpl
import com.news.app.domain.manager.LocalUserManager
import com.news.app.domain.usecases.AppEntry.AppEntryUseCases
import com.news.app.domain.usecases.AppEntry.ReadAppEntry
import com.news.app.domain.usecases.AppEntry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}