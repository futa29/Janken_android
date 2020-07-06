package com.example.janken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //それぞれの手のボタンを押されると、onJankenButtonTappedメソッドを呼び出す
        gu.setOnClickListener { onJanekenButtonTapped(it)}
        choki.setOnClickListener{ onJanekenButtonTapped(it)}
        pa.setOnClickListener{ onJanekenButtonTapped(it)}
    }

    //idを次の画面に受け渡す
    fun onJanekenButtonTapped(view: View?) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("MY_HAND", view?.id)
        startActivity(intent)
    }

}
