import arrow.refinement.Refined
import arrow.refinement.ensure

fun main() {
    PositiveInt2(1)
}

@JvmInline
value class PositiveInt2 private constructor(val value: Int) {
    companion object : Refined<Int, PositiveInt2>(::PositiveInt2, {
        ensure((it > 0) to "$it should be > 0")
    })
}