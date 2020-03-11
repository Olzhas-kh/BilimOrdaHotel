package com.example.bilimordahotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
        mAuth = FirebaseAuth.getInstance()
        mAuth.addAuthStateListener {
            if(it.currentUser==null){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
        sign_out_text.setOnClickListener {
            mAuth.signOut()
        }
}
    override fun onStart(){
        super.onStart()
        if (mAuth.currentUser == null){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}
