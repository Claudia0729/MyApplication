package com.example.myapplication.student
//抽象類別方法:當在設計新的類別時，並非只有黑(類別)白(介面)兩種，也可繼承一個不黑也不白(繼承的實作要寫，同時也可
abstract class MyReport {//此時在類別前面加上abstract後，在抽象的method或function前面也需要加上abstract
    abstract fun load()//繼承後的實作要好好寫

    fun print(){//繼承後也可直接呼叫寫好的時作方法
        println("Printing")
    }
    fun init(){

    }
}