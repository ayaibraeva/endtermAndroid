package com.example.endterm.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.endterm.Adapter.MyAdapter
import com.example.endterm.MainActivity
import com.example.endterm.Model.Post
import com.example.endterm.R
import kotlinx.android.synthetic.main.list_item_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewPost.adapter =
            MyAdapter(view.context)
        recyclerViewPost.layoutManager = LinearLayoutManager(view.context)
        MainActivity.apiService.getPosts().enqueue(object : Callback<MutableList<Post>> {
            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
            override fun onResponse(call: Call<MutableList<Post>>, response: Response<MutableList<Post>>) {
                Log.e("Response: ", response.body()!!.size.toString())
                MainActivity.posts = response.body()!!
                (recyclerViewPost.adapter as MyAdapter).notifyDataSetChanged()
            }
        })
    }
}