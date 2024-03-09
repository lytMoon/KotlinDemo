package com.lytmoon.kotlinstart

class Test {


}


fun main() {


// 使用函数
    printTypeInfo("Hello") // 输出：这是一个字符串
    printTypeInfo(123) // 输出：这是一个整数
    printTypeInfo(true) // 输出：这是一个布尔值

    val demo = Demo()

    val age = 18
    val name = "周博"
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

//
//    for (i in 1..5) {
//        println(i)
//    }


    // 创建 Classroom 对象
    val classroom2101 = Classroom("2101", 100)
    val classroom2102 = Classroom("2102", 100)
    val classroom3102 = Classroom("3102", 120)

// 打印教室详情
    classroom2101.printDetails() // 输出: 教室门牌号: 2101, 容纳人数: 100
    classroom2102.printDetails() // 输出: 教室门牌号: 2102, 容纳人数: 100
    classroom3102.printDetails() // 输出: 教室门牌号: 3102, 容纳人数: 120


    val person = Person("卷娘", 18)
    val person2 = Person()
    val person3 = Person("卷娘", 18, 60)
    println(person.name)
    println(person.age)


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


// 定义一个 Classroom 类
class Classroom(val roomNumber: String, val capacity: Int) {
    fun printDetails() {
        println("教室门牌号: $roomNumber, 容纳人数: $capacity")
    }
}


open class Animal {
    fun eat() {

    }
}

class Dog : Animal() {
    fun bark() {

    }
}

open class Person(val name: String, val age: Int) {
    // 主构造函数


    //次构造函数
    constructor(name: String) : this(name, 0)

    //次构造函数
    constructor() : this("无", 0)

    //次构造函数
    constructor(name: String, age: Int, weight: Int) : this(name, age)
}


class Person1 : Person {

    //次构造函数
    constructor(name: String, age: Int) : super(name, age)

}


class Person2 {
    var name: String
    var age: Int
    var weight: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    constructor(name: String, age: Int, weight: Int) {
        this.name = name
        this.age = age
        this.weight = weight
    }

    //这里的this会调用适合的次构造函数,当然也是可以不委托的
    constructor(name: String) : this(name, 0) {
        // 可以在这里添加额外的初始化代码
    }

}
fun printTypeInfo(obj: Any) {
    when (obj) {
        is String -> println("这是一个字符串")
        is Int -> println("这是一个整数")
        is Boolean -> println("这是一个布尔值")
        else -> println("未知类型")
    }
}





