package br.edu.ifsp.dmo.sorteador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NumberAdapter(context: Context, dataset: ArrayList<Int>):
    ArrayAdapter<Int>(context, R.layout.number_list_item, dataset) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        if(itemView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.number_list_item, null)
        }

        val number: Int? = getItem(position)

        if(itemView != null && number != null){
            itemView.findViewById<TextView>(R.id.label_number).text = "${getPosition(number)+1}º SORTEADO = ${number}"
        }

        return itemView!!
    }


}