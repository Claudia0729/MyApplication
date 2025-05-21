package com.example.myapplication
import android.app.ComponentCaller
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialogDefaults
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.myapplication.data.Record
import com.example.myapplication.data.RecordDatabase
import com.example.myapplication.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {
    private val NICKNAME_REQ: Int = 20
    private lateinit var viewModel: WeightViewModel //把viewModel抽取出去變成屬性，而非原本的區域變數。同時也用為lateinit，晚一點再去onCreate宣告
    val TAG = Main2Activity::class.java.simpleName//由於使用log時，參數都需使用到類別名稱，為了更簡潔，直接在最前面定義一個TAG = 類別的簡單名稱(類別名稱)。全名是加上package那串。
    private lateinit var binding: ActivityMain2Binding//當在xml裡面有新增新元件的時候，可能會因為使用了binding所以會反紅色，就要到Build->Rebuild Project(重新編譯)
    val game = GuessGame_物件導向()//直接改成從類別檔中獲取這個average整數值
    val requestNickname = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result ->
        val nickname = getSharedPreferences("weight", MODE_PRIVATE)
            .getString("nickname", null)
        Log.d(TAG, "Data: $nickname")
        if ( result.resultCode == RESULT_OK ){
            val nickname = result.data?.getStringExtra("name")
            Log.d(TAG, "$Result: $nickname")
        }
    }

    //val average = (55..70).random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//初始值的設定
        Log.d(TAG, "onCreate: ")
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //做完畫面之後進行取得ViewModel物件，使用ViewModelProvider類別產生viewModel
        //因為Provider的建構子要寫擁有者，ViewModel負責的是Main2Activity，因此直接寫this就好
        viewModel = ViewModelProvider(this).get(WeightViewModel ::class.java)
        //把val刪掉，按Alt+enter，選Create Property ViewModel
        //Observe是一個介面，因此要放入符合介面的家族物件(使用Lambda語法)。只要counter一有變動，就到大括號裡面執行
        viewModel.counter.observe(this) { counter ->
            binding.counter.text = counter.toString()//counter就會變動了
        }
        viewModel.status.observe(this) { status ->
            val message = when (status){
                GameStatus.BIGGER -> getString(R.string.you_are_to_soft)
                GameStatus.SMALLER -> getString(R.string.you_are_so_strong)
                GameStatus.INIT -> "" //初始化的時候就給空字串
                else -> getString(R.string.your_weight_is_just_right)
            }
            if( status != GameStatus.INIT){
                AlertDialog.Builder(this).setTitle(getString(R.string.average_weight))
                    .setMessage(message)
                    .setPositiveButton(getString(R.string.ok),null)
                    .setNegativeButton("Replay" ){
                            dialog, which -> Log.d(TAG,  "Replay")
                        viewModel.reset()
                        //binding.counter.text = game.counter.toString()
                        binding.weight.setText("")//輸入方塊清空
                    }
                    .show()
            }
        }
        viewModel.averageData.observe(this) { average ->
            //顯示目前的隨機平均體重，直接使用game從類別檔拿到數字
            Toast.makeText(this,"average weight:$average",Toast.LENGTH_LONG).show()
            //R.drawable.instagram
            //R.string.finish
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Room test
        //產生資料庫物件，最後要記得呼叫build()才能得到RecordDatabase
        val database = Room.databaseBuilder(this,
            RecordDatabase::class.java, " data.db")
            .build()
        val record = Record("Sam", 3)
        database.recordDao().insert(record)
    }
    //方法寫在類別裡的第一層
    fun enter(view:View){
        viewModel.input(binding.weight.text.toString().toInt())//透過input方法，把weight值傳到viewmodel裡面

        /*
        if ( !binding.weight.text.toString().equals("")){
            val weight = binding.weight.text.toString().toInt()
            val message = when(game.differ(weight)){
                GuessGame_物件導向.Status.SMALLER -> getString(R.string.you_are_to_soft)
                GuessGame_物件導向.Status.BIGGER -> getString(R.string.you_are_so_strong)
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
                .setPositiveButton(getString(R.string.ok),null)
                .setNegativeButton("Replay" ){
                    dialog, which -> Log.d(TAG,  "Replay")
                    game.reset()
                    binding.counter.text = game.counter.toString()
                    binding.weight.setText("")//輸入方塊清空
                    Toast.makeText(this,"average weight:${game.average}",Toast.LENGTH_LONG).show()
                }
                .show()
                //因ok不用做事所以就寫null，要的話要寫okListener
                //經過31-35行的動作，okListener才能正確被使用
                /*Lambda語法: 為了解決繁雜的匿名類別而推出的語法
                setNegativeButton("Replay", { 將okListener的兩個參數寫在大括號內
                    dialog, which -> Log.d(TAG, msg:"Replay")(which:按下哪一個按鈕)
                })
                tag的名稱可以寫得更簡潔
                 */
        }
        else{//當使用者輸入的值為空字串的時候，會有一個提醒的訊息提示(漂浮文字)，makeText()->建立這個文字的方法
            //由於APP的上層*3剛好為Context，可把自己(Main2Activity)直接使用this傳入進去。由於Stirng本身的上層介面為CharSquence，就可直接輸入一個字串。
            Toast.makeText(this,
                getString(R.string.please_enter_your_weight_number),Toast.LENGTH_LONG).show()//第三個參數:長度，由於Toast類別本身定義兩種資料，分別為LENGTH_LONG/LENGTH_SHORT
            //
        }
        */
    }
    fun setNickname(view: View){//轉換到另一個Activity的畫面，使用Intent類別
        val intent = Intent(this, NicknameActivity :: class.java)
        intent.putExtra("Weight_Value", 50)
        intent.putExtra("User_NAME", "Claudia")
        //startActivity(intent)
        //startActivityForResult(intent, NICKNAME_REQ)
        requestNickname.launch(intent)
        //Scope functions 區域範圍功能
        Intent(this, NicknameActivity::class.java).apply {
            putExtra("weight", 4)
            putExtra("name", "Tom")
        }.also {
            requestNickname.launch(intent)
        }
        //requestNickname.launch(intent)
    }

    //覆寫父類別所寫的onActivityResult -> 快捷鍵 ctrl+O
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, caller: ComponentCaller) {
        super.onActivityResult(requestCode, resultCode, data, caller)
        //取得nickname的值
        if ( resultCode == NICKNAME_REQ){
            Log.d(TAG, "onActivityResult: $resultCode")
        }
        val nickname = data?.getStringExtra("name")
        Log.d(TAG, "onActivityResult: $nickname")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }
}