package com.example.myapplication
//使用While迴圈完成簡易猜數字遊戲，while -> 重複執行程式的某一段區塊
//若while()給的條件為true，最後又沒有寫上break的情況下，會造成程式永遠出不去迴圈外。
//不太會建議在while條件裡面使用true。
fun main() {
    val secret = 7
    var num:Int = 0 //在while迴圈外宣告num，解結變數生存空間的問題。此時迴圈內外皆有num的變數，是可行的，只是兩個同名的人。
    while ( num != secret ){ //在未將num在外面宣告前，因為num(區域型變數)是定義在while回圈內的括號區塊，因此num的生存空間(變數生存空間 Scope)就會停留在while大括號裡面
        println("Please enter a number(1-10): ")
        val input = readLine()
        num = input?.toIntOrNull()  ?: 0

        println("The number you enter is $num")

        if ( num < secret ){
            println("Please enter a bigger number")
        }
        else if ( num > secret ){
            println("Please enter a smaller number")
        }
        else {
            println("You got it!")
            //break //break: 跳出最近的迴圈區塊
        }
    }
}
