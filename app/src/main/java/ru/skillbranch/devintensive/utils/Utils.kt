package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extentions.trimStartEnd

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
        var res = "";
        for (ch in payload){
            if ((ch in 'a'..'z') || (ch in 'A'..'Z')){
                res+=ch
            }
            else{
                val chInLow = ch.toLowerCase()
                if (chInLow in TranslateMap.transcriptions){
                    var transStr = TranslateMap.transcriptions[chInLow]
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
        val firstNameTrim = firstName.trimStartEnd()
        val lastNameTrim = lastName.trimStartEnd()

        if (firstNameTrim.isNullOrEmpty()) return null
        val first = firstNameTrim.first().toUpperCase().toString()
        if (lastNameTrim.isNullOrEmpty()) return first
        val second = lastNameTrim.first().toUpperCase().toString()
        return "$first$second"
    }



}