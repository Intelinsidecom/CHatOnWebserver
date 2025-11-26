package com.sec.chaton.global;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.CountryDetector;
import android.location.CountryListener;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.provider.SearchRecentSuggestions;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.InputDevice;
import android.view.WindowManager;
import com.sec.chaton.AsyncTaskC4563t;
import com.sec.chaton.C0991aa;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1735gh;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.localbackup.noti.C2555a;
import com.sec.chaton.msgsend.C2691ai;
import com.sec.chaton.msgsend.EnumC2689ag;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2136q;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p055d.p056a.C2002du;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.push.InterfaceC3092e;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.qmlog.C3122d;
import com.sec.chaton.receiver.AlarmReceiver;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4893n;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.C4905z;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.p125c.C4974b;
import com.sec.common.util.C5033j;
import com.sec.common.util.C5034k;
import com.sec.common.util.log.collector.C5038c;
import com.sec.common.util.log.collector.LogCollectorSender;
import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.ParseException;

/* loaded from: classes.dex */
public class GlobalApplication extends PushClientApplication {

    /* renamed from: f */
    public static AsyncTaskC4563t f8360f;

    /* renamed from: i */
    private static int f8362i;

    /* renamed from: j */
    private static int f8363j;

    /* renamed from: o */
    private SearchRecentSuggestions f8370o;

    /* renamed from: p */
    private TelephonyManager f8371p;

    /* renamed from: q */
    private CountryDetector f8372q;

    /* renamed from: r */
    private CountryListener f8373r;

    /* renamed from: s */
    private String f8374s;

    /* renamed from: t */
    private C2353e f8375t;

    /* renamed from: k */
    private static GlobalApplication f8364k = null;

    /* renamed from: l */
    private static C4893n f8365l = null;

    /* renamed from: a */
    public static String f8355a = null;

    /* renamed from: b */
    public static String f8356b = null;

    /* renamed from: c */
    public static String f8357c = null;

    /* renamed from: d */
    public static boolean f8358d = false;

    /* renamed from: e */
    public static String f8359e = null;

    /* renamed from: u */
    private static boolean f8366u = false;

    /* renamed from: h */
    public static boolean f8361h = false;

    /* renamed from: m */
    private int f8368m = 0;

    /* renamed from: n */
    private InterfaceC3092e f8369n = null;

    /* renamed from: g */
    Lock f8367g = new ReentrantLock();

    /* renamed from: v */
    private ServiceConnection f8376v = new ServiceConnectionC2350b(this);

    /* renamed from: w */
    private Handler f8377w = new HandlerC2352d(this);

    /* renamed from: x */
    private final Debug.MemoryInfo f8378x = new Debug.MemoryInfo();

    /* renamed from: a */
    public static GlobalApplication m10279a() {
        return f8364k;
    }

    /* renamed from: b */
    public static Resources m10283b() {
        return f8364k.getResources();
    }

    /* renamed from: c */
    public static C4893n m10284c() {
        if (f8365l == null) {
            f8365l = new C4893n();
        }
        return f8365l;
    }

    public GlobalApplication() {
        C4996f.m18963a(new C4905z(new C4974b()));
    }

