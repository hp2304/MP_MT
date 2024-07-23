package com.example.alarmintent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.ActivityNotFoundException
import android.content.Intent
import android.provider.AlarmClock
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.midtermq3.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createAlarm("This is an alarm, wake up !!", 0, 1)


        val textMessage : String = "Hello World"
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textMessage)
            type = "text/plain"
        }

        try {
            startActivity(sendIntent)
        } catch (e: ActivityNotFoundException) {
            println("Can't handle this intent")
        }

        val mapIntent: Intent = Uri.parse(
            "geo:0,0?q=319+Arthur+Lane,+Kitchener,+Ontario"
        ).let { location ->
        // Or map point based on latitude/longitude
        // val location: Uri = Uri.parse("geo:37.422219,-122.08364?z=14") // z param is zoom level
            Intent(Intent.ACTION_VIEW, location)
        }
        startActivity(mapIntent);

    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            ContextCompat.startActivity(intent)
        }
    }
}
