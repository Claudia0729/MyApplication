package com.example.myapplication
//Kotlin的main函式不用像Java一樣寫在類別裡面，可寫在class外面
//一個類別 名為Hello
class Hello {
}

//第一層 First Label，也為程式的執行點(進入點)Main Function
fun main(){
    println("Hello Kotlin!")
    val age = 20
    println(age.inc())
    println(age)

    val name = "Claudia"
    println(name.get(0))
    println(name)
}

// 可使用Template快速樣本 迅速產生main function -> 先打main，按下tab自動產生main function