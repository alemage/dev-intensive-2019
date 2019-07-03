package ru.skillbranch.devintensive.extentions

fun String?.trimStartEnd(): String? = this?.trimStart()?.trimEnd()