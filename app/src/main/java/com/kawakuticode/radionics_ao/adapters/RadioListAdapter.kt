package com.kawakuticode.radionics_ao.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kawakuticode.radionics_ao.R
import com.kawakuticode.radionics_ao.models.Radio_Station
import kotlinx.android.synthetic.main.radiocardview.view.*


class RadioListAdapter(
    private val context: Context,
    private val list_radio: List<Radio_Station>,
    private val itemListener: OnRadioSelected

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
        holder.bind(radio_item, itemListener)
        /*try {
            if (position % 2 == 0) {
                holder.itemView.setBackgroundResource(R.drawable.gradient_one)

            } else {
                holder.itemView.setBackgroundResource(R.drawable.gradient_two)
            }
        } catch (f: Resources.NotFoundException) {
            Log.d("error ", f.toString())

        } finally {



            /*val imageView: ImageView = holder.itemView.r_logocard
       val img_url: String = radio_item.logo_url
       Picasso.get().load(img_url).fit().centerCrop().into(imageView)*/
        }
*/

    }


    inner class RadioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(radio_station: Radio_Station, clickListener: OnRadioSelected) {
            itemView.setOnClickListener {
                itemListener.onRadioSelected(radio_station)
            }
        }

    }

    interface OnRadioSelected {
        fun onRadioSelected(radio_station: Radio_Station)
    }


}
