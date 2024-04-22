import com.news.app.data.local.NewsTypeConverter
import com.news.app.domain.model.Source
import junit.framework.TestCase.assertEquals
import org.junit.Test

class NewsTypeConverterTest {
    @Test
    fun sourceToStringTest() {
        val source = Source("id1", "Name")
        val result = NewsTypeConverter().sourceToString(source)
        assertEquals("id1, Name", result)
    }

    @Test
    fun stringToSourceTest() {
        val string = "id1,Name"
        val result = NewsTypeConverter().stringToSource(string)
        val expected = Source("id1", "Name")
        assertEquals(expected, result)
    }
}