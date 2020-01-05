package com.example.sharedpref

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        saveBtn.setOnClickListener{

            val editor:SharedPreferences.Editor =  sharedPreferences.edit()

            val enteredText = toastText.text.toString()

            if(enteredText.isEmpty()){
                Toast.makeText(this,"please enter text",Toast.LENGTH_LONG).show()
            }else{
                editor.putString("WelcomeText",enteredText)
                editor.apply()
                editor.commit()
                Toast.makeText(this,"saved successfully",Toast.LENGTH_LONG).show()
                toastText.text.clear()
            }
        }

        showBtn.setOnClickListener{
            val sharedNameValue = sharedPreferences.getString("WelcomeText","defaultname")

            if (sharedNameValue.equals("defaultname")){
                Toast.makeText(this, "you have not entered text yet",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "${sharedNameValue.toString()}",Toast.LENGTH_LONG).show()

            }
        }

    }
}
