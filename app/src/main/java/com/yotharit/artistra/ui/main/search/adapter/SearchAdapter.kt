package com.yotharit.artistra.ui.main.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ramotion.foldingcell.FoldingCell
import com.yotharit.artistra.R
import com.yotharit.artistra.ui.main.search.model.EventModel
import java.text.SimpleDateFormat
import java.util.*


class SearchAdapter(var reference: ArrayList<EventModel>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        var ref = reference.get(position)
        val date = SimpleDateFormat("dd-MM-yyyy").parse(ref.time)
        holder.foldingCell.setOnClickListener {
            (it as FoldingCell).toggle(false)
        }
        holder.tvVenue.text = ref.venueName
        holder.tvEventName.text = ref.eventName
        holder.tvPlace.text = ref.cityName + "," + ref.countryName
        var calendar = Calendar.getInstance()
        calendar.time = date
        val simpleDateFormat = SimpleDateFormat("MMM")
        holder.tvShortMonth.text = simpleDateFormat.format(date).toString().toUpperCase()
        holder.tvShortDate.text = calendar.get(Calendar.DATE).toString()
        holder.tvDescription.text = ref.description
        holder.tvEventNameFull.text = ref.eventName
        holder.tvPlaceAndCountry.text = ref.cityName + "," + ref.countryName

    }

    override fun getItemCount(): Int {
        return reference.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.foldable_view, parent, false)
        return SearchViewHolder(itemView)
    }

    inner class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var foldingCell = view.findViewById<FoldingCell>(R.id.folding_cell)
        var tvShortMonth = view.findViewById<TextView>(R.id.tvShortMonth)
        var tvShortDate = view.findViewById<TextView>(R.id.tvShortDate)
        var tvPlace = view.findViewById<TextView>(R.id.tvPlace)
        var tvEventName = view.findViewById<TextView>(R.id.tvEventName)
        var tvVenue = view.findViewById<TextView>(R.id.tvVenue)
        var tvEventNameFull = view.findViewById<TextView>(R.id.tvEventNameFull)
        var tvPlaceAndCountry = view.findViewById<TextView>(R.id.tvPlaceAndCountry)
        var tvDescription = view.findViewById<TextView>(R.id.tvDescription)
    }


}