package com.yotharit.artistra.ui.main.feed.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.sackcentury.shinebuttonlib.ShineButton
import com.yotharit.artistra.R
import com.yotharit.artistra.ui.main.search.model.EventModel
import com.yotharit.artistra.ui.popout.PopActivity
import java.text.SimpleDateFormat
import java.util.*

class FeedAdapter(var reference: ArrayList<EventModel>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    var imageString: Array<String> = arrayOf(
        "http://wallpaperswide.com/download/girl_playing_acoustic_guitar_close_up-wallpaper-220x176.jpg",
        "http://wallpaperswide.com/download/concert_crowd-wallpaper-220x176.jpg",
        "http://wallpaperswide.com/download/ape_not_mice_in_concert-wallpaper-220x176.jpg",
        "http://wallpaperswide.com/download/giovanca-wallpaper-220x176.jpg",
        "http://wallpaperswide.com/download/elvis_presley_in_concert-wallpaper-220x176.jpg",
        "http://wallpaperswide.com/download/concert_image-wallpaper-220x176.jpg",
        "https://1843784937.rsc.cdn77.org/wp-content/uploads/2016/01/Indie88-Concerts-Header-1190.jpg",
        "https://ichef.bbci.co.uk/images/ic/640x360/p06dz8l4.jpg",
        "https://cdn.images.express.co.uk/img/dynamic/35/590x/Kiss-London-O2-Arena-concert-review-813848.jpg",
        "https://d25tv1xepz39hi.cloudfront.net/2016-11-08/files/live-concert-photography_1430.jpg",
        "https://static1.squarespace.com/static/5aaeba3212b13f16ff5803c5/5aaebcdb562fa7d5c71de5b0/5bc96a2815fcc0508acf4a92/1539926587614/ParisVisone_MG_0224+copy.jpg",
        "http://www.thaiticketmajor.com/variety/img_news/title/original1/2288/8288/title_ttmnews_8288-20180123154414.jpg",
        "https://i.ytimg.com/vi/mgxojGXDXn8/maxresdefault.jpg",
        "https://www.do-concert.com/images/ready-template/crop-1550073612703.jpg",
        "http://media.altpress.com/uploads/2018/07/EDM_deadmau5.jpg",
        "https://www.youredm.com/wp-content/uploads/2014/07/wallpaper16-759x500.jpg"
    )


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        var ref = reference.get(position)
//        val date = SimpleDateFormat("dd-MM-yyyy").parse(ref.time)
//        val format = SimpleDateFormat().format("DD MMM YYYY")
//        val useDate = format.format(date).toString().toUpperCase()
        holder.tvTitle.text = ref.eventName
        holder.tvDescription.text = ref.description
        if (ref.description == null) {
            holder.tvDescription.text = "NO DESCRIPTION"
        }
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
        val date = SimpleDateFormat("dd-MM-yyyy").parse(ref.time)

        var calendar = Calendar.getInstance()
        calendar.time = date
        val simpleDateFormat = SimpleDateFormat("MMM")

        val rnds = (0..imageString.size-1).random()
        Glide.with(holder.itemView).load(imageString.get(rnds)).into(holder.imageView)

        holder.imageView.setOnClickListener({
            val intent = Intent(holder.itemView.context, PopActivity::class.java)
            intent.putExtra("title", ref.eventName)
            intent.putExtra("shortDate", calendar.get(Calendar.DATE).toString())
            intent.putExtra("shortMonth", simpleDateFormat.format(date).toString().toUpperCase())
            intent.putExtra("place", ref.countryName)
            intent.putExtra("venue", ref.venueName)
            if (ref.description != null) {
                intent.putExtra("description", ref.description)
            } else {
                intent.putExtra("description", "NO DESCRIPTION!")

            }
            intent.putExtra("imageUrl", imageString.get(rnds))

            holder.itemView.context.startActivity(intent)
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
        var tvDescription: TextView
        var imageView: ImageView

        init {
            imageView = view.findViewById(R.id.imageView)
            tvEventDate = view.findViewById(R.id.tvEventDate)
            tvTitle = view.findViewById(R.id.tvTitle)
            tvPlace = view.findViewById(R.id.tvPlace)
            like = view.findViewById(R.id.like)
            tvDescription = view.findViewById(R.id.tvDescription)
        }

    }


}