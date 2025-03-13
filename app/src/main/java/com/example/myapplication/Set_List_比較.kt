package com.example.myapplication
/*
    List的特色: (1)具有索引值(index) (2)集合內的元素內容是可重複的 (3)由於集合具有index索引值，因此元素具順序性
    Set的特色: (1)集合內的元素不能重複 (3)由於集合不具index索引值，因此元素沒有順序性
 */
fun main() {
    val list = listOf<Int>(2,3,5,8,5,7,4)//不可變的集合ˊ
    println(list)
    val set = setOf<Int>(4,2,3,5,4,3)//重複的會直接被省略不列印
    println(set)
    //一般println()裡面放的是it，也可自己改名字，但要先在{}內打ex: num -> 在打println(num)
    set.forEach {
        num -> //命名的話就要記得家箭頭
        println(num)
    } //forEach{}去拜訪集合內的每一個值，若忘記括號內println()裡面要放什麼，可在未打上println之前，按Enter看hint提示。

    val deck = mutableListOf<Int>()//可以被改變內容的集合 MutableListof，因此會有很多方法可以使用(ex: removeAt()...)
    for ( i in 0 until 52) {
        deck.add(i)
        if ( i%13 ==0 && i != 0 ) println()
        val a = i/13

        var type = when ( a ){
            0 -> "♣"
            1 -> "♢"
            2 -> "♡"
            else -> "♠"
        }
        print("${(i%13)+1}$type ")
    }
    println()
    println(deck) // 輸出為:[0, 1, 2 ......, 51]
    deck.shuffle()//若原本就是一個可辨的集合，那就是將集合內的值打亂
    println(deck) //打亂的集合
    val deck2 = deck.shuffled()//若不想讓原本的deck受到打亂後的影響，就可使用shuffled來產生一個新的打亂的集合
    println(deck2) //新的打亂的集合

    //類似抽兩張比大小的概念，透過shuffled得到新的打亂集合，再從打亂的集合取出第一個值，此時a和b可能相同
    val a = deck.shuffled().first()
    val b = deck.shuffled().first()


}