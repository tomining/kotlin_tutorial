package com.tomining.tutorial

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * coroutine vs thread
 */
fun main() = runBlocking {
    repeat(100_000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}

//fun main() = runBlocking {
//    repeat(100_000) {
//        thread {
//            Thread.sleep(1000L)
//            print(".")
//        }
//    }
//}