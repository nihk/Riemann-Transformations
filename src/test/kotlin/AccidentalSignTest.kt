import org.junit.Assert
import org.junit.Test

class AccidentalSignTest {

    @Test
    fun flatTimesOne() {
        val result = AccidentalSign.Flat * 1

        Assert.assertEquals(-1, result)
    }

    @Test
    fun flatTimesMany() {
        val result = AccidentalSign.Flat * 5

        Assert.assertEquals(-5, result)
    }

    @Test
    fun naturalTimesOne() {
        val result = AccidentalSign.Natural * 1
        Assert.assertEquals(0, result)
    }

    @Test
    fun naturalTimesMany() {
        val result = AccidentalSign.Natural * 5

        Assert.assertEquals(0, result)
    }

    @Test
    fun sharpTimesOne() {
        val result = AccidentalSign.Sharp * 1

        Assert.assertEquals(1, result)
    }

    @Test
    fun sharpTimesMany() {
        val result = AccidentalSign.Sharp * 5

        Assert.assertEquals(5, result)
    }
}