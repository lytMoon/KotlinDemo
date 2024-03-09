package com.lytmoon.kotlinstart

import android.util.Log

class Demo1(val name:String,val age:Int) {

    constructor(name: String):this(name,100)

    //次构造函数
    constructor(name: String, age: Int, weight: Int) : this(name, age)




}

fun main() {
    val demo1= Demo1("李晓辉",30)
    println(demo1.age)
//    val  demo2 = Demo1()




}

