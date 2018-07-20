import org.junit.Assert
import org.junit.Test

class TriadTest {

    companion object {
        val cNatural = PitchClass(PitchLetter.C)
        val dNatural = PitchClass(PitchLetter.D)
        val dSharp = PitchClass(PitchLetter.D, Accidental.SHARP)
        val eNatural = PitchClass(PitchLetter.E)
        val eFlat = PitchClass(PitchLetter.E, Accidental.FLAT)
        val gNatural = PitchClass(PitchLetter.G)
        val gSharp = PitchClass(PitchLetter.G, Accidental.SHARP)
        val bNatural = PitchClass(PitchLetter.B)
    }

    @Test
    fun parallel() {
        val cMajor = Triad(cNatural, eNatural, gNatural)
        val result = cMajor.parallel()
        val expected = Triad(cNatural, eFlat, gNatural)
        val expected2 = expected.parallel()

        Assert.assertEquals(expected, result)
        Assert.assertEquals(expected2, cMajor)
    }

    @Test
    fun relative() {
        val gMajor = Triad(gNatural, bNatural, dNatural)
        val result = gMajor.relative()
        val expected = Triad(eNatural, gNatural, bNatural)
        val expected2 = expected.relative()

        Assert.assertEquals(expected, result)
        Assert.assertEquals(expected2, gMajor)
    }

    @Test
    fun leadingTone() {
        val eMajor = Triad(eNatural, gSharp, bNatural)
        val result = eMajor.leadingTone()
        val expected = Triad(gSharp, bNatural, dSharp)
        val expected2 = expected.leadingTone()

        Assert.assertEquals(expected, result)
        Assert.assertEquals(expected2, eMajor)
    }
}