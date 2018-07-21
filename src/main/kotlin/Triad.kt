data class Triad(val root: PitchClass,
                 val third: PitchClass,
                 val fifth: PitchClass) {

    fun parallel() = Triad(root = root,
            third = when {
                isMinor() -> third.transpose(desiredInterval = 1)
                isMajor() -> third.transpose(desiredInterval = -1)
                else -> onNonMinorOrMajorTriad()
            },
            fifth = fifth)

    fun relative() = when {
        isMinor() -> Triad(root = third,
                third = fifth,
                fifth = root.transpose(-1, -2))
        isMajor() -> Triad(root = fifth.transpose(1, 2),
                third = root,
                fifth = third)
        else -> onNonMinorOrMajorTriad()
    }

    fun leadingTone() = when {
        isMinor() -> Triad(root = fifth.transpose(1, 1),
                third = root,
                fifth = third)
        isMajor() -> Triad(root = third,
                third = fifth,
                fifth = root.transpose(-1, -1))
        else -> onNonMinorOrMajorTriad()
    }

    fun nebenverwandt() = relative().leadingTone().parallel()

    fun slide() = leadingTone().parallel().relative()

    fun hexatonicPole() = leadingTone().parallel().leadingTone()

    fun dominant() = leadingTone().relative()

    fun tritone() = parallel().relative().parallel().relative()

    fun neapolitan() = slide().parallel()

    private fun isMinor() = root.isMinorThird(third) && third.isMajorThird(fifth)
    private fun isMajor() = root.isMajorThird(third) && third.isMinorThird(fifth)
    private fun isDiminished() = root.isMinorThird(third) && third.isMinorThird(fifth)
    private fun isAugmented() = root.isMajorThird(third) && fifth.isMajorThird(fifth)

    private fun onNonMinorOrMajorTriad(): Nothing =
            error("Triad was neither minor nor major")
}
