package com.sds.coolots.call;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.RingtoneInfo;
import com.sds.coolots.common.controller.CoolotsEventListener;
import com.sds.coolots.common.controller.audiopath.DrivingModeControllerInterface;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import java.io.IOException;

/* renamed from: com.sds.coolots.call.o */
/* loaded from: classes.dex */
public class HandlerC1227o extends Handler implements SoundManagerInterface {

    /* renamed from: M */
    private static final int f2815M = 1500;

    /* renamed from: N */
    private static final int f2816N = 2000;

    /* renamed from: P */
    private static final int f2817P = 80;

    /* renamed from: V */
    private static final int f2818V = 15;

    /* renamed from: a */
    public static final int f2819a = 3;

    /* renamed from: b */
    public static final int f2820b = 4;

    /* renamed from: c */
    public static final int f2821c = 5;

    /* renamed from: d */
    public static final int f2822d = 28;

    /* renamed from: e */
    private static final String f2823e = "[SoundManager]";

    /* renamed from: f */
    private static final int f2824f = 10;

    /* renamed from: g */
    private static final int f2825g = 11;

    /* renamed from: h */
    private static final int f2826h = 12;

    /* renamed from: i */
    private static final int f2827i = 13;

    /* renamed from: j */
    private static final int f2828j = 14;

    /* renamed from: k */
    private static final int f2829k = 15;

    /* renamed from: l */
    private static final int f2830l = 3000;

    /* renamed from: m */
    private static final int f2831m = 16;

    /* renamed from: n */
    private static final int f2832n = 300;

    /* renamed from: o */
    private static final int f2833o = 500;

    /* renamed from: p */
    private static final int f2834p = 500;

    /* renamed from: q */
    private static final int f2835q = 1;

    /* renamed from: r */
    private static final int f2836r = 2;

    /* renamed from: s */
    private static final int f2837s = 3;

    /* renamed from: t */
    private static final int f2838t = 4;

    /* renamed from: u */
    private static final int f2839u = MainApplication.mResources.getRawConnected();

    /* renamed from: v */
    private static final int f2840v = MainApplication.mResources.getRawDisconnected();

    /* renamed from: w */
    private static final int f2841w = MainApplication.mResources.getRawRingBackTone();

    /* renamed from: x */
    private static final int f2842x = MainApplication.mResources.getRawMusicOnHold();

    /* renamed from: y */
    private static final int f2843y = MainApplication.mResources.getRawRingtone();

    /* renamed from: L */
    private C1233u f2855L;

    /* renamed from: O */
    private volatile boolean f2856O;

    /* renamed from: Q */
    private C1134a f2857Q;

    /* renamed from: z */
    private final long[] f2862z = {0, 1000, 1000};

    /* renamed from: A */
    private final long[] f2844A = {0, 500, 0};

    /* renamed from: B */
    private AudioManager f2845B = null;

    /* renamed from: C */
    private Vibrator f2846C = null;

    /* renamed from: D */
    private MediaPlayer f2847D = null;

    /* renamed from: E */
    private MediaPlayer f2848E = null;

    /* renamed from: F */
    private MediaPlayer f2849F = null;

    /* renamed from: G */
    private MediaPlayer f2850G = null;

    /* renamed from: H */
    private MediaPlayer f2851H = null;

    /* renamed from: I */
    private ToneGenerator f2852I = null;

    /* renamed from: J */
    private ChangeRingtoneInterface f2853J = null;

    /* renamed from: K */
    private RingtoneInfo f2854K = null;

    /* renamed from: R */
    private boolean f2858R = true;

    /* renamed from: S */
    private boolean f2859S = false;

    /* renamed from: T */
    private boolean f2860T = true;

    /* renamed from: U */
    private DrivingModeControllerInterface f2861U = null;

    public HandlerC1227o() throws Throwable {
        m2774k();
    }

