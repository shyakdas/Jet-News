package com.news.app

import com.news.app.util.NewsUtils
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class NewsUtilsTest {
    @Test
    fun testTimeAgoString() {
        val currentTime = Calendar.getInstance().timeInMillis
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")

        // Test cases with different time intervals
        val oneSecondAgo = sdf.format(Date(currentTime - 1000))
        val oneMinuteAgo = sdf.format(Date(currentTime - 60000))
        val oneHourAgo = sdf.format(Date(currentTime - 3600000))
        val oneDayAgo = sdf.format(Date(currentTime - 86400000))
        val oneMonthAgo = sdf.format(Date(currentTime - 2592000000))
        val oneYearAgo = sdf.format(Date(currentTime - 31536000000))

        assertEquals("1 second ago", NewsUtils.getTimeAgoString(oneSecondAgo))
        assertEquals("1 minute ago", NewsUtils.getTimeAgoString(oneMinuteAgo))
        assertEquals("1 hour ago", NewsUtils.getTimeAgoString(oneHourAgo))
        assertEquals("1 day ago", NewsUtils.getTimeAgoString(oneDayAgo))
        assertEquals("1 month ago", NewsUtils.getTimeAgoString(oneMonthAgo))
        assertEquals("1 year ago", NewsUtils.getTimeAgoString(oneYearAgo))
    }
}