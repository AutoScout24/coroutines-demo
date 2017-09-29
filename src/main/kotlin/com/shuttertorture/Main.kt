package com.shuttertorture

import com.shuttertorture.coroutines.CoroutineNumbers
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

class App {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val numberOfParallelComputations = 10000

            //RxNumbers.sumRx(numberOfParallelComputations)

            executeCoroutineSamples(numberOfParallelComputations)
        }

        private fun executeCoroutineSamples(inNumberOfCoroutines: Int) {
            println("sumAsync() - Executed in  ${measureTimeMillis {
                runBlocking {
                    CoroutineNumbers.sumAsync(inNumberOfCoroutines)}
                }
            } milliseconds")

            println("launchAsync() - Executed in  ${measureTimeMillis {
                //asynchronous without return value using launch
                runBlocking {
                    CoroutineNumbers.launchAsync(inNumberOfCoroutines)
                }
            }} milliseconds")
        }

    }
}