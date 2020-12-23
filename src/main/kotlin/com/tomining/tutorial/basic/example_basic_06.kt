package com.tomining.tutorial

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Structured Concurrency
 */
fun main() = runBlocking {
    launch {
        myWorld()
    }

    println("Hello, ")
}

suspend fun myWorld() {
    delay(1000L)
    println("World!")
}