package com.example.myapplication.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Record(//如果希望nickname儲存在資料庫裡面的欄位名稱可能有所不同時，就可標示ColumnInfo。若沒有特別說欄位名稱有所不同，會依照屬性名稱作為欄位名稱
    //又或者是這個屬行在之後儲存時，不能儲存null的值，就可標示NonNull
    @NonNull
    @ColumnInfo(name = "nick")
    var nickname:String,
    var counter:Int,
    @PrimaryKey(autoGenerate = true)//若希望未來此欄位的值不用自己手動更改，可寫成自動產生
    //一個資料庫表格中通常會有一個欄位是不會重複的(主Key)
    var id:Long = 0L
    ) {
}