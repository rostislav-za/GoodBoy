package progr.rostoslav.za

import kotlin.math.absoluteValue

data class User(
    var name: String = "Name",
    var surname: String = "Surname",
    var date_of_birth: String = "01" + DIV + "01" + DIV + "2401"
) {

    fun differense(date: String) = "" +
            (date_of_birth.split(DIV)[0].toInt() - date.split(DIV)[0].toInt()).absoluteValue +
            DIV +
            (date_of_birth.split(DIV)[1].toInt() - date.split(DIV)[1].toInt()).absoluteValue +
            DIV +
            (date_of_birth.split(DIV)[2].toInt() - date.split(DIV)[2].toInt()).absoluteValue

    fun differense(d: Int, m: Int, y: Int) = "" +
            (date_of_birth.split(DIV)[0].toInt() - d).absoluteValue +
            DIV +
            (date_of_birth.split(DIV)[1].toInt() - m).absoluteValue +
            DIV +
            (date_of_birth.split(DIV)[2].toInt() - y).absoluteValue


    override fun toString() ="$name $surname \n $date_of_birth"
}
