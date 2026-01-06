package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Student
import com.example.myapplication.model.StudentsModel

class EditStudentActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STUDENT_POSITION = "student_position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val position = intent.getIntExtra(EXTRA_STUDENT_POSITION, -1)

        if (position == -1) {
            finish()
            return
        }

        val student = StudentsModel.students[position]

        val nameEditText: EditText = findViewById(R.id.et_edit_student_name)
        val idEditText: EditText = findViewById(R.id.et_edit_student_id)
        val addressEditText: EditText = findViewById(R.id.et_edit_student_address)
        val phoneEditText: EditText = findViewById(R.id.et_edit_student_phone)
        val checkedCheckBox: CheckBox = findViewById(R.id.cb_edit_student_checked)
        val cancelButton: Button = findViewById(R.id.btn_edit_student_cancel)
        val saveButton: Button = findViewById(R.id.btn_edit_student_save)
        val deleteButton: Button = findViewById(R.id.btn_edit_student_delete)

        nameEditText.setText(student.name)
        idEditText.setText(student.id)
        addressEditText.setText(student.address)
        phoneEditText.setText(student.phone)
        checkedCheckBox.isChecked = student.isChecked

        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        saveButton.setOnClickListener {
            val newName = nameEditText.text.toString()
            val newId = idEditText.text.toString()
            val newAddress = addressEditText.text.toString()
            val newPhone = phoneEditText.text.toString()
            val newIsChecked = checkedCheckBox.isChecked

            val updatedStudent = Student(newName, newId, newIsChecked, student.avatarUrl, newAddress, newPhone)
            StudentsModel.students[position] = updatedStudent

            setResult(Activity.RESULT_OK)
            finish()
        }

        deleteButton.setOnClickListener {
            StudentsModel.students.removeAt(position)
            val resultIntent = Intent()
            resultIntent.putExtra("deleted", true)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}