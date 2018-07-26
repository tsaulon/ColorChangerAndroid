package com.tsaulon.colorchanger

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        viewBackground.setBackgroundColor(Color.parseColor("#FFFFFF"))

        seekBarR.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
            }
        })

        seekBarG.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
            }
        })

        seekBarB.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
            }
        })

        seekBarA.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textColor.text = "rgba(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress}, ${seekBarA.progress})"
            }
        })
    }
}
