package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.StudentRecyclerAdapter
import com.example.myapplication.model.StudentsModel

class StudentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        val studentList: RecyclerView = findViewById(R.id.rv_student_list)
        studentList.layoutManager = LinearLayoutManager(this)

        val adapter = StudentRecyclerAdapter(StudentsModel.students)
        studentList.adapter = adapter

        adapter.onItemClickListener = {
            // TODO: Navigate to student details screen
        }

        adapter.onCheckboxClickListener = { position, isChecked ->
            StudentsModel.students[position].isChecked = isChecked
        }
    }
}