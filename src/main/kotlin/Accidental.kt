data class Accidental(val accidentalSign: AccidentalSign, val numSigns: Int = 1) {

    init {
        if (numSigns < 1) {
            throw ExceptionInInitializerError("Accidental quantity cannot be less than 1. Was given: $numSigns")
        }
    }

    companion object {
        val NATURAL = Accidental(AccidentalSign.Natural)
        val FLAT = Accidental(AccidentalSign.Flat)
        val SHARP = Accidental(AccidentalSign.Sharp)

        fun fromIntValue(i: Int): Accidental {
            if (i == 0) return NATURAL
            if (i < 0) return Accidental(AccidentalSign.Flat, Math.abs(i))
            if (i > 0) return Accidental(AccidentalSign.Sharp, Math.abs(i))

            throw IllegalStateException("Cannot result int value: $i")
        }
    }

    fun intValue() = accidentalSign * numSigns

    operator fun plus(i: Int) = fromIntValue(intValue() + i)

    override fun toString() = accidentalSign.timesString(numSigns)
}