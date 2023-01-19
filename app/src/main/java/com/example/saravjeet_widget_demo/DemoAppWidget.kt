package com.example.saravjeet_widget_demo

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.saravjeet_widget_demo.DemoWidgetStackService

/**
 * Implementation of App Widget functionality.
 */
class DemoAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
//    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.demo_app_widget)
//    views.setTextViewText(R.id.appwidget_text, widgetText)


//    val myIntent = Intent(context, DemoWidgetStackService().javaClass)
//    views.setRemoteAdapter(R.id.widgetStack, myIntent)
    val intent = Intent(context, DemoWidgetStackService().javaClass)
    views.setRemoteAdapter(R.id.widgetStack, intent)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}