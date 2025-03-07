package com.example.myapplication
//For 迴圈 -> 用來重複執行衣錠次數的方法
//陣列 -> 同型態的一群變數
fun main() {
    //Range
    val range = 0..10 //灰色部分的<=和>=是可以省率不寫的 只是用來提醒用

    for ( i in 1..20){ //for 迴圈內衣定要有一個in，in的右邊並非一定要放一個range
        if( i % 2 == 1){
            print("*")
        }
        else {
            print(" ")
        }
    }
    println() //跳行可直接這樣寫

    for ( i in 1..10 step 2)
        print(i)//可以跳著做 每結束一次迴圈就+2
    println()

    //陣列 Array
    val array = intArrayOf(1,2,3,4,5) //Kotlin要如何產生陣列的變數-> 各種資料型態(ex:int,double....)都有直接使用的用法
    println(array.size) // size-> 陣列中的元素(element)個數
    println(array.get(2)) //get() 呼叫存取方式 //也可寫成 array[2]([]存取方式) -> 兩個的結果會是一樣的
    //若執行println(array[5])的話，會有錯誤。但一般不會把這個錯誤稱Error，而是較Exception(例外)，指電腦在執行過程中拋出一個例外狀況。
    //例外的原因是因為，Index索引直超出了設定的範圍。

    val string = arrayOf("Apple", "Banana", "Cat") //字串的陣列就要使用到arrayOf了，就沒有所謂的直接使用的方法
    println(string.size)
    println(string.get(1))

    for ( thing in string){
        print(thing)

    }

}