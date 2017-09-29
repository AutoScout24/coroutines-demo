package com.shuttertorture.rx

import rx.Observable
import rx.schedulers.Schedulers
import kotlin.system.measureTimeMillis

object RxNumbers {
    fun sumRx(inNumberOfObservables: Int) {

        println("sumRx() - Executed in  ${measureTimeMillis {
            var sum = 0
            Observable.range(1, inNumberOfObservables)
                    .flatMap {
                        Observable.fromCallable{
                           sum += compute(it)
                        }.subscribeOn(Schedulers.io())
                    }.subscribe()
            println("Sum is $sum")
        }} milliseconds")
    }

    private fun compute(it: Int): Int {
       /* val sleep = Random().nextInt(1000)
        println("Sleeping for $sleep ms ...")
        Thread.sleep(sleep.toLong())*/
        return it + 1
    }
}