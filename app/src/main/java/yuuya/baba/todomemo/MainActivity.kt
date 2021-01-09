package yuuya.baba.todomemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.CalendarView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //追加ボタンを入力時、タスク追加画面に飛ぶ。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //タスク追加画面に遷移するボタン
        testAddButton.setOnClickListener(this)


        /******カレンダーウィジェットの設定******/
        taskCalenderView()


    }

    override fun onClick(v: View?) {
        val intent = Intent(this, taskSetting::class.java).apply {

        }
        startActivity(intent)
    }

    fun taskCalenderView(){
        //CalendarViewに現在日時を指定する。
        val calendarView = findViewById<CalendarView>(R.id.TaskCalendar)
        calendarView.date=System.currentTimeMillis()

        //CalendarViewで日にちが選択された時に呼び出されるリスナークラス。
        val listener = DateChangeListener()
        calendarView.setOnDateChangeListener(listener)

    }

    //calenderViewで日にちが選択された時に呼び出されるリスナークラス
    private inner class DateChangeListener: CalendarView.OnDateChangeListener{
        override fun onSelectedDayChange(
            view: CalendarView,
            year: Int,
            month: Int,
            dayOfMonth: Int
        ) {
            //選択された日程のタスクを取り出す？
            //日程の情報を引数として渡す。
            var intent = Intent(this@MainActivity, taskList::class.java).apply {

                intent.putExtra("year",year)
                intent.putExtra("month",month)
                intent.putExtra("day",dayOfMonth)

                var requestcode = 1000
                intent.putExtra("requestcode",requestcode)

            }
            startActivity(intent)

            




        }

    }

}

