package com.laine.mauro.datepickertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.datepicker.MaterialDatePicker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        }
    }

    companion object {
        val TAG = "DatePicker_Activity"
    }
}
