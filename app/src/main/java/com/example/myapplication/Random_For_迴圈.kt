package com.example.myapplication

import kotlin.random.Random //由於我們使用到一個名為kotlin.random的package，指說Random這個類別是屬於kotlin資料夾中裡面的一個名為random的資料夾，裡面的一個類別(Random)
//因此在使用Random方法，要使用對的類別。(kotlin.random) 會自動判斷來加入對的import

//如何在Kotlin中產生亂數
//Kotlin的專案中其實是使用到Java的環境，而Java裡面有一個Math類別，其身上有random的方法(Math.random)可用來產生亂數
fun main() {
    //如nextInt會同時有多個同名稱的使用方法
    //當指呼叫單一的nextInt()方法，就只會回傳一個整數值(-21億多到+21億多)
    //println(Random.nextInt())//此Random也不用特別生出物件，本身就帶有static方法(直接/固定的使用類別)。只要.下去就可以使用

    //現在是希望程式可以使用亂數給出一個介於1-10的數值 可從println(Random.nextInt())小括號內，按ctrl+P(Parameter 參數)-> 顯示參數用法
    //這裡的until:10 -> 不包含10，1到10要用逗點來間隔
    println(Random.nextInt(1,11)) //若ctrl+P還是不懂，那可使用ctrl+Q來顯示參數簡易說明。若要更複雜的文件，可按ctrl+QQ
    println((1..10).random()) //這種會是比較好的取得亂數的寫法，先將一個range寫好，range的左右邊用括號刮起來，直接.裡面就會有random的方法。

}