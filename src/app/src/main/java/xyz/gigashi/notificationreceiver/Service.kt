package xyz.gigashi.notificationreceiver

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class Service : NotificationListenerService() {
	override fun onCreate() {
		super.onCreate()
		d("Service onCreate")
	}

	override fun onNotificationPosted(notification: StatusBarNotification?) {
		super.onNotificationPosted(notification)

		notification?.also {
			d("----------")
			d("postTime: "     + it.postTime)
			d("id: "           + it.id)
			d("packageName: "  + it.packageName)
			d("tag: "          + it.tag)
			d("user: "         + it.user)
			d("notification: " + it.notification)

			it.notification.extras?.also {
				d("title: " + it.getString("android.title", ""))
				d("text: " + it.getString("android.text", ""))
			}
		}
	}
}