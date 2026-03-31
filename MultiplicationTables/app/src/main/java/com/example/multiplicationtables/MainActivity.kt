package com.example.multiplicationtables

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //added variable to hold the multiplication button
        val multiplyBtn = findViewById<Button>(R.id.calcBtn)
        //added variable to hold the user's input
        val numInput = findViewById<EditText>(R.id.numTxtInput)

        //added a listener to listen for when the button is clicked
        multiplyBtn.setOnClickListener {
            //created a variable to hold the switch between pages/screens
            val intent = Intent(this, Table::class.java)
                /*when this is called, the current/home page is closed and the multiplication table
                page is opened */
            intent.putExtra("tableNumber", numInput.text.toString())
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}