package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Student

class StudentRecyclerAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {

    var onItemClickListener: ((Int) -> Unit)? = null
    var onCheckboxClickListener: ((Int, Boolean) -> Unit)? = null

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentName: TextView = itemView.findViewById(R.id.tv_student_name)
        val studentId: TextView = itemView.findViewById(R.id.tv_student_id)
        val studentAvatar: ImageView = itemView.findViewById(R.id.iv_student_avatar)
        val studentCheckBox: CheckBox = itemView.findViewById(R.id.cb_student_checked)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = students[position]
        holder.studentName.text = currentStudent.name
        holder.studentId.text = currentStudent.id
        holder.studentCheckBox.isChecked = currentStudent.isChecked

        // Listeners
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(position)
        }

        holder.studentCheckBox.setOnCheckedChangeListener { _, isChecked ->
            onCheckboxClickListener?.invoke(position, isChecked)
        }
    }

    override fun getItemCount() = students.size
}