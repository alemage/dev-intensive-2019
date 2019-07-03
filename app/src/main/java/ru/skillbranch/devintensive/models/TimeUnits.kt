package ru.skillbranch.devintensive.models

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY,

}

object TimeConstants{
    const val SECOND = 1000L
    const val MINUTE = 60 * SECOND
    const val HOUR = 60* MINUTE
    const val DAY = 24* HOUR
    const val YEAR = 365 * DAY
}