package com.example.myapplication.vending

import java.net.URL
import java.net.UnknownHostException

//網址:https://api.jsonserve.com/AXh1oX
//若能連上此連結(伺服器)，再將網址(https)內的內容讀取出來，才是要達成的目的。
fun main() {
    //需要使用到Java的URL，且要按Enter才會自動import
    //先使用URL(網址)的方式定義網站的網址，再使用readText()就可以一行搞定輸入資料。
    //openStream():先打開一個對象，並與它連繫(連到那個網站)後(因為URL(網址)只是定義網站的網址)，會有一個輸入資料流。
    //openConnection():先與對象聯繫，仔取得輸出輸入資料流。
    val input = URL("https://api.jsonserve.com/AXh1oX").openStream()
    val reader = input.bufferedReader()//透過另外一種較好的方式來讀取輸入資料。
    var line = reader.readLines()
    while ( line != null) {
        println(line)//但因為網址本身在網站上就是顯示一行到底，因此在print結果輸出也沒有跳行。
        reader.readLine()
    }

}