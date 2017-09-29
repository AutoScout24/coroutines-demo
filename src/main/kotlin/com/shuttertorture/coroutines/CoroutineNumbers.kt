package com.shuttertorture.coroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.atomic.AtomicInteger

object CoroutineNumbers {

    suspend fun sumAsync(inNumberOfCoroutines: Int): Int {
        val initial = AtomicInteger(0)
        return List(inNumberOfCoroutines) {
            async(CommonPool) {
                initial.incrementAndGet()
            }
        }.fold(0, { _, next ->
            next.await()
        })
    }

    suspend fun launchAsync(inNumberOfCoroutines: Int) {
        val initial = AtomicInteger(0)
        List(inNumberOfCoroutines) {
            launch(CommonPool) {
                initial.incrementAndGet()
            }
        }.forEach { it.join() }
    }
}