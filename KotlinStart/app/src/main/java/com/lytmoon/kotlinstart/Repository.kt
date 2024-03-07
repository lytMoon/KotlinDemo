package com.lytmoon.kotlinstart

object Repository {
    private val data = mutableListOf<String>()

    fun addData(item: String) {
        data.add(item)
    }
    fun getData():String{
        return data.toString()
    }

}

fun main() {
//    Repository.addData("苟学姐")
//    Repository.addData("周学姐")
//    println(Repository.getData())



    val list = mutableListOf("苟学姐","周学姐","......")
    list.add("胡学姐")
    println(list)

    val set = setOf<String>("苟学姐","周学姐","胡学姐","......")
    for (it in set){
        println(it)
    }
    listOf(1, 2, 3).forEach { item -> println(item) }

}