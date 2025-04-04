package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.android.material.search.SearchBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {//ctrl+b可進到Theme(路徑為:ui.theme裡面)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchBar(modifier = Modifier.padding(innerPadding))
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                     */
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box( modifier = Modifier) {//因為此類別需要import，所以要按enter自動import進去
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text( text = "123456")
        Text( text = "1234")
    }

}

@Composable
fun SearchBar( modifier: Modifier = Modifier){//搜尋的輸入方塊
    Column {
        //TextField:輸入方塊(value-> 原本的值, onValueChange->當值變動時，我需要通知誰(若無，可用大括號{}刮起來。
        TextField(value = "",
            onValueChange = {},
            placeholder = {
                Text( text = "Search")
            },
            leadingIcon = {
                //參數1:icon的圖要是哪一個(這裡從Compose元件庫內拿取,Default裡有好幾個可用的圖示)
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            },
            modifier = modifier.fillMaxWidth()//占滿整個區塊
        )
    }

}

@Preview(showBackground = true)
@Composable
//可根據自己所要看的預覽圖，更改名字，如:SearchBar
fun MyView() {//為了與我們未來所設計的app長相相同，會有一個預覽可以看，
    MyApplicationTheme {//Theme:主題->包含app的配色、文字的屬性狀態等，
        SearchBar()//可更改為想要預覽的Composable的function
    }
}