package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
    ){
    abstract fun formatMessage(): String

    companion object AbstractFactory{
        var lastId = -1;
        fun makeMessage(
            from:User, chat:Chat, date:Date, type:String = "text", payload:Any? = null, isIncoming: Boolean = false
        ):BaseMessage{
            lastId++
            return when(type.toLowerCase()){
                MessageType.Text -> TextMessage(lastId.toString(),from ,chat,isIncoming,date,payload?.toString())
                MessageType.Image -> ImageMessage(lastId.toString(),from ,chat,isIncoming,date,payload?.toString())
                else -> throw Exception("wrong message format")

            }
        }
    }

}