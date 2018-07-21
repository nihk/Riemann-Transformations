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
                fifth = root.transpose(-1, -2))
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
                fifth = root.transpose(-1, -1))
    } else {
        onNonMinorOrMajorTriad()
    }

    fun nebenverwandt() = relative().leadingTone().parallel()

    fun slide() = leadingTone().parallel().relative()

    fun hexatonicPole() = leadingTone().parallel().leadingTone()

    private fun isMinor() = root.isMinorThird(third) && third.isMajorThird(fifth)
    private fun isMajor() = root.isMajorThird(third) && third.isMinorThird(fifth)
    private fun isDiminished() = root.isMinorThird(third) && third.isMinorThird(fifth)
    private fun isAugmented() = root.isMajorThird(third) && fifth.isMajorThird(fifth)

    private fun onNonMinorOrMajorTriad(): Nothing =
            error("Triad was neither minor nor major")
}
