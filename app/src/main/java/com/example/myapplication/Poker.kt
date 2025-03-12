package com.example.myapplication
//建立出一個撲克牌的發牌，會有4行，每一行的值分別為1234....13。(因此要思考如何可以讓值從1-13排列)
//每一行的花色要顯示出來，club(梅花),Daimond(菱形),Heart(紅心),Spade(黑桃)
//程式碼的執行分為兩大類，(1)Statement(敘述式):程式執行(print)後，不會回傳(得到)資料 (2)Expression(表達式):程式執行之後，是會回傳資料的，會得到結果的
//但在Kotlin語言中，if/else when 皆屬於Expression
fun main() {
    val deck = mutableListOf<Int>() //一副牌 稱deck，目前是空的集合
    /*根據Kotlin語法中的range，會自動顯示多一點資料(符號)(0..1可能會變成0<=..<=1)，但在灰色字體點一下，右鍵會看到Do not show range hints，但也可以關掉再開起來
    復原:File-Setting-Editor-Inlay Hints-Values-Kotlin點進去會說明會自動加甚麼(勾選就可復原)
     */
    for ( i in 0 until 52) {//使用for迴圈把值加到集合內，其原型為0..<52。因為Android studio的原身是由InteliJ社群版本增加而成的
        deck.add(i)//print輸出為: 0123456......51
        if ( i%13 ==0 && i != 0 ) println() //希望可以13張牌就跳行且不會在一開始多跳一行空的(因為0%13雖然餘數為0，但i=0，所以不會印跳行)
        val a = i/13 //目前的數字排序還是0...12 13..25 26..38 39..51，因此使用i/13得到的商來把花色放入四行裡面
        //type的寫法(三)
        var type = when ( a ){
            0 -> "C"
            1 -> "D"
            2 -> "H"
            else -> "S"
        }
        print("${(i%13)+1}$type ") //原本在${(i+1)%13}時候的輸出，會變成1234567891011120
        /* type的寫法(一)
        var type = "S" //也可以在宣告時不要強制給值，而是到最後的else 在println("S")
        if ( a == 0 ){
            type = "C"
        }
        else if ( a == 1 ){
            type = "D"
        }
        else if ( a == 2 ) {
            type = "H"
        }
        */
        //type的寫法(二):此時的type是如何得到-> 透過if/else判斷之後，將花色回傳給type
        /*var type = if ( a == 0 ) {
                "C"
            }else if ( a ==1 ){
                "D"
            }else if ( a == 2 ){
                "H"
            }else "S"
         */
    }


}