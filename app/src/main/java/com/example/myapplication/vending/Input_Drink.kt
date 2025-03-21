package com.example.myapplication.vending

import java.io.File

//將order.txt裡面的內容讀進來。
fun main() {
    val drinks = mutableListOf<Drink>()//空的飲料list
    val input = File("order.txt").bufferedReader()
    var line = input.readLine()//會讀到.txt檔的第一行資料
    /*使用重複的程式碼印出資料
    println(line)//Black tea,0,50
    line = input.readLine()
    println(line)
    line = input.readLine()
    println(line)
    line = input.readLine()//讀到第四次就會開始有錯誤，輸出結果為null(NullPointerException)(例外物件)
    //由於物件為null，因此無法取得物件身上的方法，因為null連身體都沒有，怎麼呼叫方法(split)。因此就會中斷main方法的執行。
    println(line)
    */
    while ( line != null) {
        println(line)
        //使用line字串中的split方法，且我中間的切割字眼是"逗點"，tokens會是一個陣列，tokens[0]...
        val tokens = line.split(",")//將Black tea,0,50拆解(切割)成一個一個部分(token)
        val drink = Drink(tokens[0], tokens[1].toInt(), tokens[2].toInt())
        drinks.add(drink)
        line = input.readLine()//這行如果未加進來，會導致while迴圈永遠出不去。用意就是要將下一筆資料讀進來，讓迴圈可以處理下一筆資料。
    }
    println(drinks)
}