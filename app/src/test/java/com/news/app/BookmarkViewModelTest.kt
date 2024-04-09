import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.news.app.domain.model.Article
import com.news.app.domain.usecases.news.NewsUseCases
import com.news.app.presentation.bookmark.BookmarkViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class BookmarkViewModelTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    // This is needed for testing coroutines.
    private val testDispatcher = TestCoroutineDispatcher()
    private val testCoroutineScope = TestCoroutineScope(testDispatcher)

    // Mock dependencies
    @Mock
    private lateinit var newsUseCases: NewsUseCases

    // Class under test
    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setUp() {
//        MockitoAnnotations.initMocks(this)
//
//        // Mock behavior of newsUseCases
//        val selectArticlesFlow = flowOf(listOf<Article>()) // Provide an initial empty list of articles
//        `when`(newsUseCases.selectArticles()).thenReturn(selectArticlesFlow)
//
//        viewModel = BookmarkViewModel(newsUseCases)
    }

    @Test
    fun `test getArticles`() = testCoroutineScope.runBlockingTest {
        // Test the function
        // viewModel.getArticles()

        // Assert the initial state
       // assert(viewModel.state.value.articles.isEmpty())
    }
}
