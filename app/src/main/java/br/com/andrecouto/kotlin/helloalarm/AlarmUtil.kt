package br.com.andrecouto.kotlin.helloalarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log

object AlarmUtil {
    private val TAG = AlarmUtil.toString();

    // Agenda o alarme
    fun schedule(context: Context, intent: Intent, triggerAtMillis: Long) {
        val p = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarme = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarme.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, p)
        Log.d(TAG, "Alarme agendado com sucesso.")
    }

    // Agenda o alarme com repetição
    fun scheduleRepeat(context: Context, intent: Intent, triggerAtMillis: Long, intervalMillis: Long) {
        val p = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarme = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarme.setInexactRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, intervalMillis, p)
        Log.d(TAG, "Alarme agendado com sucesso com repetição")
    }

    // Cancela o alarme
    fun cancel(context: Context, intent: Intent) {
        val alarme = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val p = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        alarme.cancel(p)
        Log.d(TAG, "Alarme cancelado com sucesso.")
    }
}