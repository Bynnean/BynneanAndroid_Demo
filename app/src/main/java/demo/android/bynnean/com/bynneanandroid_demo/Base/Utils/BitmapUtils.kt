package demo.android.bynnean.com.bynneanandroid_demo.Base.Utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import net.qiujuer.genius.blur.StackBlur

/**
 * Comment:  图片处理类
 *
 * Name: BitmapUtils
 * Author: Bynnean
 * Email: bin2.he@changhong.com
 * Date: 2017-05-26 17:42
 *
 */
class BitmapUtils {

    companion object Factory{
        fun  convertDrawable2Bitmap(drawable: Drawable?): Bitmap {
            var bitmapDrawable : BitmapDrawable = drawable as BitmapDrawable
            return bitmapDrawable.bitmap
        }

        fun compressBitmaps(resBitmap: Bitmap): Bitmap{
            var desBitmap :Bitmap
            var  matrix:Matrix = Matrix()
            matrix.postScale(1.0f/8,1.0f/8);
            desBitmap = Bitmap.createBitmap(resBitmap , 0 ,0 ,resBitmap.width,resBitmap.height,matrix,true)
            desBitmap = StackBlur.blurNatively(desBitmap,4,false)
            return  desBitmap
        }
    }
}