    @Override // com.sec.chaton.push.PushClientApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        f8364k = this;
        if (((Application) CommonApplication.m18732r().getApplicationContext()).getApplicationInfo().icon == R.drawable.icon_white) {
            if (C4904y.m18630a() == 0) {
                C4904y.m18632a(1);
            }
        } else {
            C4904y.m18638b();
        }
        m10294u();
        C2349a.m10298a();
        C5038c.m19161j();
        C5038c.m19159h();
        C5038c.m19145a(C5034k.m19107l());
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        f8362i = defaultDisplay.getWidth();
        f8363j = defaultDisplay.getHeight();
        if (C4809aa.m18104a().m18119a("auto_backup_on", (Boolean) false).booleanValue()) {
            C2555a.m10957a(f8364k, false);
        }
        startService(new Intent("com.sec.chaton.push.PUSH_CLIENT_SERVICE_ACTION"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AlarmReceiver.f11510a);
        intentFilter.addAction(AlarmReceiver.f11511b);
        registerReceiver(new AlarmReceiver(), intentFilter);
        C2426ao.m10506f();
        C2002du.m9149a();
        C2142w.m9597a();
        C2136q.m9583a();
        if (C4809aa.m18104a().m18129b("uid")) {
            C2691ai.m11298a(m18732r(), EnumC2689ag.REASON_CHATON_STARTED);
        }
        if (C2349a.m10301a("log_collector")) {
            C5038c.m19153c(true);
            m10285d();
            m10292s();
        }
        if (Build.VERSION.SDK_INT >= 14) {
            this.f8372q = (CountryDetector) getSystemService("country_detector");
            this.f8373r = new C2351c(this);
            this.f8372q.addCountryListener(this.f8373r, getMainLooper());
            this.f8374s = this.f8372q.detectCountry().getCountryIso();
        }
        if (C2349a.m10301a("sms_feature")) {
            C3847e.m14665aP();
        }
        C3892o.m15036j();
        this.f8375t = new C2353e(this, null);
        C0991aa.m6037a().m18959a(this.f8375t);
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3122d.m12732a();
        }
    }

    /* renamed from: s */
    private void m10292s() {
        if (C2349a.m10301a("log_collector")) {
            Context contextM18732r = CommonApplication.m18732r();
            C4904y.m18641c("registerLogCollectorAlarm()", GlobalApplication.class.getSimpleName());
            AlarmManager alarmManager = (AlarmManager) contextM18732r.getSystemService("alarm");
            PendingIntent service = PendingIntent.getService(contextM18732r, 0, new Intent(contextM18732r, (Class<?>) LogCollectorSender.class), 134217728);
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.set(11, 23);
                calendar.set(12, 59);
                calendar.set(13, 0);
                alarmManager.setRepeating(0, calendar.getTimeInMillis(), 86400000L, service);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public static void m10285d() {
        C4904y.m18641c("registerPushClient()", GlobalApplication.class.getSimpleName());
        Intent intent = new Intent("com.sec.spp.push.REQUEST_REGISTER");
        intent.putExtra("EXTRA_PACKAGENAME", f8364k.getPackageName());
        intent.putExtra("EXTRA_INTENTFILTER", "com.sec.chaton.REGISTER_FILTER");
        CommonApplication.m18732r().sendBroadcast(intent);
    }

    /* renamed from: e */
    public static boolean m10286e() {
        return C2349a.m10301a("tablet_enable_feature");
    }

    /* renamed from: f */
    public static boolean m10287f() {
        return Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: t */
    public void m10293t() {
        Debug.getMemoryInfo(this.f8378x);
        long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize() / 1024;
        long nativeHeapSize = Debug.getNativeHeapSize() / 1024;
        SharedPreferences sharedPreferences = getSharedPreferences("memory_info", 1);
        int i = sharedPreferences.getInt("max_total_pss", 0);
        C4904y.m18639b("Cur:" + this.f8378x.getTotalPss() + "(dalvik=" + this.f8378x.dalvikPss + " + native=" + this.f8378x.nativePss + " + other=" + this.f8378x.otherPss + "), Max:" + i + " / heapAllocSize=" + nativeHeapAllocatedSize, "DumpMemory");
        if (i < this.f8378x.getTotalPss()) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("max_total_pss", this.f8378x.getTotalPss());
            editorEdit.putInt("max_dalvik_pss", this.f8378x.dalvikPss);
            editorEdit.putInt("max_native_pss", this.f8378x.nativePss);
            editorEdit.putInt("max_other_pss", this.f8378x.otherPss);
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

    /* renamed from: u */
    private void m10294u() {
        try {
            String strM18121a = C4809aa.m18104a().m18121a("chaton_version", "0.0.0");
            if (strM18121a.equals("0.0.0")) {
                C1427a.f5071i = true;
            } else {
                C1427a.f5071i = false;
            }
            if (!strM18121a.equals(C1427a.f5063a)) {
                C4904y.m18639b("old version : " + strM18121a + " new version : " + C1427a.f5063a, "ChatONConst");
                C1427a.f5070h = true;
                SharedPreferences sharedPreferences = CommonApplication.m18732r().getSharedPreferences("PASSWORD_LOCK", 0);
                if (sharedPreferences != null && sharedPreferences.contains("LOCK_STATE")) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    if (sharedPreferences.getString("LOCK_STATE", C4892m.m18588h()).equals(C4892m.m18590i())) {
                        editorEdit.putString("LOCK_STATE", C4892m.m18586g());
                    } else if (sharedPreferences.getString("LOCK_STATE", C4892m.m18588h()).equals(C4892m.m18591j())) {
                        editorEdit.putString("LOCK_STATE", C4892m.m18588h());
                    }
                    C5033j.m19087a(editorEdit);
                    return;
                }
                return;
            }
            C4904y.m18639b("ChatON version is the latest", "ChatONConst");
        } catch (Exception e) {
            C4904y.m18634a("exception : " + e.toString(), "ChatONConst");
        }
    }

    /* renamed from: g */
    public static boolean m10288g() {
        PackageManager packageManager;
        if (Build.VERSION.SDK_INT < 16 || (packageManager = m18732r().getPackageManager()) == null) {
            return false;
        }
        return packageManager.hasSystemFeature("com.sec.feature.multiwindow");
    }

    /* renamed from: h */
    public static boolean m10289h() {
        return Build.VERSION.SDK_INT >= 11;
    }

    @TargetApi(9)
    /* renamed from: i */
    public static boolean m10290i() {
        if (Build.VERSION.SDK_INT < 9) {
            return false;
        }
        for (int i : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i);
            if (device != null && device.getKeyboardType() == 257) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    /* renamed from: j */
    public TelephonyManager m10295j() {
        if (this.f8371p == null) {
            this.f8371p = (TelephonyManager) getSystemService("phone");
        }
        return this.f8371p;
    }

    /* renamed from: k */
    public SearchRecentSuggestions m10296k() {
        return this.f8370o;
    }

    /* renamed from: l */
    public String m10297l() {
        return this.f8374s;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        if (!C1813b.m8906b().m8930a()) {
            C1735gh.m8621b();
        }
    }
}
