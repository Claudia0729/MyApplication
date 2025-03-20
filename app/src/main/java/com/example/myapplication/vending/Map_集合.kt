package com.example.myapplication.vending
//Map特性: (1) 不重複 (2)map裡面要放的東西為"一對一或一組"又或 "一組資料:key-value"
fun main() {
    var tea = Drink("Black tea", 50, 30)
    println(tea)/*此時的print印出來會是一個類別的參照資料型態(com.example.myapplication.vending.Drink@7e0ea639)
    參照資料型態即為"物件的資訊"，並沒有將tea物件的東西印出來。因此可能還需要在Drink.kt裡進行覆寫
    */
    //此時的tea物件仍然有一些方法可使用，ex:toString()、to()等，但此時的Drink類別並沒有設計任何方法。
    //tea.toString()
    /*tea仍有方法可用的原因為，在設計一類別時，若沒有繼承任何父類別的時候，會自動幫程式繼承Object(java.lang.Object)(在Java語言中)
        像toString()方法，若未來希望直接印出來就有資料，就需要覆寫父類別Object的toString()方法。
     */
    val tea2 = tea.copy(sugar = 20)//透過第一個類別產生出的tea物件，來呼叫copy的指令，在對身上的屬性進行微調。
    println(tea2)

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