package com.example.tasky.domain.repository

import com.example.tasky.data.UserData
import com.example.tasky.domain.models.GetUserData
import com.example.tasky.domain.models.SaveUserData

interface UserRepository {
    fun saveName(saveParam: SaveUserData): Boolean

    fun getName(): GetUserData
}