package yuuya.baba.todomemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import yuuya.baba.todomemo.R.layout.activity_task_list

class taskList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_task_list)

        setData()

        val fab :View = findViewById(R.id.fab)
        fab.setOnClickListener{view ->


        }


    }

    //画面遷移時のインテント等からデータを受け取るクラス

    fun setData() {
        val intent = getIntent()
        val selectYear = intent.getIntExtra("year", 200)
        val selectMonth = intent.getIntExtra("month", 200)
        val selectDay = intent.getIntExtra("day", 200)
        val code = intent.getIntExtra("requestcode", 200)

        if (code == 1000) {

            var daySet = findViewById<TextView>(R.id.intentTitle)

            if (daySet != null) {

               var strDay = selectDay.toString()
                daySet.setText(strDay)
            }
        }

    }
}
