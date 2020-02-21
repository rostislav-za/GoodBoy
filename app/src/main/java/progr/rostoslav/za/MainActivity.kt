package progr.rostoslav.za

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_recycler.*
import progr.rostoslav.za.adapters.ChatMessage
import progr.rostoslav.za.adapters.MessageAdapter
import java.util.*

class MainActivity : AppCompatActivity() {
    val user = User()
    val age_limit: Int = 18

    val c = Calendar.getInstance()
    var year = c.get(Calendar.YEAR)
    var month = c.get(Calendar.MONTH)
    var day = c.get(Calendar.DAY_OF_MONTH)

    val chatAdapter = MessageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = chatAdapter
        chatAdapter.addItem(ChatMessage(true, WHO_ARE_YOU_MESSAGE))
        am_btn_getbrthday.setOnClickListener { showDatePicker() }
    }

    fun showDatePicker() {
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, y, m, d ->
            user.date_of_birth = dateFormat(d, m, y)
            showResultForBoy()
        }, year, month, day).show()
    }

    fun showResultForBoy() {
        var message_text = ""
        user.name = am_et_name.text.toString()
        user.surname = am_et_surname.text.toString()
        if ((user.name != "") and (user.surname != "")) {
            message_text = (HELLO_MESSAGE + "\n" + user.name + " " + user.surname + "\n")
            message_text += if (user.differense(day, month, year).split(DIV)[2].toInt() > age_limit
            ) GOOD_RESULT_MESSAGE
            else BAD_RESULT_MESSAGE
            chatAdapter.addItem(
                ChatMessage(false, user.toString())
            )
            chatAdapter.addItem(ChatMessage(true, message_text))
        } else {
            message_text = SOME_ERROR_MESSAGE + CLEAN_FIELDS_ERROR_MESSAGE
            chatAdapter.addItem(ChatMessage(true, message_text))
        }
    }

    //return date in string pattern "dd.mm.yyyy"
    fun dateFormat(d: Int, m: Int, y: Int) =
        ((if (d < 10) "0" + d else "" + d) + DIV + (if (m < 10) "0" + m else "" + m) + DIV + y)

}

