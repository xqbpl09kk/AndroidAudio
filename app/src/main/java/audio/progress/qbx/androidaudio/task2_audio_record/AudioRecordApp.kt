package audio.progress.qbx.androidaudio.task2_audio_record

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder

object AudioRecordApp {

    var audioRecorder: AudioRecord? = null

    fun initAudioRecord() {
        val bufferSizeBytes = AudioRecord.getMinBufferSize(44100
                , AudioFormat.CHANNEL_IN_MONO
                , AudioFormat.ENCODING_PCM_16BIT)
        audioRecorder = AudioRecord(
                MediaRecorder.AudioSource.DEFAULT
                , 44000
                , AudioFormat.CHANNEL_IN_MONO
                , AudioFormat.ENCODING_PCM_16BIT
                , bufferSizeBytes
        )
    }

    fun startRecord() {
        audioRecorder
    }
}