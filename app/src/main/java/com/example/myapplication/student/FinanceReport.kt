package com.example.myapplication.student
//假設某開發人員寫了一個財務報表，此時它就需要來繼承Report介面的規範內容
//若檔案名稱可能需要修改，可在檔案右鍵->Refactor->rename(shift+f6)
class FinanceReport : Report {//由於FinanceReport不是abstract(抽象)，也沒有實作必要的方法(does not implement)，因此會有紅色線。
    //為了解決此問題，因此在類別(FinanceReport)繼承介面(Report)之下，就需要在類別檔中寫介面檔內規定的規範寫法。可在紅線部分使用Alt+Enter讓程式自動產生override的繼承規範內容。
    override fun load(){//因為是繼承所以需要寫override
        println("Loading Finance Report")//表示有實作程式了
    }
    //第二個推飯就可直接打ov按enter會自動產生規範
    override fun print(title: String) {
        //方便未來怕忘了寫，在輸出結果時會拋出一個Exception(TODO("Not yet implemented")
        println("Printing Finance")
    }

}