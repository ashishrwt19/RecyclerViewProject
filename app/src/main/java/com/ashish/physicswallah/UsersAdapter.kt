package com.ashish.physicswallah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UsersAdapter(private val data: List<UserObject>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_recyclerview, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(usersObject: UserObject) {
            val name: TextView = view.findViewById(R.id.name)
            val subject: TextView = view.findViewById(R.id.subject)
            val qualifications: TextView = view.findViewById(R.id.qualifications)
            val profileImage: ImageView = view.findViewById(R.id.profileImage)

            name.text = usersObject.name
            subject.text = ""
            for (i in usersObject.subjects.indices) {
                subject.text = subject.text.toString().plus(usersObject.subjects[i]).plus(" ")
            }
            subject.text = subject.text.toString().plus("•")

            qualifications.text = ""
            for (i in usersObject.qualification.indices) {
                qualifications.text =
                    qualifications.text.toString().plus(usersObject.qualification[i]).plus(" ")
            }
            Glide.with(view.context).load(usersObject.profileImage).centerInside().into(profileImage)
        }
    }


}

