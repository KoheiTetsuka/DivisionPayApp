package com.android.exemple.divisionpayapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // viewの取得
        val mainAddFab = findViewById<View>(R.id.mainAddFab)
        val mainListView = findViewById<ListView>(R.id.mainListView)

        // 1) アダプターにセット
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf()
        )

        mainListView.adapter = adapter
        mainListView.onItemClickListener = ListItemClick()

        // main_add_fabが押されたとき
        mainAddFab.setOnClickListener {
            // 3) EditText
            val mainEditText = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("項目の追加")
                .setMessage("何をする？")
                .setView(mainEditText)
                .setPositiveButton("追加", DialogInterface.OnClickListener { _, _ ->
                    val mainPlan = mainEditText.text.toString()
                    adapter.add(mainPlan)
                })
                .setNegativeButton("キャンセル") { dialog, _ ->
                    // キャンセルボタンを押したときの処理
                    dialog.dismiss()
                }
                .create()
                .show()
        }
    }

    private inner class ListItemClick : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

            val event = parent.getItemAtPosition(position) as String
            val intent = Intent(this@MainActivity, AddMember::class.java)
            intent.putExtra("EVENTMAIN", event)
            startActivity(intent)
        }
    }
}