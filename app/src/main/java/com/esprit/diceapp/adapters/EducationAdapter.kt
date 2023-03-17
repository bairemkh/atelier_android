package com.esprit.diceapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esprit.diceapp.R
import com.esprit.diceapp.models.Education

class EducationAdapter(val list:List<Education>): RecyclerView.Adapter<EducationAdapter.ViewHolder>() {
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        var image: ImageView = itemView.findViewById(R.id.companyImage)
        var name: TextView = itemView.findViewById(R.id.companyName)
        var address: TextView = itemView.findViewById(R.id.companyAddress)
        var startDay: TextView = itemView.findViewById(R.id.dateJob)
        var leavingDay: TextView = itemView.findViewById(R.id.dateLeavingJob)
        var icon: ImageView =itemView.findViewById(R.id.deleteExpIcon)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EducationAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.experience_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: EducationAdapter.ViewHolder, position: Int) {
        holder.name.text = list[position].schoolName
        holder.address.text=list[position].schoolAddress

    }
}