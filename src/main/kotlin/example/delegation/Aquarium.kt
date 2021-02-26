package example.delegation

import kotlin.math.PI

fun main() {
//    buildAquarium()
    buildDecoration()

    var movement = "from left " to "to right"
    println(
        "${movement.first}" +
                "${movement.second}"
    )

    var triples = Triple(10,"number",'a')
    println("${triples.first}" +
            "${triples.second}" +
            "${triples.third}"
    )
}

fun buildDecoration() {
    val decoration = Decoration("red", "wood")
    println(decoration)
    val (color, material) = decoration
    println("$color $material")
}

data class Decoration(val color: String, val material: String) {

}

fun buildAquarium() {
//    val myAquarium = Aquarium(width = 20, length = 30, height = 15)
//    myAquarium.printSize()


    val shark = Shark()
    println(shark.color)
    shark.eat()
}


//open class Aquarium(open var length: Int = 100, var width: Int = 20, open var height: Int = 40) {
//    open val shape = "rectangle"
//    open var volume: Int
//        get() = length * width * height / 1000;
//        set(value) {
//            height = (value * 1000) / (width * length)
//        }
//
////    constructor(fish: Int) : this() {
////
////        val tank = fish * 2000 * 1.1
////        height = (tank / (length * width)).toInt()
////    }
//
//    init {
//        println(" init block")
//    }
//
//    fun printSize() {
//        println("Width $width, height $height , length $length")
//        println("Volume: $volume l water and $shape")
//    }
//
//    init {
//        println(" init block 2")
//    }
//}

/*class TowerBank(override var height: Int, var diameter: Int) :
    Aquarium(height = height, width = diameter, length = diameter) {
    override val shape = "cylinder"
    override var volume: Int
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

}*/
interface FishColor {
    val color: String
}

interface FishAction {
    fun eat()
}

object GoldColor : FishColor {
    override val color: String = "gold"

}

class printFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Shark(fishColor: FishColor = GoldColor) : FishAction by printFishAction("meat"), FishColor by fishColor {

    override fun eat() {
        println("function eat for shark")
    }
}

class Plecostomus : FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("function eat for plec")
    }
}
