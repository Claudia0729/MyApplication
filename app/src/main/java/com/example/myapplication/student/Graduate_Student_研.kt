package com.example.myapplication.student

import com.example.myapplication.Student_Conpanion_object

/*透過現有的Student_Companion_object檔案，繼續擴充，此時已經不用再類別裡面重投做設計了。
(1)只需要在新增的Class類別中，加一個:，就可利用前人所設計的類別，來繼承(Inheritance)它。
(2)繼承(Inheritance): 意旨不用從頭設計類別，就可具備我的"父類別(Super class)"，而我因此成為"子類別(Sub class)"
(3)由於目前父類別中有一個建構子，因此需要再父類別後面呼叫它的建構子。若父類別為空建構子，那就沒關系。
(4)此時會遇到父類別可能會出現final的錯誤，final->不可再被他人使用的東西。Kotlin語言中，如果未來有人要繼承我的類別設計，來增加其他功能時，需在原類別前面加上open，
open-> 開放類別，未來能有衍生設計。
 */
class Graduate_Student_研(id:String, name:String
                          ,eng:Int, math:Int, val thesis:Int) ://增加了論文的成績
    Student_Conpanion_object(id ,name ,eng ,math  ) {//此時的4個屬性(學號/姓名/英/數)可透過我的建構子傳給父類別，叫父類別幫忙做初始化的設定與屬性的設定

    //覆寫的時候，必須與父類別的一模一樣(透過function的規格，判斷是否再進行覆寫)，若父類別內有參數，那覆寫的也需要有參數。若沒有參數，就不該有參數。
    //此時子類別的print()方法會有錯誤，因為在父類別已有寫過相同方法，因此需要再子類別覆寫的類別前面加上override，說明子類別的為覆寫的。
    override fun print(){//此時加入override後仍會有錯誤，因為父類別的print()方法也需要open。可在紅線部分Alt+enter，讓程式自動幫忙open開啟。要有open，才可對父類別進行覆寫。
        val mark = if (average()< pass) "*" else " "
        println("$id\t$name\t$eng\t$math\t${average()}$mark\t${gradle()}\t$thesis")
    }

    }

fun main() {
    //若創建的這個物件不要給英數成績的話，就需要再前面子類別的英數給給初始值0
    //此時的物件仍然有功能，因為是從父類別那邊得到的。雖然子類別並沒有設計任何方法，但因為繼承了父類別，因此擁有所有父類別的function/屬性
    //但也可能子類別會出現function/屬性不夠用的情況，子類別布景可以繼承父類別的屬性/方法，也可以新增自己需要用的屬性。
    val grastu = Graduate_Student_研("10160236","Sherry",90,85,85)
    //此時結果就不合用了，那就可以將父類別的print方法拿來覆寫
    grastu.print()//此時單純使用這行print出來結果，並不會將論文成績印出來，而是只有"學號 姓名 英數成績 平均成績 成績等級"
}