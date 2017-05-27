package demo.android.bynnean.com.bynneanandroid_demo.Kotlin

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import demo.android.bynnean.com.bynneanandroid_demo.Base.UI.BaseActivity
import demo.android.bynnean.com.bynneanandroid_demo.Base.Utils.BitmapUtils
import demo.android.bynnean.com.bynneanandroid_demo.Kotlin.View.Adapter.KotlinRecycelAdapter
import demo.android.bynnean.com.bynneanandroid_demo.R

class KotlinHomeActivity : BaseActivity() {

    lateinit var backgroundImage :ImageView
    lateinit var videoImageView : ImageView
    lateinit var playIconImageView : ImageView
    lateinit var recycleView  : RecyclerView

    fun getIconUrl(): String? {
        return "http://i.gtimg.cn/qqlive/img/jpgcache/files/qqvideo/y/yl6lapwmmx5ivew_x.jpg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_home)
        initView()
    }

    fun initView() {
        recycleView = findViewById(R.id.recycelview_layout) as RecyclerView
        backgroundImage = findViewById(R.id.appbar_backview) as ImageView
        videoImageView  = findViewById(R.id.resource_imageview) as ImageView
        loadImageViewer()
        initRecycleViewer()
    }

    fun loadImageViewer(): Unit {
        // Glide.with(this).load(getIconUrl()).into(backgroundImage)
        Glide.with(this).load(getIconUrl()).into(videoImageView)
        Glide.with(this).load(getIconUrl()).into(object : SimpleTarget<Drawable>(Target.SIZE_ORIGINAL,Target.SIZE_ORIGINAL) {
            /**
             * The method that will be called when the resource load has finished.

             * @param resource the loaded resource.
             */
            override fun onResourceReady(resource: Drawable?, transition: Transition<in Drawable>?) {
               //  resource.get
               var bitmap : Bitmap =  BitmapUtils.convertDrawable2Bitmap(resource)
               var desBitmap : Bitmap = BitmapUtils.compressBitmaps(bitmap)
               loadBackGroundViewFromThreads(desBitmap)
            }

        })
    }

    fun initRecycleViewer(): Unit {
        var manger: LinearLayoutManager = LinearLayoutManager(this)
        manger.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = manger
        recycleView.adapter = KotlinRecycelAdapter(this)
    }

    fun loadBackGroundViewFromThreads(bitmap: Bitmap): Unit {
        this.runOnUiThread(object : Runnable {
            /**
             * When an object implementing interface `Runnable` is used
             * to create a thread, starting the thread causes the object's
             * `run` method to be called in that separately executing
             * thread.
             *
             *
             * The general contract of the method `run` is that it may
             * take any action whatsoever.

             * @see java.lang.Thread.run
             */
            override fun run() {
                // 变量在多线程中使用 为何未报错？？
                backgroundImage.setImageBitmap(bitmap)
            }

        })
    }
}

