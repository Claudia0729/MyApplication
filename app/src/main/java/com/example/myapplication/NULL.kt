package com.example.myapplication
// 因為Kotlin要面對資料與物件有可能為Null的情況，造成後面寫程式或執行程式會有風險，因此有了Null Check，Null檢查的語法出現
fun main() {

    var name:String? = "Claudia"
    // name = null 此行指令是錯誤的 因為先簽name的資料型態已被定義為String(Non-Null 不可為空值)
    //若要定義為可以為NULL的資料型態 則要在資料型態後面加上?
    //name = null // 因此程式碼會允許為Null，因此此變數可以是NULL 也可以不是NUll

    //println(name.length) // 若在允許null的情況下，呼叫變數方法，會出現錯誤，因為已定義此變數可能為null了
    //方法一
    println(name?.length) // 在變數後面加上?可解決上行的問題-> 如果變數不為NULL 就會將方法的值回傳 -> 若變數為NULL 方法會回傳NULL 不會執行變數使用的方法

    //方法二 程式判斷 在println(name.length) 中的.之前 用Alt+Enter 看需要用哪一種方法解決
    /*if (name != null) {
        println( name.length)
    }*/

    //方法三 貓王 Elvis operator
    println( name ?: 0 ) // 若name的值是Null，那會得到:右邊的0這個值。name如果不是Null，那就會得到name的值



}