package com.example.myhomework

import android.os.Bundle
import android.os.Message
import android.os.PersistableBundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    private val textView by lazy { findViewById<TextView>(R.id.textView) }
    private val name by lazy {findViewById<EditText>(R.id.name)}
    private val secondName by lazy {findViewById<EditText>(R.id.secondName)}
    private val age by lazy {findViewById<EditText>(R.id.age)}
    private val btn by lazy {findViewById<EditText>(R.id.btn)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
    }

    override fun onStart() {
        super.onStart()
        initView()
    }
    private fun initView(){
        btn.setOnClickListener {
            val name = name.text.toString()
            val secondName = secondName.text.toString()
            val age = age.text.toString()
            if(name.isEmpty() || secondName.isEmpty()) showToast() else createUser(name, secondName, age)
        }
    }

    private fun showToast(){
        Toast.makeText(this, R.string.press_btn, Toast.LENGTH_LONG).show()
    }

    private fun createUser(name:String, secondName:String, age: String){
        val user = User(name, secondName, age)
        val result = "${user.Name}, ${user.secondName}, ${user.age}"
        textView.text=result
    }


}