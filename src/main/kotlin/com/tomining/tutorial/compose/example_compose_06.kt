import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Structured concurrency with async
 * Do not use async function call in GlobalScope, must use concurrency in coroutineScope
 */
fun main() = runBlocking {
    try {
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum()}")
        }

        println("Completed in $time ms")
    } catch (e: Exception) {

    }

    runBlocking {
        delay(10000L)
    }
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }

    delay(10L)
    println("exception")
    throw Exception("exception")

    one.await() + two.await()
}

suspend fun doSomethingUsefulOne(): Int {
    println("start: doSomethingUsefulOne")
    delay(1000L)
    println("end: doSomethingUsefulOne")
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    println("start: doSomethingUsefulTwo")
    delay(1000L)
    println("end: doSomethingUsefulTwo")
    return 29
}



