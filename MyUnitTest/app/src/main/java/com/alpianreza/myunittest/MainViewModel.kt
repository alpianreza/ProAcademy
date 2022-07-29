package com.alpianreza.myunittest

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getCircumference() = cuboidModel.getCirumference()
    fun getSurfaceArea() = cuboidModel.getSurfaceArena()
    fun getVolume() = cuboidModel.getVolume()

    fun save(w: Double, l: Double, h: Double) {
        cuboidModel.save(w, l, h)
    }
}