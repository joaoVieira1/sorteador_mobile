package br.edu.ifsp.dmo.sorteador.model

class Draw(private val border: Int = 0){

    private lateinit var strategy: SorteioStrategy
    private val history = HashSet<Int>()

    init{
        if(border == 0){
            strategy = DefaultLimit()
        }else{
            strategy = DefinedLimit(border)
        }
    }

    fun getNumber(): Int{

        var number:Int
        var cont: Int = 0

        do{
            number = strategy.nextNumber()

            if(cont == border){
                history.clear()
                cont = 0
            }

            cont++

        }while(!history.add(number))

        return number
    }

    fun getHistory() = ArrayList(history)

    fun getLowBorder(): Int = strategy.getLowBorder()

    fun getHighBorder(): Int = strategy.getHighBorder()

}