package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.recyclerviewtest.adapter.diff.MyDiffAdapter
import com.example.recyclerviewtest.adapter.list.MyListAdapter
import com.example.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val TAG = "MainActivity"
    }

    private val vBinding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    private val diffAdapter = MyDiffAdapter()
    private val listAdapter = MyListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vBinding.root)

        vBinding.btnAdd.setOnClickListener{ _ ->
            val newList = mutableListOf<String>()
            MyDataSet.list.forEach{newList.add(it)}
            newList.add((++MyDataSet.cnt).toString())

            listAdapter.submitList(newList)
            diffAdapter.updateList(newList)
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.container_frame_1, RVFragment(diffAdapter))
            .add(R.id.container_frame_2, RVFragment(listAdapter))
            .commit()
    }
}