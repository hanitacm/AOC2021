fun main() {
    fun mapToListOfInteger(input: List<String>): MutableList<Int> {
        val list = mutableListOf<Int>()
        input.mapTo(list) { it.toInt() }
        return list
    }

    fun part1(input: List<String>): Int {
        var previousDepth = 0
        var counter = 0

        mapToListOfInteger(input).map {
            if (it > previousDepth) counter++
            previousDepth = it
        }

        return counter - 1
    }

    fun part2(input: List<String>): Int {
        val list = mapToListOfInteger(input)
        val resultList = mutableListOf<String>()

        for (i in 0 until list.size - 2) {
            resultList.add(list.slice(i..i + 2).sum().toString())
        }

        return part1(resultList)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
