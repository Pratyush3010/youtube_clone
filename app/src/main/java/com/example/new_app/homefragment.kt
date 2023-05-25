package com.example.new_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "https://internship-service.onrender.com/"

class homefragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adepterVideos:Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_homefragment, container, false)
        recyclerView = view.findViewById(R.id.home_RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ServiceApi::class.java)


        val retrofitData = retrofitBuilder.getposts()
        retrofitData.enqueue(object : Callback<modal?> {


            override fun onResponse(call: Call<modal?>, response: Response<modal?>) {
                val data = response.body()?.data?.posts
                if (data != null) {
                    adepterVideos = Adapter(data)
                }
                recyclerView.adapter = adepterVideos
                adepterVideos.OnItemClick = {
                    Intent(requireContext(),videoplayer::class.java).apply {

                        if(it.submission.mediaUrl.contains(".mp4")){

                            putExtra("videoUrl",it.submission.mediaUrl)
                            startActivity(this)
                        }else{
                            //putExtra("videoUrl",it.content)
                            Toast.makeText(view.context, "It is not a Video", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            }

            override fun onFailure(call: Call<modal?>, t: Throwable) {
                Log.d("Main Activity", "onFailure: " + t.message)
            }
        })

        return view

    }

    private fun getData() {

    }
}