package jp.ac.it_college.std.s17005.quizappli

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.content.Intent
import android.view.View
import android.widget.TextView
import android.database.sqlite.SQLiteDatabase
import android.widget.Button
import android.content.ContentValues
import android.widget.Toast


class MainGameNormal : AppCompatActivity() {
    var QuestionNo: String? = null
    var Seikai: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // タイトルバー非表示
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main_game_normal)

        val intent = intent
        QuestionNo = intent.getStringExtra("QuestionNo")
    }

    override fun onResume() {
        super.onResume()

        // 画面↑にあるテキストを「クイズNo. + 問題No で表示
        (findViewById<View>(R.id.textNo) as TextView).text = "クイズNo.$QuestionNo"

        // 問題文セット処理呼び出し
        setQuestion()
    }

    private fun setQuestion() {
        // 作成したDatabaseHelperクラスに読み取り専用でアクセス
        val dbHelper = DatabaseHelper(this)
        val db = dbHelper.readableDatabase

        // SELECT文
        val sql = "SELECT Pref, City0, City1, City2, City3, City4 FROM MyTable WHERE _id=$QuestionNo"

        // SQL文を実行してカーソルを取得
        val c = db.rawQuery(sql, null)
        c.moveToFirst()

        // データベースから取ってきたデータをセット
        val Mondai = c.getString(c.getColumnIndex("Pref")) // 問題
        val Choice1 = c.getString(c.getColumnIndex("City1")) // 選択肢1
        val Choice2 = c.getString(c.getColumnIndex("City2")) // 選択肢2
        val Choice3 = c.getString(c.getColumnIndex("City3")) // 選択肢3
        val Choice4 = c.getString(c.getColumnIndex("City4")) // 選択肢4

        Seikai = c.getString(c.getColumnIndex("City0")) // 答え

        // データベースのクローズ処理
        c.close()
        db.close()

        (findViewById<View>(R.id.textQuestion) as TextView).text = Mondai // 問題文となる都道府県をテキストに表示
        (findViewById<View>(R.id.button1) as Button).setText(Choice1) // 四択の選択肢1をボタンに表示
        (findViewById<View>(R.id.button2) as Button).setText(Choice2) // 四択の選択肢2をボタンに表示
        (findViewById<View>(R.id.button3) as Button).setText(Choice3) // 四択の選択肢3をボタンに表示
        (findViewById<View>(R.id.button4) as Button).setText(Choice4) // 四択の選択肢4をボタンに表示

    }

    // 選択肢がクリックされた時の処理
    fun onClick(v: View) {
        if ((v as Button).text == Seikai) {
            Toast.makeText(applicationContext, "正解です。", Toast.LENGTH_LONG).show()
            val intent = Intent(this@MainGameNormal, Explanation::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, "不正解。", Toast.LENGTH_LONG).show()
            val intent = Intent(this@MainGameNormal, Explanation::class.java)
            startActivity(intent)
        }
    }
}
