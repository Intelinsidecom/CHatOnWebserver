package com.sec.chaton.global;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.PowerManager;
import android.view.Display;
import android.view.WindowManager;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p015d.p016a.C0569bj;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.push.InterfaceC1118d;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.receiver.ScreenReceiver;
import com.sec.chaton.util.BlackScreenNotification;
import com.sec.chaton.util.C1736as;
import com.sec.chaton.util.C1782n;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.ScreenOnNotification;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class GlobalApplication extends PushClientApplication {

    /* renamed from: c */
    public static boolean f2777c;

    /* renamed from: g */
    private static int f2780g;

    /* renamed from: h */
    private static int f2781h;

    /* renamed from: i */
    private static boolean f2782i = false;

    /* renamed from: j */
    private static GlobalApplication f2783j = null;

    /* renamed from: k */
    private static C1736as f2784k = null;

    /* renamed from: l */
    private static C1782n f2785l = null;

    /* renamed from: a */
    public static String f2775a = null;

    /* renamed from: b */
    public static String f2776b = null;

    /* renamed from: d */
    public static BlackScreenNotification f2778d = null;

    /* renamed from: e */
    public static ScreenOnNotification f2779e = null;

    /* renamed from: m */
    private int f2787m = 0;

    /* renamed from: n */
    private InterfaceC1118d f2788n = null;

    /* renamed from: f */
    Lock f2786f = new ReentrantLock();

    /* renamed from: o */
    private ServiceConnection f2789o = new ServiceConnectionC0761a(this);

    /* renamed from: p */
    private Handler f2790p = new HandlerC0762b(this);

    /* renamed from: q */
    private final Debug.MemoryInfo f2791q = new Debug.MemoryInfo();

    /* renamed from: a */
    public static Application m3256a() {
        return f2783j;
    }

    /* renamed from: b */
    public static Context m3260b() {
        return f2783j;
    }

    /* renamed from: c */
    public static Resources m3262c() {
        return f2783j.getResources();
    }

    /* renamed from: d */
    public static C1736as m3263d() {
        if (f2784k == null) {
            f2784k = new C1736as();
        }
        return f2784k;
    }

    /* renamed from: e */
    public static C1782n m3264e() {
        if (f2785l == null) {
            f2785l = new C1782n();
        }
        return f2785l;
    }

    @Override // com.sec.chaton.push.PushClientApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        f2783j = this;
        if (Build.VERSION.SDK_INT >= 11 && (getResources().getConfiguration().screenLayout & 15) >= 4) {
            f2782i = true;
        } else {
            f2782i = false;
        }
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        f2780g = defaultDisplay.getWidth();
        f2781h = defaultDisplay.getHeight();
        f2777c = ((PowerManager) getSystemService("power")).isScreenOn();
        startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(new ScreenReceiver(), intentFilter);
        C0770ab.m3283f();
        C0569bj.m2760a();
        C0665i.m3048a(m3260b().getContentResolver());
        C1786r.m6050a();
        C0639k.m2906a();
    }

    /* renamed from: a */
    public static void m3258a(Context context) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.putExtra("finish", true);
        if (context instanceof Activity) {
            C1786r.m6066e("instanceOf Activity", GlobalApplication.class.getSimpleName());
            intent.setFlags(67108864);
        } else {
            C1786r.m6066e("No instanceOf Activity", GlobalApplication.class.getSimpleName());
            intent.setFlags(335544320);
        }
        context.startActivity(intent);
    }

    /* renamed from: b */
    public static void m3261b(Context context) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("callRestart", true);
        context.startActivity(intent);
    }

    /* renamed from: f */
    public static boolean m3265f() {
        return f2782i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m3266l() {
        Debug.getMemoryInfo(this.f2791q);
        long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize() / 1024;
        long nativeHeapSize = Debug.getNativeHeapSize() / 1024;
        SharedPreferences sharedPreferences = getSharedPreferences("memory_info", 1);
        int i = sharedPreferences.getInt("max_total_pss", 0);
        C1786r.m6061b("Cur:" + this.f2791q.getTotalPss() + "(dalvik=" + this.f2791q.dalvikPss + " + native=" + this.f2791q.nativePss + " + other=" + this.f2791q.otherPss + "), Max:" + i + " / heapAllocSize=" + nativeHeapAllocatedSize, "DumpMemory");
        if (i < this.f2791q.getTotalPss()) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("max_total_pss", this.f2791q.getTotalPss());
            editorEdit.putInt("max_dalvik_pss", this.f2791q.dalvikPss);
            editorEdit.putInt("max_native_pss", this.f2791q.nativePss);
            editorEdit.putInt("max_other_pss", this.f2791q.otherPss);
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
}
