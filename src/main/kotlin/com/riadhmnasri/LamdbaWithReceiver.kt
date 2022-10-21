package com.riadhmnasri

fun main() {
    Book("id1", "programming kotlin", 40.0).applyAndReturn { println(title.uppercase()) }
}

fun Book.applyAndReturn(f: Book.() -> Unit): Book{
    f()
    return this
}