package com.lytmoon.kotlinstart

class RedRocker(val language: String) : Study {


    override fun studyProgramming() {
        println("我爱学习$language")

    }

}

class RedRocker1(val language: String) : Study {
    override fun studyProgramming() {
        println("我爱学习$language")
    }
}

class RedRocker2(val language: String) : Study {
    override fun studyProgramming() {
        println("我也爱学习$language")
    }
}

fun main() {
    val study1: Study = RedRocker1("Kotlin")
    val study2: Study = RedRocker2("Java")
    study1.studyProgramming() // 输出: 我爱学习Kotlin
    study2.studyProgramming() // 输出: 我也爱学习Java
}