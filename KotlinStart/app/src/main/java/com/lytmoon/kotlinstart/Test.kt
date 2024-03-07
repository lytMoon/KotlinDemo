package com.lytmoon.kotlinstart

class Test {

}

fun main() {

//    val age = 18
//    val name = "周博"
//    age=11

//   println(greet("Android"))


//    val x = 1
//    when (x) {
//        1 -> {
//            fun1()
//        }
//        2 ->{} println("x 等于 2")
//        else -> println("x 不是 1 也不是 2")
//    }


    for (i in 1..5) {
        println(i)
    }



}

fun greet(name: String, greeting: String = "Hello"): String {
    return "$greeting, $name!"
}


//fun greet(name: String, greeting: String = "Hello"): String= "$greeting, $name!"


fun greet() {

}

fun minChoose(a: Int, b: Int): Int {
    return if (a < b) {
        a
    } else {
        b
    }
}





//fun minChoose(a: Int, b: Int): Int = if (a < b) a else b



