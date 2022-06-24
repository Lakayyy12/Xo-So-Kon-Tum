package com.application.vietlotterysix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Details>

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var briefNews: Array<String>

    private var btnA : Button? = null

    private var jian1 : Button? = null
    private var jian2 : Button? = null
    private var jian3 : Button? = null
    private var jian4 : Button? = null

    private var exit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnA = findViewById(R.id.btnA)
        btnA?.setOnClickListener{
            val intent = Intent(this, AboutPage::class.java)
            startActivity(intent)
        }
        imageId = arrayOf(R.drawable.logo1, R.drawable.logo1, R.drawable.logo1, R.drawable.logo1, R.drawable.logo1)
        heading = arrayOf(getString(R.string.mt1),
            getString(R.string.mt2),
            getString(R.string.mt3),
            getString(R.string.mt4),
            getString(R.string.mt5)

        )
        briefNews = arrayOf(
            getString(R.string.mt11),
            getString(R.string.mt22),
            getString(R.string.mt33),
            getString(R.string.mt44),
            getString(R.string.mt55)
        )
        newRecyclerView = findViewById(R.id.recyclerItems)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Details>()
        getUserdata()

        jian1 = findViewById(R.id.jian1)
        jian2 = findViewById(R.id.jian2)
        jian3 = findViewById(R.id.jian3)
        jian4 = findViewById(R.id.jian4)

        jian1?.setOnClickListener {
            Navigator.showContent(this, getString(R.string.g1))
        }
        jian2?.setOnClickListener {
            Navigator.showContent(this, getString(R.string.g2))
        }
        jian3?.setOnClickListener {
            Navigator.showContent(this, getString(R.string.g3))
        }
        jian4?.setOnClickListener {
            Navigator.showContent(this, getString(R.string.g4))
        }
    }
    private fun getUserdata() {
        for (i in imageId.indices) {
            val news = Details(imageId[i], heading[i], briefNews[i])
            newArrayList.add(news)
        }
        val adapter = MyAdapter2(newArrayList)
        newRecyclerView.adapter = adapter
    }

    override fun onBackPressed() {
       if (exit == 0){
           exit = 1
           Toast.makeText(this, "BẤM ĐÔI ĐỂ Thoát", Toast.LENGTH_SHORT).show()
       }else{
       super.finishAffinity()}
    }
}