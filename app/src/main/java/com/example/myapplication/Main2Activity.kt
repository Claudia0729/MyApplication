package com.example.myapplication
//MainActivity主要用於控制一個畫面
/*過往的AppCompatActivity名稱為"android.support.v7.app.AppCompatActivity"
目前的稱為"androidx.appcompat.app.AppCompatActivity"
androidx(若寫成這樣，表示為一個新的命名的函示庫): Android eXtensions(擴充)，為目前使用的趨勢。
 */
//https://developer.android.com/jetpack?hl=zh-tw可到此網址查看android jetpack相關內容
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Main2Activity : AppCompatActivity() {
    ////onCreate:允許被子類別覆寫。使用override來覆寫覆類別身上的onCreate方法，做初始值的設定。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//初始值的設定
        enableEdgeToEdge()
        /*設定內容的View元件。R:類別全名為com.example.myapplication.R，此類別為自動產生的。
        當城市中有使用到R，表示R會自動掃描專案內的res資料夾
        */
        setContentView(R.layout.activity_main2)
        R.id.hello_world /*在activity_main2.xml檔中設定id名稱(一般使用小寫)，可直接在onCreate方法內
        打R.id.(id名稱)此時的hello_world會回傳一個int(整數)，是因為res資料夾內的資料被掃瞄到後，都會配置一個
        不會重複的int的值，如此就可存取到res的值了
        */
        //因為圖檔以新增到drawable資料夾中，資料因此變動後，經過資料的掃描，就可存取到圖片(示)的資料了。
        R.drawable.instagram
        R.string.finish //字串也可拿來使用此觀念，在strings.xml內新增一個常用的字串資源，之後就可直接在Main2Activity裡面使用。

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}