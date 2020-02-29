package progr.rostoslav.za

import kotlin.math.absoluteValue

data class User(
    var name: String = "Name",
    var surname: String = "Surname",
    var date_of_birth: String = "01" + DIV + "01" + DIV + "2401"
) {

    fun differense(date: String):String{
        return differense(
            date.split(DIV)[0].toInt(),
            date.split(DIV)[1].toInt(),
            date.split(DIV)[2].toInt())
    }

    fun differense(d: Int, m: Int, y: Int): String {
        var r = ""
        val diff_d = date_of_birth.split(DIV)[0].toInt() - d
        val diff_m = date_of_birth.split(DIV)[1].toInt() - m - if (diff_d < 0) 1 else 0
        val diff_y = date_of_birth.split(DIV)[2].toInt() - y - if (diff_m < 0) 1 else 0

        r += (if (diff_d < 0) diff_d + 30 else diff_d).toString() + DIV
        r += (if (diff_m < 0) diff_m + 12 else diff_m).toString() + DIV
        r += diff_y.absoluteValue
        if (diff_y > 0) r = "-" + r
        return r
    }
 fun isOlder(d:Int,m:Int,y:Int,age_limit:Int=18):Boolean {
     return if (differense(d, m, y)[0] == '-') false
      else (differense(d, m, y).split(DIV)[2]).toInt() > age_limit

 }

    override fun toString() = "$name $surname \n $date_of_birth"
}
