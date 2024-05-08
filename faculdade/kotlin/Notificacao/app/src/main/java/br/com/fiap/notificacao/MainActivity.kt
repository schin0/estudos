package br.com.fiap.notificacao

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val CHANNEL_ID = "Notificacao"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        criarCanalNotificacao()
    }

    fun criarCanalNotificacao() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.chanel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel)
        }
    }

    fun gerarNotificacao(view: View) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val p = PendingIntent.getActivity(
            this,
            0,
            Intent(
                this,
                TelaRespostaActivity::class.java
            ),
            PendingIntent.FLAG_IMMUTABLE
        )

        var mensagens = arrayOf(
            "Reunião com o grupo",
            "Trabalho",
            "Academia"
        )

        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
        builder.setContentTitle(mensagens[(Math.random() * mensagens.size).toInt()])
        builder.setSmallIcon(R.drawable.ponteiro)
        builder.setLargeIcon(Biblioteca.decoder())
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setContentIntent(p)

        val style = NotificationCompat.InboxStyle()

        val lugares = arrayOf(
            arrayOf("Smartfit", "Maxi Shopping"),
            arrayOf("FIAP", "Av. Paulista"),
            arrayOf("Call", "Discord")
        )

        var random = (Math.random() * lugares.size).toInt()
        var lugar = lugares[random]

        for (detalhe in lugar) {
            style.addLine(detalhe)
        }

        builder.setStyle(style)

        val notificacao = builder.build()
        notificacao.flags = Notification.FLAG_AUTO_CANCEL

        notificationManager.notify(R.drawable.ic_launcher_background, notificacao)

        // Emitir um som:
        try {
            val som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val toque = RingtoneManager.getRingtone(this, som)

            toque.play();
        } catch (e: Exception) {
            Log.e("Erro", e.message.toString())
        }

    }
}