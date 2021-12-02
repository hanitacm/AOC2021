fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0

        input.map {
            val command = it.split(" ")
            when (command[0]) {
                "forward" -> x += command[1].toInt()
                "up" -> y -= command[1].toInt()
                "down" -> y += command[1].toInt()
            }
        }

        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0

        input.map {
            val command = it.split(" ")
            when (command[0]) {
                "forward" -> {
                    x += command[1].toInt()
                    if (aim > 0) y += aim * command[1].toInt()
                }
                "up" -> aim -= command[1].toInt()
                "down" -> aim += command[1].toInt()
            }
        }

        return x * y
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}