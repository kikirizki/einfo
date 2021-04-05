package ta.andy.einfo;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import androidx.core.app.*;
import com.google.firebase.messaging.*; 



public class FirebaseMessageReceiver 

extends FirebaseMessagingService
{ 
    // Fungsi onMessageReceived() akan diajalankan
    // saat menerima pesan dari FCM
	

    @Override

    public void

    onMessageReceived(RemoteMessage remoteMessage)
	{ 

   

        // Jika notifikasi kosong. 

        if (remoteMessage.getNotification() != null)
		{ 

            // Since the notification is received directly from 

            // FCM, the title and the body can be fetched 

            // directly as below. 

            showNotification( 
                 remoteMessage.getNotification().getTitle(), 
                 remoteMessage.getNotification().getBody()); 

        } 

    } 



    // Method to get the custom Design for the display of 

    // notification. 

    private RemoteViews getCustomDesign(String title, 

                                        String message)
	{ 

        RemoteViews remoteViews = new RemoteViews( 

			getApplicationContext().getPackageName(), 

			R.layout.notification); 

        remoteViews.setTextViewText(R.id.title, title); 

        remoteViews.setTextViewText(R.id.message, message); 

        remoteViews.setImageViewResource(R.id.icon, 

										 R.drawable.abc_ic_star_black_48dp); 

        return remoteViews; 

    } 



    // Fungsi untuk menampilkan notifikasi

    public void showNotification(String title, 

                                 String message)
	{ 

        // Intent untuk berpindah activity

        Intent intent 

			= new Intent(this, LoginActivity.class); 

        // Memasukan ID channel

        String channel_id = "notification_channel"; 

        //  FLAG_ACTIVITY_CLEAR_TOP digunakan

        // untuk menghapus activity teratas pada stack

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 

        // Mengirim intent ke PendingInteratuntuk memulai

       // activity selanjutnya

        PendingIntent pendingIntent 

			= PendingIntent.getActivity( 

			this, 0, intent, 

			PendingIntent.FLAG_ONE_SHOT); 



        //Membuat objek Builder menggunakan NotificationCompat 

        

        NotificationCompat.Builder builder 

			= new NotificationCompat 

			.Builder(getApplicationContext(), 

					 channel_id) 

			.setSmallIcon(R.drawable.tooltip_frame_dark) 

			.setAutoCancel(true) 

			.setVibrate(new long[]{1000, 1000, 1000, 

							1000, 1000}) 

			.setOnlyAlertOnce(true) 

			.setContentIntent(pendingIntent); 



        

        // hanya untuk Android versions 4.1hatau lebih tinggi  

      

        if (Build.VERSION.SDK_INT 

			>= Build.VERSION_CODES.JELLY_BEAN)
		{ 

            builder = builder.setContent( 

				getCustomDesign(title, message)); 

        }

        else
		{ 

            builder = builder.setContentTitle(title) 

				.setContentText(message) 

				.setSmallIcon(R.drawable.notification_bg); 

        } 

        // Membuat NotificationManager 

      
        NotificationManager notificationManager 

			= (NotificationManager) getSystemService( 

			Context.NOTIFICATION_SERVICE); 

        // Cek apakah versi android lebih besar dari Oreo 

        if (Build.VERSION.SDK_INT 

			>= Build.VERSION_CODES.O)
		{ 

            NotificationChannel notificationChannel 

				= new NotificationChannel( 

				channel_id, "web_app", 

				NotificationManager.IMPORTANCE_HIGH); 

            notificationManager.createNotificationChannel( 

				notificationChannel); 

        } 



        notificationManager.notify(0, builder.build()); 

    } 
} 
