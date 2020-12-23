package com.tomining.tutorial.compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Structured concurrency with async
 * Do not use async function call in GlobalScope, must use concurrency in coroutineScope
 */
fun main() = runBlocking {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }

    println("Completed in $time ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    one.await() + two.await()
}



