package com.example.myapplication
//Kotlin的main函式不用像Java一樣寫在類別裡面，可寫在class外面
//一個類別 名為Hello
class Hello {
}

//第一層 First Label，也為程式的執行點(進入點)Main Function
fun main(){
    //將一個檔案裏面的類別(Person.類別)給生出來
    //使用類別名稱加小括號(Person())就可以來找這個檔案，並在記憶體內建立起來
    val people = Person()
    people.Hello() //people建立後會留下記憶體的住址，因此未來要尋找Person物件時，就使用people來呼叫所設計的Hello方法




    println("Hello Kotlin!")
    val age = 20 //就算年齡是2或20等小的數字，還是盡量使用int來標示，不用特意使用到Short/Byte來表示
    println(age.inc()) //值+1 但不影響本身的age值
    println(age)
    //Kotlin的整數資料型態: Byte(大小8位元), Short(16位元), Int(32位元), Long(64位元)
    //定義變數有兩種方法: (1) val age = 20(程式會自動判斷是哪一種資料類型)
    //(2) val age:Int= 20(直接表明變數age的資料型態)

    //若資料較大，如:總人口數 就可能需要用到Long
    //另外一種寫法為 val popularity = 99999L
    val popularity:Long = 99999

    //Kotlin的浮點數資料型態: Float(單精確浮點數,32位元), Double(雙精確浮點數,64位元)
    //Kotlin一般會將帶有小數點的數值訂為Double，但也可以自己手動變為float。ex: val weight = 65.5f
    val weight = 65.5 //Double型態
    val weight2:Float = 65.5f //未加上.toFloat()前，會有錯誤，因為系統看到帶有小數點的值，會判斷為double
    //較常使用直接產生一個浮點數的型態 val weight = 65.5f

    //另一種資料類型Boolean: true,false(只有這兩種可寫的值)
    val isTrue = true

    //另一種資料類型 Char(16位元): 要使用單引號刮起來
    val c='A'
    /*
    val name = "Claudia"
    println(name.get(0))
    println(name)
    */
}

// 可使用Template快速樣本 迅速產生main function -> 先打main，按下tab自動產生main function