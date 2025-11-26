package com.sec.chaton.chat.background;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ChatBackgroundService extends Service {

    /* renamed from: a */
    private HandlerThread f6018a;

    /* renamed from: b */
    private HandlerC1582a f6019b;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f6018a = new HandlerThread("ChatBackgroundService");
        this.f6018a.start();
        this.f6019b = new HandlerC1582a(this.f6018a.getLooper());
        C4904y.m18641c("onCreate", "ChatBackgroundService");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f6019b.m8439a();
        this.f6018a.quit();
        C4904y.m18641c("onDestory", "ChatBackgroundService");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Bundle bundleExtra;
        int i3;
        C4904y.m18641c("onStartCommand : " + String.valueOf(i2), "ChatBackgroundService");
        if (intent != null) {
            if (intent.hasExtra("request")) {
                Bundle bundleExtra2 = intent.getBundleExtra("request");
                if (bundleExtra2 != null) {
                    C1593l c1593l = new C1593l();
                    C4904y.m18641c(Long.toString(bundleExtra2.getLong("request_id", -1L)), "ChatBackgroundService");
                    C4904y.m18641c(Integer.toString(bundleExtra2.getInt("chat_type", -1)), "ChatBackgroundService");
                    C4904y.m18641c(Integer.toString(bundleExtra2.getInt("media_type", -1)), "ChatBackgroundService");
                    C4904y.m18641c(bundleExtra2.getString("content"), "ChatBackgroundService");
                    C4904y.m18641c(bundleExtra2.getString("packageName"), "ChatBackgroundService");
                    C4904y.m18641c(Long.toString(bundleExtra2.getLong("message_id", -1L)), "ChatBackgroundService");
                    C4904y.m18641c(bundleExtra2.getString("password"), "ChatBackgroundService");
                    c1593l.m8494d(i2).m8492a(this).m8495e(0).m8475a(bundleExtra2.getString(Config.NOTIFICATION_INTENT_SENDER)).m8473a(bundleExtra2.getLong("request_id", -1L)).m8478b(bundleExtra2.getLong("message_id", -1L)).m8476a(bundleExtra2.getStringArray("receivers")).m8477b(bundleExtra2.getInt("chat_type", -1)).m8480c(bundleExtra2.getInt("media_type", -1)).m8479b(bundleExtra2.getString("content")).m8482c(bundleExtra2.getString("packageName")).m8487h(bundleExtra2.getString("password"));
                    C1592k c1592kMo8471a = c1593l.mo8471a();
                    Message messageObtainMessage = this.f6019b.obtainMessage();
                    messageObtainMessage.what = 0;
                    messageObtainMessage.obj = c1592kMo8471a;
                    this.f6019b.sendMessage(messageObtainMessage);
                }
            } else if (intent.hasExtra("request3rdapp") && (bundleExtra = intent.getBundleExtra("request3rdapp")) != null) {
                int i4 = bundleExtra.containsKey("message_category") ? bundleExtra.getInt("message_category") : 0;
                C1593l c1593l2 = new C1593l();
                C4904y.m18641c(Long.toString(bundleExtra.getLong("request_id", -1L)), "ChatBackgroundService");
                C4904y.m18641c(bundleExtra.getString("inbox_no"), "ChatBackgroundService");
                C4904y.m18641c(Long.toString(bundleExtra.getLong("message_id", -1L)), "ChatBackgroundService");
                C4904y.m18641c(bundleExtra.getString("packageName"), "ChatBackgroundService");
                int iM9958k = !TextUtils.isEmpty(bundleExtra.getString("inbox_no")) ? C2198l.m9958k(CommonApplication.m18732r().getContentResolver(), bundleExtra.getString("inbox_no")) : 0;
                if (i4 != 0 || iM9958k <= 0) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                c1593l2.m8494d(i2).m8492a(this).m8495e(i3).m8473a(bundleExtra.getLong("request_id", -1L)).m8488i(bundleExtra.getString("inbox_no")).m8478b(bundleExtra.getLong("message_id", -1L)).m8475a(bundleExtra.getString("sender_id")).m8482c(bundleExtra.getString("packageName")).m8472a(bundleExtra.getInt("message_category")).m8487h(bundleExtra.getString("password"));
                C1592k c1592kMo8471a2 = c1593l2.mo8471a();
                Message messageObtainMessage2 = this.f6019b.obtainMessage();
                messageObtainMessage2.what = 0;
                messageObtainMessage2.obj = c1592kMo8471a2;
                this.f6019b.sendMessage(messageObtainMessage2);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
