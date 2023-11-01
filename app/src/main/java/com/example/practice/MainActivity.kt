package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.provider.ContactsContract.Profile
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val user1 = User("aaaaa5@mail.ru", "qwe123RTY", "Ivan", "Zaytcev")
            val user2 = User("bbbb4@mail.ru", "123Qwerty", "Nikolay", "Korolev")
            val user3 = User("ccccc5@gmail.com", "Qwerty357", "Violetta", "Efremova")
            val user4 = User("ddddd5@mail.ru", "qweRTY357", "Yana", "Vorontsova")
            val user5 = User("eeeee@mail.ru", "qwe1RTY", "George", "Smith")
            val user6 = User("fffff@mail.ru", "QwErTy55", "Mikolaj", "Krawez")
        val users = listOf<User>(user1, user2, user3, user4, user5, user6)



        val user_login: EditText = findViewById(R.id.login)
        val user_pass: EditText = findViewById(R.id.password)
        val button: Button = findViewById(R.id.authorization)

        button.setOnClickListener {
            var login = user_login.text.toString().trim()
            var pass = user_pass.text.toString().trim()
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            if (!login.matches(emailPattern.toRegex())) {
                // Почта не соответствует формату
                user_login.error = "Некорректный адрес электронной почты"
            }
            val passPattern = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,}"
            if (!pass.matches(passPattern.toRegex())) {
                // Пароль не соответствует требованиям
                user_pass.error = "Пароль должен содержать хотя бы одну заглавную букву, строчную букву и цифру, и быть не короче 6 символов"
            }

            val isRegisteredAndTrueData = users.any{
                    user -> user.login == login && user.pass == pass
            }
            if (login == "" || pass == "")
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
            if (isRegisteredAndTrueData){
                val intent = Intent(this, ProfileActivity::class.java).apply{
                    putExtra("user1", user1)
                    putExtra("user2", user2)
                    putExtra("user3", user3)
                    putExtra("user4", user4)
                    putExtra("user5", user5)
                    putExtra("user6", user6)
                    putExtra("login", login)
                }
                startActivity(intent)
                login = ""
                pass = ""
            }
            else Toast.makeText(this, "Пользователь не найден", Toast.LENGTH_LONG).show()



        }


    }
}