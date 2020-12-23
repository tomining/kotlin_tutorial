package com.tomining.tutorial.cancellation

import kotlinx.coroutines.*

/**
 * WAY 1. cancel coroutine: to periodically invoke a suspending
 * Coroutine can be cancelled if CoroutineScope has any suspend function call.
 * if not, CoroutineScope will be finished at the end of coroutine block.
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            while(i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    // delay(1L)
                    yield()
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        } catch (e: Exception) {
            println("Exception [$e]")
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}