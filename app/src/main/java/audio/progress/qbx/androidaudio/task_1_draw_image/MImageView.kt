package audio.progress.qbx.androidaudio.task_1_draw_image

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import audio.progress.qbx.androidaudio.R

/**
 * 文 件 名: MImageView
 * 创 建 人: XiaQiBo
 * 创建日期: 2019/2/22 16:57
 * 邮   箱: bob.xia@xiangwushuo.com
 * 修改备注：
 */
class MImageView : View {
    constructor(context: Context) : super(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int)
            : super(context, attributeSet, defStyleAttr) {
        init()
    }

    private fun init() {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val bitmap = BitmapFactory.decodeResource(context.resources , R.drawable.demo_image)
        canvas?.drawBitmap(bitmap , 0f , 0f , null )
    }


}