package com.example.myapplication.model

data class Student(
    val name: String,
    val id: String,
    var isChecked: Boolean,
    val avatarUrl: String,
    val address: String,
    val phone: String
)