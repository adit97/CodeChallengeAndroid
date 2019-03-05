package com.google.codechallengeandroid.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.codechallengeandroid.R
import com.google.codechallengeandroid.model.AndroidModel
import kotlinx.android.synthetic.main.item_android.view.*

class AndroidAdapter(private val androidList: List<AndroidModel>,
                     private val onClick: (androidModel: AndroidModel) -> Unit

) : RecyclerView.Adapter<AndroidAdapter.MyHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): AndroidAdapter.MyHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view: View = layoutInflater.inflate(R.layout.item_android, viewGroup, false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int = androidList.size

    override fun onBindViewHolder(myHolder: AndroidAdapter.MyHolder, position: Int) {
        val androidModel: AndroidModel = androidList[position]

        myHolder.bind(androidModel)
        myHolder.itemView.run {
            setOnClickListener {
                onClick(androidModel)
            }
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(androidModel: AndroidModel) = itemView.run {
            itemView.tvAndroidName.text = androidModel.androidName
            itemView.tvAndroidVersion.text = androidModel.androidVersion
            itemView.tvApiLevel.text = androidModel.androidApiLevel
        }
    }
}