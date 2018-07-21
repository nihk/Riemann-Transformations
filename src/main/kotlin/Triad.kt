data class Triad(val root: PitchClass,
                 val third: PitchClass,
                 val fifth: PitchClass) {

    fun parallel() = Triad(root = root,
            third = if (isMinor()) third + 1
                    else if (isMajor()) third - 1
                    else onNonMinorOrMajorTriad(),
            fifth = fifth)

    fun relative() = if (isMinor()) {
        Triad(root = third,
                third = fifth,
                fifth = root.transpose(6, 10))
    } else if (isMajor()) {
        Triad(root = fifth.transpose(1, 2),
                third = root,
                fifth = third)
    } else {
        onNonMinorOrMajorTriad()
    }

    fun leadingTone() = if (isMinor()) {
        Triad(root = fifth.transpose(1, 1),
                third = root,
                fifth = third)
    } else if (isMajor()) {
        Triad(root = third,
                third = fifth,
                fifth = root.transpose(6, 11))
    } else {
        onNonMinorOrMajorTriad()
    }

    fun nebenverwandt() = relative().leadingTone().parallel()

    fun slide() = leadingTone().parallel().relative()

    fun hexatonicPole() = leadingTone().parallel().leadingTone()

    fun isMinor() = root.isMinorThird(third) && third.isMajorThird(fifth)

    fun isMajor() = root.isMajorThird(third) && third.isMinorThird(fifth)

    private fun onNonMinorOrMajorTriad(): Nothing =
            error("Triad was neither minor nor major")
}