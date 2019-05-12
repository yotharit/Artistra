package com.yotharit.artistra.ui.main.feed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.sackcentury.shinebuttonlib.ShineButton
import com.yotharit.artistra.R
import com.yotharit.artistra.ui.main.search.model.EventModel
import java.text.SimpleDateFormat

class FeedAdapter(var reference: ArrayList<EventModel>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        var ref = reference.get(position)
//        val date = SimpleDateFormat("dd-MM-yyyy").parse(ref.time)
//        val format = SimpleDateFormat().format("DD MMM YYYY")
//        val useDate = format.format(date).toString().toUpperCase()
        holder.tvTitle.text = ref.eventName
        holder.tvDescription.text = ref.description
//        holder.tvEventDate.text = useDate
        holder.tvPlace.text = ref.venueName
        holder.like.OnButtonClickListener(View.OnClickListener {
            val mRootRef = FirebaseDatabase.getInstance().reference
            val mUsersRef = mRootRef.child("user")
            val mChildRef = mUsersRef.child(FirebaseAuth.getInstance().currentUser!!.uid)
            val mLoveRef = mChildRef.child("Love")
            if (holder.like.isChecked) mLoveRef.child(ref.id).setValue(true)
            else mLoveRef.child(ref.id).setValue(false)
        })
    }


    override fun getItemCount(): Int {
        return reference.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feed_list_layout, parent, false)
        return FeedViewHolder(itemView)
    }

    inner class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvEventDate: TextView
        var tvTitle: TextView
        var tvPlace: TextView
        var like: ShineButton
        var tvDescription : TextView
        init {
            tvEventDate = view.findViewById(R.id.tvEventDate)
            tvTitle = view.findViewById(R.id.tvTitle)
            tvPlace = view.findViewById(R.id.tvPlace)
            like = view.findViewById(R.id.like)
            tvDescription = view.findViewById(R.id.tvDescription)
        }

    }


}