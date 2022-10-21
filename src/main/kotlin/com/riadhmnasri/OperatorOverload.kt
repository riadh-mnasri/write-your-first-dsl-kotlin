package com.riadhmnasri

data class Book(val id: String, val title: String, val price: Double) {

}

operator fun Book.plus(book: Book): Book{
    return Book(this.id + "-"+ book.id, this.title + book.title, this.price + book.price)
}

fun main() {
    val kotlinBook = Book("id1", "Programming Kotlin", 40.0)
    val javaBook = Book("id2", "Programmig Java" , 35.0)
    println( kotlinBook + javaBook)
}