data class PitchClass(
        val pitchLetter: PitchLetter,
        val accidental: Accidental = Accidental.NATURAL) {

    companion object {
        const val NUM_PITCH_CLASSES = 12
        const val MINOR_THIRD_INTERVAL = 3
        const val MAJOR_THIRD_INTERVAL = 4
    }

    fun interval(other: PitchClass) =
            (other.intValue() - intValue())
                    .apply {
                        return if (this < 0) this + NUM_PITCH_CLASSES
                        else this
                    }

    fun intValue() = pitchLetter.intValue() + accidental.intValue()

    fun isMinorThird(other: PitchClass) =
            interval(other) == MINOR_THIRD_INTERVAL

    fun isMajorThird(other: PitchClass) =
            interval(other) == MAJOR_THIRD_INTERVAL

    operator fun plus(i: Int) = PitchClass(pitchLetter, accidental + i)
    operator fun minus(i: Int) = plus(-i)

    override fun toString() = pitchLetter.toString() + accidental.toString()

    fun transpose(numLetters: Int, desiredInterval: Int): PitchClass {
        var newPitchClass = PitchClass(pitchLetter + numLetters)

        // Easy way to account for the inconsistencies of pitch intervals
        while (true) {
            val i = interval(newPitchClass)
            if (i < desiredInterval) {
                newPitchClass += 1
            } else if (i > desiredInterval) {
                newPitchClass -= 1
            } else {
                return newPitchClass
            }
        }
    }

}