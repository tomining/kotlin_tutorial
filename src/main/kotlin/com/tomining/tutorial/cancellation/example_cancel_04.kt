package com.tomining.tutorial.cancellation

import kotlinx.coroutines.*

/**
 * You can release some resources such as File, ByteStream and etc. in finally block.
 */
fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}