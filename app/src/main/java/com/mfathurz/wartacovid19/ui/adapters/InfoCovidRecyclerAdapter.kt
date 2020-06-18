package com.mfathurz.wartacovid19.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.models.InfoCovidModel
import kotlinx.android.synthetic.main.item_rv_about_covid.view.*

class SymptomRecyclerAdapter(private val symptom : ArrayList<InfoCovidModel>) : RecyclerView.Adapter<SymptomRecyclerAdapter.SymptomViewHolder>(){

    inner class SymptomViewHolder(val view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomViewHolder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.item_rv_about_covid,parent,false)
        return SymptomViewHolder(view)
    }

    override fun getItemCount(): Int =symptom.size

    override fun onBindViewHolder(holder: SymptomViewHolder, position: Int) {
        holder.view.txt_item_title_covid.text=symptom[position].title
        holder.view.img_item_info_covid.load(symptom[position].image)
    }

}