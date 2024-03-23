package com.news.app.presentation.details

sealed class DetailsEvent {

    object UpsertDeleteArticle : DetailsEvent()
    object RemoveSideEvent : DetailsEvent()
}