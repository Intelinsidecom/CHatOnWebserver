package com.sec.chaton.chat.notification;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import com.sec.chaton.BootstrapActivity;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1066bf;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2251l;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p065io.entry.ApplinkMsgEntry;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.sstream.C4562a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChatONNotificationManager.java */
/* renamed from: com.sec.chaton.chat.notification.b */
/* loaded from: classes.dex */
public class C1813b {

    /* renamed from: b */
    public static C1810aq f6833b = null;

    /* renamed from: c */
    public static int f6834c = 1;

    /* renamed from: d */
    public static int f6835d = 2;

    /* renamed from: e */
    public static int f6836e = 3;

    /* renamed from: f */
    public static int f6837f = 4;

    /* renamed from: g */
    public static int f6838g = 10;

    /* renamed from: h */
    public static int f6839h = 11;

    /* renamed from: i */
    public static int f6840i = 12;

    /* renamed from: j */
    public static int f6841j = 13;

    /* renamed from: u */
    private static C1813b f6842u;

    /* renamed from: s */
    private int f6860s;

    /* renamed from: v */
    private MediaPlayer f6862v;

    /* renamed from: a */
    public final String f6851a = getClass().getSimpleName();

    /* renamed from: C */
    private boolean f6845C = false;

    /* renamed from: k */
    int f6852k = 1;

    /* renamed from: l */
    int f6853l = 2;

    /* renamed from: m */
    int f6854m = 4;

    /* renamed from: n */
    int f6855n = 8;

    /* renamed from: o */
    int f6856o = 16;

    /* renamed from: p */
    int f6857p = 32;

    /* renamed from: q */
    int f6858q = 64;

    /* renamed from: r */
    int f6859r = 128;

    /* renamed from: D */
    private final Object f6846D = new Object();

    /* renamed from: E */
    private final ArrayList<C1818g> f6847E = new ArrayList<>();

    /* renamed from: F */
    private final String f6848F = "camera_ready";

    /* renamed from: G */
    private final String f6849G = "access_control_enabled";

    /* renamed from: H */
    private final Handler f6850H = new HandlerC1814c(this, Looper.getMainLooper());

    /* renamed from: t */
    private final Context f6861t = CommonApplication.m18732r();

    /* renamed from: w */
    private final NotificationManager f6863w = (NotificationManager) this.f6861t.getSystemService("notification");

    /* renamed from: x */
    private final C4810ab f6864x = C4809aa.m18104a();

    /* renamed from: y */
    private ActivityManager f6865y = (ActivityManager) this.f6861t.getSystemService("activity");

    /* renamed from: z */
    private final KeyguardManager f6866z = (KeyguardManager) this.f6861t.getSystemService("keyguard");

    /* renamed from: A */
    private final PowerManager f6843A = (PowerManager) this.f6861t.getSystemService("power");

    /* renamed from: B */
    private final C1828q f6844B = C1828q.m8956a();

