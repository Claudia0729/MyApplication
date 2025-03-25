package com.example.myapplication.student
//此時繼承了MyReport會有紅線，因為繼承一個抽象，沒有寫抽象的實作當然可行，但自己就需要宣告為抽象。
class SalaryReport : MyReport() {
    //而此時MyReport有錯誤是因為，雖然沒有寫建構子，但其實還是會送一個空的建構子，因此這邊目前就無參數，寫()即可。
    override fun load() {//可在類別紅線Alt+enter看有哪些時作要進行覆寫
        println("loading data")
        init()//因此不管在類別程式碼裡面的哪裡，皆可使用繼承而來的init()方法
    }

}