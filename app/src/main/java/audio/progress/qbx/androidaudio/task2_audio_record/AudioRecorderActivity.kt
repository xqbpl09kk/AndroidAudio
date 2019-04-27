package audio.progress.qbx.androidaudio.task2_audio_record

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import audio.progress.qbx.androidaudio.R
import kotlinx.android.synthetic.main.activity_audio_recoder.*

class AudioRecorderActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_recoder)
        audio_btn.setOnClickListener { audioRecord() }
    }

    private fun audioRecord(){

    }
}