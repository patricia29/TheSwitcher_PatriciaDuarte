package com.example.theswitcher_patriciaduarte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var toolbar: Toolbar
    private lateinit var adapter: DivisionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val divisions = listOf(
            Division("Kitchen", false),
            Division("Living room", false),
            Division("Master bedroom", false),
            Division("Guest's bedroom", false)
        )
        adapter =  DivisionAdapter(divisions) { clickedDivision ->
            openDivisionDetail(clickedDivision)
        }

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun openDivisionDetail(division: Division) {
        val intent = Intent(this, DivisionLightActivity::class.java)
        intent.putExtra(DivisionLightActivity.EXTRA_DIVISION, division)
        intent.putExtra(DivisionLightActivity.EXTRA_DIVISION_NAME, division.name)
        startActivity(intent)
    }
}