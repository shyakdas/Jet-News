package com.news.app.presentation.details

sealed class DetailsEvent {

    object SaveArticle : DetailsEvent()
}