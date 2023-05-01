package com.example.list_prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var name: EditText
    lateinit var btn: Button

var mydata : MutableList<String> = mutableListOf("Motabbir Hossain Sourov", " Mahfuz Sarkar", "Rubaiya Saimin", "Rubayet Khusbu", "Sayed Sahba",
    " Snehasish Bandhiya", "Mamun Hossen")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.list1)
        name=findViewById(R.id.user_input1)
        btn=findViewById(R.id.add_name)

        val myAdapter =ArrayAdapter(this,android.R.layout.simple_list_item_1,mydata)
        listView.adapter=myAdapter
        listView.setOnItemClickListener { adapterView, view, position, l ->
            mydata.removeAt(position)
            myAdapter.notifyDataSetChanged()

        }
        btn.setOnClickListener{
            var name1= name.text.toString()
            mydata.add(0,name1)
            myAdapter.notifyDataSetChanged()
            name.text.clear()
                }
    }
}