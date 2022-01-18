import kotlin.math.PI
import kotlin.math.sqrt

enum class HasRoom(val value: String) {
    YES("yes"), NO("no")
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int    
    fun hasRoom(): String = if(residents < capacity) HasRoom.YES.value else HasRoom.NO.value
    abstract fun floorArea(): Double
    fun getRoom() { 
        if (hasRoom() == HasRoom.YES.value) {
        	residents++; 
        	println("You got a room!")
        }
        else
        	println("Sorry, at capacity and no rooms left.")
    }
}

class SquareCabin(
    residents: Int, 
    val length: Double) : Dwelling(residents) {
	override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea(): Double = length * length
}

open class RoundHut(
    residents: Int,
	val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double = PI * radius * radius
    private val diameter = 2 * radius
    fun calculateMaxCarpetSize(): Double = sqrt(diameter * diameter / 2)
}

class RoundTower(
    residents: Int,
    radius: Double,
	val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors    
}

fun main() {
    val cabin = SquareCabin(4, 2.5)
    val roundHut = RoundHut(3, 4.0)
    val roundTower = RoundTower(4, 15.5)
    with(cabin) {
    	println("\nSquare Cabin\n=============")
    	println("Floor Area: %.2f".format(floorArea()))
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
    	println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
    }
    with(roundHut) {
    	println("\nSquare Cabin\n=============")
        println("Floor Area: %.2f".format(floorArea()))
    	println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Carpet size: %.2f".format(calculateMaxCarpetSize()))
    	println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
    }
    with(roundTower) {
    	println("\nSquare Cabin\n=============")
        println("Floor Area: %.2f".format(floorArea()))
    	println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Carpet size: %.2f".format(calculateMaxCarpetSize()))
    	println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
    }
}
