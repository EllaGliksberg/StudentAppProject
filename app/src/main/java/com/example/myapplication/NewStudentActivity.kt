package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Student
import com.example.myapplication.model.StudentsModel

class NewStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val nameEditText: EditText = findViewById(R.id.et_new_student_name)
        val idEditText: EditText = findViewById(R.id.et_new_student_id)
        val checkedCheckBox: CheckBox = findViewById(R.id.cb_new_student_checked)
        val cancelButton: Button = findViewById(R.id.btn_new_student_cancel)
        val saveButton: Button = findViewById(R.id.btn_new_student_save)

        cancelButton.setOnClickListener {
            finish()
        }

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()
            val isChecked = checkedCheckBox.isChecked

            val newStudent = Student(name, id, isChecked, "")
            StudentsModel.students.add(newStudent)

            finish()
        }
    }
}