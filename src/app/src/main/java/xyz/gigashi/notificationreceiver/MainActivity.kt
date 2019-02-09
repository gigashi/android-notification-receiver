package xyz.gigashi.notificationreceiver

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		d("MainActivity onCreate")
		setContentView(R.layout.activity_main)

		if (!NotificationManagerCompat.getEnabledListenerPackages(this).contains(packageName)) {
			AlertDialog.Builder(this)
				.setTitle("need permission")
				.setMessage("allow access to notifications")
				.setPositiveButton("ok"){ _, _ ->
					Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS).apply {
						startActivity(this)
					}
				}.show()
		}
	}
}
