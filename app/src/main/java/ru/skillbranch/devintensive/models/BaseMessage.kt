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
            from:User, chat:Chat, date:Date, type:MessageType, payload:String?, isIncoming: Boolean = false
        ):BaseMessage{
            lastId++
            return when(type){
                MessageType.Text -> TextMessage(lastId.toString(),from ,chat,isIncoming,date,payload)
                MessageType.Image -> ImageMessage(lastId.toString(),from ,chat,isIncoming,date,payload)
            }
        }
    }

}