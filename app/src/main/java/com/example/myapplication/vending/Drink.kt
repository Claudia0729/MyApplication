package com.example.myapplication.vending
//此時還未加上冒號的類別(所有類別)，代表繼承的是一個物件(Object)類別，非真正繼承父類別的繼承
//在類別中，若想進行覆寫父類別的方法，可使用ctrl+O。可得知，在Kotlin中，沒有繼承任何父類別時，會繼承Kotlin的Any類別。
//為了讓簡單的類別Drink具備一些基礎性的功能，如:toString()等，可在類別最前面加上data。此時的類別會幫忙做一些額外的事情，包含如:覆寫toString()等方法
/*Extensions(擴充功能):讓一些類別有額外的功能。但有可能因為沒有類別的原始碼，也就是要寫的功能可能是利用他人已寫好的類別，拿來使用來做我要的功能。不僅
可用於內建的類別(如:String)上，自己寫的類別裡也可使用。只要將擴充的內容寫在第一層即可，沒有規定一定要在main的前或後。
*/
data class Drink( val name:String, val sugar:Int,val price:Int ) {
    /*override fun toString(): String {//會回傳一個String資料，使用此方法才能正確將物件的屬性印出來。
        return "$name $sugar $price"//這邊return的東西可自行修改
    }
    此方法雖然為可行的，但會遇到每個物件都要印，又需要每次都更改類別的設計，因此有較好的方法可以使用。
     */
    //加上data後輸出的值為Drink(name=Black tea, sugar=50, price=30)，意旨是從Drink類別所生出的，其中屬性的值又為多少
}