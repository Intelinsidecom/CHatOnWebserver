package com.sec.chaton.global;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.view.Display;
import android.view.InputDevice;
import android.view.WindowManager;
import com.sec.chaton.AsyncTaskC1599k;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.localbackup.noti.C1653a;
import com.sec.chaton.msgsend.C1766z;
import com.sec.chaton.msgsend.EnumC1764x;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p025d.p026a.C1231de;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.push.InterfaceC2092e;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.receiver.AlarmReceiver;
import com.sec.chaton.receiver.ScreenReceiver;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3242q;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import com.sec.common.util.log.collector.C3353c;
import com.sec.common.util.log.collector.LogCollectorSender;
import com.sec.spp.push.Config;
import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.ParseException;

/* loaded from: classes.dex */
public class GlobalApplication extends PushClientApplication {

    /* renamed from: e */
    public static AsyncTaskC1599k f5515e;

    /* renamed from: h */
    private static int f5517h;

    /* renamed from: i */
    private static int f5518i;

    /* renamed from: j */
    private static GlobalApplication f5519j = null;

    /* renamed from: k */
    private static C3242q f5520k = null;

    /* renamed from: a */
    public static String f5511a = null;

    /* renamed from: b */
    public static String f5512b = null;

    /* renamed from: c */
    public static boolean f5513c = false;

    /* renamed from: d */
    public static String f5514d = null;

    /* renamed from: n */
    private static boolean f5521n = false;

    /* renamed from: g */
    public static boolean f5516g = false;

    /* renamed from: l */
    private int f5523l = 0;

    /* renamed from: m */
    private InterfaceC2092e f5524m = null;

    /* renamed from: f */
    Lock f5522f = new ReentrantLock();

    /* renamed from: o */
    private ServiceConnection f5525o = new ServiceConnectionC1494b(this);

    /* renamed from: p */
    private Handler f5526p = new HandlerC1496d(this);

    /* renamed from: q */
    private final Debug.MemoryInfo f5527q = new Debug.MemoryInfo();

    /* renamed from: a */
    public static Application m6447a() {
        return f5519j;
    }

    /* renamed from: b */
    public static Resources m6451b() {
        return f5519j.getResources();
    }

    /* renamed from: c */
    public static C3242q m6453c() {
        if (f5520k == null) {
            f5520k = new C3242q();
        }
        return f5520k;
    }

    @Override // com.sec.chaton.push.PushClientApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        f5519j = this;
        C1493a.m6462a();
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        f5517h = defaultDisplay.getWidth();
        f5518i = defaultDisplay.getHeight();
        if (C3159aa.m10962a().m10977a("auto_backup_on", (Boolean) false).booleanValue()) {
            C1653a.m6926a(f5519j, false);
        }
        startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(new ScreenReceiver(), intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(AlarmReceiver.f8058a);
        intentFilter2.addAction(AlarmReceiver.f8059b);
        registerReceiver(new AlarmReceiver(), intentFilter2);
        C1548ag.m6568f();
        C1231de.m5555a();
        C3250y.m11438a();
        m6461o();
        C1337o.m5798a();
        if (C3159aa.m10962a().m10987b("uid")) {
            C1766z.m7268a(m11493l(), EnumC1764x.REASON_CHATON_STARTED);
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C3353c.m11831a(C3364o.m11849a(C3159aa.m10962a().m10979a("chaton_id", ""), "|", C3159aa.m10962a().m10979a("chaton_version", "")));
            boolean zM11832a = C3353c.m11832a();
            C3353c.m11834c();
            if (!zM11832a) {
                m6455d();
            }
            Thread.setDefaultUncaughtExceptionHandler(new C1495c(this, Thread.getDefaultUncaughtExceptionHandler()));
            if (C3159aa.m10962a().m10987b("uid")) {
                m6459m();
            }
        }
    }

