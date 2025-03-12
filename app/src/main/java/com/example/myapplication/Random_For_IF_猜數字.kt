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

        val message = when {//由於when必須回傳一個值，若把break(不是值，且不會回傳資料)放入else最後，Kotlin會有錯誤。
            num > secret -> "Please enter a smaller number!"
            num < secret -> "Please enter a bigger number!"
            else -> {//只要把要回傳給使用者的東西放在最後一行即可
                bingo = true
                "You got it!!"//此時you got it後還要做bingo和print訊息和跳出迴圈
            }
        }
        println(message)//因此先輸出message，在確認bingo的值，來判斷要不要離開迴圈
        if ( bingo ){
            break
        }
        /*if ( !bingo ){//使用驚嘆號作為取反的用途，表若bingo=false(--得+)，if才會被執行。等同於bingo == false的簡寫
            println("The correct number is $secret")
        }*/
        /*if ( num < secret ){
            println("Please enter a bigger number!")
        }
        else if (num > secret){
            println("Please enter a smaller number!")
        }
        else{
            println("You got it!!")
            bingo = true
            break //若猜對了，那就直接離開(結束)for迴圈，為避免繼續執行剩下次數
        }*/
    }
    if ( !bingo ){//使用驚嘆號作為取反的用途，表若bingo=false(--得+)，if才會被執行。等同於bingo == false的簡寫
        println("The correct number is $secret")
    }
}

