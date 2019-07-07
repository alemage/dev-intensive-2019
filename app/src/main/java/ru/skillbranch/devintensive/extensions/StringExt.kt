package ru.skillbranch.devintensive.extensions

fun String?.trimStartEnd(): String? = this?.trimStart()?.trimEnd()

fun String.truncate(length: Int = 16):String{
    val trimString = this.trimStartEnd() ?: ""
    if (trimString.length <= length) return trimString

    val thisFirstSymbols = trimString.substring(0,length)
    return "${thisFirstSymbols.trimEnd()}..."
}

fun String.stripHtml():String{
    val regexTags = "<[^<]*>".toRegex()
    val withoutTags = regexTags.replace(this,"")

    val regexEscapes= "&[^&;]*;".toRegex()
    val withoutEscapes = regexEscapes.replace(withoutTags,"")

    val regexSpaces = "\\s+".toRegex()
    val res = regexSpaces.replace(withoutEscapes," ")

    return res
}