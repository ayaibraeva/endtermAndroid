package com.example.endterm.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.endterm.MainActivity
import com.example.endterm.Model.Post
import com.example.endterm.R
import kotlinx.android.synthetic.main.post_detail_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostDetailFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.post_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postId = arguments?.getInt("postId")!!




        MainActivity.apiService.getPostById(postId).enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.e("Response: ", response.body()!!.toString())

                val list = response.body()!!
                post_detail_title.text = list.title
                bodyTextView.text = list.body


            }
        })

    }
}