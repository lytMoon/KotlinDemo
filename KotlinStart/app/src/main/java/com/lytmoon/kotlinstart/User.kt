package com.lytmoon.kotlinstart

data class User(val name: String, val age: Int)


fun main() {
    val list = listOf("苟云东学姐","苟云东学姐")


    listOf(1, 2, 3).forEach{ item -> println(item) }

    val sum: (Int, Int) -> Int = { x, y -> x + y }

    println(sum(1, 2)) // 输出结果为3
}


