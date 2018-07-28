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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_color)

        seekBarR.max = 255
        seekBarG.max = 255
        seekBarB.max = 255
        seekBarA.max = 10

        viewBackground.setBackgroundColor(Color.parseColor(textColor.text.toString()))


        seekBarR.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                //textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
                textColor.text = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}".padEnd(7, '0')
                updateBackground(textColor.text.toString())
            }
        })

        seekBarG.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                //textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
                textColor.text = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}".padEnd(7, '0')
                updateBackground(textColor.text.toString())
            }
        })

        seekBarB.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                //textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
                textColor.text = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}".padEnd(7, '0')
                updateBackground(textColor.text.toString())
            }
        })

        seekBarA.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                //textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
                textColor.text = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}".padEnd(7, '0')
                updateBackground(textColor.text.toString())
            }
        })
    }

    fun updateBackground(hex: String) = viewBackground.setBackgroundColor(Color.parseColor(hex))
}

//  TODO: Fix color transitions for more readability.
//  TODO: Polish and remove redundant code