//package com.example.myapplication
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.widget.*
//import androidx.appcompat.app.AppCompatActivity
//
//class TaskActivity : AppCompatActivity() {
//
//    private lateinit var nameEditText: EditText
//    private lateinit var emailEditText: EditText
//    private lateinit var passwordEditText: EditText
//    private lateinit var maleRadioButton: RadioButton
//    private lateinit var femaleRadioButton: RadioButton
//    private lateinit var cityAutoComplete: AutoCompleteTextView
//    private lateinit var spinner: Spinner
//    private lateinit var submitButton: Button
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_task)
//
//        // Initialize views
//        nameEditText = findViewById(R.id.editFullName)
//        emailEditText = findViewById(R.id.editAddressEmail)
//        passwordEditText = findViewById(R.id.editUserPassword)
//        maleRadioButton = findViewById(R.id.genderMale)
//        femaleRadioButton = findViewById(R.id.genderFemale)
//        cityAutoComplete = findViewById(R.id.cityAutoCompleteTextView)
//        spinner = findViewById(R.id.editSpin)
//        submitButton = findViewById(R.id.editBtnSubmit)
//
//        // Set up the AutoCompleteTextView
//        val cities = arrayOf("Kathmandu", "Pokhara", "Biratnagar", "Lalitpur")
//        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
//        cityAutoComplete.setAdapter(cityAdapter)
//
//        // Set up the Spinner
//        val countries = arrayOf("Nepal", "India", "USA", "Canada")
//        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
//        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = spinnerAdapter
//
//        // Set up the Submit Button
//        submitButton.setOnClickListener {
//            val name = nameEditText.text.toString()
//            val email = emailEditText.text.toString()
//            val password = passwordEditText.text.toString()
//            val gender = if (maleRadioButton.isChecked) "Male" else "Female"
//            val city = cityAutoComplete.text.toString()
//            val country = spinner.selectedItem.toString()
//
//            // Display the entered information
//            Toast.makeText(
//                this,
//                "Name: $name\nEmail: $email\nPassword: $password\nGender: $gender\nCity: $city\nCountry: $country",
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }
//}
