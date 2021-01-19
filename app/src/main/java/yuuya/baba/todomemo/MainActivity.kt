package yuuya.baba.todomemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.CalendarView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //追加ボタンを入力時、タスク追加画面に飛ぶ。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /******カレンダーウィジェットの設定******/
        taskCalenderView()

        /*タスク追加画面の呼び出しボタン*/
        val fab :View = findViewById(R.id.mainfab)
        fab.setOnClickListener{view ->
            val intent = Intent(this, taskSetting::class.java)
            startActivity(intent)
        }

    }


    fun taskCalenderView() {
        //CalendarViewに現在日時を指定する。
        val calendarView = findViewById<CalendarView>(R.id.TaskCalendar)
        calendarView.date = System.currentTimeMillis()

        //CalendarViewで日にちが選択された時に呼び出されるリスナークラス。
        val listener = DateChangeListener()
        calendarView.setOnDateChangeListener(listener)

    }

    fun moveTaskList(year: Int, month: Int, day: Int) {

        var intent = Intent(this@MainActivity, taskList::class.java)

        intent.putExtra("year", year)
        intent.putExtra("month", month)
        intent.putExtra("day", day)

        var requestcode = 1000
        intent.putExtra("requestcode", requestcode)


        if (intent.resolveActivity(packageManager) != null) {

            this@MainActivity.startActivity(intent)

        }
    }

    //calenderViewで日にちが選択された時に呼び出されるリスナークラス
    private inner class DateChangeListener : CalendarView.OnDateChangeListener {
        override fun onSelectedDayChange(
            view: CalendarView,
            year: Int,
            month: Int,
            dayOfMonth: Int
        ) {

            //カレンダークラスから別画面に移動するための関数
            moveTaskList(year, month, dayOfMonth)

        }

    }


}



