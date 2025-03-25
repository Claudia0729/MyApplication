package com.example.myapplication.student
//在package右鍵-> New -> Kotlin file/class -> interface
//interface類似一個行為的規範，在Interface裡面可以設計方法，但此方法是用來定義它的行為規範，不用寫實作的內容。(方法的大括號內不用寫東西)
interface Report {//此時的關鍵字就變成Interface了
    //假設一個報表:假如報表的功能為讀取資料進來並列印，且同時需要印多種的報表，因此報表裡的方法大致為讀取data
    //無論讀取data的方法為何(ex:檔案/網站/...)，都會有一個load或loadData()
    fun load()//此時的括號與大括號接不需要寫內容，因為只是在定義一個規範。(但小括號內其實也可放參數等)
    fun print(title: String )//此時就是希望可以印報表的title
}
/*Interface()並不是直接拿來使用，而是讓別人來繼承。設一個公司有多個開發人員，此時需要將報表的程式設計分配給這些人。
但若沒有給予他們報表內的定義規範，會導致每個人的讀取方式(名稱)可能不同(ex:有些人寫load()而有些寫loadData()..)。
因此希望在設計各類功能時，有一個統一的介面，才不會亂七八糟。
 */