    /* renamed from: e */
    private void m8908e(String str) {
        StringBuilder sb = new StringBuilder(str);
        Iterator<C1818g> it = this.f6847E.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f6881a).append(",");
        }
        if (C4904y.f17873c) {
            C4904y.m18641c(sb.toString(), this.f6851a);
        }
    }

    /* renamed from: a */
    public boolean m8931a(String str) {
        boolean z;
        synchronized (this.f6846D) {
            if (this.f6847E.size() == 0 || TextUtils.isEmpty(str)) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i >= this.f6847E.size()) {
                    z = false;
                    break;
                }
                if (!str.equals(this.f6847E.get(i).f6881a)) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            m8908e("[isFrontInbox]");
            if (C4904y.f17873c) {
                C4904y.m18641c("[isFrontInbox] inboxNo:" + str + ", isFront:" + z, this.f6851a);
            }
            return z;
        }
    }

    /* renamed from: b */
    public int m8933b(String str) {
        int iM17247a;
        synchronized (this.f6846D) {
            if (this.f6847E.size() == 0 || TextUtils.isEmpty(str)) {
                iM17247a = EnumC4549n.LIVEINVALID.m17247a();
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.f6847E.size()) {
                        if (!this.f6847E.get(i2).f6881a.equals(str)) {
                            i = i2 + 1;
                        } else {
                            iM17247a = this.f6847E.get(i2).f6882b.m17247a();
                            break;
                        }
                    } else {
                        iM17247a = EnumC4549n.LIVEINVALID.m17247a();
                        break;
                    }
                }
            }
        }
        return iM17247a;
    }

    /* renamed from: a */
    public void m8924a(String str, EnumC4549n enumC4549n) {
        boolean z;
        synchronized (this.f6846D) {
            int i = 0;
            while (true) {
                if (i >= this.f6847E.size()) {
                    z = false;
                    break;
                } else if (!str.equals(this.f6847E.get(i).f6881a)) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.f6847E.add(new C1818g(this, str, enumC4549n));
                if (C4904y.f17873c) {
                    C4904y.m18641c("[addFrontInbox] Add front inbox. inboxNo:" + str + ", serviceType:" + enumC4549n, this.f6851a);
                }
                m8908e("[addFrontInbox]");
            }
        }
    }

    /* renamed from: c */
    public void m8937c(String str) {
        m8924a(str, EnumC4549n.LIVEINVALID);
    }

    /* renamed from: d */
    public void m8939d(String str) {
        synchronized (this.f6846D) {
            if (!TextUtils.isEmpty(str)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f6847E.size()) {
                        break;
                    }
                    if (!this.f6847E.get(i2).f6881a.equals(str)) {
                        i = i2 + 1;
                    } else {
                        if (C4904y.f17873c) {
                            C4904y.m18641c("[removeFrontInbox] Remove inboxNo:" + str, this.f6851a);
                        }
                        this.f6847E.remove(i2);
                        m8908e("[removeFrontInbox]");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m8930a() {
        return this.f6847E != null && this.f6847E.size() > 0;
    }

    private C1813b() {
    }

    /* renamed from: b */
    public static synchronized C1813b m8906b() {
        if (f6842u == null) {
            f6842u = new C1813b();
        }
        return f6842u;
    }

    /* renamed from: c */
    public void m8935c() {
        this.f6863w.cancelAll();
        if (C2349a.m10301a("main_icon_badge_feature")) {
            C4822an.m18210a(0);
            C4822an.m18222b(0);
            C4822an.m18200J();
        }
        new C4562a().m17260c(this.f6844B.m8973e());
    }

    /* renamed from: d */
    public void m8938d() {
        if (C4904y.f17873c) {
            C4904y.m18641c("clear msg noti only", this.f6851a);
        }
        this.f6844B.m8970b();
        this.f6863w.cancel(0);
        if (C2349a.m10301a("main_icon_badge_feature")) {
            C4822an.m18210a(0);
            C4822an.m18200J();
        }
        C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
        new C4562a().m17260c(null);
    }

    /* renamed from: e */
    public void m8940e() {
        this.f6863w.cancel(-1);
    }

    /* renamed from: a */
    public void m8917a(int i) {
        this.f6863w.cancel(i);
    }

    /* renamed from: l */
    private boolean m8909l() {
        return false;
    }

    /* renamed from: a */
    public void m8929a(String str, boolean z, boolean z2) {
        boolean z3 = true;
        boolean zM8941f = m8941f();
        boolean zM8909l = m8909l();
        boolean zM8912o = m8912o();
        try {
        } catch (Exception e) {
            C4904y.m18634a("process for the Interaction Control " + m8902a(this.f6861t), getClass().getSimpleName());
        }
        boolean z4 = Settings.System.getInt(GlobalApplication.m18732r().getContentResolver(), "access_control_enabled", 0) == 1;
        if (C4904y.f17873c) {
            C4904y.m18641c("isEnableNoti: true isWebNoti:" + z + ", isRecording:" + zM8941f + ", isBlockingMode:" + zM8912o + ", isCameraPreview:" + zM8909l + ", isInteractionControl" + z4 + ", isPopupOpen" + m8945j(), this.f6851a);
        }
        if ((this.f6864x.m18119a("Setting show blackscreen popup", (Boolean) true).booleanValue() && !zM8941f && !zM8912o && !z4 && !zM8909l) || z) {
            if (this.f6843A.isScreenOn() && !this.f6866z.inKeyguardRestrictedInputMode() && m8910m()) {
                C4904y.m18641c("keyguard off && foreground -> don't display popup", getClass().getSimpleName());
                return;
            }
            if (z) {
                Intent intent = new Intent(this.f6861t, (Class<?>) ScreenWebNotification.class);
                intent.putExtra("contents", str);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.addFlags(268435456);
                intent.addFlags(65536);
                this.f6861t.startActivity(intent);
                return;
            }
            if (this.f6843A.isScreenOn() && !m8945j() && this.f6864x.m18119a("Setting is simple popup", (Boolean) true).booleanValue()) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("Start screen notification Toast", this.f6851a);
                }
                this.f6844B.m8976h();
                int iM8974f = this.f6844B.m8974f();
                C1830s c1830sM8972d = this.f6844B.m8972d();
                this.f6844B.m8977i();
                if (iM8974f > 0 && c1830sM8972d != null) {
                    String str2 = new String(c1830sM8972d.f6928b);
                    String str3 = new String(c1830sM8972d.f6929c);
                    int iIntValue = new Integer(c1830sM8972d.f6933g).intValue();
                    boolean zBooleanValue = new Boolean(c1830sM8972d.f6941o).booleanValue();
                    int iIntValue2 = new Integer(c1830sM8972d.f6942p.m10212a()).intValue();
                    Message messageObtainMessage = this.f6850H.obtainMessage();
                    messageObtainMessage.obj = new C1817f(str2, str3, iIntValue, zBooleanValue, EnumC2301u.m10211a(iIntValue2));
                    this.f6850H.sendMessage(messageObtainMessage);
                    return;
                }
                if (C4904y.f17875e) {
                    C4904y.m18634a("[EXCEPTION] current unread count is zero. Do not display toast.", this.f6851a);
                    return;
                }
                return;
            }
            boolean zBooleanValue2 = this.f6864x.m18119a("Setting is use popup while screen off", (Boolean) true).booleanValue();
            if (!this.f6843A.isScreenOn() && !zBooleanValue2) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[showNotiPushPopup] isUsePopupWhileScreenOff:" + zBooleanValue2 + ", return", this.f6851a);
                    return;
                }
                return;
            }
            Intent intent2 = new Intent(this.f6861t, (Class<?>) ScreenNotification2.class);
            if (C4822an.m18237g(this.f6861t) || (this.f6843A.isScreenOn() && !this.f6866z.inKeyguardRestrictedInputMode())) {
                z3 = false;
            }
            intent2.putExtra(ScreenNotification2.f6726n, z3);
            intent2.addFlags(268435456);
            intent2.addFlags(65536);
            if (C4904y.f17873c) {
                C4904y.m18641c("Start screenNotification, isBlack:" + z3, this.f6851a);
            }
            this.f6861t.startActivity(intent2);
        }
    }

    /* renamed from: a */
    public void m8928a(String str, String str2, String str3, String str4, String str5, int i, long j, String str6, boolean z, long j2, boolean z2, boolean z3) throws IllegalStateException, Resources.NotFoundException, IOException, SecurityException, IllegalArgumentException {
        String string;
        String string2;
        EnumC2301u enumC2301u;
        if (C4904y.f17873c) {
            C4904y.m18641c("[composeAndShowNoti] receive message from SMS plugIn. msgID:" + j + ", isSMS:" + z3 + ", threadID" + str3, this.f6851a);
        }
        if (TextUtils.isEmpty(str)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[composeAndShowNoti] sender NO from SMS is null. Set buddy Name.", this.f6851a);
            }
            str = str6;
        }
        if (TextUtils.isEmpty(str)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[composeAndShowNoti] sender name from SMS is null. Set unknown.", this.f6851a);
            }
            string = CommonApplication.m18732r().getResources().getString(R.string.unknown);
        } else {
            string = str;
        }
        if (TextUtils.isEmpty(str2)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[composeAndShowNoti] message from SMS is null. Set no subject.", this.f6851a);
            }
            string2 = CommonApplication.m18732r().getResources().getString(R.string.no_subject);
        } else {
            string2 = str2;
        }
        if (z2) {
            enumC2301u = EnumC2301u.NORMAL;
        } else {
            enumC2301u = EnumC2301u.SMS;
        }
        m8927a(string, string2, str3, j, EnumC2214ab.TEXT, EnumC2300t.ONETOONE.m10210a(), str4, str6, z, j2, str5, i, 1, 0L, "N", enumC2301u, z3 ? C1828q.f6915c : C1828q.f6916d);
    }

    /* renamed from: a */
    public void m8925a(String str, String str2, long j, long j2, String str3, boolean z, long j3, boolean z2) throws IllegalStateException, Resources.NotFoundException, IOException, SecurityException, IllegalArgumentException {
        m8928a(str, str2, String.valueOf(j), "", "", 0, j2, str3, z, j3, false, z2);
    }

    /* renamed from: a */
    public void m8926a(String str, String str2, String str3, long j, EnumC2214ab enumC2214ab, int i, String str4, String str5, boolean z, long j2, String str6, int i2, int i3, long j3, String str7, EnumC2301u enumC2301u) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        m8927a(str, str2, str3, j, enumC2214ab, i, str4, str5, z, j2, str6, i2, i3, j3, str7, enumC2301u, C1828q.f6914b);
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0257  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8927a(java.lang.String r25, java.lang.String r26, java.lang.String r27, long r28, com.sec.chaton.p057e.EnumC2214ab r30, int r31, java.lang.String r32, java.lang.String r33, boolean r34, long r35, java.lang.String r37, int r38, int r39, long r40, java.lang.String r42, com.sec.chaton.p057e.EnumC2301u r43, int r44) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.notification.C1813b.m8927a(java.lang.String, java.lang.String, java.lang.String, long, com.sec.chaton.e.ab, int, java.lang.String, java.lang.String, boolean, long, java.lang.String, int, int, long, java.lang.String, com.sec.chaton.e.u, int):void");
    }

    /* renamed from: b */
    public void m8934b(int i) {
        m8920a(i, false, false);
    }

    /* renamed from: a */
    public void m8920a(int i, boolean z, boolean z2) {
        if (C4904y.f17873c) {
            C4904y.m18641c("[updateMessageNotificationFromDB] flag:" + i + ", isEnableNoti:" + z, this.f6851a);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[updateMessageNotificationFromDB] it is main thread. do notification update task, flag:" + i, this.f6851a);
            }
            C2212z.m10068a(new C2212z(), 0, new C2251l((InterfaceC2243d) null, i, z, z2));
        } else {
            if (C4904y.f17873c) {
                C4904y.m18641c("[updateMessageNotificationFromDB] it is not main thread. Call do notification update directly, flag:" + i, this.f6851a);
            }
            new C2251l((InterfaceC2243d) null, i, z, z2).mo8896a();
        }
    }

    /* renamed from: a */
    public void m8919a(int i, boolean z, String str, boolean z2, boolean z3) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        m8918a(i, z);
        ArrayList<C1830s> arrayListM8973e = this.f6844B.m8973e();
        if (arrayListM8973e == null || arrayListM8973e.size() == 0) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[showNotiPopupExternal] allMsgList size is 0", this.f6851a);
                return;
            }
            return;
        }
        if (C4822an.m18218a() && !z2) {
            new C4562a().m17258a(arrayListM8973e);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[showNotiPopupExternal] it is main thread. do 3rd app task", this.f6851a);
                }
                C2212z.m10068a(new C2212z(), 0, new C1793a(arrayListM8973e.get(0).f6931e, arrayListM8973e.get(0).f6927a, arrayListM8973e.get(0).f6933g, arrayListM8973e.get(0).f6940n, f6841j, arrayListM8973e.get(0).f6943q, null));
            } else {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[showNotiPopupExternal] it is not main thread. Call 3rd app directly", this.f6851a);
                }
                new C1793a(arrayListM8973e.get(0).f6931e, arrayListM8973e.get(0).f6927a, arrayListM8973e.get(0).f6933g, arrayListM8973e.get(0).f6940n, f6841j, arrayListM8973e.get(0).f6943q, null).mo8896a();
            }
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("isEnableNoti:" + z + ", notiFlag:" + i, this.f6851a);
        }
        if (i == f6836e) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Alert mute. Do not display push popup", this.f6851a);
                return;
            }
            return;
        }
        if (z || m8945j()) {
            if (C4822an.m18227c(GlobalApplication.m18732r())) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("It is on call", this.f6851a);
                }
                this.f6860s = Settings.System.getInt(GlobalApplication.m18732r().getContentResolver(), "alertoncall_mode", 1);
                if (this.f6860s == 0) {
                    C4904y.m18641c("[NOTI] ALERTONCALL_OFF", this.f6851a);
                } else {
                    m8911n();
                }
                SensorManager sensorManager = (SensorManager) GlobalApplication.m18732r().getSystemService("sensor");
                Sensor defaultSensor = sensorManager.getDefaultSensor(8);
                if (defaultSensor != null) {
                    if (z2) {
                        sensorManager.registerListener(new C1812as(str), defaultSensor, 0);
                        return;
                    } else {
                        sensorManager.registerListener(new C1812as(z3), defaultSensor, 0);
                        return;
                    }
                }
                return;
            }
            m8929a(str, z2, z3);
        }
    }

    /* renamed from: m */
    private boolean m8910m() {
        if (this.f6865y == null) {
            this.f6865y = (ActivityManager) this.f6861t.getSystemService("activity");
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.f6865y.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(this.f6861t.getPackageName())) {
                    String className = this.f6865y.getRunningTasks(1).get(0).topActivity.getClassName();
                    return className.startsWith(Config.CHATON_PACKAGE_NAME) && !className.equals(ScreenNotification2.class.getName());
                }
            }
        }
        return false;
    }

    /* renamed from: n */
    private void m8911n() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Uri actualDefaultRingtoneUri = null;
        String strM18121a = this.f6864x.m18121a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM18121a)) {
            if (!"Silent".equals(strM18121a)) {
                actualDefaultRingtoneUri = Uri.parse(strM18121a);
            }
        } else {
            actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f6861t, 2);
        }
        try {
            if (this.f6862v != null) {
                this.f6862v.release();
                this.f6862v = null;
            }
            this.f6862v = new MediaPlayer();
            this.f6862v.setAudioStreamType(0);
            this.f6862v.setDataSource(this.f6861t, actualDefaultRingtoneUri);
            this.f6862v.prepare();
            m8904a(this.f6862v);
            this.f6862v.start();
        } catch (Exception e) {
            C4904y.m18641c("makeAlertSound() cated Exception : " + e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m8904a(MediaPlayer mediaPlayer) {
        AudioManager audioManager;
        if (mediaPlayer != null && (audioManager = (AudioManager) this.f6861t.getSystemService("audio")) != null && audioManager.getStreamVolume(0) > 0.0f) {
            C4904y.m18641c("makeAlertSoundOnCall() - am.getStreamVolume() volume = 0.4", getClass().getSimpleName());
            mediaPlayer.setVolume(0.4f, 0.4f);
        }
    }

    /* renamed from: d */
    private boolean m8907d(int i) {
        if (i != EnumC2300t.WEB_AUTH.m10210a()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m8921a(Notification notification) {
        Uri actualDefaultRingtoneUri = null;
        String strM8946k = m8946k();
        if (strM8946k.equalsIgnoreCase("ALL") || strM8946k.equalsIgnoreCase("MELODY")) {
            if (!C4822an.m18245m() || !C4822an.m18246n()) {
                notification.sound = null;
            } else {
                String strM18121a = this.f6864x.m18121a("Ringtone", (String) null);
                if (!TextUtils.isEmpty(strM18121a)) {
                    if (!"Silent".equals(strM18121a)) {
                        actualDefaultRingtoneUri = Uri.parse(strM18121a);
                    }
                } else {
                    actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f6861t, 2);
                }
                notification.sound = actualDefaultRingtoneUri;
            }
            if (strM8946k.equalsIgnoreCase("ALL")) {
                notification.vibrate = new long[]{100, 1000, 1000};
            }
        } else if (strM8946k.equalsIgnoreCase("VIBRATION")) {
            notification.vibrate = new long[]{100, 1000, 1000};
            notification.sound = null;
        } else if (strM8946k.equalsIgnoreCase("OFF")) {
            notification.sound = null;
            notification.vibrate = null;
        }
        if (this.f6864x.m18119a("LED Indicator", (Boolean) true).booleanValue()) {
            notification.ledARGB = -368876;
            notification.ledOnMS = 500;
            notification.ledOffMS = 5000;
            notification.flags |= 1;
        }
    }

    /* renamed from: f */
    public boolean m8941f() {
        boolean zInKeyguardRestrictedInputMode;
        boolean zBooleanValue;
        AudioManager audioManager = (AudioManager) this.f6861t.getSystemService("audio");
        if (!this.f6864x.m18119a("Video Recording ON", (Boolean) false).booleanValue()) {
            return false;
        }
        try {
            zBooleanValue = ((Boolean) AudioManager.class.getMethod("isRecordActive", new Class[0]).invoke(audioManager, new Object[0])).booleanValue();
            try {
                C4904y.m18641c("isAudioRecording - " + zBooleanValue, getClass().getSimpleName());
                zInKeyguardRestrictedInputMode = this.f6866z.inKeyguardRestrictedInputMode();
                try {
                    C4904y.m18641c("KeyguardManager.inKeyguardRestrictedInputMode() - " + zInKeyguardRestrictedInputMode, getClass().getSimpleName());
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (NoSuchMethodException e3) {
                    C4904y.m18641c("[NOTI]NoSuchMethodException - isRecordActive mehtod is not available", getClass().getSimpleName());
                } catch (InvocationTargetException e4) {
                }
            } catch (IllegalAccessException e5) {
                zInKeyguardRestrictedInputMode = false;
            } catch (IllegalArgumentException e6) {
                zInKeyguardRestrictedInputMode = false;
            } catch (NoSuchMethodException e7) {
                zInKeyguardRestrictedInputMode = false;
            } catch (InvocationTargetException e8) {
                zInKeyguardRestrictedInputMode = false;
            }
        } catch (IllegalAccessException e9) {
            zInKeyguardRestrictedInputMode = false;
            zBooleanValue = false;
        } catch (IllegalArgumentException e10) {
            zInKeyguardRestrictedInputMode = false;
            zBooleanValue = false;
        } catch (NoSuchMethodException e11) {
            zInKeyguardRestrictedInputMode = false;
            zBooleanValue = false;
        } catch (InvocationTargetException e12) {
            zInKeyguardRestrictedInputMode = false;
            zBooleanValue = false;
        }
        return zBooleanValue && !zInKeyguardRestrictedInputMode;
    }

    /* renamed from: a */
    public void m8923a(String str, int i, boolean z, boolean z2) {
        if (C4904y.f17873c) {
            C4904y.m18641c("[NOTIPannel] ClearNoti. inbox No: " + str, this.f6851a);
        }
        this.f6844B.m8963a(str, z, z2);
        this.f6844B.m8976h();
        int iM8974f = this.f6844B.m8974f();
        ArrayList<C1830s> arrayListM8973e = this.f6844B.m8973e();
        this.f6844B.m8977i();
        if (C4822an.m18218a() && i != f6840i) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[clearNoti] it is main thread. do 3rd app task", this.f6851a);
                }
                C2212z.m10068a(new C2212z(), 0, new C1793a(str, i, null));
            } else {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[clearNoti] it is not main thread. Call 3rd app directly", this.f6851a);
                }
                new C1793a(str, i, null).mo8896a();
            }
        }
        if (iM8974f == 0) {
            if (C4904y.f17873c) {
                C4904y.m18641c("[ClearNoti] unread count is zero. Check DB to adjust.", this.f6851a);
            }
            m8906b().m8934b(f6835d);
            return;
        }
        this.f6863w.notify(0, m8905b(f6835d, false));
        if (C2349a.m10301a("main_icon_badge_feature")) {
            C4822an.m18210a(iM8974f);
            C4822an.m18200J();
        }
        new C4562a().m17259b(arrayListM8973e);
        C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
    }

    /* renamed from: a */
    public void m8922a(String str, int i) {
        m8923a(str, i, true, false);
    }

    /* renamed from: a */
    public static String m8902a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
    }

    /* renamed from: c */
    public void m8936c(int i) {
        m8918a(i, false);
    }

    /* renamed from: a */
    public void m8918a(int i, boolean z) {
        boolean zM8941f;
        Notification notificationM8913a;
        if (i == f6834c) {
            zM8941f = m8941f();
        } else {
            zM8941f = false;
        }
        this.f6844B.m8976h();
        int iM8974f = this.f6844B.m8974f();
        if (iM8974f == 0) {
            this.f6844B.m8977i();
            m8938d();
            return;
        }
        C1830s c1830sM8972d = this.f6844B.m8972d();
        String[] strArrM8971c = this.f6844B.m8971c();
        int length = strArrM8971c.length;
        ArrayList<C1830s> arrayListM8969b = this.f6844B.m8969b(7);
        int iM8975g = this.f6844B.m8975g();
        this.f6844B.m8977i();
        C1819h c1819hM8915a = m8915a(iM8974f, length, c1830sM8972d, strArrM8971c);
        if (Build.VERSION.SDK_INT < 11) {
            notificationM8913a = m8914a(i, c1819hM8915a, iM8975g, iM8974f, c1830sM8972d);
        } else {
            notificationM8913a = m8913a(i, c1819hM8915a, length, iM8975g, iM8974f, arrayListM8969b);
        }
        if (z) {
            if (i == f6836e) {
                notificationM8913a.sound = null;
                notificationM8913a.vibrate = null;
                if (C4904y.f17873c) {
                    C4904y.m18641c("[getNotification] It's on mute. sound:null, vibrate:null", this.f6851a);
                }
            } else {
                m8921a(notificationM8913a);
            }
        } else {
            notificationM8913a.sound = null;
            notificationM8913a.vibrate = null;
        }
        if (zM8941f) {
            notificationM8913a.sound = null;
            notificationM8913a.vibrate = null;
        }
        try {
            this.f6863w.notify(0, notificationM8913a);
        } catch (SecurityException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, this.f6851a);
            }
            notificationM8913a.defaults |= 2;
            this.f6863w.notify(0, notificationM8913a);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("[NotiPanel] Notify()", this.f6851a);
        }
        if (C2349a.m10301a("main_icon_badge_feature")) {
            C4822an.m18210a(iM8974f);
            C4822an.m18200J();
        }
    }

    /* renamed from: a */
    public Notification m8914a(int i, C1819h c1819h, int i2, int i3, C1830s c1830s) {
        String string;
        Notification notification;
        boolean z = !this.f6864x.m18119a("Setting show receive message", (Boolean) true).booleanValue() || this.f6864x.m18121a("OFF", "OFF").equals("ON");
        PendingIntent activity = PendingIntent.getActivity(CommonApplication.m18732r(), 0, m8900a(i2, c1830s), 268435456);
        if (i == f6835d) {
            notification = new Notification(R.drawable.chaton_quick_icon, null, c1830s.f6930d.longValue());
        } else {
            if (!z) {
                string = c1830s.f6928b + " : " + m8916a(c1830s.f6933g, c1830s.f6929c, c1830s.f6941o);
            } else {
                string = CommonApplication.m18732r().getString(R.string.new_chaton_messages, Integer.valueOf(i3));
            }
            notification = new Notification(R.drawable.chaton_quick_icon, string, c1830s.f6930d.longValue());
        }
        notification.setLatestEventInfo(CommonApplication.m18732r(), c1819h.f6884a, c1819h.f6885b, activity);
        return notification;
    }

    /* renamed from: b */
    private Notification m8905b(int i, boolean z) {
        boolean zM8941f;
        Notification notificationM8913a;
        if (i == f6834c) {
            zM8941f = m8941f();
        } else {
            zM8941f = false;
        }
        this.f6844B.m8976h();
        int iM8974f = this.f6844B.m8974f();
        C1830s c1830sM8972d = this.f6844B.m8972d();
        String[] strArrM8971c = this.f6844B.m8971c();
        int length = strArrM8971c.length;
        ArrayList<C1830s> arrayListM8969b = this.f6844B.m8969b(7);
        int iM8975g = this.f6844B.m8975g();
        this.f6844B.m8977i();
        C1819h c1819hM8915a = m8915a(iM8974f, length, c1830sM8972d, strArrM8971c);
        if (Build.VERSION.SDK_INT < 11) {
            notificationM8913a = m8914a(i, c1819hM8915a, iM8975g, iM8974f, c1830sM8972d);
        } else {
            notificationM8913a = m8913a(i, c1819hM8915a, length, iM8975g, iM8974f, arrayListM8969b);
        }
        if (z) {
            if (i == f6836e) {
                notificationM8913a.sound = null;
                notificationM8913a.vibrate = null;
                if (C4904y.f17873c) {
                    C4904y.m18641c("[getNotification] It's on mute. sound:null, vibrate:null", this.f6851a);
                }
            } else {
                m8921a(notificationM8913a);
            }
        } else {
            notificationM8913a.sound = null;
            notificationM8913a.vibrate = null;
        }
        if (zM8941f) {
            notificationM8913a.sound = null;
            notificationM8913a.vibrate = null;
        }
        return notificationM8913a;
    }

    /* renamed from: a */
    private Intent m8901a(String str, String str2) {
        Intent intentM2878a = BootstrapActivity.m2878a(CommonApplication.m18732r(), true);
        intentM2878a.setAction("com.sec.chaton.action.NOTI_WEB");
        intentM2878a.putExtra("callChatList", false);
        intentM2878a.putExtra("inboxNO", str);
        intentM2878a.putExtra("chatType", EnumC2300t.WEB_AUTH.m10210a());
        intentM2878a.putExtra("fromPush", 1);
        intentM2878a.putExtra("Content", str2);
        return intentM2878a;
    }

    /* renamed from: a */
    private Intent m8900a(int i, C1830s c1830s) {
        if (i == 1) {
            Intent intentM2921a = IntentControllerActivity.m2921a(CommonApplication.m18732r(), 1);
            intentM2921a.setAction("com.sec.chaton.action.NOTI_MESSAGE");
            intentM2921a.putExtra("callChatList", true);
            switch (C1815d.f6868a[EnumC2300t.m10207a(c1830s.f6932f).ordinal()]) {
                case 1:
                case 2:
                    intentM2921a.putExtra("inboxNO", c1830s.f6931e);
                    intentM2921a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                    if (!TextUtils.isEmpty(c1830s.f6935i)) {
                        intentM2921a.putExtra("sessionID", c1830s.f6935i);
                    }
                    intentM2921a.putExtra("fromPush", 1);
                    intentM2921a.putExtra("buddyNO", c1830s.f6927a);
                    intentM2921a.putExtra("roomType", c1830s.f6942p.m10212a());
                    intentM2921a.putExtra("msgContentType", c1830s.f6933g);
                    break;
                case 3:
                case 4:
                    intentM2921a.putExtra("inboxNO", c1830s.f6931e);
                    intentM2921a.putExtra("chatType", c1830s.f6932f);
                    if (!TextUtils.isEmpty(c1830s.f6935i)) {
                        intentM2921a.putExtra("sessionID", c1830s.f6935i);
                    }
                    intentM2921a.putExtra("fromPush", 1);
                    intentM2921a.putExtra("buddyNO", c1830s.f6927a);
                    break;
                case 5:
                    intentM2921a.putExtra("inboxNO", c1830s.f6931e);
                    intentM2921a.putExtra("chatType", EnumC2300t.BROADCAST2.m10210a());
                    if (!TextUtils.isEmpty(c1830s.f6935i)) {
                        intentM2921a.putExtra("sessionID", c1830s.f6935i);
                    }
                    intentM2921a.putExtra("fromPush", 1);
                    intentM2921a.putExtra("buddyNO", c1830s.f6927a);
                    break;
            }
            return intentM2921a;
        }
        Intent intentM2923a = IntentControllerActivity.m2923a(CommonApplication.m18732r(), true);
        intentM2923a.setAction("com.sec.chaton.action.NOTI_MESSAGE");
        intentM2923a.putExtra("callChatTab", true);
        return intentM2923a;
    }

    /* renamed from: a */
    private String m8903a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i != strArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public C1819h m8915a(int i, int i2, C1830s c1830s, String[] strArr) {
        String string;
        boolean z = !this.f6864x.m18119a("Setting show receive message", (Boolean) true).booleanValue() || this.f6864x.m18121a("OFF", "OFF").equals("ON");
        if (i == 1) {
            string = CommonApplication.m18732r().getString(R.string.new_1_message_dont_preview);
        } else {
            string = CommonApplication.m18732r().getString(R.string.new_chaton_messages, Integer.valueOf(i));
        }
        C1819h c1819h = new C1819h();
        c1819h.f6886c = c1830s.f6930d;
        if (c1819h.f6886c.longValue() <= 0) {
            c1819h.f6886c = Long.valueOf(System.currentTimeMillis());
        }
        if (z) {
            c1819h.f6884a = CommonApplication.m18732r().getString(R.string.app_name);
            c1819h.f6885b = string;
            return c1819h;
        }
        if (i2 > 1) {
            c1819h.f6884a = string;
            c1819h.f6885b = m8903a(strArr);
        } else if (i > 1) {
            c1819h.f6884a = string;
            c1819h.f6885b = c1830s.f6928b;
        } else {
            c1819h.f6884a = c1830s.f6928b;
            if (TextUtils.isEmpty(c1819h.f6884a)) {
                c1819h.f6884a = CommonApplication.m18732r().getString(R.string.unknown);
            }
            c1819h.f6885b = m8916a(c1830s.f6933g, c1830s.f6929c, c1830s.f6941o);
        }
        return c1819h;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public Notification m8913a(int i, C1819h c1819h, int i2, int i3, int i4, ArrayList<C1830s> arrayList) {
        String str;
        Bitmap bitmapM10785d;
        Bitmap bitmapDecodeResource;
        String string;
        Notification.Builder builder = new Notification.Builder(CommonApplication.m18732r());
        boolean z = !this.f6864x.m18119a("Setting show receive message", (Boolean) true).booleanValue() || this.f6864x.m18121a("OFF", "OFF").equals("ON");
        if (z) {
            if (i4 > 1) {
                string = CommonApplication.m18732r().getString(R.string.new_chaton_messages, Integer.valueOf(i4));
            } else {
                string = CommonApplication.m18732r().getString(R.string.new_1_message_dont_preview);
            }
            bitmapDecodeResource = BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), R.drawable.chaton_indicator_icon);
            str = string;
        } else {
            str = arrayList.get(0).f6928b + " : " + m8916a(arrayList.get(0).f6933g, arrayList.get(0).f6929c, arrayList.get(0).f6941o);
            if (i2 == 1) {
                try {
                    bitmapM10785d = C2496n.m10785d(this.f6861t, arrayList.get(0).f6927a);
                } catch (IOException e) {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("can not get profile image bitmap", this.f6851a);
                    }
                    bitmapM10785d = null;
                }
                if (bitmapM10785d == null || bitmapM10785d.isRecycled()) {
                    if (C4904y.f17873c) {
                        if (bitmapM10785d == null) {
                            C4904y.m18641c("profile image is null", this.f6851a);
                        } else if (bitmapM10785d.isRecycled()) {
                            C4904y.m18641c("profile image has been recycled", this.f6851a);
                        }
                    }
                    bitmapDecodeResource = BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), C2496n.m10751a());
                } else {
                    bitmapDecodeResource = bitmapM10785d;
                }
            } else {
                bitmapDecodeResource = BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), R.drawable.chaton_indicator_icon);
            }
        }
        builder.setContentTitle(c1819h.f6884a).setContentText(c1819h.f6885b).setWhen(c1819h.f6886c.longValue()).setLargeIcon(bitmapDecodeResource).setContentIntent(PendingIntent.getActivity(CommonApplication.m18732r(), 0, m8900a(i3, arrayList.get(0)), 268435456)).setNumber(0).setSmallIcon(R.drawable.chaton_quick_icon);
        if (i != f6835d) {
            builder.setTicker(str);
        }
        if (Build.VERSION.SDK_INT < 16) {
            return builder.getNotification();
        }
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle(builder);
        if (!z) {
            C1734gg.m8609a(arrayList, this.f6851a);
            if (i2 == 1) {
                if (TextUtils.isEmpty(arrayList.get(0).f6928b)) {
                    arrayList.get(0).f6928b = CommonApplication.m18732r().getString(R.string.unknown);
                }
                inboxStyle.setBigContentTitle(arrayList.get(0).f6928b);
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    C1830s c1830s = arrayList.get(i6);
                    inboxStyle.addLine(m8916a(c1830s.f6933g, c1830s.f6929c, c1830s.f6941o));
                    i5 = i6 + 1;
                }
            } else {
                inboxStyle.setBigContentTitle(c1819h.f6884a);
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= arrayList.size()) {
                        break;
                    }
                    C1830s c1830s2 = arrayList.get(i8);
                    if (TextUtils.isEmpty(c1830s2.f6928b)) {
                        c1830s2.f6928b = CommonApplication.m18732r().getString(R.string.unknown);
                    }
                    inboxStyle.addLine(c1830s2.f6928b + " : " + m8916a(c1830s2.f6933g, c1830s2.f6929c, c1830s2.f6941o));
                    i7 = i8 + 1;
                }
            }
            String string2 = "";
            int i9 = i4 - 7;
            if (i9 > 0) {
                string2 = i9 > 1 ? CommonApplication.m18732r().getResources().getString(R.string.more_messages, Integer.valueOf(i9)) : CommonApplication.m18732r().getString(R.string.one_more_message);
            }
            inboxStyle.setSummaryText(string2);
        } else {
            inboxStyle.addLine(c1819h.f6885b);
            inboxStyle.setSummaryText("");
        }
        return inboxStyle.build();
    }

    /* renamed from: a */
    public String m8916a(int i, String str, boolean z) {
        String string = "";
        switch (C1815d.f6869b[EnumC2214ab.m10070a(i).ordinal()]) {
            case 1:
                string = ApplinkMsgEntry.getDisplayMessage(str);
                break;
            case 2:
                if (C1736gi.m8652d(str)) {
                    str = str.substring(1);
                }
                string = str;
                break;
            case 3:
                if (z) {
                    string = CommonApplication.m18732r().getString(R.string.media_image_text);
                    break;
                } else {
                    string = CommonApplication.m18732r().getString(R.string.media_photo);
                    break;
                }
            case 4:
                if (z) {
                    string = CommonApplication.m18732r().getString(R.string.media_sticker_text);
                    break;
                } else {
                    string = CommonApplication.m18732r().getString(R.string.chat_stickers);
                    break;
                }
            case 5:
                if (z) {
                    string = CommonApplication.m18732r().getString(R.string.media_video_text);
                    break;
                } else {
                    string = CommonApplication.m18732r().getString(R.string.media_video);
                    break;
                }
            case 6:
                string = CommonApplication.m18732r().getString(R.string.media_map);
                break;
            case 7:
                string = CommonApplication.m18732r().getString(R.string.media_voice);
                break;
            case 8:
                string = CommonApplication.m18732r().getString(R.string.media_contact);
                break;
            case 9:
                string = CommonApplication.m18732r().getString(R.string.media_event);
                break;
            case 10:
            case 11:
                string = CommonApplication.m18732r().getString(R.string.media_file);
                break;
            case 12:
                string = CommonApplication.m18732r().getString(R.string.poll_title);
                break;
            case 13:
                if (z) {
                    string = CommonApplication.m18732r().getString(R.string.media_animessage_text);
                    break;
                } else {
                    string = CommonApplication.m18732r().getString(R.string.media_animessage);
                    break;
                }
            case 14:
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM17228a = C4542g.m17228a(str, true);
                if (specialBuddyShareContentsEntryM17228a != null) {
                    string = specialBuddyShareContentsEntryM17228a.title;
                    break;
                }
                break;
            case 15:
                SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM17234b = C4542g.m17234b(str, true);
                if (specialBuddyRecommendBuddyEntryM17234b != null) {
                    string = specialBuddyRecommendBuddyEntryM17234b.name;
                    break;
                }
                break;
            case 16:
                string = C4542g.m17242g(str);
                break;
            case 17:
                string = CommonApplication.m18732r().getString(R.string.glympse);
                break;
            case 18:
                string = CommonApplication.m18732r().getString(R.string.hugefile_large_file);
                break;
            default:
                string = CommonApplication.m18732r().getString(R.string.unknown);
                break;
        }
        if (string == null) {
            string = "";
        }
        if (string.length() > 100) {
            return string.substring(0, 100);
        }
        return string;
    }

    /* renamed from: o */
    private boolean m8912o() {
        if (Settings.System.getInt(this.f6861t.getContentResolver(), "dormant_switch_onoff", 0) == 1 && Settings.System.getInt(this.f6861t.getContentResolver(), "dormant_disable_notifications", 0) == 1) {
            if (Settings.System.getInt(this.f6861t.getContentResolver(), "dormant_always", 0) == 1) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(11);
            int i2 = calendar.get(12);
            int i3 = Settings.System.getInt(this.f6861t.getContentResolver(), "dormant_start_hour", 0);
            int i4 = Settings.System.getInt(this.f6861t.getContentResolver(), "dormant_start_min", 0);
            int i5 = Settings.System.getInt(this.f6861t.getContentResolver(), "dormant_end_hour", 0);
            int i6 = Settings.System.getInt(this.f6861t.getContentResolver(), "dormant_end_min", 0);
            C4904y.m18641c("[NOTI] Blocking mode set time , current hour: " + i + ", current minute: " + i2 + ", start hour: " + i3 + ", start minute: " + i4 + ", end hour: " + i5 + ", end minute: " + i6, getClass().getSimpleName());
            if (i3 > i5 || (i3 == i5 && i4 > i6)) {
                i5 += 24;
            }
            if (i3 < i || (i3 == i && i4 <= i2)) {
                if (i < i5) {
                    return true;
                }
                if (i == i5 && i2 < i6) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: g */
    public void m8942g() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm");
        if (C4809aa.m18104a().m18120a("Setting mute type", (Integer) 3).intValue() == 2 && C4809aa.m18104a().m18119a("Setting mute repeat", (Boolean) false).booleanValue()) {
            long jM18118a = C4809aa.m18104a().m18118a("Setting mute hour start Long", 0L) + 86400000;
            long jM18118a2 = C4809aa.m18104a().m18118a("Setting mute hour end Long", 0L) + 86400000;
            C4809aa.m18104a().m18124a("Setting mute hour start Long", Long.valueOf(jM18118a));
            C4809aa.m18104a().m18124a("Setting mute hour end Long", Long.valueOf(jM18118a2));
            if (C4904y.f17873c) {
                Calendar.getInstance().setTimeInMillis(jM18118a);
                StringBuilder sb = new StringBuilder();
                sb.append("extend >start : ").append(simpleDateFormat.format(new Date(jM18118a))).append(" >end : ").append(simpleDateFormat.format(new Date(jM18118a2)));
                C4904y.m18641c("[deregiMuteAlert] " + sb.toString(), this.f6851a);
                return;
            }
            return;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("[deregiMuteAlert] Deregi mute", this.f6851a);
        }
        C4809aa.m18104a().m18126b("Setting mute type", (Integer) 3);
        C4809aa.m18104a().m18123a("Setting mute hour start Long");
        C4809aa.m18104a().m18123a("Setting mute hour end Long");
        C4809aa.m18104a().m18123a("Setting mute repeat");
    }

    /* renamed from: h */
    public boolean m8943h() {
        return this.f6864x.m18119a("Setting Notification", (Boolean) true).booleanValue() && this.f6864x.m18119a("pref_setting_message_notification_on", (Boolean) true).booleanValue();
    }

    /* renamed from: i */
    public EnumC1816e m8944i() {
        EnumC1816e enumC1816e;
        EnumC1816e enumC1816e2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm");
        int iIntValue = C4809aa.m18104a().m18120a("Setting mute type", (Integer) 3).intValue();
        EnumC1816e enumC1816e3 = EnumC1816e.MUTE_OFF;
        if (iIntValue == 0) {
            long jM18118a = C4809aa.m18104a().m18118a("Setting mute hour end Long", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (C4904y.f17873c) {
                C4904y.m18641c("[isAlertMute] endTime :" + jM18118a + " curretTime:" + jCurrentTimeMillis, this.f6851a);
            }
            if (jCurrentTimeMillis <= jM18118a) {
                return EnumC1816e.MUTE_ON;
            }
            return EnumC1816e.MUTE_EXPIRED;
        }
        if (iIntValue == 1) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            long jM18118a2 = C4809aa.m18104a().m18118a("Setting mute hour end Long", 0L);
            if (jCurrentTimeMillis2 <= jM18118a2) {
                enumC1816e2 = EnumC1816e.MUTE_ON;
            } else {
                enumC1816e2 = EnumC1816e.MUTE_EXPIRED;
            }
            if (C4904y.f17873c) {
                StringBuilder sb = new StringBuilder();
                sb.append(">current : ").append(simpleDateFormat.format(new Date(jCurrentTimeMillis2))).append(" >end : ").append(simpleDateFormat.format(new Date(jM18118a2)));
                C4904y.m18641c("[isAlertMute] " + sb.toString() + ", ret :" + enumC1816e2, this.f6851a);
                return enumC1816e2;
            }
            return enumC1816e2;
        }
        if (iIntValue == 2) {
            long jM18118a3 = C4809aa.m18104a().m18118a("Setting mute hour start Long", 0L);
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            long jM18118a4 = C4809aa.m18104a().m18118a("Setting mute hour end Long", 0L);
            if (C4809aa.m18104a().m18119a("Setting mute repeat", (Boolean) false).booleanValue()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(jM18118a4);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(jCurrentTimeMillis3);
                if (calendar.get(1) == calendar2.get(1) && calendar.get(6) < calendar2.get(6)) {
                    int i = calendar2.get(6) - calendar.get(6);
                    jM18118a3 += 86400000 * i;
                    jM18118a4 += 86400000 * i;
                    if (C4904y.f17873c) {
                        C4904y.m18641c("[isAlertMute] increase end time by " + i + "startTime:" + jM18118a3 + ", endTime:" + jM18118a4, this.f6851a);
                    }
                    C4809aa.m18104a().m18124a("Setting mute hour start Long", Long.valueOf(jM18118a3));
                    C4809aa.m18104a().m18124a("Setting mute hour end Long", Long.valueOf(jM18118a4));
                }
            }
            long j = jM18118a4;
            long j2 = jM18118a3;
            if (j2 <= jCurrentTimeMillis3 && jCurrentTimeMillis3 <= j) {
                enumC1816e = EnumC1816e.MUTE_ON;
            } else if (j < jCurrentTimeMillis3) {
                enumC1816e = EnumC1816e.MUTE_EXPIRED;
            } else {
                enumC1816e = EnumC1816e.MUTE_OFF;
            }
            if (C4904y.f17873c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(">start : ").append(simpleDateFormat.format(new Date(j2))).append(" >current : ").append(simpleDateFormat.format(new Date(jCurrentTimeMillis3))).append(" >end : ").append(simpleDateFormat.format(new Date(j)));
                C4904y.m18641c("[isAlertMute] " + sb2.toString() + "ret:" + enumC1816e.m8947a(), this.f6851a);
                return enumC1816e;
            }
            return enumC1816e;
        }
        return enumC1816e3;
    }

    /* renamed from: j */
    public boolean m8945j() {
        return this.f6845C;
    }

    /* renamed from: a */
    public boolean m8932a(boolean z) {
        this.f6845C = z;
        return z;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: k */
    public String m8946k() {
        Vibrator vibrator;
        C4810ab c4810abM18104a = C4809aa.m18104a();
        String strM18121a = c4810abM18104a.m18121a("Set Type", "");
        if (TextUtils.isEmpty(strM18121a)) {
            c4810abM18104a.m18128b("Set Type", "ALL");
            if (Build.VERSION.SDK_INT <= 10 || ((vibrator = (Vibrator) CommonApplication.m18732r().getSystemService("vibrator")) != null && vibrator.hasVibrator())) {
                return "ALL";
            }
            c4810abM18104a.m18128b("Set Type", "MELODY");
            return "MELODY";
        }
        return strM18121a;
    }
}
