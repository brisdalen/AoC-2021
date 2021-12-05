package day2

import java.io.File

class Day2(filepath: String) {

    private val lines = File(filepath).readLines()
        .stream()
        .toList()

    init {
        day2a()
        day2b()
    }

    private fun day2a() {
        var x = 0
        var depth = 0

        lines.forEach { c ->
            val parts = c.split(" ")
            val value = Integer.valueOf(parts[1])

            when(parts[0]) {
                "forward" -> x += value
                "down" -> depth += value
                "up" -> depth -= value
            }
        }

        println(x * depth)
    }

    private fun day2b() {
        var aim = 0
        var x = 0
        var depth = 0

        lines.forEach { c ->
            val parts = c.split(" ")
            val value = Integer.valueOf(parts[1])

            when(parts[0]) {
                "down" -> aim += value
                "up" -> aim -= value
                "forward" -> {
                    x += value
                    depth += aim * value
                }
            }
        }

        println(x * depth)
    }
}