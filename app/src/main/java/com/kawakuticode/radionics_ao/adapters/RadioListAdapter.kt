package com.kawakuticode.radionics_ao.adapters

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kawakuticode.radionics_ao.R
import com.kawakuticode.radionics_ao.models.Radio_Station
import kotlinx.android.synthetic.main.radiocardview.view.*


class RadioListAdapter(
    private val context: Context,
    private val list_radio: List<Radio_Station>,
    val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RadioListAdapter.RadioViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.radiocardview, parent, false)
        return RadioViewHolder(itemView)
    }

    override fun getItemCount(): Int = list_radio.size


    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        val radio_item: Radio_Station = list_radio[position]
        holder.itemView.name_radio_card.text = radio_item.name
        /*val imageView:ImageView = holder.itemView.r_logocard
        val img_url: String = radio_item.logo_url
        Picasso.get().load(img_url).fit().centerCrop().into(imageView) */
        try {
            if (position % 2 == 0) {
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorPrimaryDark
                    )
                )
            } else {
                holder.itemView.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorPrimary
                    )
                )
            }
        } catch (f: Resources.NotFoundException) {
            Log.d("error ", f.toString())

        } finally {
            holder.bind(radio_item, itemClickListener)
        }


    }


    inner class RadioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(radio_station: Radio_Station, clickListener: OnItemClickListener) {
            itemView.setOnClickListener {
                clickListener.onItemClicked(radio_station)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClicked(radio_station: Radio_Station)


    }
}