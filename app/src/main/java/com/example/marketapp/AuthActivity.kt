package com.example.marketapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val userLogin: EditText = findViewById(R.id.etUser_login_auth)
        val userPass: EditText = findViewById(R.id.etUser_password_auth)
        val button: Button = findViewById(R.id.btn_auth)
        val linkToReg: TextView = findViewById(R.id.tvLink_to_reg)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login  = userLogin.text.toString().trim()
            val pass  = userPass.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Not all fields are filled in", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if(isAuth == true) {
                    Toast.makeText(this, "User: $login is authorized", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "User: $login isn't authorized", Toast.LENGTH_LONG).show()
            }
        }
    }
}