data class Triad(
        val root: PitchClass,
        val third: PitchClass,
        val fifth: PitchClass) {

    fun parallel() = Triad(
            root,
            if (isMinor()) third + 1 else third - 1,
            fifth
    )

    fun relative() = if (isMinor()) {
        Triad(
                root = third,
                third = fifth,
                fifth = root.transpose(6, 10)
        )
    } else {
        Triad(
                root = fifth.transpose(1, 2),
                third = root,
                fifth = third
        )
    }

    fun leadingTone() = if (isMinor()) {
        Triad(
                root = fifth.transpose(1, 1),
                third = root,
                fifth = third
        )
    } else {
        Triad(
                root = third,
                third = fifth,
                fifth = root.transpose(6, 11)
        )
    }

    fun nebenverwandt() = relative().leadingTone().parallel()

    fun slide() = leadingTone().parallel().relative()

    fun hexatonicPole() = leadingTone().parallel().leadingTone()

    fun isMinor() = root.isMinorThird(third)

    fun isMajor() = root.isMajorThird(third)
}