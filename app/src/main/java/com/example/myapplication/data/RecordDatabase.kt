package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
//arrayof()括號內放類別名稱，version的版本先寫死寫成1就好
@Database(entities = arrayOf(Record::class), version = 1)
abstract class RecordDatabase : RoomDatabase() {//繼承一個RoomDatabase()，要記得在最前面加上abstract抽象類別
    //需要設計一個抽象的方法: 取得DAO類別 命名前面是小寫後面是大寫
    abstract fun recordDao(): RecordDao
}