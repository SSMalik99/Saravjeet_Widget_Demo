package com.example.saravjeet_widget_demo

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import kotlin.math.log

class DemoWidgetStackService: RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return DemoWidgetStackViewsFactory(applicationContext)
    }
}

class DemoWidgetStackViewsFactory (context: Context):RemoteViewsService.RemoteViewsFactory{
    var numberOfImages = 0
    val myContext = context

    override fun onCreate()  {

    }

    override fun onDataSetChanged() {

    }

    override fun onDestroy() {

    }

    override fun getCount(): Int {
        return numberOfImages
    }

    override fun getViewAt(position: Int): RemoteViews {
        val view = RemoteViews(myContext.packageName, R.layout.stakc_item)
        val imageId = "img_" + (position - 1)
        Log.i("imae id", imageId)
        view.setImageViewResource(R.id.stack_image, myContext.resources.getIdentifier(imageId, "drawable", myContext.packageName))
        return view
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return 1
    }

    override fun hasStableIds(): Boolean {
        return false
    }

}