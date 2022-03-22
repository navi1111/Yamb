import kotlin.random.Random

class Die {
    var throwedValue:Int=0
    public var isLocked: Boolean=false
    fun rollTheDie(){
        val number:Int=Random.nextInt(1,6)
        throwedValue=number
    }
    fun resetValues(){
        throwedValue=0
        isLocked=false
    }
    fun lockDie(){
        isLocked=true
    }
}