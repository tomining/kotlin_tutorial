package com.tomining.tutorial

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Coroutine will be finished when main process finished
 */
fun main() = runBlocking {
    GlobalScope.launch {
        repeat(1000) {i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }

    delay(1300L)
}