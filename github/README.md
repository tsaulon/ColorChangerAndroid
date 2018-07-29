COLOR CHANGER
=============

This is a small-scale android application that uses seekbar progression values to change the background color and text color of the application. Interacting with the seekbars also retrieve the hexadecimal and rgb values of the background color. Additionally, the text colors are inversed to create readability for the user.

Demo
====

![Color Changer Demo](colorchanger.gif)

Technology & Frameworks
=======================
* Kotlin
* Android Studio

Code Sample
===========

```
package com.tsaulon.colorchanger

import android.app.Activity
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_pick_color.*
import android.widget.SeekBar

//  TODO: Introduce OOP design

class PickColor : Activity() {  //  Change AppCompatActivity() to Activity to remove default activity header.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_color)

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
    }

    //  initialize UI
    fun init(){
        seekBarR.max = 255
        seekBarG.max = 255
        seekBarB.max = 255
        updateUI()
    }

    fun updateUI(){
        updateBackground()
        updateAccents()
        updateText()
    }

    fun updateBackground() {
        viewBackground.setBackgroundColor(Color.rgb(seekBarR.progress, seekBarG.progress, seekBarB.progress))
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
```