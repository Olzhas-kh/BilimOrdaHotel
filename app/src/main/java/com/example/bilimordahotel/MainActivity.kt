package com.example.bilimordahotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private val TAG = "LoginActivity"

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
        login_btn.setOnClickListener(this)
        mAuth = FirebaseAuth.getInstance()

}
    override fun onClick(view: View) {
        when (view.id) {
            R.id.login_btn -> {
                val email = email_input.text.toString()
                val password = password_input.text.toString()
                if (email == "ohrana@bilimorda.kz" && password == "o123456") {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {

                        startActivity(Intent(this, OhranaActivity::class.java))
                        finish()

                    }
                } else if (email == "admin@bilimorda.kz" && password == "admin2020") {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {

                        startActivity(Intent(this, AdminActivity::class.java))
                        finish()

                    }

                } else if (email == "moderator@bilimorda.kz" && password == "moderator123") {
                    mAuth.signInWithEmailAndPassword("asdfghj@k.com", "123456")
                        .addOnCompleteListener {

                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()

                        }

                } else {
                    Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT)

                }

            }
        }
    }

}
