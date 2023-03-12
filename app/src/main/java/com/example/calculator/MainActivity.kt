package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged


class MainActivity : AppCompatActivity() {

    lateinit var decimalNumber: EditText
    lateinit var binaryNumber: EditText
    lateinit var octalNumber: EditText
    lateinit var hexNumber: EditText
    lateinit var buttonClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        addCallbacks()

    }

    private fun clearAll(){
        decimalNumber.text.clear()
        binaryNumber.text.clear()
        octalNumber.text.clear()
        hexNumber.text.clear()
    }
    private fun addCallbacks(){
        buttonClear.setOnClickListener{
            clearAll()
        }

        decimalNumber.doAfterTextChanged {
            if(decimalNumber.isFocused) {
                if (decimalNumber.text.toString().isNotEmpty()){
                    binaryNumber.setText(it.toString().toInt().toString(2))
                    octalNumber.setText(it.toString().toInt().toString(8))
                    hexNumber.setText(it.toString().toInt().toString(16).toUpperCase())
                } else
                    clearAll()
            }
        }
        binaryNumber.doAfterTextChanged {
            if(binaryNumber.isFocused) {
                if (binaryNumber.text.toString().isNotEmpty()) {
                    val binary = it.toString().toLong(2)
                    decimalNumber.setText(binary.toString(10))
                    octalNumber.setText(binary.toString(8))
                    hexNumber.setText(binary.toString(16).toUpperCase())
                } else
                    clearAll()
            }
        }
        octalNumber.doAfterTextChanged {
            if(octalNumber.isFocused){
                if(octalNumber.text.toString().isNotEmpty()){
                    val octal = it.toString().toLong(8)
                    binaryNumber.setText(octal.toString(2))
                    decimalNumber.setText(octal.toString(10))
                    hexNumber.setText(octal.toString(16).toUpperCase())
                }
                else
                    clearAll()
            }
        }
        hexNumber.doAfterTextChanged {
            if (hexNumber.isFocused) {
                if (hexNumber.text.toString().isNotEmpty()) {
                    val hex = it.toString().toLong(16)
                    binaryNumber.setText(hex.toString(2))
                    octalNumber.setText(hex.toString(8))
                    decimalNumber.setText(hex.toString(10))
                } else
                    clearAll()
            }
        }
    }

    private fun initView(){
        decimalNumber = findViewById(R.id.NumberDecimal)
        binaryNumber = findViewById(R.id.NumberBinary)
        octalNumber = findViewById(R.id.NumberOctal)
        hexNumber = findViewById(R.id.NumberHexa)
        buttonClear = findViewById(R.id.clear_btn)
    }
}

