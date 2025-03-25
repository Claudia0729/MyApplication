package com.example.myapplication.student

class Health_Report : Report{
    override fun load() {
        println("Loading Health Report")
    }

    override fun print(title: String) {
        println("Printing Health")
    }
}