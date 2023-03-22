package com.example.tasky.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tasky.R
import com.example.tasky.data.repository.UserRepositoryImpl
import com.example.tasky.domain.models.GetUserData
import com.example.tasky.domain.models.SaveUserData
import com.example.tasky.domain.usecase.GetDataUserUseCase
import com.example.tasky.domain.usecase.SaveDataUserUseCase

class MainActivity : AppCompatActivity() {
    private val repository by lazy {  UserRepositoryImpl(context = applicationContext) }
    private val saveDataUserUseCase by lazy { SaveDataUserUseCase(repository)}
    private val getDataUserUseCase by lazy { GetDataUserUseCase(repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTextView = findViewById<TextView>(R.id.editTextPersonName)
        val passwordTextView = findViewById<TextView>(R.id.editTextPassword)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val textName = findViewById<TextView>(R.id.textName)

        saveButton.setOnClickListener(){
           val loginText = nameTextView.text.toString()
            val passwordText = passwordTextView.text.toString()
            val params = SaveUserData(login = loginText, password = passwordText)
            val result: Boolean = saveDataUserUseCase.execute(param = params)
            if(result == true){
                val userData: GetUserData = getDataUserUseCase.execute()
                textName.text = "${userData.login}  ${userData.password}"
            }
        }
    }
}