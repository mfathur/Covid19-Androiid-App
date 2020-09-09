package com.mfathurz.wartacovid19.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mfathurz.wartacovid19.R
import com.mfathurz.wartacovid19.models.ProvinceData
import com.mfathurz.wartacovid19.utils.Utils
import kotlinx.android.synthetic.main.item_rv_spread_detail.view.*

class ProvinceListAdapter :ListAdapter<ProvinceData, ProvinceListAdapter.ProvinceViewHolder>(ProvinceCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_spread_detail,parent,false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) =holder.bind(getItem(position))

    inner class ProvinceViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        fun bind(provinceData : ProvinceData){
            with(view){
                txt_item_area.text=provinceData.province
                num_item_positive.text=Utils.numberConverter(provinceData.positiveCase)
                num_item_recovered.text=Utils.numberConverter(provinceData.curedCase)
                num_item_death.text=Utils.numberConverter(provinceData.deathCase)
            }
        }
    }
}

private class ProvinceCallBack:DiffUtil.ItemCallback<ProvinceData>(){
    override fun areItemsTheSame(oldItem: ProvinceData, newItem: ProvinceData): Boolean {
        return oldItem.province==newItem.province
    }

    override fun areContentsTheSame(oldItem: ProvinceData, newItem: ProvinceData): Boolean {
        return oldItem==newItem
    }

}