    /* renamed from: A */
    private boolean m2755A() {
        if (this.f2845B == null) {
            this.f2845B = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        return this.f2845B.shouldVibrate(0);
    }

    /* renamed from: B */
    private void m2756B() {
        if (this.f2846C == null) {
            this.f2846C = (Vibrator) MainApplication.mContext.getSystemService("vibrator");
        }
        this.f2846C.vibrate(new long[]{0, 20, 30, 20, 30, 20, 30, 20, 30, 20, 30, 20, 30, 20, 30, 20, 30, 20, 30, 20, 30}, -1);
    }

    /* renamed from: C */
    private void m2757C() {
        if (this.f2861U == null) {
            this.f2861U = MainApplication.mNativeInterfaceCreator.createDrivingModeController();
        }
    }

    /* renamed from: D */
    private boolean m2758D() {
        m2757C();
        return this.f2861U.isDrivingMode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0042 A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0018, B:9:0x001f, B:10:0x003f, B:11:0x0042, B:16:0x005c, B:18:0x0062, B:20:0x0068, B:21:0x006e, B:23:0x0078, B:24:0x0083, B:25:0x0089, B:27:0x008d, B:29:0x0093, B:31:0x0099, B:32:0x009e, B:34:0x00a2, B:39:0x00b1, B:41:0x00b7, B:36:0x00a6, B:38:0x00ac, B:42:0x00bb, B:44:0x00c7, B:45:0x00cc, B:47:0x00d7, B:50:0x00e2, B:53:0x00f0), top: B:55:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7 A[Catch: all -> 0x0059, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0018, B:9:0x001f, B:10:0x003f, B:11:0x0042, B:16:0x005c, B:18:0x0062, B:20:0x0068, B:21:0x006e, B:23:0x0078, B:24:0x0083, B:25:0x0089, B:27:0x008d, B:29:0x0093, B:31:0x0099, B:32:0x009e, B:34:0x00a2, B:39:0x00b1, B:41:0x00b7, B:36:0x00a6, B:38:0x00ac, B:42:0x00bb, B:44:0x00c7, B:45:0x00cc, B:47:0x00d7, B:50:0x00e2, B:53:0x00f0), top: B:55:0x0006 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void m2760a(int r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sds.coolots.call.HandlerC1227o.m2760a(int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2763a(String str) {
        Log.m2958e(f2823e + str);
    }

    /* renamed from: b */
    private void m2764b(String str) {
        Log.m2963i(f2823e + str);
    }

    /* renamed from: k */
    private void m2774k() throws Throwable {
        this.f2860T = MainApplication.mConfig.isPlayRingBackTone();
        this.f2858R = MainApplication.mConfig.isPlayRingTone();
        if (this.f2845B == null) {
            this.f2845B = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this.f2846C == null) {
            this.f2846C = (Vibrator) MainApplication.mContext.getSystemService("vibrator");
        }
        this.f2857Q = new C1134a();
        this.f2853J = ChangeRingtone.getChangeRingtone();
        m2777m();
        m2776l();
        m2780p();
        m2781q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m2776l() throws Throwable {
        if (!this.f2860T || f2841w == 0) {
            return;
        }
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                this.f2849F = new MediaPlayer();
                this.f2849F.setAudioStreamType(0);
                this.f2849F.setLooping(true);
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = MainApplication.mContext.getResources().openRawResourceFd(f2841w);
                try {
                    this.f2849F.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                    this.f2849F.setOnErrorListener(new C1228p(this));
                    if (assetFileDescriptorOpenRawResourceFd != null) {
                        try {
                            assetFileDescriptorOpenRawResourceFd.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    e.printStackTrace();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m2777m() throws Throwable {
        if (f2839u == 0) {
            return;
        }
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                this.f2850G = new MediaPlayer();
                this.f2850G.setAudioStreamType(0);
                this.f2850G.setLooping(false);
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = MainApplication.mContext.getResources().openRawResourceFd(f2839u);
                try {
                    this.f2850G.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                    this.f2850G.setOnErrorListener(new C1229q(this));
                    if (assetFileDescriptorOpenRawResourceFd != null) {
                        try {
                            assetFileDescriptorOpenRawResourceFd.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    e.printStackTrace();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m2778n() throws Throwable {
        if (f2840v == 0) {
            return;
        }
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                this.f2851H = new MediaPlayer();
                this.f2851H.setAudioStreamType(0);
                this.f2851H.setLooping(false);
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = MainApplication.mContext.getResources().openRawResourceFd(f2840v);
                try {
                    this.f2851H.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                    this.f2851H.setOnErrorListener(new C1230r(this));
                    if (assetFileDescriptorOpenRawResourceFd != null) {
                        try {
                            assetFileDescriptorOpenRawResourceFd.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    e.printStackTrace();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* renamed from: o */
    private void m2779o() {
        this.f2854K = new RingtoneInfo(MainApplication.mRingtoneSettingData.getRingtoneFromSettingData());
        if (this.f2854K.getIndex() == -1) {
            this.f2859S = true;
        } else {
            this.f2859S = false;
        }
    }

    /* renamed from: p */
    private void m2780p() {
        m2764b("initRingTone()");
        if (this.f2858R) {
            if (this.f2847D != null) {
                this.f2847D.release();
            }
            if (f2843y != 0) {
                m2779o();
                m2764b("RingtoneType : " + this.f2854K.getType() + ", isSilent : " + this.f2859S);
                this.f2847D = new MediaPlayer();
                switch (this.f2854K.getType()) {
                    case 1:
                        this.f2847D = this.f2853J.setDeviceDefaultRingtone(this.f2847D);
                        break;
                    case 2:
                        this.f2847D = this.f2853J.setChatONVDefaultRingtone(this.f2847D);
                        break;
                    case 3:
                        this.f2847D = this.f2853J.setUserSelectedRingtone(this.f2854K.getIndex(), this.f2847D);
                        break;
                    case 4:
                        this.f2847D = this.f2853J.setUserPersonalRingtone(this.f2854K.getPath(), this.f2847D);
                        break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m2781q() throws Throwable {
        if (f2842x == 0) {
            return;
        }
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            try {
                this.f2848E = new MediaPlayer();
                this.f2848E.setAudioStreamType(0);
                this.f2848E.setLooping(true);
                AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = MainApplication.mContext.getResources().openRawResourceFd(f2842x);
                try {
                    this.f2848E.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                    this.f2848E.setOnErrorListener(new C1231s(this));
                    if (assetFileDescriptorOpenRawResourceFd != null) {
                        try {
                            assetFileDescriptorOpenRawResourceFd.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    e.printStackTrace();
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
                    if (assetFileDescriptor != null) {
                        try {
                            assetFileDescriptor.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* renamed from: r */
    private boolean m2782r() throws IllegalStateException, IOException {
        m2764b("playConnectTone()");
        if (f2839u == 0 || this.f2850G == null) {
            return false;
        }
        try {
            this.f2850G.prepare();
            this.f2850G.seekTo(0);
            this.f2850G.start();
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: s */
    private boolean m2783s() throws IllegalStateException, IOException {
        m2764b("playDisconnectTone()");
        if (f2840v == 0 || this.f2851H == null) {
            return false;
        }
        try {
            this.f2851H.prepare();
            this.f2851H.seekTo(0);
            this.f2851H.start();
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: t */
    private boolean m2784t() throws IllegalStateException, IOException {
        m2764b("playRingbacktone()");
        if (f2841w == 0 || this.f2849F == null) {
            return false;
        }
        try {
            this.f2849F.prepare();
            this.f2849F.seekTo(0);
            this.f2849F.start();
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: u */
    private void m2785u() throws Throwable {
        m2764b("playHoldTone()");
        if (f2842x == 0 || m2786v()) {
            return;
        }
        if (this.f2848E != null) {
            this.f2848E.reset();
        }
        m2781q();
        m2786v();
    }

    /* renamed from: v */
    private boolean m2786v() throws IllegalStateException, IOException {
        m2764b("playHoldtone()");
        if (f2842x == 0 || this.f2848E == null) {
            return false;
        }
        try {
            this.f2848E.prepare();
            this.f2848E.seekTo(0);
            this.f2848E.start();
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: w */
    private void m2787w() throws IllegalStateException, IOException {
        m2764b("playRingStream()");
        if (!this.f2858R) {
            CoolotsEventListener coolotsEventListener = MainApplication.mPhoneManager.getCoolotsEventListener();
            if (coolotsEventListener != null) {
                Message message = new Message();
                message.what = EventCode.EVENT_CALL_RINGTONE_PLAY;
                coolotsEventListener.onCallEvent(message);
                return;
            }
            return;
        }
        int ringerMode = this.f2845B.getRingerMode();
        boolean zIsVibrateWhenRinging = MainApplication.mNativeSetting.isVibrateWhenRinging();
        m2764b("ringerMode: " + ringerMode);
        m2764b("isVibrateWhenRinging: " + zIsVibrateWhenRinging);
        if (ringerMode == 2) {
            m2764b("(1)AudioManager.RINGER_MODE_NORMAL");
            m2790z();
            if (zIsVibrateWhenRinging && !m2801j()) {
                m2764b("Vibration When Ringing is ON");
                m2789y();
            }
        } else if (ringerMode == 1) {
            m2764b("(3)AudioManager.RINGER_MODE_VIBRATE");
            if (m2758D()) {
                return;
            }
            m2779o();
            m2764b("(4)AudioManager.VIBRATE_SETTING_ON");
            m2788x();
        }
        if (ringerMode != 0) {
            sendEmptyMessageDelayed(15, 3000L);
        }
    }

    /* renamed from: x */
    private void m2788x() {
        if (m2755A() && this.f2855L == null) {
            this.f2856O = true;
            this.f2855L = new C1233u(this, null);
            this.f2855L.start();
        }
    }

    /* renamed from: y */
    private void m2789y() {
        if (this.f2855L == null) {
            this.f2856O = true;
            this.f2855L = new C1233u(this, null);
            this.f2855L.start();
        }
    }

    /* renamed from: z */
    private void m2790z() throws IllegalStateException, IOException {
        m2764b("_playRingStream");
        m2780p();
        if (this.f2847D != null) {
            try {
                if (this.f2859S) {
                    m2763a("ringtoneStream - ChatON V Ringtone Setting : silent");
                } else {
                    this.f2847D.prepare();
                    this.f2847D.seekTo(0);
                    this.f2847D.start();
                }
            } catch (IllegalStateException e) {
                this.f2846C.vibrate(this.f2862z, 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m2791a() throws Throwable {
        if (this.f2857Q.m2125d()) {
            if (m2783s()) {
                SystemClock.sleep(500L);
            } else {
                if (this.f2851H != null) {
                    this.f2851H.reset();
                }
                m2778n();
                m2783s();
                SystemClock.sleep(500L);
            }
        }
        this.f2857Q.m2127f();
        this.f2857Q.m2124c();
    }

    /* renamed from: a */
    public boolean m2792a(Context context) {
        if (this.f2845B == null) {
            this.f2845B = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        return this.f2845B.isWiredHeadsetOn();
    }

    /* renamed from: b */
    public void m2793b() {
        if (Build.VERSION.SDK_INT > 15) {
            m2760a(0, false);
            if (this.f2845B == null) {
                this.f2845B = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            this.f2845B.abandonAudioFocus(null);
        }
    }

    /* renamed from: c */
    public void m2794c() throws Throwable {
        this.f2845B.setSpeakerphoneOn(false);
        stopRingBackTone();
        m2795d();
        stopRingStream();
        this.f2857Q.m2124c();
        m2760a(0, false);
    }

    /* renamed from: d */
    public void m2795d() throws Throwable {
        m2764b("stopHoldTone()");
        if (f2842x == 0 || this.f2848E == null) {
            return;
        }
        try {
            if (this.f2848E.isPlaying()) {
                this.f2848E.stop();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            this.f2848E.release();
            this.f2848E = null;
            m2781q();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m2796e() {
        int ringerMode = this.f2845B.getRingerMode();
        int vibrateSetting = this.f2845B.getVibrateSetting(0);
        if (ringerMode == 1 || ringerMode == 0 || (ringerMode == 2 && vibrateSetting == 1)) {
            new C1232t(this, 22).start();
        }
    }

    /* renamed from: f */
    public void m2797f() {
        removeMessages(28);
        if (this.f2852I != null) {
            try {
                this.f2852I.stopTone();
                this.f2852I.release();
                this.f2852I = null;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    this.f2852I.release();
                    this.f2852I = null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f2852I = null;
                }
            }
        }
    }

    /* renamed from: g */
    public void m2798g() {
        if (this.f2846C != null) {
            this.f2846C.vibrate(this.f2862z, -1);
        }
    }

    /* renamed from: h */
    public void m2799h() throws Throwable {
        stopRingBackTone();
        m2795d();
        stopRingStream();
        m2760a(0, false);
        setSpeakerPhone(false);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        switch (message.what) {
            case 10:
                m2760a(2, false);
                break;
            case 11:
                m2760a(2, true);
                break;
            case 12:
                m2787w();
                break;
            case 13:
                if (!m2784t()) {
                    if (this.f2849F != null) {
                        this.f2849F.reset();
                    }
                    m2776l();
                    m2784t();
                    break;
                }
                break;
            case 14:
                m2760a(2, ((Boolean) message.obj).booleanValue());
                break;
            case 15:
                if (MainApplication.mPhoneManager.getTTSManager() != null) {
                    MainApplication.mPhoneManager.getTTSManager().startTTS();
                    break;
                }
                break;
            case 16:
                if (!m2782r()) {
                    if (this.f2850G != null) {
                        this.f2850G.reset();
                    }
                    m2777m();
                    m2782r();
                }
                sendEmptyMessageDelayed(13, 500L);
                break;
            case 28:
                m2796e();
                break;
        }
        super.handleMessage(message);
    }

    /* renamed from: i */
    public void m2800i() throws Throwable {
        m2799h();
        if (this.f2849F != null) {
            this.f2849F.release();
        }
        if (this.f2848E != null) {
            this.f2848E.release();
        }
        if (this.f2847D != null) {
            this.f2847D.release();
        }
        if (this.f2852I != null) {
            this.f2852I.release();
            this.f2852I = null;
        }
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public boolean isSpeakerOn(Context context) {
        if (this.f2845B == null) {
            this.f2845B = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        return this.f2845B.isSpeakerphoneOn();
    }

    /* renamed from: j */
    public boolean m2801j() {
        m2757C();
        return this.f2861U.isDrivingModeUI();
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void playRingBackTone() {
        m2764b("playRingBackTone()");
        if (this.f2857Q.m2122a()) {
            sendEmptyMessageDelayed(16, 500L);
        } else {
            sendEmptyMessageDelayed(13, 500L);
        }
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void restoreSpeakerFor3G() {
        this.f2845B.setSpeakerphoneOn(false);
        EngineInterface.getInstance().speakerOn(false);
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeBusy() throws Throwable {
        m2764b("setMode_busy()");
        setModeDisconnected(false);
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeCalling(boolean z, boolean z2) {
        m2764b("setMode_calling");
        if (z) {
            Message message = new Message();
            message.what = 14;
            message.obj = Boolean.valueOf(z2);
            sendMessageDelayed(message, 300L);
        } else {
            m2760a(1, z2);
            sendEmptyMessageDelayed(12, 300L);
        }
        this.f2857Q.m2121a(true, z);
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeConnected(boolean z) throws Throwable {
        m2764b("SoundManager setMode_connected()");
        stopRingBackTone();
        stopRingStream();
        if (z) {
            sendEmptyMessageDelayed(11, 300L);
        } else {
            sendEmptyMessageDelayed(10, 300L);
        }
        this.f2857Q.m2120a(true);
        this.f2857Q.m2123b();
        this.f2857Q.m2126e();
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeConnectedFor3GIdleMode(boolean z) throws Throwable {
        m2764b("SoundManager setModeConnectedFor3GIdleMode()");
        stopRingBackTone();
        stopRingStream();
        m2760a(2, z);
        this.f2857Q.m2123b();
        this.f2857Q.m2126e();
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeDisconnected(boolean z) throws Throwable {
        m2763a("setMode_disconnected()");
        removeMessages(12);
        stopAllStream();
        m2760a(0, false);
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeError(boolean z) throws Throwable {
        m2764b("setMode_error()");
        setModeDisconnected(z);
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeForMinuteMinder(boolean z) throws Throwable {
        m2764b("SoundManager setModeForMinuteMinder()");
        stopRingBackTone();
        stopRingStream();
        m2760a(2, z);
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeStartHold() throws Throwable {
        m2764b("setMode_starthold");
        m2785u();
    }

    @Override // com.sds.coolots.call.SetModeInterface
    public void setModeStopHold(boolean z) throws Throwable {
        m2764b("setMode_stophold");
        m2795d();
        m2760a(2, z);
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void setSpeakerPhone(boolean z) {
        Log.m2954d("setSpeakerPhone(" + z + ") : mAudioManager.isSpeakerphoneOn()" + this.f2845B.isSpeakerphoneOn());
        if (MainApplication.mPhoneManager.getClientType() == 2) {
            Log.m2954d("setSpeakerPhone in audiochat (" + z + ")");
            this.f2845B.setSpeakerphoneOn(z);
            EngineInterface.getInstance().speakerOn(z);
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
            return;
        }
        if (z && !this.f2845B.isSpeakerphoneOn()) {
            Log.m2954d("setSpeakerPhone true");
            this.f2845B.setSpeakerphoneOn(true);
            EngineInterface.getInstance().speakerOn(true);
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
            return;
        }
        if (z || !this.f2845B.isSpeakerphoneOn()) {
            return;
        }
        Log.m2954d("setSpeakerPhone false");
        this.f2845B.setSpeakerphoneOn(false);
        EngineInterface.getInstance().speakerOn(false);
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isActiveShareScreen() == 1 || MainApplication.mPhoneManager.getPhoneStateMachine().isActiveShareScreen() == 3) {
            return;
        }
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForProximity();
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void setSpeakerPhoneModeSwitching() {
        if (!this.f2845B.isSpeakerphoneOn()) {
            this.f2845B.setSpeakerphoneOn(true);
            EngineInterface.getInstance().speakerOn(true);
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
        } else if (this.f2845B.isSpeakerphoneOn()) {
            this.f2845B.setSpeakerphoneOn(false);
            EngineInterface.getInstance().speakerOn(false);
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForProximity();
        }
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void simpleVibrate() {
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            m2756B();
            return;
        }
        if (this.f2846C == null) {
            this.f2846C = (Vibrator) MainApplication.mContext.getSystemService("vibrator");
        }
        this.f2846C.vibrate(1000L);
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void startPeriodicCallWaitingTone() {
        Message message = new Message();
        message.what = 28;
        sendMessage(message);
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void stopAllStream() throws Throwable {
        stopRingBackTone();
        m2795d();
        stopRingStream();
        m2791a();
        setSpeakerPhone(false);
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void stopPeriodicCallWaitingTone() {
        m2797f();
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void stopRingBackTone() throws Throwable {
        m2764b("stopRingBackTone()");
        if (!this.f2860T) {
            if (MainApplication.mPhoneManager.getCoolotsEventListener() != null) {
                Message message = new Message();
                message.what = EventCode.EVENT_CALL_RINGBACK_STOP;
                MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(message);
                return;
            }
            return;
        }
        removeMessages(13);
        if (this.f2849F != null) {
            try {
                if (this.f2849F.isPlaying()) {
                    this.f2849F.stop();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
                this.f2849F.release();
                this.f2849F = null;
                m2776l();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.sds.coolots.call.SoundManagerInterface
    public void stopRingStream() throws IllegalStateException {
        m2764b("stopRingStream()");
        m2797f();
        if (!this.f2858R) {
            CoolotsEventListener coolotsEventListener = MainApplication.mPhoneManager.getCoolotsEventListener();
            if (coolotsEventListener != null) {
                Message message = new Message();
                message.what = EventCode.EVENT_CALL_RINGTONE_STOP;
                coolotsEventListener.onCallEvent(message);
                return;
            }
            return;
        }
        if (this.f2847D != null) {
            try {
                if (this.f2847D.isPlaying()) {
                    this.f2847D.stop();
                    this.f2847D.release();
                    this.f2847D = null;
                    m2780p();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (this.f2847D != null) {
                    try {
                        this.f2847D.release();
                        this.f2847D = null;
                        m2780p();
                    } catch (Exception e2) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (this.f2855L != null) {
            this.f2856O = false;
            this.f2855L = null;
        }
        try {
            if (this.f2846C != null) {
                this.f2846C.cancel();
            }
        } catch (Exception e4) {
            m2763a("stopRingStream : Exception occured during canceling mVibrator");
            e4.printStackTrace();
        }
        removeMessages(15);
        if (MainApplication.mPhoneManager.getTTSManager() != null) {
            MainApplication.mPhoneManager.getTTSManager().stopTTS();
        }
    }
}
