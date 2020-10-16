package com.example.widgetweather

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {
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


    internal fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
//        val widgetText = NewAppWidgetConfigureActivity

//    val jsonObj = JSONObject()
//    val main = jsonObj.getJSONObject("main")
//    val sys = jsonObj.getJSONObject("sys")
//    val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
//
//    val weatherDescription = weather.getString("description")
//
//    val temp = main.getString("temp") + "°C"
//    val tempMin = "Min Temp: " + main.getString("temp_min") + "°C"
//    val tempMax = "Max Temp: " + main.getString("temp_max") + "°C"
//    val address = jsonObj.getString("name") + ", " + sys.getString("country")
//
//    val updatedAt: Long = jsonObj.getLong("dt")
//    val updatedAtText =
//        "Updated at: " + SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
//            Date(updatedAt * 1000)
//        )

        // Construct the RemoteViews object
        val views = RemoteViews(context.packageName, R.layout.new_app_widget)
    views.setTextViewText(R.id.status_widget, MainActivity.weatherTask)
    views.setTextViewText(R.id.temp_widget, MainActivity.temp)
    views.setTextViewText(R.id.temp_max_widget, tempMax)
    views.setTextViewText(R.id.temp_min_widget, tempMin)
    views.setTextViewText(R.id.address_widget, address)
    views.setTextViewText(R.id.updated_at_widget, updatedAtText)
//        views.setTextViewText(R.id.status_widget, widgetText)
//    views.setTextViewText(R.id.temp_widget, temp)
//    views.setTextViewText(R.id.temp_max_widget, tempMax)
//    views.setTextViewText(R.id.temp_min_widget, tempMin)
//    views.setTextViewText(R.id.address_widget, address)
//    views.setTextViewText(R.id.updated_at_widget, updatedAtText)

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}
