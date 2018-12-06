package jp.ac.it_college.std.s17005.quizappli

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.content.Intent



class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        // タイトルバー非表示
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        // レイアウトのセット
        setContentView(R.layout.activity_main)


        // ジャンル選択遷移
        val btnGenre = findViewById<View>(R.id.button_hard) as Button
        btnGenre.setOnClickListener {
            val intent = Intent(this@MainActivity, Genre::class.java)
            startActivity(intent)
        }

        //　ランダムモードへの遷移
        val btnRandom = findViewById<View>(R.id.button_random) as Button
        btnRandom.setOnClickListener{
            val intent = Intent(this@MainActivity, MainGameRandom::class.java)
            startActivity(intent)
        }

    }

}
