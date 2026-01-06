package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Student
import com.example.myapplication.model.StudentsModel

class StudentDetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STUDENT_POSITION = "student_position"
    }

    private var studentPosition: Int = -1

    private val editStudentLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            // If a student was deleted, finish this activity
            if (it.data?.getBooleanExtra("deleted", false) == true) {
                finish()
            } else {
                // Otherwise, just refresh the details
                recreate()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentPosition = intent.getIntExtra(EXTRA_STUDENT_POSITION, -1)

        if (studentPosition != -1) {
            displayStudentDetails()

            val editButton: Button = findViewById(R.id.btn_details_edit)
            editButton.setOnClickListener {
                val intent = Intent(this, EditStudentActivity::class.java)
                intent.putExtra(EditStudentActivity.EXTRA_STUDENT_POSITION, studentPosition)
                editStudentLauncher.launch(intent)
            }
        }
    }

    private fun displayStudentDetails() {
        val student = StudentsModel.students[studentPosition]

        val nameTextView: TextView = findViewById(R.id.tv_details_name)
        val idTextView: TextView = findViewById(R.id.tv_details_id)
        val phoneTextView: TextView = findViewById(R.id.tv_details_phone)
        val addressTextView: TextView = findViewById(R.id.tv_details_address)
        val checkedCheckBox: CheckBox = findViewById(R.id.cb_details_checked)

        nameTextView.text = student.name
        idTextView.text = student.id
        phoneTextView.text = student.phone
        addressTextView.text = student.address
        checkedCheckBox.isChecked = student.isChecked
    }
}