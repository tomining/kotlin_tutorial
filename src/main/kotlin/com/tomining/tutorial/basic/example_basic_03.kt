package com.tomining.tutorial

import kotlinx.coroutines.*

fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello, ")
    delay(2000L)
}