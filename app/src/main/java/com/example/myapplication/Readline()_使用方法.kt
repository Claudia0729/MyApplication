package com.example.myapplication
//如何讓使用者在命令模式下，輸入一個值。 Readline()-> 提供輸入資料的方法
fun main() {
    //第一階層的方法: 使用前不需要在前面加上什麼類別，或是.什麼物件等去執行，就是直接就可以拿來用。ex:println()/readline()
    println("Please enter a number(1-10): ")

    //readLine()可能會回傳一個字串或是Null
    val input = readLine() // 等號右邊的readline()先做，當使用者輸入了一個值且按下Enter後，程式會將此值放到input裡面
    //目前在執行時，在使用者完全沒有輸入就按下Enter的情況下，是回傳一個內容為空的字串(空字串)，並非NULL(連字串都沒有才稱Null)

    //由於此處的input可能為Null，在日後拿來運算(數值的比較)前，需先進行檢查
    //val num = input?.toInt() //input.toInt() 在.前加一個問號，讓他可以轉型。但還是會有個問題
    //13行，當input不為null，就轉成Int。但若input為Null，會得到Null。但這樣不太符合要使用的方式 因為我們會希望num:Int 也不希可能是Null

    //?:左邊如果是Null，就給右邊的值。 左邊如果不為Null，就給左邊的值(進行Int轉換)
    val num:Int = input?.toIntOrNull() ?: 0
    //println(num)
    println("The number you entered: $num ${input?.length}"  )//可使用字串模板的方式取代傳統的字串與字串用+的方法
    //若不像num一樣是單純的變數，就需要用到${}包住，這樣Null Check才會過
}