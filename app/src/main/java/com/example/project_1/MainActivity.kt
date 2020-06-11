package com.example.project_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun convert(view: View){
        val2.setText((val1.text.toString().toDouble() / 74).toString())
        GlobalScope.async(Dispatchers.IO){
            var valute1 = str1.text.toString()
            var valute2 = str2.text.toString()
            var res1 = 1.0
            if (valute1 != "EUR"){
                var url1 = "https://api.exchangeratesapi.io/latest?symbols=$valute1"
                res1 = URL(url1).readText().substring(16,22).toDouble()
            }
            var value = val1.text

            if (valute1 == valute2){
                val2.text = (res1/res1*value.toString().toDouble()).toString()
            }else{
                var url2 = "https://api.exchangeratesapi.io/latest?symbols=$valute2"
                var res2 = URL(url2).readText().substring(16,22).toDouble()
                val2.text = (res2/res1*value.toString().toDouble()).toString()
            }

        }
    }
}