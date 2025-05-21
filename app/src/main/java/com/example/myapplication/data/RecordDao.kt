package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface RecordDao {
    //當資料的id與之前的資料庫內部的id有所重複的話，就可設定onConflict
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(reocrd:Record)//新增資料

    @Query("select * from Record")//查詢語法
    fun getAll() : List<Record>//取得所有資料
}