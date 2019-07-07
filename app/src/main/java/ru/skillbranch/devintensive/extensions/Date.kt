package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.TimeConstants
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(num: Int):String{
        val pluralForm = getPluralForm(num)
        val pluralText = when (this){
            SECOND -> secondsMap[pluralForm]
            MINUTE -> minutesMap[pluralForm]
            HOUR -> hourMap[pluralForm]
            DAY -> daysMap[pluralForm]
        } ?: throw Exception ("Not found text value in pre-defined Map $pluralForm")

        return "$num $pluralText"
    }

    private fun getPluralForm(num: Int): TextForm {
        if (num in 10 .. 19) return TextForm.MANY
        return when (num % 10){
            0 -> TextForm.MANY
            1-> TextForm.ONE
            in 2 .. 4 -> TextForm.FEW
            in 5 .. 9 -> TextForm.MANY
            else -> throw Exception("${num % 10} mod 10 not in range")

        }

    }

    private val secondsMap = mapOf(
        TextForm.ONE to "секунду",
        TextForm.FEW to "секунды",
        TextForm.MANY to "секунд")

    private val minutesMap = mapOf(
        TextForm.ONE to "минуту",
        TextForm.FEW to "минуты",
        TextForm.MANY to "минут")

    private val hourMap = mapOf(
        TextForm.ONE to "час",
        TextForm.FEW to "часа",
        TextForm.MANY to "часов")

    private val daysMap = mapOf(
        TextForm.ONE to "день",
        TextForm.FEW to "дня",
        TextForm.MANY to "дней")

    private val yearsMap = mapOf(
        TextForm.ONE to "год",
        TextForm.FEW to "года",
        TextForm.MANY to "лет")

    enum class TextForm{
        ONE,
        FEW,
        MANY,
    }

}

val Int.sec get() = this * TimeConstants.SECOND
val Int.min get() = this * TimeConstants.MINUTE
val Int.hour get() = this * TimeConstants.HOUR
val Int.day get() = this * TimeConstants.DAY

val Long.asMin get() = (this / TimeConstants.MINUTE).toInt()
val Long.asHour get() = (this / TimeConstants.HOUR).toInt()
val Long.asDay get() = (this / TimeConstants.DAY).toInt()

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"):String{
    val simpleDateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return simpleDateFormat.format(this)
}

fun Date.add(value: Int, unit: TimeUnits = TimeUnits.SECOND): Date{
    var time = this.time
    time+= when (unit){
        TimeUnits.SECOND -> value * TimeConstants.SECOND
        TimeUnits.MINUTE -> value * TimeConstants.MINUTE
        TimeUnits.HOUR -> value * TimeConstants.HOUR
        TimeUnits.DAY-> value * TimeConstants.DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date? = Date()): String{
    val secondDate = date ?: Date()

    var diff = (this.time / 1000L - secondDate.time / 1000L) * 1000L
    if (diff < 0){
        diff = -diff
        return when (diff){
            in 0.sec..1.sec -> "только что"
            in 1.sec..45.sec->"несколько секунд назад"
            in 45.sec..75.sec->"минуту назад"
            in 75.sec..45.min ->"${TimeUnits.MINUTE.plural(diff.asMin)} назад"
            in 45.min..75.min->"час назад"
            in 75.min..22.hour -> "${TimeUnits.HOUR.plural(diff.asHour)} назад"
            in 22.hour .. 26.hour -> "день назад"
            in 26.hour..360.day -> "${TimeUnits.DAY.plural(diff.asDay)} назад"
            else -> "более года назад"
        }
    }
    else{
        return when (diff){
            in 0.sec..1.sec -> "прямо сейчас"
            in 1.sec..45.sec->"через несколько секунд"
            in 45.sec..75.sec->"через минуту"
            in 75.sec..45.min ->"через ${TimeUnits.MINUTE.plural(diff.asMin)}"
            in 45.min..75.min->"через час"
            in 75.min..22.hour -> "через ${TimeUnits.HOUR.plural(diff.asHour)}"
            in 22.hour .. 26.hour -> "через день"
            in 26.hour..360.day -> "через ${TimeUnits.DAY.plural(diff.asDay)}"
            else -> "более чем через год"
        }
    }

}