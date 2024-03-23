package com.news.app.presentation.details

import com.news.app.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEvent : DetailsEvent()
}