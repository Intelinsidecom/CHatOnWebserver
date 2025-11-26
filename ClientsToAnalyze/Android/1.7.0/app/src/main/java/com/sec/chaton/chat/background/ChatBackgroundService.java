package com.sec.chaton.chat.background;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ChatBackgroundService extends Service {

    /* renamed from: a */
    private HandlerThread f1913a;

    /* renamed from: b */
    private HandlerC0554a f1914b;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f1913a = new HandlerThread("ChatBackgroundService");
        this.f1913a.start();
        this.f1914b = new HandlerC0554a(this.f1913a.getLooper());
        Log.i("ChatBackgroundService", "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f1914b.m2730a();
        this.f1913a.quit();
        Log.i("ChatBackgroundService", "onDestory");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Bundle bundleExtra;
        Log.i("ChatBackgroundService", "onStartCommand");
        if (intent != null && (bundleExtra = intent.getBundleExtra("request")) != null) {
            C0556c c0556c = new C0556c();
            Log.i("ChatBackgroundService", Long.toString(bundleExtra.getLong("request_id", -1L)));
            Log.i("ChatBackgroundService", Integer.toString(bundleExtra.getInt("chat_type", -1)));
            Log.i("ChatBackgroundService", Integer.toString(bundleExtra.getInt("media_type", -1)));
            Log.i("ChatBackgroundService", bundleExtra.getString("content"));
            Log.i("ChatBackgroundService", bundleExtra.getString("packageName"));
            Log.i("ChatBackgroundService", Long.toString(bundleExtra.getLong("message_id", -1L)));
            c0556c.m2733a(bundleExtra.getString(Config.NOTIFICATION_INTENT_SENDER)).m2732a(bundleExtra.getLong("request_id", -1L)).m2737b(bundleExtra.getLong("message_id", -1L)).m2734a(bundleExtra.getStringArray("receivers")).m2731a(bundleExtra.getInt("chat_type", -1)).m2736b(bundleExtra.getInt("media_type", -1)).m2738b(bundleExtra.getString("content")).m2740c(bundleExtra.getString("packageName"));
            C0558e c0558eM2735a = c0556c.m2735a();
            Message messageObtainMessage = this.f1914b.obtainMessage();
            messageObtainMessage.what = 0;
            messageObtainMessage.obj = c0558eM2735a;
            this.f1914b.sendMessage(messageObtainMessage);
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
