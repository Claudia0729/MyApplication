package com.example.myapplication.vending
//在order.txt內的第二行加上-- 來舉例Exception例外(輕量錯誤)/try/catch/finally
//加上--後的txt檔，執行後會有一個java.lang.IndexOutOfBoundsException的輕量錯誤(Exception)
//因為此時第二行的資料---並沒有逗號的出現，因此索引值[0]=---
//java.lang.IndexOutOfBoundsException:稱為索引值超出範圍的的輕量錯誤。他的父類別為Exception類別。
//針對目前Java、Kotlin的新語言，有針對Exception去處理的語法，稱為try語法
import java.io.File

fun main() {
    val drinks = mutableListOf<Drink>()
    val input = File("order.txt").bufferedReader()
    var line = input.readLine()
    while ( line != null) {
        println(line)
        val tokens = line.split(",")
        //一個try最少要搭配一個catch(catch最少要1個)，也可多個。
        //因為出現的IndexOutOfBoundsException有被抓下來處理，因此程式並沒有中斷和整個停止
        try{//此區塊為"監控區塊"，用來抓(監控)一些Exception，看看程式碼會不會出現Exception
            val drink = Drink(tokens[0], tokens[1].toInt(), tokens[2].toInt())
            drinks.add(drink)
        }
        //此時括號內的也可縮寫成Exception，因為Exception就是IndexOutOfBoundsException的父類別
        catch ( ex: IndexOutOfBoundsException ){//此區塊為當監控區塊出現Exception的時候的處理區塊，括號內要寫"要抓什麼樣的Exception"
            println("Invalid line data format!")
        }
        /*
        finally {
        }
         */
        line = input.readLine()
    }
    println(drinks)
}