package ru.skillbranch.devintensive.extensions

fun String?.trimStartEnd(): String? = this?.trimStart()?.trimEnd()