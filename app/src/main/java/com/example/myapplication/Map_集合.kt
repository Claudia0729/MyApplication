package com.example.myapplication
//Map特性: (1) 不重複 (2)map裡面要放的東西為"一對一或一組"又或 "一組資料:key-value"
fun main() {
    //Int為一個key(不能重複的) ， String(可重複的)為Int的值，一組資料間使用逗點分隔
    val drinks = mutableMapOf<Int, String>(
        1 to "Coke", //在Kotlin中，每一個key會被轉成為一個Pair，真正長相為Pair(1,"Coke")
        2 to "Coffee",
        3 to "Juice",
        4 to "milk"
    )
    println(drinks) //輸出為{ 1=Coke, 2=.....}
    //Map的get方法是給他一個Key，會回傳一個String值給我
    println(drinks.get(2))
    drinks.put(5, "Water")//put(可加其他值到集合內)方法的用法，要給兩個值(分別為Int和String)，會回傳一個字串
    println(drinks)
}