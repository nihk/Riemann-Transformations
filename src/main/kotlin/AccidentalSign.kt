enum class AccidentalSign(val value: Int) {
    Flat(-1), Natural(0), Sharp(1);

    override fun toString() = when (this) {
        Flat -> "b"
        Natural -> ""
        Sharp -> "#"
    }

    operator fun times(numSigns: Int) = value * numSigns

    fun timesString(numSigns: Int): String {
        val builder = StringBuilder(this.toString())
        for (i in 1 until Math.abs(numSigns)) {
            builder.append(this.toString())
        }

        return builder.toString()
    }
}