package com.tomining.tutorial.cancellation

import kotlinx.coroutines.*

/**
 * WAY 2. cancel coroutine: explicitly check the cancellation status (isActive)
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            println("isAction: $isActive")
            while(isActive) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
            println("isAction: $isActive")
        } catch (e: Exception) {
            println("Exception [$e] ...")   // this is never occurs because there is no exception to cancel coroutine
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}