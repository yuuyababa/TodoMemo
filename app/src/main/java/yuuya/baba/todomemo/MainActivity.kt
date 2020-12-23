package yuuya.baba.todomemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //追加ボタンを入力時、タスク追加画面に飛ぶ。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testAddButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val intent = Intent(this, taskSetting::class.java).apply {

        }
        startActivity(intent)
    }

}

