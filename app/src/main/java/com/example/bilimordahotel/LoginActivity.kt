package com.example.bilimordahotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {
    private val TAG = "LoginActivity"


    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG, "onCreate: ")

        email_input.addTextChangedListener(this)
        password_input.addTextChangedListener(this)
        login_btn.setOnClickListener(this)
        mAuth = FirebaseAuth.getInstance()

    }
    override fun onClick(view: View) {
        val email = email_input.text.toString()
        val password = password_input.text.toString()
        if(validate(email, password)){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }

        }
    }

    private fun validate(email: String, password: String)=
        email.isNotEmpty() &&  password.isNotEmpty()
    override fun afterTextChanged(p0: Editable?) {
        login_btn.isEnabled = validate(email_input.text.toString(), password_input.text.toString())
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
}
