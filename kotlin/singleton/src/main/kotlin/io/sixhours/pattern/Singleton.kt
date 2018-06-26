package io.sixhours.pattern

object Singleton : Comparator<Int> {

    override fun compare(o1: Int?, o2: Int?): Int {
        if (o1 == null || o2 == null) throw IllegalArgumentException("Value cannot be null.")

        return if (o1.length() != o2.length()) o2.length() - o1.length() else o2 - o1
    }

    private fun Int.length() = this.toString().length
}

fun main(args: Array<String>) {
    println(listOf(1234, 987, 789, 234, 2000).sortedWith(Singleton))
}