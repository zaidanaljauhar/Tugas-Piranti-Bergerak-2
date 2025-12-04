
package com.example.androidcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val vm: ItemViewModel by viewModels { ItemVMFactory(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.inputName)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val list = findViewById<ListView>(R.id.listView)

        val adapter = ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1)
        list.adapter = adapter

        vm.items.observe(this) {
            adapter.clear()
            adapter.addAll(it)
        }

        btnAdd.setOnClickListener {
            val text = input.text.toString()
            if (text.isNotEmpty()) vm.add(text)
            input.text.clear()
        }

        list.setOnItemClickListener { _, _, pos, _ ->
            val item = adapter.getItem(pos)
            if (item != null) vm.delete(item)
        }
    }
}
