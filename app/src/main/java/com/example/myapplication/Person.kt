package com.example.myapplication

class Person constructor(val name:String ,val w:Float,val h:Float){
    //在此Person類別不只有println出Hello World的功能，同時也可以被賦予儲存資料的功能
    //Person建立了兩個專門存放資料的東西，因為兩個變數(w,h)是設計在類別的第一層中，因此就不稱為變數，而是類別身上的"屬性(Field/Property)
    //定義兩個變數的"資料"(與Hello.kt的main內的宣告(val weight = 52.3f)不同
    //var w:Float = 0f
    //var h:Float = 0f

    fun bmi() : Float{ //程式碼在運算完bmi之後，會回傳一個Float的浮點數(bmi)
        //此時的bmi值已經變成一般的變數(區域變數 Local variable)，因為這個變數是被定義在方法內。若出了方法之外就沒有bmi了
        val bmi = w / ( h*h )
        return bmi
    }

    fun Hello(){
        println("Hello I'm Claudia")
    }

}