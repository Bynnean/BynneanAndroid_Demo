package demo.android.bynnean.com.bynneanandroid_demo.Kotlin.View

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.view.View
import android.widget.RelativeLayout
import java.util.jar.Attributes

/**
 * Comment:
 *
 * Name: KotlinScrollViewBehaivor
 * Author: Bynnean
 * Email: bin2.he@changhong.com
 * Date: 2017-05-27 10:37
 *
 */
class KotlinScrollViewBehaivor(context: Context , attributes: Attributes) : CoordinatorLayout.Behavior<RelativeLayout>() {

    override fun onLayoutChild(parent: CoordinatorLayout?, child: RelativeLayout?, layoutDirection: Int): Boolean {
        return super.onLayoutChild(parent, child, layoutDirection)
    }


    override fun layoutDependsOn(parent: CoordinatorLayout?, child: RelativeLayout?, dependency: View?): Boolean {
        return super.layoutDependsOn(parent, child, dependency)
    }
}