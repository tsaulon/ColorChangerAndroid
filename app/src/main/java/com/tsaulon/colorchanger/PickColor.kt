package com.tsaulon.colorchanger

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.view.View
import kotlinx.android.synthetic.main.activity_pick_color.*
import android.widget.SeekBar
import android.widget.TextView

class PickColor : AppCompatActivity() {

    var colorHex: String = "#FFFFFF"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_color)


        seekBarR.max = 255
        seekBarG.max = 255
        seekBarB.max = 255
        seekBarA.max = 10

        seekBarR.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
                colorHex = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}"
                updateBackground()
            }
        })

        seekBarG.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
                colorHex = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}"
                updateBackground()
            }
        })

        seekBarB.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
                colorHex = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}"
                updateBackground()
            }
        })

        seekBarA.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
                colorHex = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}"
                updateBackground()
            }
        })

        textColor.setOnClickListener{
            textColor.text = colorHex;
        }
    }

    fun updateBackground() = viewBackground.setBackgroundColor(Color.parseColor(colorHex.padStart(6, '0')))
}

//  TODO: Get app to stop crashing when updating background color on seekbar value changes
//  TODO: Polish and remove redundant code