package com.example.tasky.data.repository

import android.content.Context
import com.example.tasky.domain.models.GetUserData
import com.example.tasky.domain.models.SaveUserData
import com.example.tasky.domain.repository.UserRepository

private  const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_USER_LOGIN = "login"
private const val KEY_USER_PASSWORD = "password"

class UserRepositoryImpl(private val context: Context) : UserRepository {

   private val sharedPrefences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserData): Boolean{
        sharedPrefences.edit().putString(KEY_USER_LOGIN, saveParam.login).apply()
        sharedPrefences.edit().putString(KEY_USER_PASSWORD, saveParam.password)

      return true
    }

    override fun getName(): GetUserData {
        val login = sharedPrefences.getString(KEY_USER_LOGIN, "") ?: ""
        val password = sharedPrefences.getString(KEY_USER_PASSWORD, "") ?: ""

        return  GetUserData(login = login, password =  password)
    }

}