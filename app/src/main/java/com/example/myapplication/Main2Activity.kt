package com.example.myapplication
//MainActivity主要用於控制一個畫面
/*過往的AppCompatActivity名稱為"android.support.v7.app.AppCompatActivity"
目前的稱為"androidx.appcompat.app.AppCompatActivity"
androidx(若寫成這樣，表示為一個新的命名的函示庫): Android eXtensions(擴充)，為目前使用的趨勢。
 */
//https://developer.android.com/jetpack?hl=zh-tw可到此網址查看android jetpack相關內容

/*過往常需使用findViewById的方式，透過設定的畫面layout(activity_main2.xml)裡面的元件進行互動，一定需要使用此方法把元件找出來。
但此方法較麻煩。因為需要先知道元件是何種屬性ex:EditText、Button..，還需從一般元件轉型成EditText。
而在Kotlin成為Android的重要開發語言後，就出現了Kotlin Android Extensions擴充功能的方法，此方法可直接不透過findViewById，就可直接存取畫面的元件。
後來此方法仍有缺點，因此Android官方推出了View Binding的方法。
ViewBinding-> 在過程中，掃描package裡面有那些Layout檔，並將它畫成一個類別，就可直接在MainActivity裡面直接取得元件，不需任何轉換。
如何啟動此功能-> 要道build.gradle.kts(Moudle:app)檔裡面 -> buildFeatures方法內 -> 打上viewBinding = true -> sync now
啟動後，layout(.xml)檔會被轉成一個類別名稱，ex: 目前的activity_main2.xml -> Activity_Main2Binding
 */
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {
    /*如何讓binding可以在類別到處皆可使用，不用局限於onCreate的生存環境中。同時也不希望binding是null
    也不希望還要再類別後面加?，不然還要做null check會很麻煩。lateinit晚一點一定會產生物件(晚一點會初始化變數)
     */
    private lateinit var binding: ActivityMain2Binding
    ////onCreate:允許被子類別覆寫。使用override來覆寫覆類別身上的onCreate方法，做初始值的設定。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//初始值的設定
        enableEdgeToEdge()
        /*設定內容的View元件。R:類別全名為com.example.myapplication.R，此類別為自動產生的。
        當城市中有使用到R，表示R會自動掃描專案內的res資料夾
        */
        //setContentView(R.layout.activity_main2)
        /*R.id.hello_world 在activity_main2.xml檔中設定id名稱(一般使用小寫)，可直接在onCreate方法內
        打R.id.(id名稱)此時的hello_world會回傳一個int(整數)，是因為res資料夾內的資料被掃瞄到後，都會配置一個
        不會重複的int的值，如此就可存取到res的值了
        */

        /*inflate方法:LayoutInflater-> 畫面配置的充氣機(直接取得即可)。因為我們繼承了AppCompatActivity()，它身上已
       具備一個layoutInflater了
       */
        binding = ActivityMain2Binding.inflate(layoutInflater)
        //原本的第32行setContentView就可刪掉，此時MainActivity已經和activity_main2.xml連結(binding)起了
        setContentView(binding.root)//root:整個layout的xml檔(binding最上層的東西)，把binding交給setContentView

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