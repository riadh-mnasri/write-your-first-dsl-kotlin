package com.riadhmnasri

import kotlin.math.roundToInt


fun main() {
    // Operator overloading
    val kotlinBook = Book("id1", "Programming Kotlin", 40.0)
    val dslBook = Book("id2", "Kotlin DSL", 35.0)
    println(kotlinBook + dslBook)

    // type alias
    mytasks name "DSL Todolist"

    // lambda Out of parentheses // transformC
    transformCustom("Hello Kotlin") { text -> text.uppercase() }

    // Infix functions
    println("Hello Kotlin" shouldBeEqualTo "Hello Kotlin")
    println("Hello Kotlin" shouldBeEqualTo "Hello")

    // Extension functions
    println(kotlinBook.rate(5))

    // Lambda with receiver // applyC Book
    kotlinBook.applyCustom {
        println(title.uppercase())
        println(price.roundToInt())
    }

    // Demo DSL

}

private fun Book.applyCustom(func: Book.() -> Unit): Book {
    func()
    return this
}

private fun Book.rate(note: Int) = "*".repeat(note)

private infix fun String.shouldBeEqualTo(text: String) = this == text

fun transformCustom(text: String, func: (String) -> String) = func(text)

private operator fun Book.plus(book: Book) = Book(this.id + " - " + book.id, this.title + " - " + book.title, this.price + book.price)

data class Book(val id: String, val title: String, val price: Double) {}

typealias mytasks = TodoList
object TodoList {
    infix fun name(text: String) {
        println("TodoList: $text")
    }
}

