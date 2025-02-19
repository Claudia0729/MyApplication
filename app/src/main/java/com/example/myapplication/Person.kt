package com.example.myapplication

class Person {
    //在此Person類別不只有println出Hello World的功能，同時也可以被賦予儲存資料的功能
    //定義兩個變數的"資料"(與Hello.kt的main內的宣告(val weight = 52.3f)不同
    var w:Float = 0f
    var h:Float = 0f

    fun bmi() : Float{ //程式碼在運算完bmi之後，會回傳一個Float的浮點數(bmi)
        val bmi = w / ( h*h )
        return bmi
    }

    fun Hello(){
        println("Hello I'm Claudia")
    }

}