import java.util.*
import kotlin.system.exitProcess

class Game (private var dieList: DieList){
    private var timesThrowed:Int=0
    //constructor(vararg dieList:DieList)
    fun isPoker(mutableList:MutableList<Int>, wantedValue:Int):Boolean{
        if(Collections.frequency(mutableList,wantedValue)==4)
            return true
        return false
    }
    fun isYahtzee(mutableList: MutableList<Int>, wantedValue: Int):Boolean{
        if(Collections.frequency(mutableList,wantedValue)==5)
            return true
        return false
    }
    fun isScale(mutableList: MutableList<Int>, wantedValue: Int):Boolean{
        val firstScale= listOf<Int>(1,2,3,4,5)
        val secondScale= listOf<Int>(2,3,4,5,6)
        if(mutableList.distinct().containsAll(firstScale) || mutableList.distinct().containsAll(secondScale))
            return true
        return false
    }
    fun printCombinations(mutableList: MutableList<Int>){
        for(element in mutableList){
            if (isPoker(mutableList,element))
                println("POKER!!!")
                break
            if (isScale(mutableList,element))
                println("SCALE!!!")
                break
            if (isYahtzee(mutableList,element))
                println("YAHTZEE!!!")
                break
        }
    }
    fun play(){
        turn()
        println("Do you want to throw again?")
        var inputAnswer:String?= readLine()
        if(inputAnswer=="Yes"){
            turn()
        }

        println("Do you want to throw again?")
        if (inputAnswer=="Yes"){
            round()
            println("End of game")
        }


    }
    fun lockDice(number:Int){
        dieList.lock(number)
    }
    fun round(){
        //dieList.resetDice()
        dieList.throwDice()
        dieList.printThrowedValues()
        printCombinations(dieList.convertList())

    }
    fun turn(){
        round()
        println("Enter index of dice you want to lock")
        var inputLock:String?= readLine()
        var number:Int=Integer.parseInt(inputLock)
        lockDice(number)
    }
}