package com.riadhmnasri


fun main() {
    // Operator overloading
    val kotlinBook = Book("id1", "Programming Kotlin", 40.0)
    val dslBook = Book("id2", "Kotlin DSL", 35.0)
    println(kotlinBook + dslBook)

    // type alias
    mytasks name "DSL Todo list"

    // lambda Out of parentheses
    println(transform("Hello DevCon") { it.uppercase() })

    // Infix functions
    println("Hello Kotlin" assertEquals "Hello")
    println("Hello" assertEquals "Hello")

    // Extension functions
    println(kotlinBook.rate(5))

    // Lambda with receiver
   kotlinBook.apply {
        println(title.uppercase())
    }

    // Demo DSL

}

fun Book.apply(f: Book.() -> Unit): Book{
    f()
    return this
}

private infix fun String.assertEquals(text: String): Boolean {
    return this == text
}

private fun Book.rate(note: Int): String = "*".repeat(note)

data class Book(val id: String, val title: String, val price: Double) {}

operator fun Book.plus(book: Book): Book {
    return Book(this.id + " - " + book.id, this.title + " - " + book.title, this.price + book.price)
}

fun transform(text: String, block: (String) -> String): String {
    return block(text)
}

typealias mytasks = TodoList

object TodoList {
    infix fun name(text: String) {
        println("TodoList: $text")
    }
}