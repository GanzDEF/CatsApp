package ru.dimadef.cats.app.data.models

import java.util.concurrent.atomic.AtomicInteger

class Page(var limit: Int = 100) {

    private val numDefault: Int = 0

    private var num = AtomicInteger(numDefault)
    var offset: Int = 0

    fun next() {
        num.incrementAndGet()

        updateOffset()
    }

    fun currentNum(): Int = num.get()

    private fun updateOffset() {
        val cNum = currentNum()

        offset = if (cNum > 0) {
            limit * cNum
        } else {
            0
        }
    }
}