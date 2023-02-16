package com.example.bookofrecipes;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class MyTimer extends CountDownTimer {

    private TextView timerView;
    private Button start;
    private static final int NOTIFY_ID = 100;
    private Handler handler;
    private NotificationManager notificationManager;
    private final String CHANEL = "main";
    private Context context;
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public MyTimer(long millisInFuture, long countDownInterval, Context context, TextView v, Button b) {
        super(millisInFuture, countDownInterval);
        timerView=v;
        start = b;

        this.context = context;

        handler = new Handler();
        notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(CHANEL, "Main chanel", NotificationManager.IMPORTANCE_DEFAULT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onTick(long millisUntilFinished) {
        int sec = (int) Math. ceil(millisUntilFinished/1000);
        int min = (int) Math.floor(sec/60);
        sec -= min * 60;
        timerView.setText(String.format("%02d:%02d", min,sec));
    }

    @Override
    public void onFinish() {

        timerView.setText("00:00");
        timerView.setTextColor(Color.parseColor("#873939"));
        start.setText("Готово!");


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent notificationIntent = new Intent(context, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANEL)
                        .setSmallIcon(R.drawable.timer)
                        .setContentTitle("Время вышло")
                        .setChannelId(CHANEL)
                        .setContentText("Пора переходить к следующему шагу")
                        .setContentIntent(contentIntent)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

                Notification notification = builder.build();
                notification.defaults = Notification.DEFAULT_ALL;

                notificationManager.notify(NOTIFY_ID, builder.build());
            }
        }, 1000);


    }
}
