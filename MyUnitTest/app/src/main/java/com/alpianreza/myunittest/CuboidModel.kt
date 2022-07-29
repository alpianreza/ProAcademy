package com.alpianreza.myunittest

class CuboidModel {
    private val width = 0.0
    private val length = 0.0
    private val height = 0.0

    fun getVolume(): Double = width * length * height

    fun getSurfaceArena(): Double {
        val wl = width * length
        val wh = width * height
        val lh = length * height

        return 2 * (wl + wh + lh)
    }

    fun  getCirumference(): Double = 4 * (width + length + height)

    fun save(width: Double, length: Double, height: Double) {
        this.width = width
        this.length = length
        this.height = height
    }

}