    /* renamed from: m */
    private void m6459m() {
        Context contextM11493l = CommonApplication.m11493l();
        C3250y.m11453c("registerLogCollectorAlarm()", GlobalApplication.class.getSimpleName());
        AlarmManager alarmManager = (AlarmManager) contextM11493l.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(contextM11493l, 0, new Intent(contextM11493l, (Class<?>) LogCollectorSender.class), 134217728);
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), 86400000L, service);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public static void m6455d() {
        C3250y.m11453c("activePushClient()", GlobalApplication.class.getSimpleName());
        Intent intent = new Intent(Config.ACTION_LOG_SERVICE_REQUEST);
        intent.putExtra(Config.EXTRA_APP_PACKAGE_NAME, "com.sec.chaton");
        intent.putExtra(Config.EXTRA_REQTYPE, 101);
        if (Build.VERSION.SDK_INT > 12) {
            intent.addFlags(32);
        }
        CommonApplication.m11493l().sendBroadcast(intent, Config.PERMISSION_LOG_SERVICE_RECEIVER);
        Intent intent2 = new Intent(Config.ACTION_LOG_SERVICE_REQUEST);
        intent2.putExtra(Config.EXTRA_APP_PACKAGE_NAME, "com.sec.chaton.error");
        intent2.putExtra(Config.EXTRA_REQTYPE, 101);
        if (Build.VERSION.SDK_INT > 12) {
            intent2.addFlags(32);
        }
        CommonApplication.m11493l().sendBroadcast(intent2, Config.PERMISSION_LOG_SERVICE_RECEIVER);
    }

    /* renamed from: a */
    public static void m6449a(Context context) {
        Intent intentM1226a = TabActivity.m1226a(context);
        intentM1226a.putExtra("finish", true);
        if (context instanceof Activity) {
            C3250y.m11456e("instanceOf Activity", GlobalApplication.class.getSimpleName());
        } else {
            C3250y.m11456e("No instanceOf Activity", GlobalApplication.class.getSimpleName());
            intentM1226a.setFlags(335544320);
        }
        context.startActivity(intentM1226a);
    }

    /* renamed from: b */
    public static void m6452b(Context context) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.putExtra("finish", true);
        if (context instanceof Activity) {
            C3250y.m11456e("instanceOf Activity", GlobalApplication.class.getSimpleName());
            intent.setFlags(67108864);
        } else {
            C3250y.m11456e("No instanceOf Activity", GlobalApplication.class.getSimpleName());
            intent.setFlags(335544320);
        }
        context.startActivity(intent);
    }

    /* renamed from: c */
    public static void m6454c(Context context) {
        Intent intentM1226a = TabActivity.m1226a(context);
        intentM1226a.putExtra("callRestart", true);
        intentM1226a.setFlags(intentM1226a.getFlags() ^ 536870912);
        context.startActivity(intentM1226a);
    }

    /* renamed from: e */
    public static boolean m6456e() {
        return C1493a.m6463a("tablet_enable_feature");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m6460n() {
        Debug.getMemoryInfo(this.f5527q);
        long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize() / 1024;
        long nativeHeapSize = Debug.getNativeHeapSize() / 1024;
        SharedPreferences sharedPreferences = getSharedPreferences("memory_info", 1);
        int i = sharedPreferences.getInt("max_total_pss", 0);
        C3250y.m11450b("Cur:" + this.f5527q.getTotalPss() + "(dalvik=" + this.f5527q.dalvikPss + " + native=" + this.f5527q.nativePss + " + other=" + this.f5527q.otherPss + "), Max:" + i + " / heapAllocSize=" + nativeHeapAllocatedSize, "DumpMemory");
        if (i < this.f5527q.getTotalPss()) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("max_total_pss", this.f5527q.getTotalPss());
            editorEdit.putInt("max_dalvik_pss", this.f5527q.dalvikPss);
            editorEdit.putInt("max_native_pss", this.f5527q.nativePss);
            editorEdit.putInt("max_other_pss", this.f5527q.otherPss);
            editorEdit.putLong("max_heap_alloc_size", nativeHeapAllocatedSize);
            editorEdit.putLong("max_heap_size", nativeHeapSize);
            editorEdit.putLong("max_dump_time", System.currentTimeMillis());
            if (Build.VERSION.SDK_INT < 9) {
                editorEdit.commit();
            } else {
                editorEdit.apply();
            }
        }
    }

    /* renamed from: o */
    private void m6461o() {
        try {
            String strM10979a = C3159aa.m10962a().m10979a("chaton_version", "0.0.0");
            if (!strM10979a.equals(C0816a.f3112a)) {
                C3250y.m11450b("old version : " + strM10979a + " new version : " + C0816a.f3112a, "ChatONConst");
                C0816a.f3115d = true;
            } else {
                C3250y.m11450b("ChatON version is the latest", "ChatONConst");
            }
        } catch (Exception e) {
            C3250y.m11442a("exception : " + e.toString(), "ChatONConst");
        }
    }

    /* renamed from: f */
    public static boolean m6457f() {
        PackageManager packageManager;
        if (Build.VERSION.SDK_INT < 16 || (packageManager = m11493l().getPackageManager()) == null) {
            return false;
        }
        return packageManager.hasSystemFeature("com.sec.feature.multiwindow");
    }

    /* renamed from: g */
    public static boolean m6458g() {
        for (int i : InputDevice.getDeviceIds()) {
            if (InputDevice.getDevice(i).getKeyboardType() == 257) {
                return true;
            }
        }
        return false;
    }
}
