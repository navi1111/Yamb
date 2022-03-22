class DieList {
    var listofDie : MutableList<Die> = mutableListOf()
    init {
        fulfillList()
    }
    fun fulfillList(){
        for (gen in 1..6){
            var die:Die=Die()
            listofDie.add(die)
        }
    }
    fun resetDice(){
        for(die in listofDie){
            die.resetValues()
        }
    }
    fun throwDice(){
        for(die in listofDie){
            if (die.isLocked!= true)
            die.rollTheDie()
        }
    }
    fun printThrowedValues(){
        for (element in listofDie){
            print("${element.throwedValue} ")
        }
    }
    fun convertList():MutableList<Int>{
        val mutableList:MutableList<Int> = mutableListOf()
        for(element in listofDie){
            mutableList.add(element.throwedValue)
        }
        return mutableList
    }
    fun lock(number:Int){
        listofDie.elementAt(number-1).isLocked=true
    }
}