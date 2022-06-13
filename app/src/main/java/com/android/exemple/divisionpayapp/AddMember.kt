package com.android.exemple.divisionpayapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class AddMember : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_member)

        val event = intent.getStringExtra("EVENTMAIN")

        val textView = findViewById<TextView>(R.id.addMemberSum)
        textView.text = event

        val memberAddListView = findViewById<ListView>(R.id.memberAddListView)
        val memberAddFab = findViewById<View>(R.id.memberAddFab)

        // 1) アダプターにセット
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf()
        )

        memberAddListView.adapter = adapter
        memberAddListView.onItemClickListener = ListItemClick()

        // main_add_fabが押されたとき
        memberAddFab.setOnClickListener {
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

            val member = parent.getItemAtPosition(position) as String
            val intent = Intent(this@AddMember, ShoppingDetails::class.java)
            intent.putExtra("MEMBER", member)
            startActivity(intent)
        }
    }
}