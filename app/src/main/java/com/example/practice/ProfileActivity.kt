package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val user1 = intent.getSerializableExtra("user1") as User
        val user2 = intent.getSerializableExtra("user2") as User
        val user3 = intent.getSerializableExtra("user3") as User
        val user4 = intent.getSerializableExtra("user4") as User
        val user5 = intent.getSerializableExtra("user5") as User
        val user6 = intent.getSerializableExtra("user6") as User
        val users = listOf<User>(user1, user2, user3, user4, user5, user6)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val nameTextView = findViewById<TextView>(R.id.name)
        val surnameTextView = findViewById<TextView>(R.id.surname)
        val emailTextView = findViewById<TextView>(R.id.email)
        val exitButton = findViewById<Button>(R.id.logOut)

        val login = intent.getStringExtra("login")
        val user = users.find { it.login == login }
        val name = user?.name ?: "Unknown"
        val surname = user?.surname ?: "Unknown"

        nameTextView.text = "${name}"
        surnameTextView.text = "${surname}"
        emailTextView.text = "${login}"
        val profilePic = name.lowercase()
        val resId = resources.getIdentifier(profilePic, "drawable", "com.example.practice")
        imageView.setImageResource(resId)
        exitButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}