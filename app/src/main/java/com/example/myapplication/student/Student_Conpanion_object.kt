package com.example.myapplication
//類別層級的屬性 Companion object: 用來定義類別層級的變數與用法。希望能夠讓好幾個物件共用一個變數，常用於物件導向或程式設計內的Static。
//Static在Kotlin程式語言中，稱為Companion Object
open class Student_Conpanion_object constructor (val id:String, val name:String, var eng: Int = 0, var math: Int = 0 ) {
    companion object{//如夥伴/伴侶/陪同的意思(陪伴型物件)
        var pass = 60 //加入companion object後的student list屬性中，還未有pass的值出現，可用debug看
    }
    open fun print() {
        val mark = if (average()< pass) "*" else " "
        println("$id\t$name\t$eng\t$math\t${average()}$mark\t${gradle()}")
    }
    fun average() = (eng + math) / 2
    fun gradle() = when (average() / 10) {//簡化後，直接讓方法等於when的運篹
        9, 10 -> "A"
        8 -> "B"
        7 -> "C"
        6 -> "D"
        else -> "F"
    }
    //return gradle
}
//注意:在上面的Class類別名稱需要和main()裡面建立的物件類別名稱相同，若使用到陣列，也要使用Class類別名的名稱，否則Kotlin會找不到正確的類別。
fun main() {//因為產生的類別Student中存有4個屬性，因此未來產生的物件裡面也會有一套存在的屬性們
    //前面第9行雖然有一個比較，但在這裡改了一個分數時，其他物件也會一同使用同一個變數(pass)
    Student_Conpanion_object.pass = 50 //因為是Companion object(跳脫於物件的)，因此可以在物件還未產生前，就能使用.的方式叫出方法。
    val student = listOf<Student_Conpanion_object>(
        Student_Conpanion_object("10160154", "Claudia", 40, 60),
        Student_Conpanion_object("10160254", "Cloud", 50, 40 ),
        Student_Conpanion_object("10160254","cherry")
    )

    for ( stu in student ){//法(二):會讓人看得比較清楚
        stu.print()
    }

}