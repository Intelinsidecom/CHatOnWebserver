package com.sec.chaton.account;

import android.accounts.Account;
import android.app.Service;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.sec.chaton.control.ContactControl;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.util.ChatONLogWriter;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class ChatONSyncServiceAdapter extends Service {

    /* renamed from: c */
    private static ServiceConnectionC0068e f328c = null;

    /* renamed from: a */
    static Handler f326a = new HandlerC0066c(Looper.getMainLooper());

    /* renamed from: b */
    static ContactControl f327b = new ContactControl(f326a);

    /* renamed from: a */
    private ServiceConnectionC0068e m400a() {
        if (f328c == null) {
            f328c = new ServiceConnectionC0068e(this);
        }
        return f328c;
    }

    /* renamed from: a */
    public static void m401a(Context context, Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        ChatONLogWriter.m3506b("ChatONSyncServiceAdapter performSync start in thread " + Thread.currentThread().getName(), "performSync");
        f327b.m1994a(RtspHeaders.Values.APPEND, true);
        ChatONLogWriter.m3506b("ChatONSyncServiceAdapter performSync upload address done in thread " + Thread.currentThread().getName(), "performSync");
        f327b.m1995a(true);
        ChatONLogWriter.m3506b("ChatONSyncServiceAdapter performSync getAllBuddies done in thread " + Thread.currentThread().getName(), "performSync");
        InBoxDatabaseHelper.m2253a(context);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return m400a().getSyncAdapterBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ChatONLogWriter.m3508c("onCreate", getClass().getSimpleName());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3508c("onDestroy", getClass().getSimpleName());
    }
}
