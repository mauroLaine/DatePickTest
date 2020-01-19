package com.laine.mauro.datepickertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_date.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val builder = MaterialDatePicker.Builder.datePicker()
        val picker = builder.build()
        picker.show(supportFragmentManager, picker.toString())

        picker.addOnCancelListener {
            Log.d(TAG, "Dialog was cancelled")
        }
        picker.addOnNegativeButtonClickListener {
            Log.d(TAG, "Dialog Negative Button was clicked")
        }
        picker.addOnPositiveButtonClickListener {
            Log.d(TAG, "Date String = ${picker.headerText}:: Date epoch value = ${it}")
            showValue(picker.headerText)
        }
    }

    private fun showValue(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
    }

    companion object {
        val TAG = "DatePicker_Activity"
    }
}
