package ru.skillbranch.devintensive.extentions

import ru.skillbranch.devintensive.models.TimeConstants
import ru.skillbranch.devintensive.models.TimeUnits
import java.text.SimpleDateFormat
import java.util.*



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
    return ""
}