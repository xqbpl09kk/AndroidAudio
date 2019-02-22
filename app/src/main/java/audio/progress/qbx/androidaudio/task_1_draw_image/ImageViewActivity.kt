package audio.progress.qbx.androidaudio.task_1_draw_image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Surface
import android.view.SurfaceHolder
import android.view.View
import audio.progress.qbx.androidaudio.R
import kotlinx.android.synthetic.main.activity_image_view.*

/**
 * 文 件 名: ImageViewActivity
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/22 15:15
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        displayByImageView()
        displaySurfaceView()
    }


    private fun displayByImageView() {
        image_view.setImageResource(R.drawable.demo_image)
    }

    private fun displaySurfaceView() {
        val holder = surface_view.holder
        holder.addCallback(object : SurfaceHolder.Callback {
            var thread: Thread? = null
            override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

            }

            override fun surfaceDestroyed(holder: SurfaceHolder?) {
                thread?.join()
                thread = null
            }

            override fun surfaceCreated(holder: SurfaceHolder?) {
                thread = Thread(Runnable {
                    val canvas = holder?.lockCanvas()
                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.demo_image)
//                        val layoutParams = surface_view.layoutParams
//                        layoutParams.height = bitmap.height
//                        layoutParams.width = bitmap.width
//                        surface_view.layoutParams = layoutParams
                    canvas?.drawBitmap(bitmap, 0f, 0f, null)
                    holder?.unlockCanvasAndPost(canvas)
                })
                thread?.start()
            }

        })


    }



}