package audio.progress.qbx.androidaudio

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import audio.progress.qbx.androidaudio.task2_audio_record.AudioRecoderActivity
import audio.progress.qbx.androidaudio.task_1_draw_image.ImageViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        recycler_view.adapter = MAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View
                                        , parent: RecyclerView, state: RecyclerView.State) {
                outRect.bottom = 2
            }
        })
    }


    class MAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        private val titles =
                arrayOf("多种显示图片"
                ,"AudioRecord 和 AudioTrack API PCM数据的采集和播放"
                ,"SurfaceView、TextureView来预览Camera数据"
                ,"MediaExtractor和MediaMuxer API,解析和封装mp4"
                ,"OpenGL 绘制一个三角形"
                ,"OpenGL 显示一张图片"
                ,"MediaCodec API,音频AAC硬编、硬解"
                ,"MediaCodec API,视频H.264的硬编、硬解"
                ,"串联整个音视频录制流程,输出MP4"
                ,"串联整个音视频播放流程,解析MP4"
                ,"OpenGL 高级特性"
                ,"图形图像架构，使用GLSurfaceview绘制Camera"
                ,"深入研究音视频相关的网络协议"
                ,"深入学习一些音视频领域的开源项目"
                ,"ffmpeg库移植到Android平台"
                ,"x264库移植到Android平台"
                ,"librtmp 库移植到 Android 平台"
                ,"短视频 APP")
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            return object : RecyclerView.ViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.list_item_main , p0 , false)) {
                init { itemView.setOnClickListener { navigateByIndex(adapterPosition) } }
            }
        }

        override fun getItemCount(): Int {
            return titles.size
        }

        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
            (p0.itemView as TextView).text = titles[p1]
        }

        private fun navigateByIndex(index : Int ){
            when(index){
                0 -> {
                    context.startActivity(Intent(context , ImageViewActivity::class.java))
                }
                1 -> {
                    context.startActivity(Intent(context , AudioRecoderActivity::class.java))
                }
            }
        }

    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
