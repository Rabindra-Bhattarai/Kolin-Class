package com.example.myapplication

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnerActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{
    lateinit var spinner: Spinner
    lateinit var display: TextView
    lateinit var autoCompleteTextView:AutoCompleteTextView
    lateinit var datePicker: EditText
    val countries= arrayOf("Nepal","USA","Australia", "China", "India","Pakistan")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        spinner=findViewById(R.id.spinner3)
        display=findViewById(R.id.countrySelect)
        autoCompleteTextView=findViewById(R.id.idCity)
        datePicker=findViewById(R.id.editTextDate)

        datePicker.isFocusable=false
        datePicker.isClickable=true



        datePicker.setOnClickListener {
            loadCalendar()
        }

        val adapter =ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_dropdown_item_1line,
            countries
        )

        val cities= arrayOf("Kathmandu", "Lalitpur","Bhaktapur", "Kanchanpur")
        val autoCompleteAdapter=ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            cities
        )

        autoCompleteTextView.setAdapter(autoCompleteAdapter)
        autoCompleteTextView.threshold=1
        spinner.onItemSelectedListener=this

        spinner.adapter=adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cityID)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar() {
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)


        val dialog= DatePickerDialog(
            this@SpinnerActivity,
            DatePickerDialog.OnDateSetListener { d, i, i2, i3 ->
                                        //year //month //day
                  datePicker.setText("$day/${month+1}/$year")
            }, year, month, day
        )
        dialog.show()
    }


    override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {

        display.text=p0?.getItemAtPosition(position).toString()
    }
    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}