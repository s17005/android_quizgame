package jp.ac.it_college.std.s17005.quizappli

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.*

class Genre : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
    }

    val btn05 = findViewById<View>(R.id.genre05) as Button
    btn05.setOnClickListener {
        val intent = Intent(this@Genre, Difficult::class.java)
        startActivity(intent)
    }

}
