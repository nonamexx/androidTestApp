package com.example.kotlinapp

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.kotlinapp.databinding.LayoutNotificationContentBinding

/**
 * Created by Pear on 4/2/2019.
 */
class RecyclerNotificationAdapter(private val onClickNotificationListener: OnClickNotificationListener): RecyclerView.Adapter<RecyclerNotificationAdapter.ViewHolder>() {
    private val contentText = arrayOf("Notification 1",
        "Notification 2", "Notification 3", "Notification 4",
        "Notification 5", "Notification 6", "Notification 7",
        "Notification 8", "Notification 9", "Notification 10",
        "Notification 11", "Notification 12", "Notification 13",
        "Notification 14", "Notification 15", "Notification 16",
        "Notification 17", "Notification 18", "Notification 19",
        "Notification 20", "Notification 21", "Notification 22")

    private val notificationImage = intArrayOf(R.drawable.img_notification,
        R.drawable.img_notification, R.drawable.img_notification, R.drawable.img_notification,
        R.drawable.img_notification, R.drawable.img_notification, R.drawable.img_notification,
        R.drawable.img_notification, R.drawable.img_notification, R.drawable.img_notification,
        R.drawable.img_notification, R.drawable.img_notification, R.drawable.img_notification,
        R.drawable.img_notification, R.drawable.img_notification, R.drawable.img_notification,
        R.drawable.img_notification, R.drawable.img_notification, R.drawable.img_notification,
        R.drawable.img_notification, R.drawable.img_notification, R.drawable.img_notification)

    private var lastPosition = -1

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return ViewHolder(DataBindingUtil.inflate(inflater, R.layout.layout_notification_content, p0, false))
    }

    override fun getItemCount(): Int {
        return contentText.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.apply {
            setNotificationImage(notificationImage[p1])
            setContent(contentText[p1])
            setOnClick(onClickNotificationListener, p1)
        }
        val animator = AnimationUtils.loadAnimation(p0.itemView.context,
            if (p1 > lastPosition){
                R.anim.animation_buttom_to_top
            } else {
                R.anim.animation_up_to_buttom
            })
        p0.itemView.startAnimation(animator)
        lastPosition = p1
    }

    inner class ViewHolder(private val binding: LayoutNotificationContentBinding): RecyclerView.ViewHolder(binding.root){
        fun setNotificationImage(image: Int){
            binding.imageNotification.setImageResource(image)
        }
        fun setContent(text: String){
            binding.textNotification.text = text
        }
        fun setOnClick(listener: OnClickNotificationListener, position: Int){
            binding.backgroundNotification.setOnClickListener {
                listener.onClickNotification(position)
            }
        }
    }

    interface OnClickNotificationListener {
        fun onClickNotification(position: Int)
    }
}