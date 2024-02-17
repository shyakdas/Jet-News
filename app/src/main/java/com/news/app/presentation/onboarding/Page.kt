package com.news.app.presentation.onboarding

import androidx.annotation.DrawableRes
import com.news.app.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


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
