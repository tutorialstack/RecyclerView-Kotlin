package `in`.tutorialstack.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import java.util.*

class ItemAdapter(val context: Context, val models: ArrayList<DataModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recyclerview, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        holder.bindItems(context, models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(context: Context, model: DataModel) {
            val txtTitle = itemView.findViewById<TextView>(R.id.txt_title) as TextView
            val txtDate = itemView.findViewById<TextView>(R.id.txt_date) as TextView

            txtTitle.text = model.title
            txtDate.text = model.date

            txtTitle.setOnClickListener {
                Toast.makeText(context,"clicked on "+txtTitle.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}