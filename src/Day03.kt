fun main() {
    fun part1(input: List<String>): Int {

        val columnRange = input[0].indices

        val result = columnRange.map { column -> input.groupingBy { it[column] }.eachCount() }

        val gamma = result.joinToString("") { it.maxByOrNull { map-> map.value}?.key.toString() }
        val epsilon = result.joinToString("") { it.minByOrNull { map-> map.value }?.key.toString()}

        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
       return 1
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}