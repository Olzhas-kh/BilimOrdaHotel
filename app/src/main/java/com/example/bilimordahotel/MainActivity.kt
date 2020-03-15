package com.example.bilimordahotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
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
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        if(email.contains("ohrana")) {
                            startActivity(Intent(this, OhranaActivity::class.java))
                            finish()
                        }else if (email.contains("admin")){
                            startActivity(Intent(this, AdminActivity::class.java))
                            finish()
                        }else if (email.contains("moderator")){
                            startActivity(Intent(this, ModeratorActivity::class.java))
                            finish()
                        }
                        else if (email.contains("reception")){
                            startActivity(Intent(this, ReceptionActivity::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Please enter your login and password",Toast.LENGTH_SHORT)
                        }
                    }
                }
            }
        }
    }

}
