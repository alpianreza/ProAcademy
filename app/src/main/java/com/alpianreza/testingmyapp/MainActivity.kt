package com.alpianreza.testingmyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val btnSetValue: Button? = null
    private lateinit var tvText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText =  findViewById(R.id.tv_text)
        btnSetValue!!.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_set_value)
            tvText.text = "19"
    }

}