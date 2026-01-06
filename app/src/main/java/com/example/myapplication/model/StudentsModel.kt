package com.example.myapplication.model

object StudentsModel {
    val students = mutableListOf<Student>()

    init {
        students.add(Student("Ella Gliksberg", "123456789", false, "", "Ramat Gan", "050-1234567"))
        students.add(Student("John Doe", "987654321", true, "", "New York", "052-9876543"))
        students.add(Student("Jane Smith", "111222333", false, "", "London", "054-1112223"))
    }
}