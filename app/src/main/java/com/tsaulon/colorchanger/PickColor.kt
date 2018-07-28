package com.tsaulon.colorchanger

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pick_color.*
import android.widget.SeekBar

//  TODO: Change seekbar colors on progress changes

class PickColor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_color)

        seekBarR.max = 255
        seekBarG.max = 255
        seekBarB.max = 255
        seekBarA.max = 10

        updateText()
        updateBackground()
        updateAccents()

        seekBarR.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateText()
                updateBackground()
                updateAccents()
            }
        })

        seekBarG.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateText()
                updateBackground()
                updateAccents()
            }
        })

        seekBarB.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateText()
                updateBackground()
                updateAccents()
            }
        })

        seekBarA.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateText()
                updateBackground()
                updateAccents()
            }
        })
    }

    fun updateBackground() = viewBackground.setBackgroundColor(Color.rgb(seekBarR.progress, seekBarG.progress, seekBarB.progress))
    fun updateAccents(){
        textRGB.setTextColor(Color.rgb(255 - seekBarR.progress, 255 - seekBarG.progress, 255 - seekBarA.progress))
        textHex.setTextColor(Color.rgb(255 - seekBarR.progress, 255 - seekBarG.progress, 255 - seekBarA.progress))
    }
    fun updateText(){
        textRGB.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
        textHex.text = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}".padEnd(7, '0').toUpperCase()
    }

}