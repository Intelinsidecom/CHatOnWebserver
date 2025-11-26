package com.sec.chaton.chat.background;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import twitter4j.conf.PropertyConfiguration;

/* loaded from: classes.dex */
public class ChatBackgroundService extends Service {

    /* renamed from: a */
    private HandlerThread f3965a;

    /* renamed from: b */
    private HandlerC0967a f3966b;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f3965a = new HandlerThread("ChatBackgroundService");
        this.f3965a.start();
        this.f3966b = new HandlerC0967a(this.f3965a.getLooper());
        C3250y.m11453c("onCreate", "ChatBackgroundService");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f3966b.m5188a();
        this.f3965a.quit();
        C3250y.m11453c("onDestory", "ChatBackgroundService");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Bundle bundleExtra;
        C3250y.m11453c("onStartCommand : " + String.valueOf(i2), "ChatBackgroundService");
        if (intent != null) {
            if (intent.hasExtra("request")) {
                Bundle bundleExtra2 = intent.getBundleExtra("request");
                if (bundleExtra2 != null) {
                    C0978l c0978l = new C0978l();
                    C3250y.m11453c(Long.toString(bundleExtra2.getLong("request_id", -1L)), "ChatBackgroundService");
                    C3250y.m11453c(Integer.toString(bundleExtra2.getInt("chat_type", -1)), "ChatBackgroundService");
                    C3250y.m11453c(Integer.toString(bundleExtra2.getInt("media_type", -1)), "ChatBackgroundService");
                    C3250y.m11453c(bundleExtra2.getString("content"), "ChatBackgroundService");
                    C3250y.m11453c(bundleExtra2.getString("packageName"), "ChatBackgroundService");
                    C3250y.m11453c(Long.toString(bundleExtra2.getLong("message_id", -1L)), "ChatBackgroundService");
                    C3250y.m11453c(bundleExtra2.getString(PropertyConfiguration.PASSWORD), "ChatBackgroundService");
                    c0978l.m5241c(i2).m5239a(this).m5242d(0).m5223a(bundleExtra2.getString(Config.NOTIFICATION_INTENT_SENDER)).m5221a(bundleExtra2.getLong("request_id", -1L)).m5226b(bundleExtra2.getLong("message_id", -1L)).m5224a(bundleExtra2.getStringArray("receivers")).m5220a(bundleExtra2.getInt("chat_type", -1)).m5225b(bundleExtra2.getInt("media_type", -1)).m5227b(bundleExtra2.getString("content")).m5229c(bundleExtra2.getString("packageName")).m5234h(bundleExtra2.getString(PropertyConfiguration.PASSWORD));
                    C0977k c0977kMo5219a = c0978l.mo5219a();
                    Message messageObtainMessage = this.f3966b.obtainMessage();
                    messageObtainMessage.what = 0;
                    messageObtainMessage.obj = c0977kMo5219a;
                    this.f3966b.sendMessage(messageObtainMessage);
                }
            } else if (intent.hasExtra("request3rdapp") && (bundleExtra = intent.getBundleExtra("request3rdapp")) != null) {
                C0978l c0978l2 = new C0978l();
                C3250y.m11453c(Long.toString(bundleExtra.getLong("request_id", -1L)), "ChatBackgroundService");
                C3250y.m11453c(bundleExtra.getString("inbox_no"), "ChatBackgroundService");
                C3250y.m11453c(Long.toString(bundleExtra.getLong("message_id", -1L)), "ChatBackgroundService");
                C3250y.m11453c(bundleExtra.getString("packageName"), "ChatBackgroundService");
                int i3 = 2;
                if ((!TextUtils.isEmpty(bundleExtra.getString("inbox_no")) ? C1370n.m6144h(CommonApplication.m11493l().getContentResolver(), bundleExtra.getString("inbox_no")) : 0) > 0) {
                    i3 = 1;
                }
                c0978l2.m5241c(i2).m5239a(this).m5242d(i3).m5221a(bundleExtra.getLong("request_id", -1L)).m5235i(bundleExtra.getString("inbox_no")).m5226b(bundleExtra.getLong("message_id", -1L)).m5223a(bundleExtra.getString("sender_id")).m5229c(bundleExtra.getString("packageName")).m5234h(bundleExtra.getString(PropertyConfiguration.PASSWORD));
                C0977k c0977kMo5219a2 = c0978l2.mo5219a();
                Message messageObtainMessage2 = this.f3966b.obtainMessage();
                messageObtainMessage2.what = 0;
                messageObtainMessage2.obj = c0977kMo5219a2;
                this.f3966b.sendMessage(messageObtainMessage2);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
