package com.example.myapplication.model

object StudentsModel {
    val students = mutableListOf<Student>()

    init {
        students.add(Student("Ella Gliksberg", "123456789", false, ""))
        students.add(Student("John Doe", "987654321", true, ""))
        students.add(Student("Jane Smith", "111222333", false, ""))
    }
}