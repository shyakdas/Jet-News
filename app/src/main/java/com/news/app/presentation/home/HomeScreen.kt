package com.news.app.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.news.app.R
import com.news.app.domain.model.Article
import com.news.app.presentation.Dimens
import com.news.app.presentation.common.ArticleList
import com.news.app.presentation.common.SearchBar
import com.news.app.presentation.navgraph.Route

/**
 * Composable function to display the home screen.
 *
 * @param articles LazyPagingItems representing the list of articles to display.
 * @param navigateToSearch Callback function to navigate to the search screen.
 * @param navigateToDetails Callback function to navigate to the details screen for a specific article.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    // Extract titles of the first 10 articles for display
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items.slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.MediumPadding1)
            .statusBarsPadding()
    ) {
        // Display app logo
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = Dimens.MediumPadding1)
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        SearchBar(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = {
                navigateToSearch()
            },
            onSearch = {})
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        // Display titles of the first 10 articles
        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimens.MediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        // Display list of articles
        ArticleList(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            articles = articles,
            onClick = {
                navigateToDetails(it)
            })
    }
}