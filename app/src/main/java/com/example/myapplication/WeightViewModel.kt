package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//要記得要繼承ViewModel(類別)，並呼叫建構子
class WeightViewModel : ViewModel() {
    var average = (55..100).random()//有需要和別人要資料再寫，在這裡不寫也可以
    val averageData = MutableLiveData<Int>()//可以傾聽(observe)用
    var counter = MutableLiveData<Int>()//因為counter值會變動，存放counter的Int值
    val status = MutableLiveData<GameStatus>()
    //當WeightViewModel物件在Main2Activity被生出來後，且物件的建構子產生後，還需多執行甚麼指令，可以在init()內
    init {//建構子產生後，會先跑這個，再跑fun input
        counter.value = 0 //確保方法裡面的counter值不會是null的可能，但這樣fun裡面的value還是可能為null
        status.value = GameStatus.INIT
        averageData.value = average
    }
    fun input ( weight:Int){//透過呼叫方法，來取得counter的值
        status.value = when ( average - weight ){
            0 -> GameStatus.CORRECT
            in 1..Int.MAX_VALUE -> GameStatus.BIGGER
            else -> GameStatus.SMALLER
        }

        var c = counter.value ?: 0 //再加上貓王，讓value值完全等於整數
        c++
        counter.value = c //把新的值放到MutableLiveData裡面，此時counter值已改變。Main2Activity透過observe可知道值改變
    }
    fun reset(){
        average = (55..100).random()
        counter.value = 0
        status.value = GameStatus.INIT
        averageData.value = average
    }
}

enum class GameStatus{
    INIT, BIGGER, SMALLER, CORRECT
}
