package com.news.app.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.app.domain.usecases.appEntry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel responsible for handling onboarding related logic.
 * Uses Hilt for dependency injection.
 */
@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases) :
    ViewModel() {

    /**
     * Handles events related to onboarding screens.
     * @param event The event to handle.
     */
    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    /**
     * Saves the app entry, typically triggered after completing onboarding.
     */
    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}