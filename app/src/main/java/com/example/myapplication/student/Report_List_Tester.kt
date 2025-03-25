package com.example.myapplication.student
//類別認"父類別"，稱"繼承"。
//類別認"介面"，稱"實作(implement)"
class Report_List_Tester {
}

fun main() {
    val reports = listOf<Report>(
        FinanceReport(),
        Health_Report()
    )
    for ( report in reports ){
        //不管是哪一個report都是繼承類別
        report.load()
        report.print("Test")
    }
}