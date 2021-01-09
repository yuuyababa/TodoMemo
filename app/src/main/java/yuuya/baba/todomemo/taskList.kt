package yuuya.baba.todomemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class taskList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        setData()


    }

    //画面遷移時のインテント等からデータを受け取るクラス

    fun setData() {
        val intent = getIntent()
        val selectYear = intent.getStringExtra("year")
        val selectMonth = intent.getStringExtra("month")
        val selectDay = intent.getStringExtra("day")
        val code = intent.getStringExtra("requestcode")

        if (code == "1000") {


            var daySet = findViewById<TextView>(R.id.intentTitle)
            daySet.setText(selectDay)
        }

    }
}
