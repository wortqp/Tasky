package com.example.tasky.domain.usecase

import com.example.tasky.domain.models.GetUserData
import com.example.tasky.domain.repository.UserRepository


class GetDataUserUseCase(private val userRepository: UserRepository) {

    fun execute(): GetUserData {
        return userRepository.getName()
    }
}