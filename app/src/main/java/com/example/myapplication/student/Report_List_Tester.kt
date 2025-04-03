package com.example.myapplication.student
//類別認"父類別"，稱"繼承"。
//類別認"介面"，稱"實作(implement)"
class Report_List_Tester {
}

fun main() {
    val reports = listOf<Report>(
        //Finance和Health都是有名的類別，滑鼠停在類別上，ctrl可點進去類別檔裡面
        FinanceReport(),
        Health_Report(),
        //Object-> 可產生出一個匿名(無名)類別(Anonymous class)，且可直接拿來使用。
        object : Report {//新增一個報表，且為繼承報表介面，也不再另外設計一個類別。冒號後面是要繼承哪一個介面。
            override fun load() {//會自動偵測Report身上的兩個必須實作的方法
                println("Oth report")
            }

            override fun print(title: String) {
                println("OtherReport")//避免自己(print)呼叫自己(會造成無窮呼叫)，因此寫為println
            }
        }
    )
    for ( report in reports ){
        //不管是哪一個report都是繼承類別
        report.load()
        report.print("Test")
    }
}