package com.example.tasky.domain.usecase

import com.example.tasky.domain.models.GetUserData
import com.example.tasky.domain.models.SaveUserData
import com.example.tasky.domain.repository.UserRepository


class SaveDataUserUseCase(private  val userRepository: UserRepository) {

    fun execute(param: SaveUserData) : Boolean {
        val oldUserName = userRepository.getName()

        if(oldUserName.login == param.login){
            return true
        }

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}