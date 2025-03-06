package com.example.myapplication
//if/else判斷式 選擇性執行某些程式碼
fun main() {
    println("Please enter a number(1-10): ")
    val input = readLine()
    val num:Int = input?.toIntOrNull()  ?: 0

    println("The number you enter is $num")

    val secret = 7
    if ( num < secret ){
        println("Please enter a bigger number")
    }
    else if ( num > secret ){
        println("Please enter a smaller number")
    }
    else
        println("You got it!")
}