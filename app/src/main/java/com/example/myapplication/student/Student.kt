package com.example.myapplication.student

import java.lang.reflect.Constructor

//學生的學號 姓名 英文 數學成績
//印出學生資料 學生平均成績
//印出學生等級(A B C D E)

//student的屬性
class Student constructor (val id:String, val name:String, var eng: Int, var math: Int ) {
    //以下為"次要建構子"-> 只要不是寫在Class類別後面的，都叫做次要建構子。以student為例，當我val 學生，會有兩種寫法可以用
    //此時次要建構子的括號裡面，不能再定義一次val，因為沒有第二次定義的屬性存在，屬性只能在主要建構子裡面定義。因此次要建構子定義的都是"區域變數"
    constructor(id:String, name: String): this(id,name,0,0)//冒號後面為次要建構子的屬性(去呼叫把id和name傳到哪裡)(主要是將兩值傳到主要建構子裡)，使用this()(若this後面為小括號，表示要呼叫自己的主建構子)

    fun print(){
        println("$id\t$name\t$eng\t$math")
    }

}

fun main() {//上面類別建立好之後，在建立下一個學生時，若不知道要寫那些東西，可以用ctrl+P看
    val me = Student("10160154", "Claudia", 85, 60) //產生一個建構子
    val he = Student("10160254", "Cloud", 80, 80 )
    val she = Student("10160254","cherry")//若沒有寫英數成績，就是直接給0。(設計為了不要寫了學號名字，後面又寫0)
    me.print()
}