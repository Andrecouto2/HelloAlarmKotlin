package br.com.andrecouto.kotlin.helloalarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class AlarmReceiver : BroadcastReceiver() {

    companion object {
        // Constantes
        val TAG = "kotlinandrecouto"
        val ACTION = "br.com.andrecouto.kotlin.helloalarm.LEMBREME_DE_BATERPONTO"
    }

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Você precisa bater o ponto: " + Date())

        val notifIntent = Intent(context, MainActivity::class.java)

        NotificationUtil.create(context, 1, notifIntent,
                "Ãtenção",
                "Hora de bater o ponto.")
    }
}