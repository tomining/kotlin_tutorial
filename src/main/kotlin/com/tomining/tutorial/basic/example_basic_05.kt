package com.tomining.tutorial

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Structured Concurrency
 */
fun main() = runBlocking {
    launch {
        delay(1000L)
        println("World!")
    }

    println("Hello, ")
}