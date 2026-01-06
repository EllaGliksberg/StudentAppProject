package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.StudentsModel

class StudentDetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STUDENT_POSITION = "student_position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val position = intent.getIntExtra(EXTRA_STUDENT_POSITION, -1)

        if (position != -1) {
            val student = StudentsModel.students[position]

            val nameTextView: TextView = findViewById(R.id.tv_details_name)
            val idTextView: TextView = findViewById(R.id.tv_details_id)
            val phoneTextView: TextView = findViewById(R.id.tv_details_phone)
            val addressTextView: TextView = findViewById(R.id.tv_details_address)
            val checkedCheckBox: CheckBox = findViewById(R.id.cb_details_checked)
            val editButton: Button = findViewById(R.id.btn_details_edit)

            nameTextView.text = student.name
            idTextView.text = student.id
            phoneTextView.text = student.phone
            addressTextView.text = student.address
            checkedCheckBox.isChecked = student.isChecked

            editButton.setOnClickListener {
                // TODO: Navigate to edit student screen
            }
        }
    }
}