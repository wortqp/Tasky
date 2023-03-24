package com.example.tasky.domain.usecase

import com.example.tasky.data.UserData
import com.example.tasky.domain.repository.UserRepository


class GetDataUserUseCase(private val userRepository: UserRepository) {

    fun execute(): UserData {
        return userRepository.getName()
    }
}