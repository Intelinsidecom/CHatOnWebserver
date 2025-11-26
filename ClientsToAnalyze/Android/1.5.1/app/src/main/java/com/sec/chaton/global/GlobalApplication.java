package com.sec.chaton.global;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.PowerManager;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.control.PushControlFactory;
import com.sec.chaton.control.task.NetTaskHandler;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.receiver.ScreenReceiver;
import com.sec.chaton.util.ChatONCryptoKeyMgr;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.MessageServerAddressMgr;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class GlobalApplication extends PushClientApplication {

    /* renamed from: d */
    public static boolean f1897d;

    /* renamed from: f */
    private static GlobalApplication f1898f = null;

    /* renamed from: g */
    private static MessageServerAddressMgr f1899g = null;

    /* renamed from: h */
    private static ChatONCryptoKeyMgr f1900h = null;

    /* renamed from: a */
    public static boolean f1894a = true;

    /* renamed from: b */
    public static String f1895b = null;

    /* renamed from: c */
    public static String f1896c = null;

    /* renamed from: i */
    private int f1902i = 0;

    /* renamed from: j */
    private IPushClientService f1903j = null;

    /* renamed from: e */
    Lock f1901e = new ReentrantLock();

    /* renamed from: k */
    private ServiceConnection f1904k = new ServiceConnectionC0237a(this);

    /* renamed from: a */
    public static void m2384a(Context context) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.putExtra("finish", true);
        if (context instanceof Activity) {
            ChatONLogWriter.m3511e("instanceOf Activity", GlobalApplication.class.getSimpleName());
            intent.setFlags(67108864);
        } else {
            ChatONLogWriter.m3511e("No instanceOf Activity", GlobalApplication.class.getSimpleName());
            intent.setFlags(335544320);
        }
        context.startActivity(intent);
    }

    /* renamed from: b */
    public static void m2385b(Context context) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("callRestart", true);
        context.startActivity(intent);
    }

    /* renamed from: d */
    public static Application m2386d() {
        return f1898f;
    }

    /* renamed from: e */
    public static Context m2387e() {
        return f1898f;
    }

    /* renamed from: f */
    public static Resources m2388f() {
        return f1898f.getResources();
    }

    /* renamed from: g */
    public static MessageServerAddressMgr m2389g() {
        if (f1899g == null) {
            f1899g = new MessageServerAddressMgr();
        }
        return f1899g;
    }

    /* renamed from: h */
    public static ChatONCryptoKeyMgr m2390h() {
        if (f1900h == null) {
            f1900h = new ChatONCryptoKeyMgr();
        }
        return f1900h;
    }

    @Override // com.sec.chaton.push.PushClientApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        f1898f = this;
        f1897d = ((PowerManager) getSystemService("power")).isScreenOn();
        startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
        PushControlFactory.m2072a().mo1978d(new HandlerC0238b(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(new ScreenReceiver(), intentFilter);
        TcpEnvelope.m2799g();
        NetTaskHandler.m2152a();
        MessageDatabaseHelper.m2277a(m2387e().getContentResolver());
        ChatONLogWriter.m3495a();
    }
}
