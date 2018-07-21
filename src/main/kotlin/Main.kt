fun main(args: Array<String>) {
    val cMajor = Triad(
            root = PitchClass(PitchLetter.C),
            third = PitchClass(PitchLetter.E),
            fifth = PitchClass(PitchLetter.G)
    )

    println(cMajor.relative())       // A minor
    println(cMajor.parallel())       // C minor
    println(cMajor.leadingTone())    // E minor
    println(cMajor.hexatonicPole())  // G# minor
    println(cMajor.slide())          // C# minor
    println(cMajor.nebenverwandt())  // F minor
    println(cMajor.dominant())       // G major
    println(cMajor.tritone())        // Gb major
    println(cMajor.neapolitan())     // C# major
}