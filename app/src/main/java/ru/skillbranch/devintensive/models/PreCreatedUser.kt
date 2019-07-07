package ru.skillbranch.devintensive.models

import java.util.*

class PreCreatedUser {
    private var _user = User.makeUser(null)
    private var _id = ""
    fun id(s:String) :PreCreatedUser {return this.apply { _id  = s}}
    fun firstName(s:String?) :PreCreatedUser {return this.apply { _user.firstName  = s}}
    fun lastName(s:String?) :PreCreatedUser {return this.apply { _user.lastName  = s}}
    fun avatar(s:String?) :PreCreatedUser {return this.apply { _user.avatar  = s}}
    fun rating(n: Int):PreCreatedUser {return this.apply { _user.rating  = n}}
    fun respect(n: Int):PreCreatedUser {return this.apply { _user.respect  = n}}
    fun lastVisit(d: Date?):PreCreatedUser {return this.apply { _user.lastVisit  = d}}
    fun isOnline(b: Boolean) :PreCreatedUser {return this.apply { _user.isOnline  = b}}
    fun build():User {
        return _user.copy(id = _id)
    }
}