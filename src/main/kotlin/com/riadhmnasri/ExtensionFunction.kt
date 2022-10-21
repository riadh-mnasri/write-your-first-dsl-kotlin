package com.riadhmnasri

fun Book.rate(note: Int): String{
    return "*".repeat(note)
}

fun main() {
    val kotlinBook = Book("id1", "Programming Kotlin", 40.0)
    println(kotlinBook.rate(5))
}