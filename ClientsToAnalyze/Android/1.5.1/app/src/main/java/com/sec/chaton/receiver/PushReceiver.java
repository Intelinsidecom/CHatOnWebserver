package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.database.task.PushReceivedTask;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class PushReceiver extends BroadcastReceiver {

    /* renamed from: d */
    private static PowerManager.WakeLock f2799d;

    /* renamed from: e */
    private static ChatFragment f2800e;

    /* renamed from: a */
    NotifyingAsyncTaskWorker f2801a;

    /* renamed from: b */
    AbstractQueryTask.OnQueryTaskResult f2802b = new C0400a(this);

    /* renamed from: c */
    private Context f2803c;

    /* renamed from: a */
    public static void m3044a(ChatFragment chatFragment) {
        f2800e = chatFragment;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2803c = context;
        if (f2799d == null) {
            f2799d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "ChatON");
        }
        String stringExtra = intent.getStringExtra("notificationId");
        String stringExtra2 = intent.getStringExtra("msg");
        boolean booleanExtra = intent.getBooleanExtra("ack", false);
        String stringExtra3 = intent.getStringExtra("sender");
        String stringExtra4 = intent.getStringExtra("appData");
        ChatONLogWriter.m3508c("Push Received : Sender = " + stringExtra3 + ", appData : " + stringExtra4 + ", notiId: " + stringExtra, getClass().getSimpleName());
        if (ChatONPref.m3519a().contains("uid")) {
            this.f2801a = new NotifyingAsyncTaskWorker();
            NotifyingAsyncTaskWorker.m2304a(this.f2801a, -1, new PushReceivedTask(this.f2802b, stringExtra, booleanExtra, stringExtra3, stringExtra2, stringExtra4));
        }
    }
}
