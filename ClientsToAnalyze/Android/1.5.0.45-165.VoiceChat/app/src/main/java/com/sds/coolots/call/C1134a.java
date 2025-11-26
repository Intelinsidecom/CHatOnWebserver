package com.sds.coolots.call;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.sds.coolots.call.a */
/* loaded from: classes.dex */
public final class C1134a {

    /* renamed from: b */
    private static final String f2325b = "[CallStatusTone]";

    /* renamed from: c */
    private static final boolean f2326c = true;

    /* renamed from: n */
    private static final int f2327n = 60000;

    /* renamed from: q */
    private static final int f2328q = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "min_minder", 0);

    /* renamed from: r */
    private static final int f2329r = 50;

    /* renamed from: s */
    private static final int f2330s = 300;

    /* renamed from: t */
    private static final int f2331t = 0;

    /* renamed from: u */
    private static final int f2332u = 1;

    /* renamed from: v */
    private static final int f2333v = 2;

    /* renamed from: w */
    private static final int f2334w = 1000;

    /* renamed from: x */
    private static final int f2335x = 500;

    /* renamed from: d */
    private boolean f2337d;

    /* renamed from: e */
    private boolean f2338e;

    /* renamed from: f */
    private boolean f2339f;

    /* renamed from: g */
    private boolean f2340g;

    /* renamed from: h */
    private Timer f2341h;

    /* renamed from: i */
    private TimerTask f2342i;

    /* renamed from: j */
    private AlarmManager f2343j = null;

    /* renamed from: k */
    private PendingIntent f2344k = null;

    /* renamed from: l */
    private AudioManager f2345l = null;

    /* renamed from: m */
    private int f2346m = 0;

    /* renamed from: o */
    private BroadcastReceiver f2347o = null;

    /* renamed from: p */
    private String f2348p = "com.coolots.chaton.action.MINUTE_MINDER";

    /* renamed from: a */
    public Vibrator f2336a = null;

    public C1134a() {
        Log.m2963i("[CallStatusTone] new Instance");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m2109b(String str) {
        Log.m2963i(f2325b + str);
    }

    /* renamed from: h */
    private boolean m2111h() {
        return MainApplication.mSettingData.getCallConnectTone();
    }

    /* renamed from: i */
    private boolean m2112i() {
        return MainApplication.mSettingData.getCallEndTone();
    }

    /* renamed from: j */
    private boolean m2113j() {
        return MainApplication.mSettingData.getMinuteMinder();
    }

    /* renamed from: k */
    private boolean m2114k() {
        return MainApplication.mSettingData.getCallAnswerVibration();
    }

    /* renamed from: l */
    private boolean m2115l() {
        return MainApplication.mSettingData.getCallEndVibration();
    }

    /* renamed from: m */
    private void m2116m() {
        m2119p();
        this.f2342i = new C1148b(this);
        this.f2341h = new Timer();
        this.f2341h.schedule(this.f2342i, 60000L, 60000L);
    }

    /* renamed from: n */
    private void m2117n() {
        if (this.f2343j == null || this.f2344k == null || this.f2347o == null) {
            return;
        }
        m2109b("<CIH> stopMinuteMinderTone()");
        this.f2343j.cancel(this.f2344k);
        this.f2343j = null;
        this.f2344k = null;
        try {
            MainApplication.mContext.unregisterReceiver(this.f2347o);
        } catch (IllegalArgumentException e) {
            Log.m2958e("IllegalArgumentException \n e");
        }
        this.f2347o = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m2118o() {
        m2109b("<CIH> playMinuteMinderTone()");
        if (this.f2343j == null && this.f2344k == null && this.f2347o == null) {
            this.f2347o = new C1150c(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(this.f2348p);
            MainApplication.mContext.registerReceiver(this.f2347o, intentFilter);
            this.f2343j = (AlarmManager) MainApplication.mContext.getSystemService("alarm");
            this.f2344k = PendingIntent.getBroadcast(MainApplication.mContext, 0, new Intent(this.f2348p), 268435456);
            m2109b("<CIH> mPendingIntent = " + this.f2344k);
            m2109b("<CIH> mMinuteMinderBroadcastReceiver = " + this.f2347o);
            m2109b("<CIH> SystemClock.elapsedRealtime() = " + SystemClock.elapsedRealtime());
            long time = 0;
            if (MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime() != null && MainApplication.mPhoneManager.getPhoneStateMachine().getCallFirstStartTime() != null) {
                time = MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime().getTime() - MainApplication.mPhoneManager.getPhoneStateMachine().getCallFirstStartTime().getTime();
            }
            m2109b("<CIH> callDuration = " + time);
            long j = 60000 - (time % 60000);
            m2109b("<CIH> firstAlarmedTime = " + j);
            this.f2343j.setRepeating(2, j + SystemClock.elapsedRealtime(), 60000L, this.f2344k);
        }
    }

    /* renamed from: p */
    private void m2119p() {
        if (this.f2341h != null) {
            this.f2341h.cancel();
            this.f2341h = null;
        }
        if (this.f2342i != null) {
            this.f2342i.cancel();
            this.f2342i = null;
        }
    }

    /* renamed from: a */
    public void m2120a(boolean z) {
        m2109b("setConnected()");
        this.f2338e = z;
    }

    /* renamed from: a */
    public void m2121a(boolean z, boolean z2) {
        m2109b("setCalling()");
        this.f2337d = z;
        this.f2339f = z2;
        this.f2340g = false;
    }

    /* renamed from: a */
    public boolean m2122a() {
        if (this.f2337d) {
            m2109b("playCallConnectionTone()");
            if (m2111h()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m2123b() {
        if (m2113j()) {
            m2109b("<CIH> startMinuteMinderAlarm: MINDER_TONE_TYPE = " + f2328q);
            m2118o();
        }
    }

    /* renamed from: c */
    public void m2124c() {
        m2109b("stopMinuteMinder()");
        m2117n();
    }

    /* renamed from: d */
    public boolean m2125d() {
        if (!this.f2337d) {
            return false;
        }
        m2109b("playCallEndTone()");
        this.f2337d = false;
        if (this.f2338e) {
            this.f2338e = false;
            return m2112i();
        }
        m2109b("[YHT] NOT CONNECTED!!!");
        return false;
    }

    /* renamed from: e */
    public void m2126e() {
        m2109b("vibrateAnswer()");
        if (m2114k()) {
            if (this.f2336a == null) {
                this.f2336a = (Vibrator) MainApplication.mContext.getSystemService("vibrator");
            }
            this.f2336a.vibrate(500L);
        }
    }

    /* renamed from: f */
    public void m2127f() {
        if (this.f2340g) {
            return;
        }
        m2109b("vibrateCallEnd()");
        this.f2340g = true;
        if (m2115l()) {
            if (this.f2336a == null) {
                this.f2336a = (Vibrator) MainApplication.mContext.getSystemService("vibrator");
            }
            this.f2336a.vibrate(500L);
        }
    }

    /* renamed from: g */
    public void m2128g() {
        ToneGenerator toneGenerator;
        try {
            toneGenerator = new ToneGenerator(0, 50);
        } catch (RuntimeException e) {
            m2109b("<CIH> Exception caught while creating ToneGenerator: " + e);
            toneGenerator = null;
        }
        if (this.f2345l == null) {
            this.f2345l = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (toneGenerator != null) {
            this.f2345l.getRingerMode();
            synchronized (this) {
                if (this.f2346m != 1) {
                    this.f2346m = 2;
                    toneGenerator.startTone(25);
                    try {
                        wait(2000);
                    } catch (InterruptedException e2) {
                        m2109b("InCallTonePlayer stopped: " + e2);
                    }
                    toneGenerator.stopTone();
                    toneGenerator.release();
                    this.f2346m = 0;
                } else {
                    toneGenerator.release();
                    this.f2346m = 0;
                }
            }
        }
    }
}
