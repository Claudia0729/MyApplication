package com.example.myapplication

import kotlin.random.Random

/*在Random_For_IF_猜數字的程式中，是將要寫的程式直接在main函式裡一次完成，但若在未來程式上有需求需要增加，就比較無法解決較複雜的問題，
  因為在寫程式前沒有先做設計，如果先設計一些方便未來使用的類別，再利用類別來解決問題。這樣的方法可能往後要做更改會比較不方便
 */
class GuessGame_物件導向 {//先設計好常用的類別，在main方法裡面使用少數程式，往後若需要更改程式的過程，會比較方便。
    //希望透過GuessGame_物件導向這個類別，ˋ己產生一個祕密數字
    var secret = Random.nextInt(1,11)//未來這個secret是可以重複一直玩的
    var counter = 0 //猜了幾次
    //由於使用者會傳一個整數，因此()內會放一個變數num
    fun differ( num:Int ): Int{//希望在未來可以透過使用者輸入後，使用這個differ的方法，來看使用者輸入和秘密數字是否一樣
        counter ++
        return secret - num
    }
    fun reset(){//若return回來的值為0，那遊戲就可以重新開始
        secret = Random.nextInt(1,11)
        counter = 0
    }
}

fun main() {//用來啟動這個類別檔案
    val game = GuessGame_物件導向() //使用GuessGame_物件導向這個類別(Class)來產生一個遊戲
    val num = 5//假設是使用者輸入的數字
    var result = game.differ(num)


}
/*
    物件導向的三大特性:
    (1)繼承 Inheritance: 可以基於上層(底層 Class)的父類別，來擴充程式內容
    (2)多型 Polymorphism:
    (3)封裝:
 */