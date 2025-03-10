package com.example.myapplication

fun main() {
    /* Array:
    (1) 陣列中限制需要是同性質的，ex: int string...
    (2) 陣列一旦產生後，陣列的元素大小就無法改變
    */
    val array = intArrayOf(2,5,8)
    println(array)//此時的輸出為array的記憶體地址，是因為println(array)是直接輸出陣列(array)toString()的結果

    /* List:
       (1) 一般的list產生之後，是不能改變內容的list集合，因此就沒有add,remove等的方法可以使用
       (2) 可改變內容的list集合: Mutable List
     */
    //var list = listOf<Int>(2,5,8) //<>(<T>Generic泛型)用來放入要使用的資料型態
    //println(list)

    //可改變內容的list
    var list = mutableListOf<Int>(2,5,8)
    println(list)
    list.add(10) // [2,5,8,10]
    list.removeAt(2)
    println(list)

}