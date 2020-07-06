package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {


    //じゃんけんの勝敗を計算式で求めるために、それぞれの手に数値を与える
    val gu = 0
    val choki = 1
    val pa = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val id = intent.getIntExtra("MY_HAND",0)

        //自分が出した手をmyHandに格納する（例：グーならidに0を代入する）
        val myHand: Int
        myHand = when(id){
            R.id.gu ->{
                myHandImage.setImageResource(R.drawable.gu)
                gu
            }
            R.id.choki ->{
                myHandImage.setImageResource(R.drawable.choki)
                choki
            }
            R.id.pa ->{
                myHandImage.setImageResource(R.drawable.pa)
                pa
            }
            else -> gu
        }

        //コンピュータが出す手をランダムに決める（例：グーならcomHandに0が代入される）
        val comHand = (Math.random()*3).toInt()
        when(comHand){
            gu -> comHandImage.setImageResource(R.drawable.com_gu)
            choki -> comHandImage.setImageResource(R.drawable.com_choki)
            pa -> comHandImage.setImageResource(R.drawable.com_pa)
        }

        //じゃんけんロジックを使い、対戦結果を表示させる
        //コンピュータがグー、ユーザーがパーの場合　（0-2+3)%3 = 1をgameResultに代入する
        val gameResult = (comHand - myHand + 3) % 3
        when(gameResult){
            0 -> resultLabel.setText(R.string.result_draw)
            1 -> resultLabel.setText(R.string.result_win)
            2 -> resultLabel.setText(R.string.result_lose)
        }
        //戻るボタンが押されると処理を終了させ、一つ前の画面に戻る
        backbutton.setOnClickListener { finish() }
    }
}
