package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityNicknameBinding

class NicknameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNicknameBinding
    val TAG = NicknameActivity ::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNicknameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_nickname)
        val value = intent.getIntExtra("Weight_Value", 0)
        val name = intent.getStringExtra("User_NAME")
        Log.d(TAG, "onCreate: $value $name")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun save(view:View){
        val nickname = binding.addnickname.text.toString()
        getSharedPreferences("weight", MODE_PRIVATE)
            .edit()
            .putString("nickname", nickname)
            .apply()//資料不急著寫進去
        setResult(RESULT_OK, intent.putExtra("name", nickname))
        finish()
    }
}