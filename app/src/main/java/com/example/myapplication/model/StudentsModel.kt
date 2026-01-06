package com.example.myapplication.model

object StudentsModel {
    val students = mutableListOf<Student>()

    init {
        students.add(Student("Ella Gliksberg", "123456789", false, "", "Ramat Hasharon", "050-1234567"))
        students.add(Student("Noa Nufussi", "987654321", true, "", "Raanana", "052-9876543"))
    }
}