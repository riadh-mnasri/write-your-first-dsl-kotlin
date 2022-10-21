package com.riadhmnasri

fun transform(text: String, supplier: (String) -> String): String {
    return supplier(text)
}

fun main() {
    println(transform("Hello Kotlin") { text -> text.uppercase() })
}