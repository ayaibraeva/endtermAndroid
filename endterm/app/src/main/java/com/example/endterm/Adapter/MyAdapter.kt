package com.example.endterm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.endterm.MainActivity
import com.example.endterm.MainActivity.Companion.instance
import com.example.endterm.R

class MyAdapter(val context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_fragment, parent, false)
        instance = this
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return MainActivity.posts.size
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val post = MainActivity.posts[position]
        holder.titleText.text = post.title


        holder.itemView.setOnClickListener {
            val bundle = bundleOf("postId" to post.id, "userId" to post.userId)
            it.findNavController().navigate(R.id.action_firstFragment_to_postDetailFragment, bundle)
        }

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.titleTextView)

    }


    companion object {
        lateinit var instance: MyAdapter
    }
}