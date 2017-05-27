package demo.android.bynnean.com.bynneanandroid_demo.Kotlin.View.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import demo.android.bynnean.com.bynneanandroid_demo.R

/**
 * Comment:
 *
 * Name: RecycleItemHolder
 * Author: Bynnean
 * Email: bin2.he@changhong.com
 * Date: 2017-05-27 09:54
 *
 */
class RecycleItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView: TextView = itemView.findViewById(R.id.text_info) as TextView
}