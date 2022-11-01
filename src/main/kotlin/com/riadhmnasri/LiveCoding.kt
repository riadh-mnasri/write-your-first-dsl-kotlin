package com.riadhmnasri


fun main() {
    // Operator overloading
    val kotlinBook = Book("id1", "Programming Kotlin", 40.0)
    val dslBook = Book("id2", "Kotlin DSL", 35.0)
    println(kotlinBook + dslBook)

    // type alias
    myTasks name "DSL todolist"

    // lambda Out of parentheses // transform
    println(transformC("Hello Kotlin") { t -> t.uppercase() })

    // Infix functions
    println("Hello Kotlin" shouldBeEqualTo "Hello Kotlin")
    println("Hello Kotlin" shouldBeEqualTo "Hello")

    // Extension functions
    println(kotlinBook.rate(5))

    // Lambda with receiver // apply Book
    kotlinBook.applyC {
        println(title.uppercase())
    }

    // Demo DSL

}

private fun Book.applyC(f: Book.() -> Unit): Book {
    f()
    return this
}

private fun Book.rate(note: Int): String = "*".repeat(note)

private infix fun String.shouldBeEqualTo(text: String) = this == text

fun transformC(text: String, func: (String) -> String): String {
    return func(text)
}

private operator fun Book.plus(book: Book): Book {
    return Book(this.id + " - " + book.id, this.title + " - " + book.title, this.price + book.price)
}

data class Book(val id: String, val title: String, val price: Double) {}

typealias myTasks = TodoList

object TodoList {
    infix fun name(text: String) {
        println("TodoList: $text")
    }
}