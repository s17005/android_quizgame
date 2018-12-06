package jp.ac.it_college.std.s17005.quizappli

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "QuizTable.db", null, 1){
    //onCreateメソッド
    override fun onCreate(db: SQLiteDatabase) {
        // テーブルの作成
        db.execSQL(
            "CREATE TABLE MyTable " +
                    "(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", Pref TEXT" +
                    ", City0 TEXT" +
                    ", City1 TEXT" +
                    ", City2 TEXT" +
                    ", City3 TEXT" +
                    ", City4 TEXT" +
                    ")"
        )

        // 初期データ投入
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('この中でアプリをＤＬしなくてもできるゲームはどれか','グランブルーファンタジー','プリンセスコネクトＲｅＤｉｖｅ','アイドルマスターシンデレラガールズスターライトステージ','シャドウバース','グランブルーファンタジー');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('この中でリリースされたのが一番新しいのはどれか','プリンセスコネクトＲｅＤｉｖｅ','シャドウバース','グランブルーファンタジー','プリンセスコネクトＲｅＤｉｖｅ','アイドルマスターシンデレラガールズスターライトステージ');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('プリンセスコネクトＲｅＤｉｖｅのジャンルは何か','アニメＲＰＧ','デジタルカードゲーム','リズムゲーム','アニメＲＰＧ','スマホＲＰＧ');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('グランブルーファンタジーを作っている会社の名前は','サイゲームス','サイゲームス','サイバーエージェント','バンダイナムコゲームス','ミクシィ');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('アイドルマスターシンデレラガールズスターライトステージはとある会社とサイゲームスの共同制作である。とある会社とはどこか','バンダイナムコゲームス','ガンホー','ＫＯＮＡＭＩ','ＳＥＧＡ','バンダイナムコゲームス');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('シャドウバースはサイゲームスのあるゲームが元となって制作された。あるゲームとはどれか','神撃のバハムート','ドラゴンコレクション','怪盗ロワイヤル','釣りスタ','神撃のバハムート');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('プリンセスコネクトＲｅｄｉｖｅはサービス停止した前作を元に作られた作品である。前作の名前は','プリンセスコネクト','プリンセスコネクト','プリンセスコネクト1','プリンセスコネクトS','プリンセスコネクトG');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('グランブルーファンタジーは多数のメディア展開をしているが、この中でしていないメディア展開はどれか','映画','ＴＶアニメ','映画','キャラソンＣＤ','コミック');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('サイゲームスはある会社の子会社である。サイゲームスの親会社の名前は','サイバーエージェント','サイバーエージェント','シーエー・モバイル','サイバーエージェント・ベンチャーズ','ＣｙｂｅｒＺ');")
        db.execSQL("INSERT INTO MyTable(Pref,City0, City1, City2, City3, City4) values ('この中で２０１８年１１月現在サービスを終了しているサイゲームスのゲームはどれか','ナイツオブグローリー','ドラガリアロスト','ナイツオブグローリー','神撃のバハムート','リトルノア');")
    }

    // onUpgradeめそっど
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 空
    }
}