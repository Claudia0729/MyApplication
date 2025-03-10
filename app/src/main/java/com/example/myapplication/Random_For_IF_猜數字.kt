package com.example.myapplication

fun main() {

    val secret = (1..10).random()
    println("secret: $secret")
    var num:Int = 0
    var bingo = false
    for ( i in 1..3){//使用次數限制 -> 有可能在第1或2次就猜中，也有可能三次還是沒重
        println("Please enter a number(1-10): ")
        val input = readLine()
        num = input?.toIntOrNull() ?: 0

        println("The number you enter is $num")

        if ( num < secret ){
            println("Please enter a bigger number!")
        }
        else if (num > secret){
            println("Please enter a smaller number!")
        }
        else{
            println("You got it!!")
            bingo = true
            break //若猜對了，那就直接離開(結束)for迴圈，為避免繼續執行剩下次數
        }
    }
    if ( !bingo ){//使用驚嘆號作為取反的用途，表若bingo=false(--得+)，if才會被執行。等同於bingo == false的簡寫
        println("The correct number is $secret")
    }
}

