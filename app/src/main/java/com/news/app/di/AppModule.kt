package com.news.app.di

import android.app.Application
import com.news.app.data.manager.LocalUserManagerImpl
import com.news.app.data.remote.NewsApi
import com.news.app.data.remote.repository.NewsRepositoryImpl
import com.news.app.domain.manager.LocalUserManager
import com.news.app.domain.repository.NewsRepository
import com.news.app.domain.usecases.appEntry.AppEntryUseCases
import com.news.app.domain.usecases.appEntry.ReadAppEntry
import com.news.app.domain.usecases.appEntry.SaveAppEntry
import com.news.app.domain.usecases.news.GetNews
import com.news.app.domain.usecases.news.NewsUseCases
import com.news.app.domain.usecases.news.SearchNews
import com.news.app.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}