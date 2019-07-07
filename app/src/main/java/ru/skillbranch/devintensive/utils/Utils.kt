package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.trimStartEnd

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        val trimFullName = fullName.trimStartEnd()
        if (trimFullName.isNullOrEmpty()) return null to null
        val regex = Regex("\\s+")
        val values = regex.split(trimFullName)

        val res =  when (val length = values.count()) {
            0 -> null to null
            1 -> values[0] to null
            2 -> values[0] to values[1]
            else -> {
                val lastName = values[length-1]
                val firstName = values.dropLast(1).joinToString(" ")
                return firstName to lastName
            }
        }
        return res
    }

    fun transliteration(payload:String, divider:String = " "):String{
        var res = ""
        for (ch in payload){
            if ((ch in 'a'..'z') || (ch in 'A'..'Z')){
                res+=ch
            }
            else{
                val chInLow = ch.toLowerCase()
                if (chInLow in TranslateMap.transcriptions){
                    val transStr = TranslateMap.transcriptions[chInLow]
                    if (ch.isUpperCase() && !transStr.isNullOrEmpty()){
                        res+=transStr[0].toUpperCase()
                        res+=transStr.drop(1)
                    }
                    else{
                        res+=transStr
                    }
                }
                else{
                    res+=divider
                }
            }
        }
        return res
    }

    fun toInitials(firstName:String?, lastName:String?) : String?{
        var res = ""
        val firstNameSymbol = getFirstSymbolOrNull(firstName)
        if (firstNameSymbol != null){
            res+=firstNameSymbol
        }
        val lastNameSymbol = getFirstSymbolOrNull(lastName)
        if (lastNameSymbol != null){
            res+=lastNameSymbol
        }
        return if (res.isEmpty()) null else res
    }

    private fun getFirstSymbolOrNull(src: String?):Char?{
        val srcTrim = src.trimStartEnd()
        if (srcTrim.isNullOrEmpty()){
            return null
        }
        return srcTrim.first().toUpperCase()
    }



}