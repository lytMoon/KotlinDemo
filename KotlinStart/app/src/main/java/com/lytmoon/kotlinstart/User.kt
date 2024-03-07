package com.lytmoon.kotlinstart

data class User(val name: String, val age: Int)


fun main() {
    val user1 = User("卷卷", 18)
    println(user1.toString())
}

