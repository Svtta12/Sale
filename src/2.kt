
fun main() {
    val price: MutableList<Int> = mutableListOf(5,100,20,66,16,7,14,91,74,65,67,134,53,488)
    val discount: Int = 48
    val offset: Int = 5
    val readLength: Int = 4
    decryptData (price,discount,offset,readLength)
}

fun decryptData (price: MutableList<Int>, discount: Int, offset: Int , readLength: Int) {
    var i = 0

//Сделаем проверку % скидки.
//Согласно условию задачи, % применяемой скидки должен быть от 1 до 99.
    if (discount in 1..99) {

//Сделаем проверку значения количества позиций, к которым необходимо применить скидку.
//Применять скидку будет в случае, если количество позиций положительное число больше 0.
    if (readLength != 0 && readLength > 0) {

//Сделаем проверку номера позиции, с которой нужно применять скидку
//Если значение номера позиции отрицательное или больше,чем позиций в нашем списке,
//то выведем ошибку.
        if (offset < 0 || offset > price.size-1) {
            println("Некорректный номер позиции!")
        }

        else {
        while (i < offset) {
            price.removeAt(0)
            i++
        }
        if (readLength > price.size) {
            println(price.map {Math.floor(it.toDouble() - (it.toDouble() * discount/100)).toInt()})
        }
        else {
            println(price.slice(0 until readLength)
                .map {Math.floor(it.toDouble() - (it.toDouble() * discount/100)).toInt()})
        }
    }
    }

//Если количество позиций отрицательное число или 0, то выведем предупреждение о некорректном вводе данных,
//т.к нет позиций к которым необходимо применить скидку
    else {
        println("Количество позиций отрицательно или равно 0!")
    }
    }
//Если % скидки не входит в диапазон от 1% до 99%, то выведем предупреждение.
    else {
        println("Некорректный % скидки!")
    }
}

