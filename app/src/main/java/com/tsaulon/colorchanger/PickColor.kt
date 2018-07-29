package com.tsaulon.colorchanger

import android.app.Activity
import android.graphics.Color
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_pick_color.*
import android.widget.SeekBar

//  TODO: Introduce touch gestures

class PickColor : Activity() {  //  Change AppCompatActivity() to Activity to remove default activity header.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_color)

        var seekBarsVisible = true
        init()  //  Initialize seekbar ranges and UI

        seekBarR.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateUI()
            }
        })

        seekBarG.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateUI()
            }
        })

        seekBarB.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateUI()
            }
        })

        viewBackground.setOnClickListener{

            seekBarsVisible = !seekBarsVisible

            if(seekBarsVisible){
                val fadeIn = AnimationUtils.loadAnimation(this, R.anim.abc_fade_in)
                seekBarR.startAnimation(fadeIn)
                Handler().postDelayed({seekBarR.visibility = View.VISIBLE}, 50)
                seekBarG.startAnimation(fadeIn)
                Handler().postDelayed({seekBarG.visibility = View.VISIBLE}, 50)
                seekBarB.startAnimation(fadeIn)
                Handler().postDelayed({seekBarB.visibility = View.VISIBLE}, 50)
            } else{
                val fadeOut = AnimationUtils.loadAnimation(this, R.anim.abc_fade_out)
                seekBarR.startAnimation(fadeOut)
                Handler().postDelayed({seekBarR.visibility = View.INVISIBLE}, 50)
                seekBarG.startAnimation(fadeOut)
                Handler().postDelayed({seekBarG.visibility = View.INVISIBLE}, 50)
                seekBarB.startAnimation(fadeOut)
                Handler().postDelayed({seekBarB.visibility = View.INVISIBLE}, 50)
            }
        }
    }

    //  initialize UI
    fun init(){
        seekBarR.max = 255
        seekBarG.max = 255
        seekBarB.max = 255
        updateUI()
    }

    fun updateUI(){
        updateBackgrounds()
        updateAccents()
        updateText()
    }

    fun updateBackgrounds() {
        viewBackground.setBackgroundColor(Color.rgb(seekBarR.progress, seekBarG.progress, seekBarB.progress))
        seekBarR.setBackgroundColor(Color.argb(80, 0, 0, 0))
        seekBarG.setBackgroundColor(Color.argb(80, 0 , 0, 0))
        seekBarB.setBackgroundColor(Color.argb(80, 0, 0, 0))
    }

    fun updateAccents(){
        textRGB.setTextColor(Color.rgb(255 - seekBarR.progress, 255 - seekBarG.progress, 255 - seekBarB.progress))
        textHex.setTextColor(Color.rgb(255 - seekBarR.progress, 255 - seekBarG.progress, 255 - seekBarB.progress))
    }

    fun updateText(){
        textRGB.text = "rgb(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress})"
        textHex.text = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}".padEnd(7, '0').toUpperCase()
    }

}