# Neo-Riemannian Transformations in Kotlin

This project allows for Hugo Riemann's triadic transformations to be executed programmatically.  For example:

```
val cMajor = Triad(
        root = PitchClass(PitchLetter.C),
        third = PitchClass(PitchLetter.E),
        fifth = PitchClass(PitchLetter.G)
)

val aMinor: Triad = cMajor.relative()
val cMinor: Triad = cMajor.parallel()
val eMinor: Triad = cMajor.leadingTone()
val gSharpMinor: Triad = cMajor.hexatonicPole()
val cSharpMinor: Triad = cMajor.slide()
val fMinor: Triad = cMajor.nebenverwandt()
``` 
