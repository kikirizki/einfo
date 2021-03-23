package ta.andy.einfo;

import android.app.*;
import android.os.*;
import android.support.v4.app.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		// https://developer.android.com/training/notify-user/build-notification
		// constructor requires that you provide a channel ID. This is required for compatibility with Android 8.0 (API level 26) and higher, but is ignored by older versions.
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this )
			.setSmallIcon(R.drawable.ic_launcher)
			.setContentTitle("Title ")
			.setCategory(NotificationCompat.CATEGORY_SOCIAL)
			.setContentText("Konten Informasi")
			.setPriority(NotificationCompat.PRIORITY_HIGH);
			
		NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
		notificationManager.notify(1234, builder.build());
    }
}
