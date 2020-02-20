package progr.rostoslav.za

import kotlin.math.absoluteValue


data class User(
    var name: String = "Name",
    var surname: String = "Surname",
    var date_of_birth: String = "01.01.2401"

) {
    val DIV="."
    fun differense(date: String) =
        (date_of_birth.split(DIV)[0].toInt() - date.split(DIV)[0].toInt()).absoluteValue.toString() +
        "." +
        (date_of_birth.split(DIV)[1].toInt() - date.split(DIV)[1].toInt()).absoluteValue.toString() +
        "." +
        (date_of_birth.split(DIV)[2].toInt() - date.split(DIV)[2].toInt()).absoluteValue.toString()

}
/*Year.now().getValue()
*
* Calendar.getInstance().get(Calendar.YEAR*/