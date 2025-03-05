package com.example.myapplication
//數值運算與比較運算
fun main() {

    var counter = 12
    counter ++ //counter = counter + 1
    counter -- //counter = counter - 1
    println(counter)

    //println(10%3) //因為是int與int 所以回傳直不會有小數點
    println(10%3.3)
    //可透過.to讓數值類型做轉換
    counter.toFloat()

    //布林(真-> 假 假-> 真)運算 AND OR運算
    var a= true
    var b = false
    println(!a) //相反為println(a)
    println( a && b )  // AND 兩者皆為真 即為真
    println( a || b ) // OR 兩者其一為真 即為真

    var num = -4
    println( num <= 5 && num >= -1 ) // 是否介於實心兩點數值間
    println( num >= 5)
    println( num <= 5 || num >= -1 ) // 是否介於空心兩點以外的區間
}