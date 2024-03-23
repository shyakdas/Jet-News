package com.news.app.presentation.details

import androidx.lifecycle.ViewModel
import com.news.app.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val newsUseCases: NewsUseCases): ViewModel() {
    
}