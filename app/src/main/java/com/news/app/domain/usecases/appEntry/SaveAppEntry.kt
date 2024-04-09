package com.news.app.domain.usecases.appEntry

import com.news.app.domain.manager.LocalUserManager

/**
 * Use case class for saving the app entry preference.
 * @param localUserManager The LocalUserManager instance for accessing user preferences.
 */
class SaveAppEntry(private val localUserManager: LocalUserManager) {

    /**
     * Invokes the use case to save the app entry preference.
     */
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}