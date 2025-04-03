package com.example.myapplication
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {
    val TAG = Main2Activity::class.java.simpleName//由於使用log時，參數都需使用到類別名稱，為了更簡潔，直接在最前面定義一個TAG = 類別的簡單名稱(類別名稱)。全名是加上package那串。
    private lateinit var binding: ActivityMain2Binding//當在xml裡面有新增新元件的時候，可能會因為使用了binding所以會反紅色，就要到Build->Rebuild Project(重新編譯)
    val game = GuessGame_物件導向()//直接改成從類別檔中獲取這個average整數值
    //val average = (55..70).random()
    //方法寫在類別裡的第一層
    fun enter(view:View){
        if ( !binding.weight.text.toString().equals("")){
            val weight = binding.weight.text.toString().toInt()
            val message = when(game.differ(weight)){
                GuessGame_物件導向.Status.SMALLER -> getString(R.string.you_are_so_strong)
                GuessGame_物件導向.Status.BIGGER -> getString(R.string.you_are_to_soft)
                else -> getString(R.string.your_weight_is_just_right)
            }
            //將GuessGame_物件導向內的counter值更新到APP畫面中，
            binding.counter.text = game.counter.toString()
            //由於android. content. DialogInterface. OnClickListener listener其實為一個介面，因此listener:null裡面需要實作。
            val okListener = object : OnClickListener {//若看到object有紅底線，Alt+enter有實作裡面必要的方法
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    TODO("Not yet implemented")
                }
            }
            //對話框的類別，使用類別中的Builder可建立一個快速使用的對話框。Bulider.後面是指對話框的Title的名字，可繼續.看要set哪些訊息。
            AlertDialog.Builder(this).setTitle(getString(R.string.average_weight))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok),null)//因ok不用做事所以就寫null，要的話要寫okListener
                .show() //經過31-35行的動作，okListener才能正確被使用
                /*Lambda語法: 為了解決繁雜的匿名類別而推出的語法
                setNegativeButton("Replay", { 將okListener的兩個參數寫在大括號內
                    dialog, which -> Log.d(TAG, msg:"Replay")(which:按下哪一個按鈕)
                })
                tag的名稱可以寫得更簡潔
                 */
                game.reset()
                binding.counter.text = game.counter.toString()


        }
        else{//當使用者輸入的值為空字串的時候，會有一個提醒的訊息提示(漂浮文字)，makeText()->建立這個文字的方法
            //由於APP的上層*3剛好為Context，可把自己(Main2Activity)直接使用this傳入進去。由於Stirng本身的上層介面為CharSquence，就可直接輸入一個字串。
            Toast.makeText(this,
                getString(R.string.please_enter_your_weight_number),Toast.LENGTH_LONG).show()//第三個參數:長度，由於Toast類別本身定義兩種資料，分別為LENGTH_LONG/LENGTH_SHORT
            //
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//初始值的設定
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //顯示目前的隨機平均體重，直接使用game從類別檔拿到數字
        Toast.makeText(this,"average weight:${game.average}",Toast.LENGTH_LONG).show()
        //R.drawable.instagram
        //R.string.finish


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}