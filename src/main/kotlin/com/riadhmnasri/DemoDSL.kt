package com.riadhmnasri

fun main() {
    print("Please enter the filename for conference:")
    val fileName = readLine()
    val dsl = java.io.File(fileName).readText()
    val scriptEngine =
        javax.script.ScriptEngineManager().getEngineByExtension("kts")
    try {
        val result = scriptEngine.eval("""
import com.riadhmnasri
$dsl
""")
        println("Result of evaluation of the DSL:")
        println(result)
    } catch(ex: Exception) {
        println("""OOPS, we ran into an error.
${ex.message}""")
    }
}