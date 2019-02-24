package audio.progress.qbx.androidaudio.task2_audio_record

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder

object AudioRecordApp {

    var audioRecorder : AudioRecord ?= null

    fun initAudioRecord(){
        audioRecorder = AudioRecord(
                MediaRecorder.AudioSource.DEFAULT
                        ,44000
                    ,AudioFormat.CHANNEL_IN_MONO
        ,AudioFormat.ENCODING_PCM_16BIT
        , 8 * 1024
        )
    }

    fun startRecord(){
        audioRecorder?.startRecording()
    }
}