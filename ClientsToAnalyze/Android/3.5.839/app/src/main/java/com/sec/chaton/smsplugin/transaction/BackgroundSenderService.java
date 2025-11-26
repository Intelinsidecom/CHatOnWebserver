package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.sec.chaton.smsplugin.p111h.C3890m;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class BackgroundSenderService extends Service {

    /* renamed from: a */
    private C4066b f14563a;

    /* renamed from: a */
    public static void m15514a(Context context, String str, String[] strArr, int i, Handler handler) {
        m15515a(context, str, strArr, null, i, handler);
    }

    /* renamed from: a */
    public static void m15515a(Context context, String str, String[] strArr, Uri uri, int i, Handler handler) {
        Intent intent = new Intent(context, (Class<?>) BackgroundSenderService.class);
        intent.setAction("com.sec.chatron.smsplugin.transaction.BG_SEND_SMS");
        intent.putExtra("extra_bg_recipients", strArr);
        intent.putExtra("extra_bg_message", str);
        intent.putExtra("extra_bg_token", i);
        if (uri != null) {
            intent.setData(uri);
        }
        if (handler != null) {
            intent.putExtra("extra_bg_cb_messenger", new Messenger(handler));
        }
        context.startService(intent);
    }

    /* renamed from: a */
    public static void m15512a(Context context, Uri uri, long j, int i, Handler handler) {
        Intent intent = new Intent(context, (Class<?>) BackgroundSenderService.class);
        intent.setAction("com.sec.chatron.smsplugin.transaction.BG_SEND_SMS");
        intent.putExtra("extra_message_uri", uri);
        intent.putExtra("extra_bg_token", i);
        if (handler != null) {
            intent.putExtra("extra_bg_cb_messenger", new Messenger(handler));
        }
        intent.putExtra("extra_thread_id", j);
        context.startService(intent);
    }

    /* renamed from: a */
    public static void m15513a(Context context, String str, String[] strArr) {
        m15514a(context, str, strArr, 1000, (Handler) null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            this.f14563a = new C4066b(this, intent);
        }
        if (this.f14563a == null) {
            return 2;
        }
        this.f14563a.m15647a();
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0116  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m15516b(android.content.Context r9, android.net.Uri r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.BackgroundSenderService.m15516b(android.content.Context, android.net.Uri):java.lang.String");
    }

    /* renamed from: a */
    public static void m15511a(int i, int i2, Messenger messenger) throws RemoteException {
        if (messenger != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.arg1 = i;
            try {
                messenger.send(messageObtain);
            } catch (RemoteException e) {
                C3890m.m14999e("Mms/MessageBackgroundSenderService", "Failed to send BG send result");
                e.printStackTrace();
            }
        }
    }
}
