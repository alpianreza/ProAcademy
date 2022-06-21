package com.alpianreza.testingmyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSetValue = findViewById(R.id.btn_set_value)
        tvText =  findViewById(R.id.tv_text)
        btnSetValue.setOnClickListener(this)

        names.add("Reza")
        names.add("Alpian")
        names.add("Kasep")

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_set_value)
            Log.d("MainActivity", names.toString())
        val name = StringBuilder()
        for (i in 0..3) {
            name.append(names[i]).append("\n")
        }
        tvText.text = name.toString()
    }

}