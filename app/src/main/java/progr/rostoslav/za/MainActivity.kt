package progr.rostoslav.za

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val user = User()
    val age_limit: Int = 18

    val c = Calendar.getInstance()
    var year = c.get(Calendar.YEAR)
    var month = c.get(Calendar.MONTH)
    var day = c.get(Calendar.DAY_OF_MONTH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        am_btn_getbrthday.setOnClickListener { showDatePicker() }
    }

    fun showDatePicker() {
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, y, m, d ->
            user.date_of_birth = dateFormat(d, m, y)
            showResultForBoy()
        }, year, month, day).show()
    }

    fun showResultForBoy() {
        var r: String = ""
        user.name = am_et_name.text.toString()
        user.surname = am_et_surname.text.toString()
        if (!((user.name == "") or (user.surname == ""))) {
            r = (HELLO_MESSAGE + "\n" + user.name + " " + user.surname + "\n" +
                    if (user.differense(day, month, year).split(DIV)[2].toInt() > age_limit
                    ) GOOD_RESULT_MESSAGE
                    else BAD_RESULT_MESSAGE)
        } else {
            r = SOME_ERROR_MESSAGE + CLEAN_FIELDS_ERROR_MESSAGE
        }
        am_tv_result.text = r
    }

    //return date in string pattern "dd.mm.yyyy"
    fun dateFormat(d: Int, m: Int, y: Int) =
        ((if (d < 10) "0" + d else "" + d) + DIV + (if (m < 10) "0" + m else "" + m) + DIV + y)

}

