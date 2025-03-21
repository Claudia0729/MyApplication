package com.example.myapplication.vending

import java.io.File

//Kotlin的檔案的輸出與輸入，Kotlin語言在Android開發時，是使用Java類別庫。會先將檔案編譯成Java類別檔，再到Android內做處理。
//java.io的類別庫，有近100個類別，可方便使用。
//輸出(Output):出發點為此程式碼為基礎點，把資料向外送。 輸入(Input):出發點為此程式碼為基礎點，資料從外面被讀進來。
//在java中，針對網路與檔案等等外部的東西，皆是使用輸出入的類別庫(java.io*)。
//輸出: printWriter()-> 和print()一樣是同個類別所寫的功能。與BufferedWriter():具有一個buffer(緩衝區)且有效率一點輸出串流類別，若在有上百行的資料，就需使用到BufferWriter()。
fun main() {
    val drinks = listOf<Drink>(//此list內放的為Drink類別
        Drink("Black tea", 0, 50),
        Drink("Green tea", 5, 45),
        Drink("Wuloon tea", 0, 60)
    )
    /*PrintWriter()
    設想將三種飲料的訂單寫到一個檔案中，可使用到java的類別File(java.io)，括號內需要放檔案的檔名。
    因為此order.txt沒有設計在資料夾內，因此可在Project視野內的根目錄來產生此檔案。
    由於若是使用printWriter的println()方法，會變成每次讀一筆資料都要開一次檔->得到串流->寫東西，會較麻煩。所以就使用迴圈，開一次檔在寫資料。
    val out = File("order.txt").printWriter()//.後就可選鑿要輸出還是輸入，一個通道內有兩個串流，往外流的稱輸出，往內流的稱輸入。
    */
    //BufferedWriter()->使用此方法後的輸出(.txt)內的東西，會將前面printWriter()的東西覆蓋掉，因為沒有說要寫在前者的後面。
    val out = File("order.txt").bufferedWriter()
    for ( d in drinks){
        //BufferWriter()-> 就沒有println的方法了，但可改使用write方法，write的方法本身也有好幾種資料類型的型態。
        out.write("${d.name},${d.sugar},${d.price}\n")//因為write本身沒有跳行的功能，因此需要自行加上。
        /*printWriter()
        //輸出沒有資料是因為->電腦系統在輸出資料時，會有一個緩衝區，當程式不斷的output資料，此時的資料是輸出到自己的電腦裡的一個緩衝區。
        out.println("${d.name},${d.sugar},${d.price}")//若單傳只寫這行，是不會輸出任何資料的。此時再Project視野可看到輸出的output.txt，但裡面是空的。
        */

    }
    out.flush()//因此不管在迴圈內還是最後，只要有將東西推(flush())出去，輸出的檔案才會有資料。
}