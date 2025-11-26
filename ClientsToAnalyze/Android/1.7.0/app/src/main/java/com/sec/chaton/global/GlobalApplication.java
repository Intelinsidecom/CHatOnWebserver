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
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p013a.p014a.C0134aj;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.push.InterfaceC0903g;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.receiver.ScreenReceiver;
import com.sec.chaton.util.BlackScreenNotification;
import com.sec.chaton.util.C1277a;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1343r;
import com.sec.chaton.util.ScreenOnNotification;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class GlobalApplication extends PushClientApplication {

    /* renamed from: c */
    public static boolean f2409c;

    /* renamed from: i */
    private static int f2414i;

    /* renamed from: j */
    private static int f2415j;

    /* renamed from: k */
    private static boolean f2416k = false;

    /* renamed from: l */
    private static GlobalApplication f2417l = null;

    /* renamed from: m */
    private static C1277a f2418m = null;

    /* renamed from: n */
    private static C1343r f2419n = null;

    /* renamed from: a */
    public static String f2407a = null;

    /* renamed from: b */
    public static String f2408b = null;

    /* renamed from: d */
    public static BlackScreenNotification f2410d = null;

    /* renamed from: e */
    public static ScreenOnNotification f2411e = null;

    /* renamed from: f */
    public static String f2412f = null;

    /* renamed from: g */
    public static boolean f2413g = false;

    /* renamed from: o */
    private int f2421o = 0;

    /* renamed from: p */
    private InterfaceC0903g f2422p = null;

    /* renamed from: h */
    Lock f2420h = new ReentrantLock();

    /* renamed from: q */
    private ServiceConnection f2423q = new ServiceConnectionC0713a(this);

    /* renamed from: r */
    private Handler f2424r = new HandlerC0714b(this);

    /* renamed from: s */
    private final Debug.MemoryInfo f2425s = new Debug.MemoryInfo();

    /* renamed from: f */
    public static Application m3105f() {
        return f2417l;
    }

    /* renamed from: a */
    public static Context m3100a() {
        return f2417l;
    }

    /* renamed from: g */
    public static Resources m3106g() {
        return f2417l.getResources();
    }

    /* renamed from: h */
    public static C1277a m3107h() {
        if (f2418m == null) {
            f2418m = new C1277a();
        }
        return f2418m;
    }

    /* renamed from: i */
    public static C1343r m3108i() {
        if (f2419n == null) {
            f2419n = new C1343r();
        }
        return f2419n;
    }

    @Override // com.sec.chaton.push.PushClientApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        f2417l = this;
        if (Build.VERSION.SDK_INT >= 11 && (getResources().getConfiguration().screenLayout & 15) >= 4) {
            f2416k = true;
        } else {
            f2416k = false;
        }
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        f2414i = defaultDisplay.getWidth();
        f2415j = defaultDisplay.getHeight();
        f2409c = ((PowerManager) getSystemService("power")).isScreenOn();
        startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(new ScreenReceiver(), intentFilter);
        C0510q.m2567f();
        C0134aj.m678a();
        C0635o.m2918a(m3100a().getContentResolver());
        C1341p.m4647a();
        m3111l();
        C0223v.m809a();
    }

    /* renamed from: a */
    public static void m3102a(Context context) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.putExtra("finish", true);
        if (context instanceof Activity) {
            C1341p.m4662e("instanceOf Activity", GlobalApplication.class.getSimpleName());
            intent.setFlags(67108864);
        } else {
            C1341p.m4662e("No instanceOf Activity", GlobalApplication.class.getSimpleName());
            intent.setFlags(335544320);
        }
        context.startActivity(intent);
    }

    /* renamed from: b */
    public static void m3104b(Context context) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("callRestart", true);
        context.startActivity(intent);
    }

    /* renamed from: j */
    public static boolean m3109j() {
        return f2416k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m3110k() {
        Debug.getMemoryInfo(this.f2425s);
        long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize() / 1024;
        long nativeHeapSize = Debug.getNativeHeapSize() / 1024;
        SharedPreferences sharedPreferences = getSharedPreferences("memory_info", 1);
        int i = sharedPreferences.getInt("max_total_pss", 0);
        C1341p.m4658b("Cur:" + this.f2425s.getTotalPss() + "(dalvik=" + this.f2425s.dalvikPss + " + native=" + this.f2425s.nativePss + " + other=" + this.f2425s.otherPss + "), Max:" + i + " / heapAllocSize=" + nativeHeapAllocatedSize, "DumpMemory");
        if (i < this.f2425s.getTotalPss()) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("max_total_pss", this.f2425s.getTotalPss());
            editorEdit.putInt("max_dalvik_pss", this.f2425s.dalvikPss);
            editorEdit.putInt("max_native_pss", this.f2425s.nativePss);
            editorEdit.putInt("max_other_pss", this.f2425s.otherPss);
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

    /* renamed from: l */
    private void m3111l() {
        try {
            String string = C1323bs.m4575a().getString("chaton_version", "0.0.0");
            if (!string.equals(C0684a.f2331b)) {
                C1341p.m4658b("old version : " + string + " new version : " + C0684a.f2331b, "ChatONConst");
                C0684a.f2334e = true;
            } else {
                C1341p.m4658b("ChatON version is the latest", "ChatONConst");
            }
        } catch (Exception e) {
            C1341p.m4651a("exception : " + e.toString(), "ChatONConst");
        }
    }
}
