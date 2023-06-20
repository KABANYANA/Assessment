package com.example.assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.assessment.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnLogg.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        binding.tvH.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        validateRegisterPerson()
        clearErrorOnType()
    }
    fun clearErrorOnType(){
        binding.teUsername.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilUserName.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
        binding.tePhoneNumber.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilPhoneNumber.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
        binding.teEmail.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilEmail.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )

        binding.tePassword.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilPassword.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
    }


    fun validateRegisterPerson(){
        val name =binding.teUsername.text.toString()
        val contacts = binding.tePhoneNumber.text.toString()
        val email =binding. teEmail.text.toString()
        val password =binding. tePassword.text.toString()

        var error = false
        if (name.isBlank()){
            binding. tilUserName.error = "name is required"
            error = true
        }

        if (contacts.isBlank()){
            binding.    tilPhoneNumber.error = "contacts is required"
            error = true
        }

        if (email.isBlank()){
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (email.isBlank()){
            binding.tilPassword.error = "Email is required"
            error = true
        }



        if (!error){
            Toast.makeText(this,"$name,$contacts, $email,$password", Toast.LENGTH_LONG).show()
        }

    }
}

