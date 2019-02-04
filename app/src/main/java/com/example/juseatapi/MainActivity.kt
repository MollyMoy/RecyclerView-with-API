package com.example.juseatapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val movieAdapter = MovieAdapter()
        my_recycler_view.adapter = movieAdapter
        my_recycler_view.layoutManager = LinearLayoutManager(this)



        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()



        val MovieApi = retrofit.create(MovieApi::class.java)

        MovieApi.getMovies()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    movieAdapter.setMovies(it.results)
                },
                        {
                            Toast.makeText(applicationContext, it.message, Toast.LENGTH_LONG).show()
                        })
    }

}
