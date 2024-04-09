package com.news.app.presentation.onboarding

import androidx.annotation.DrawableRes
import com.news.app.R

/**
 * Data class representing a page in the onboarding screen.
 * @property title The title of the page.
 * @property description The description of the page.
 * @property image The drawable resource ID of the image associated with the page.
 */
data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

/**
 * List of predefined onboarding pages.
 */
val pages = listOf(
    Page(
        title = "Loren Ipsum is simply dummy",
        description = "Loren Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Loren Ipsum is simply dummy",
        description = "Loren Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Loren Ipsum is simply dummy",
        description = "Loren Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding3
    )
)
