package com.tsaulon.colorchanger

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_pick_color.*
import android.widget.SeekBar
import android.widget.Toast

class PickColor : Activity() {  //  Change AppCompatActivity() to Activity to remove default activity header.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_color)

        var seekBarsVisible = true

        init()  //  Initialize seekbar ranges and UI
        //  Update UI based on changes to seekBarR
        seekBarR.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateUI()
            }
        })

        //  Update UI based on changes to seekBarR
        seekBarG.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateUI()
            }
        })

        //  Update UI based on changes to seekBarR
        seekBarB.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                updateUI()
            }
        })

        //  Rotate seekbar visibility
        viewBackground.setOnClickListener{

            seekBarsVisible = !seekBarsVisible  //  rotate visibility flag

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

        //  Copy codes to clipboard
        var clipboard: ClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        var clip: ClipData

        textRGB.setOnClickListener {
            clip = ClipData.newPlainText("text", textRGB.text)
            clipboard.primaryClip = clip

            Toast.makeText(applicationContext, "RGB copied", Toast.LENGTH_SHORT).show()
        }

        textHex.setOnClickListener{
            clip = ClipData.newPlainText("text", textHex.text)
            clipboard.primaryClip = clip

            Toast.makeText(applicationContext, "Hex copied", Toast.LENGTH_SHORT).show()
        }

    }

    //  initialize UI
    private fun init(){
        seekBarR.max = 255
        seekBarG.max = 255
        seekBarB.max = 255
        seekBarR.progress = 255
        seekBarG.progress = 255
        seekBarB.progress = 255
        updateUI()
    }

    private fun updateUI(){
        updateBackgroundColor()
        updateText()
    }

    private fun updateBackgroundColor() {
        viewBackground.setBackgroundColor(Color.rgb(seekBarR.progress, seekBarG.progress, seekBarB.progress))
        seekBarR.setBackgroundColor(Color.argb(80, 0, 0, 0))
        seekBarG.setBackgroundColor(Color.argb(80, 0 , 0, 0))
        seekBarB.setBackgroundColor(Color.argb(80, 0, 0, 0))
    }

    private fun updateText(){
        textRGB.text = "rgb(${seekBarR.progress}, ${seekBarG.progress}, ${seekBarB.progress})"
        textHex.text = "#${Integer.toHexString(seekBarR.progress)}${Integer.toHexString(seekBarG.progress)}${Integer.toHexString(seekBarB.progress)}".padEnd(7, '0').toUpperCase()
        textRGB.setTextColor(Color.rgb(255 - seekBarR.progress, 255 - seekBarG.progress, 255 - seekBarB.progress))
        textHex.setTextColor(Color.rgb(255 - seekBarR.progress, 255 - seekBarG.progress, 255 - seekBarB.progress))
    }
}