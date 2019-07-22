package ru.skillbranch.devintensive.models

class Bender(var status:Status = Status.NORMAL, val question:Question = Question.NAME) {

    fun askQuestion():String = when (question){

        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> TODO()
        Question.MATERIAL -> TODO()
        Question.BDAY -> TODO()
        Question.SERIAL -> TODO()
        Question.IDLE -> TODO()
    }



    fun listenAnswer(answer:String):Pair<String, Triple<Int,Int,Int>>{
        TODO()
    }

    enum class Status(val color: Triple<Int,Int,Int>) {
        NORMAL(Triple(255, 255, 255)) ,
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 0, 0)) ;
    }
    enum class Question(val question: String, val answers: List<String>) {
        NAME("Как меня зовут?", listOf("Бендер", "bender")),
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender")),
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron", "wood")),
        BDAY("Когда меня создали?", listOf("2993")),
        SERIAL("Мой серийный номер?", listOf("2716057")),
        IDLE("На этом все, вопросов больше нет", listOf())
    }
}