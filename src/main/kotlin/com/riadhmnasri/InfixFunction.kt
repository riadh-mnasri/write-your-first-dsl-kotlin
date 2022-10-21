package com.riadhmnasri

infix fun String.assertEquals(text: String): Boolean{
    return  this == text
}

fun main() {
    println("Hello Kotlin" assertEquals "Hello")
    println("Hello" assertEquals "Hello")
}