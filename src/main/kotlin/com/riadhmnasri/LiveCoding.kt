package com.riadhmnasri



fun main() {
    // Operator overloading

    // type alias

    // lambda Out of parentheses // transformC

    // Infix functions

    // Extension functions

    // Lambda with receiver // applyC Book

    // Demo DSL

}

private fun Book.applyC(func: Book.() -> Unit): Book {
    func()
    return this
}

private fun Book.rate(note: Int) = "*".repeat(note)

private infix fun String.shouldBeEqualTo(text: String): Boolean = this == text

fun transformC(text: String, func: (String) -> String): String {
    return func(text)
}

private operator fun Book.plus(book: Book) =
    Book(this.id + book.id, this.title + book.title, this.price + book.price)

data class Book(val id: String, val title: String, val price: Double) {}

typealias mytasks = TodoList

object TodoList {
    infix fun name(text: String) {
        println("TodoList: $text")
    }
}