package com.example.theswitcher_patriciaduarte

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.appcompat.widget.Toolbar

class DivisionLightActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DIVISION = "extra_division"
        const val EXTRA_DIVISION_NAME = "extra_division_name"
    }

    private lateinit var division: Division
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.division_light)

        setToolbar()

        val divisionName = findViewById<TextView>(R.id.light_text)
        val lightImage = findViewById<ImageView>(R.id.light_image)
        val yourLightIs = findViewById<TextView>(R.id.light_division_text)

        division = intent.getSerializableExtra(EXTRA_DIVISION) as? Division ?: return

        val divisionClickedName = intent.getStringExtra(EXTRA_DIVISION_NAME)
        val firstMessage = "$divisionClickedName"
        yourLightIs.text = "Your $firstMessage light is"

        val lightStatus = if (division.isLightOn) "ON" else "OFF"
        val message = "$lightStatus"
        divisionName.text = message

        lightImage.setImageResource(
            if (division.isLightOn) R.drawable.light_on else R.drawable.light_off
        )

        val switchLayout = LayoutInflater.from(this).inflate(R.layout.item_division, null)
        val lightSwitch = switchLayout.findViewById<SwitchCompat>(R.id.light_switch)

        lightSwitch.isChecked = division.isLightOn
        lightSwitch.setOnCheckedChangeListener { _, isChecked ->
            division.isLightOn = isChecked
            lightImage.setImageResource(
                if (isChecked) R.drawable.light_on else R.drawable.light_off
            )
        }
    }

    private fun setToolbar(){
        toolbar = findViewById(R.id.toolbar_division)
        val frameLayout = findViewById<FrameLayout>(R.id.fl_back_image)
        frameLayout.visibility = View.VISIBLE
    }
}