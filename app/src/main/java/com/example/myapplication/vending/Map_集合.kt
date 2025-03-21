package com.example.myapplication.vending
//Map特性: (1) 不重複 (2)map裡面要放的東西為"一對一或一組"又或 "一組資料:key-value"

//若想增加一個密碼驗證的功能，不一定要找字串類別來做擴充，而是可直接使用fun設計，方法可用字串類別(String)來命名，要設計的方法可在String.後面寫上方法名稱
//.後面的方法名稱第一個字一定要是英文字母
fun String.validate() : Boolean{
    return this.length >= 6//若要在字串String裡面拿到字串的本身自己，要使用到this，這樣可拿到字串本身裡面的內容。
}
fun Drink.off20() : Drink{//當遇到活動飲品有打8折時，因此透過自己設計的Drink類別的off20方法，會回傳一個新的飲品
    return this.copy(price = (this.price * 0.8).toInt())//因為原本的this.price * 0.8會是一個Int*Double，因此會有錯誤，那就將this的價格括起來toInt。
    //此時的this就是tea這個Drink物件Drink("Black tea", 50, 30)，this的核心作用是讓off20()方法知道它正在處理哪個Drink。
}
fun main() {
    val s = "12345"
    println(s.validate())//透過擴充出來的validate方法，在字串上面進行使用。

    var tea = Drink("Black tea", 50, 30)
    println(tea)/*此時的print印出來會是一個類別的參照資料型態(com.example.myapplication.vending.Drink@7e0ea639)
    參照資料型態即為"物件的資訊"，並沒有將tea物件的東西印出來。因此可能還需要在Drink.kt裡進行覆寫
    */
    //此時的tea物件仍然有一些方法可使用，ex:toString()、to()等，但此時的Drink類別並沒有設計任何方法。
    //tea.toString()
    /*tea仍有方法可用的原因為，在設計一類別時，若沒有繼承任何父類別的時候，會自動幫程式繼承Object(java.lang.Object)(在Java語言中)
        像toString()方法，若未來希望直接印出來就有資料，就需要覆寫父類別Object的toString()方法。
     */
    val discounttea = tea.off20()
    println(discounttea)
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
