import org.junit.Assert
import org.junit.Test

class PitchClassTest {

    @Test
    fun dFlatIntValue() {
        val dFlat = PitchClass(PitchLetter.D, Accidental.FLAT)

        Assert.assertEquals(1, dFlat.intValue())
    }

    @Test
    fun dDoubleFlatIntValue() {
        val dFlat = PitchClass(PitchLetter.D, Accidental(AccidentalSign.Flat, 2))

        Assert.assertEquals(0, dFlat.intValue())
    }

    @Test
    fun fNaturalIntValue() {
        val fNatural = PitchClass(PitchLetter.F)

        Assert.assertEquals(5, fNatural.intValue())
    }

    @Test
    fun aSharpIntValue() {
        val aSharp = PitchClass(PitchLetter.A, Accidental.SHARP)

        Assert.assertEquals(10, aSharp.intValue())
    }

    @Test
    fun aDoubleSharpIntValue() {
        val aDoubleSharp = PitchClass(PitchLetter.A, Accidental(AccidentalSign.Sharp, 2))

        Assert.assertEquals(11, aDoubleSharp.intValue())
    }

    @Test
    fun semitoneDistance() {
        val cNatural = PitchClass(PitchLetter.C)
        val dFlat = PitchClass(PitchLetter.D, Accidental.FLAT)

        Assert.assertEquals(1, cNatural.interval(dFlat))
        Assert.assertEquals(11, dFlat.interval(cNatural))
    }

    @Test
    fun minorThirdDistance() {
        val dFlat = PitchClass(PitchLetter.D, Accidental.FLAT)
        val fFlat = PitchClass(PitchLetter.F, Accidental.FLAT)

        Assert.assertEquals(3, dFlat.interval(fFlat))
        Assert.assertEquals(9, fFlat.interval(dFlat))
    }

    @Test
    fun majorThirdDistance() {
        val aSharp = PitchClass(PitchLetter.A, Accidental.SHARP)
        val cDoubleSharp = PitchClass(PitchLetter.C, Accidental(AccidentalSign.Sharp, 2))
        Assert.assertEquals(4, aSharp.interval(cDoubleSharp))
        Assert.assertEquals(8, cDoubleSharp.interval(aSharp))
    }

    @Test
    fun plusOne() {
        val cNatural = PitchClass(PitchLetter.C)
        val result = cNatural + 1

        Assert.assertEquals(PitchClass(PitchLetter.C, Accidental.SHARP), result)
    }

    @Test
    fun plusTwo() {
        val dSharp = PitchClass(PitchLetter.D, Accidental.SHARP)
        val result = dSharp + 2

        Assert.assertEquals(PitchClass(PitchLetter.D, Accidental(AccidentalSign.Sharp, 3)), result)
    }

    @Test
    fun minusOne() {
        val fFlat = PitchClass(PitchLetter.F, Accidental.FLAT)
        val result = fFlat - 1

        Assert.assertEquals(PitchClass(PitchLetter.F, Accidental(AccidentalSign.Flat, 2)), result)
    }

    @Test
    fun minusTwoFromSharp() {
        val aSharp = PitchClass(PitchLetter.A, Accidental.SHARP)
        val result = aSharp - 2

        Assert.assertEquals(PitchClass(PitchLetter.A, Accidental.FLAT), result)
    }

    @Test
    fun addTwoToFlat() {
        val bFlat = PitchClass(PitchLetter.B, Accidental.FLAT)
        val result = bFlat + 2

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental.SHARP), result)
    }

    @Test
    fun semitoneTranspose() {
        val eNatural = PitchClass(PitchLetter.E)
        val result = eNatural.transpose(1, 1)

        Assert.assertEquals(PitchClass(PitchLetter.F), result)
    }

    @Test
    fun majorSecondTranspose() {
        val eNatural = PitchClass(PitchLetter.E)
        val result = eNatural.transpose(1, 2)

        Assert.assertEquals(PitchClass(PitchLetter.F, Accidental.SHARP), result)
    }

    @Test
    fun minorThirdTranspose() {
        val gSharp = PitchClass(PitchLetter.G, Accidental.SHARP)
        val result = gSharp.transpose(2, 3)

        Assert.assertEquals(PitchClass(PitchLetter.B), result)
    }

    @Test
    fun majorSeventhTranspose() {
        val cSharp = PitchClass(PitchLetter.C, Accidental.SHARP)
        val result = cSharp.transpose(6, 11)

        Assert.assertEquals(PitchClass(PitchLetter.B, Accidental.SHARP), result)
    }

    @Test
    fun descendingMinorThirdTranspose() {
        val gSharp = PitchClass(PitchLetter.G, Accidental.SHARP)
        val result = gSharp.transpose(-2, -3)

        Assert.assertEquals(PitchClass(PitchLetter.E, Accidental.SHARP), result)
    }

    @Test
    fun descendingSemitoneTransposeDifferentLetter() {
        val eNatural = PitchClass(PitchLetter.E)
        val result = eNatural.transpose(-1, -1)

        Assert.assertEquals(PitchClass(PitchLetter.D, Accidental.SHARP), result)
    }

    @Test
    fun descendingSemitoneTransposeSameLetter() {
        val eNatural = PitchClass(PitchLetter.E)
        val result = eNatural.transpose(0, -1)

        Assert.assertEquals(PitchClass(PitchLetter.E, Accidental.FLAT), result)
    }
}