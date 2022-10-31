package com.riadhmnasri


fun main() {
    // Operator overloading
    val kotlinBook = Book("id1", "Programming Kotlin", 40.0)
    val javaBook = Book("id2", "Programmig Java", 35.0)
    println(kotlinBook + javaBook)
    // type alias
    mytasks name "prepare conference"
    // lambda Out of parentheses
    println(transform("Hello Kotlin") { text -> text.uppercase() })
    // Infix funnctions
    println("Hello Kotlin" assertEquals "Hello")
    println("Hello" assertEquals "Hello")
    // Extension functions
    println(kotlinBook.rate(5))
    // Lambda with receiver
    Book("id1", "programming kotlin", 40.0).applyAndReturn { println(title.uppercase()) }
}

fun Book.applyAndReturn(f: Book.() -> Unit): Book{
    f()
    return this
}

fun Book.rate(note: Int): String{
    return "*".repeat(note)
}


infix fun String.assertEquals(text: String): Boolean{
    return  this == text
}


fun transform(text: String, supplier: (String) -> String): String {
    return supplier(text)
}

object TodoList {
    infix fun name(text: String) {
        println("TodoList: $text")
    }
}

typealias mytasks = TodoList

data class Book(val id: String, val title: String, val price: Double) {}

operator fun Book.plus(book: Book): Book {
    return Book(this.id + "-" + book.id, this.title + "-" + book.title, this.price + book.price)
}
