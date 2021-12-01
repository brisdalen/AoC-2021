package day1

import java.io.File
import kotlin.streams.toList

class Day1(filepath: String) {

    private val input = File(filepath).readLines()
        .stream()
        .mapToInt(String::toInt)
        .toList()

    init {
        day1a()
        day1b()
    }

    private fun day1a() {
        var numIncreased = 0
        for(i in 1 until input.size) {
            if(input[i] > input[i-1]) {
                numIncreased++
            }
        }
        println(numIncreased)
    }

    private fun day1b() {
        var sumsIncreased = 0
        for(i in 0 until input.size - 3) {
            // Compare N+1 to N
            if(sum(i + 1, input) > sum(i, input)) {
                sumsIncreased++
            }
        }
        print(sumsIncreased)
    }

    private fun sum(i: Int, input: List<Int>) : Int {
        return input[i] + input[i + 1] + input[i + 2]
    }
}