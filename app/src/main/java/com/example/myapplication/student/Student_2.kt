package com.example.myapplication
//Kotlin語言中，可以讓建構子裡面傳入的這些屬性賦予"初始值"，代表若未來沒有給英數成績時，都會使用初始值來回傳。
//通常在Kotlin語言設計建構子時，會將不一定要提供的屬性(Property)寫在後面。
class Student constructor (val id:String, val name:String, var eng: Int = 0, var math: Int = 0 ) {
    //constructor(id:String, name: String): this(id,name,0,0)
    fun print() {
        println("$id\t$name\t$eng\t$math\t${average()}\t${gradle()}")
    }

    //同理，也可以讓average的方法值等於(eng + math) / 2
    fun average() = (eng + math) / 2
    /*
    fun average(): Int {//平均後得到的結果的性質，此時回傳的值可放入print方法中的println裡，但要使用${}，因為是呼叫一個方法
        return (eng + math) / 2
    }
     */

    fun gradle() = when (average() / 10) {//簡化後，直接讓方法等於when的運篹
        9, 10 -> "A"
        8 -> "B"
        7 -> "C"
        6 -> "D"
        else -> "F"
    }
    //return gradle
}
/*
fun gradle(): String { //為簡化前
    val gradle = when(average() / 10){//此時也可做簡化，直接寫成return = when(average()){}
        9,10 -> "A"
        8 -> "B"
        7 -> "C"
        6 -> "D"
        else -> "F"
    }
    return gradle
}
 */
fun main() {
    val student = listOf<Student>(
        Student("10160154", "Claudia", 100, 90),
        Student("10160254", "Cloud", 80, 80 ),
        Student("10160254","cherry")
    )
    for ( i in 0..2){//法(一)
        student.get(i).print()//student幫忙取出get()第i個，再直接呼叫print的方法
    }

    for ( stu in student ){//法(二):會讓人看得比較清楚
        //程式會一個一個從student的list的第0號[0]拿出來，再放入i
        stu.print()
    }

    val me = Student("10160154", "Claudia", 100, 90)
    val he = Student("10160254", "Cloud", 80, 80 )
    val she = Student("10160254","cherry")//使用ctrl+P可以看出是有初始值的，不若不需用可以不用給
    me.print()
}