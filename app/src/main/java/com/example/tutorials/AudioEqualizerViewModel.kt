package com.example.tutorials

import android.media.audiofx.Equalizer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

val FLAT = arrayListOf(0.0, 0.0, 0.0, 0.0, 0.0)
const val PRESENT_CUSTOM = 0
const val PRESENT_FLAT = 1

class AudioEqualizerViewModel : ViewModel() {
    val audioEffects = MutableStateFlow<AudioEffects?>(null)
    private var equalizer: Equalizer? = null
    private var audioSessionId = 0


    init {
        if (audioEffects.value == null) {
            audioEffects.tryEmit(AudioEffects(PRESENT_FLAT, FLAT))
        }

    }

    fun onStart(sessionId: Int) {
        audioSessionId = sessionId
        equalizer = Equalizer(Int.MAX_VALUE, audioSessionId)
        audioEffects.value?.gainValue?.forEachIndexed { index, value ->
            val bandLevel = (value * 1000).toInt().toShort()
            equalizer?.setBandLevel(index.toShort(), bandLevel)

        }
    }

    fun onBandLevelChanged(changeBand: Int, newGainValue: Int){
        equalizer?.setBandLevel(changeBand.toShort(), newGainValue.toShort())
        val list = ArrayList(audioEffects.value!!.gainValue)
        list[changeBand] = (newGainValue.toDouble() / 1000)
        audioEffects.tryEmit(
            AudioEffects(
                PRESENT_CUSTOM,
                list
            )
        )
    }
}