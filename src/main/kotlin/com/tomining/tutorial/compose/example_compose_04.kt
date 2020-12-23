package com.tomining.tutorial.compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Async style function
 * - Kotlin coroutine is strongly discouraged
 */
fun main() {
    try {
        val time = measureTimeMillis {
            val one = doSomethingUsefulOneAsync()
            val two = doSomethingUsefulTwoAsync()

            println("my exception")
            throw Exception("my exceptions")
            runBlocking {
                println("The answer is ${one.await() + two.await()}")
            }

        }
        println("Completed in $time ms")
    } catch (e: Exception) {

    }

    runBlocking {
        delay(10000L)
    }
}

fun doSomethingUsefulOneAsync() = GlobalScope.async {
    println("start: doSomethingUsefulOneAsync")
    val result = doSomethingUsefulOne()
    println("end: doSomethingUsefulOneAsync")
    result
}

fun doSomethingUsefulTwoAsync() = GlobalScope.async {
    println("start: doSomethingUsefulTwoAsync")
    val result = doSomethingUsefulTwo()
    println("end: doSomethingUsefulTwoAsync")
    result
}




