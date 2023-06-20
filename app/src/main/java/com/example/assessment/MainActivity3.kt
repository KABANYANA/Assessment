package com.example.assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.assessment.databinding.ActivityMain3Binding





class MainActivity3 : AppCompatActivity() {

    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnSignn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        binding.tvHo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        validateLoginPerson()
        clearErrorOnType()
    }
    fun clearErrorOnType(){
        binding.etUser.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilUser.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )



        binding.etPass.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilPass.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
    }


    fun validateLoginPerson(){
        val name =binding.etUser.text.toString()
        val password =binding. etPass.text.toString()

        var error = false
        if (name.isBlank()){
            binding. tilUser.error = "name is required"
            error = true
        }

        if (password.isBlank()){
            binding.tilPass.error = "Email is required"
            error = true
        }



        if (!error){
            Toast.makeText(this,"$name,$password", Toast.LENGTH_LONG).show()
        }

    }
}

