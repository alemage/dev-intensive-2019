package ru.skillbranch.devintensive.utils

sealed class TranslateMap {
    companion object{
        val transcriptions : Map<Char, String> = mapOf(
        Pair<Char,String>('а', "a"),
        Pair<Char,String>('б', "b"),
        Pair<Char,String>('в', "v"),
        Pair<Char,String>('г', "g"),
        Pair<Char,String>('д', "d"),
        Pair<Char,String>('е', "e"),
        Pair<Char,String>('ё', "e"),
        Pair<Char,String>('ж', "zh"),
        Pair<Char,String>('з', "z"),
        Pair<Char,String>('и', "i"),
        Pair<Char,String>('й', "j"),
        Pair<Char,String>('к', "k"),
        Pair<Char,String>('л', "l"),
        Pair<Char,String>('м', "m"),
        Pair<Char,String>('н', "n"),
        Pair<Char,String>('о', "o"),
        Pair<Char,String>('п', "p"),
        Pair<Char,String>('р', "r"),
        Pair<Char,String>('с', "s"),
        Pair<Char,String>('т', "t"),
        Pair<Char,String>('у', "u"),
        Pair<Char,String>('ф', "f"),
        Pair<Char,String>('х', "h"),
        Pair<Char,String>('ц', "c"),
        Pair<Char,String>('ч', "ch"),
        Pair<Char,String>('ш', "sh"),
        Pair<Char,String>('щ', "sh"),
        Pair<Char,String>('ъ', ""),
        Pair<Char,String>('ы', "i"),
        Pair<Char,String>('ь', ""),
        Pair<Char,String>('э', "e"),
        Pair<Char,String>('ю', "yu"),
        Pair<Char,String>('я', "ya")
    )
    }
}