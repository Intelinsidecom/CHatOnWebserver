package com.sec.chaton.chat.notification;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1072en;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1435c;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1421l;
import com.sec.chaton.p035io.entry.ApplinkMsgEntry;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyRecommendBuddyEntry;
import com.sec.chaton.p035io.entry.specialbuddy.SpecialBuddyShareContentsEntry;
import com.sec.chaton.specialbuddy.C2930k;
import com.sec.chaton.sstream.C2946a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import twitter4j.Query;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ChatONNotificationManager.java */
/* renamed from: com.sec.chaton.chat.notification.a */
/* loaded from: classes.dex */
public class C1103a {

    /* renamed from: b */
    public static C1130z f4440b = null;

    /* renamed from: c */
    public static int f4441c = 1;

    /* renamed from: d */
    public static int f4442d = 2;

    /* renamed from: e */
    public static int f4443e = 3;

    /* renamed from: f */
    public static int f4444f = 4;

    /* renamed from: g */
    public static int f4445g = 10;

    /* renamed from: h */
    public static int f4446h = 11;

    /* renamed from: i */
    public static int f4447i = 12;

    /* renamed from: x */
    private static C1103a f4448x;

    /* renamed from: j */
    public HashMap<String, C1113i> f4460j;

    /* renamed from: k */
    public ArrayList<C1109e> f4461k;

    /* renamed from: l */
    public ArrayList<C1111g> f4462l;

    /* renamed from: v */
    private int f4472v;

    /* renamed from: y */
    private MediaPlayer f4474y;

    /* renamed from: a */
    public final String f4459a = getClass().getSimpleName();

    /* renamed from: E */
    private boolean f4453E = false;

    /* renamed from: m */
    public int f4463m = 0;

    /* renamed from: n */
    int f4464n = 1;

    /* renamed from: o */
    int f4465o = 2;

    /* renamed from: p */
    int f4466p = 4;

    /* renamed from: q */
    int f4467q = 8;

    /* renamed from: r */
    int f4468r = 16;

    /* renamed from: s */
    int f4469s = 32;

    /* renamed from: t */
    int f4470t = 64;

    /* renamed from: u */
    int f4471u = 128;

    /* renamed from: F */
    private Object f4454F = new Object();

    /* renamed from: G */
    private ArrayList<String> f4455G = new ArrayList<>();

    /* renamed from: H */
    private final String f4456H = "camera_ready";

    /* renamed from: I */
    private final String f4457I = "access_control_enabled";

    /* renamed from: J */
    private Handler f4458J = new HandlerC1106b(this, Looper.getMainLooper());

    /* renamed from: w */
    private Context f4473w = CommonApplication.m11493l();

    /* renamed from: z */
    private NotificationManager f4475z = (NotificationManager) this.f4473w.getSystemService("notification");

    /* renamed from: A */
    private C3160ab f4449A = C3159aa.m10962a();

    /* renamed from: B */
    private ActivityManager f4450B = (ActivityManager) this.f4473w.getSystemService("activity");

    /* renamed from: C */
    private KeyguardManager f4451C = (KeyguardManager) this.f4473w.getSystemService("keyguard");

    /* renamed from: D */
    private PowerManager f4452D = (PowerManager) this.f4473w.getSystemService("power");

    /* renamed from: a */
    public boolean m5458a(String str) {
        boolean zContains;
        synchronized (this.f4454F) {
            zContains = (this.f4455G.size() == 0 || TextUtils.isEmpty(str)) ? false : this.f4455G.contains(str);
        }
        return zContains;
    }

    /* renamed from: b */
    public void m5462b(String str) {
        synchronized (this.f4454F) {
            if (!this.f4455G.contains(str)) {
                this.f4455G.add(str);
            }
        }
    }

    /* renamed from: c */
    public void m5464c(String str) {
        synchronized (this.f4454F) {
            this.f4455G.remove(str);
        }
    }

    private C1103a(Context context) {
        m5471f();
    }

    /* renamed from: a */
    public static synchronized C1103a m5432a(Context context) {
        if (f4448x == null) {
            f4448x = new C1103a(context);
        }
        return f4448x;
    }

    /* renamed from: a */
    public void m5450a() {
        this.f4475z.cancelAll();
    }

    /* renamed from: j */
    private void m5442j() {
        this.f4475z.cancel(0);
    }

    /* renamed from: b */
    public void m5460b() {
        this.f4475z.cancel(-1);
    }

    /* renamed from: a */
    public void m5451a(int i) {
        this.f4475z.cancel(i);
    }

    /* renamed from: a */
    public void m5456a(String str, boolean z, boolean z2) {
        boolean z3;
        boolean zM5465c = m5465c();
        boolean zM5446n = m5446n();
        try {
        } catch (Exception e) {
            C3250y.m11442a("process for the Galaxy camera " + m5438b(this.f4473w), getClass().getSimpleName());
        }
        if (Settings.System.getInt(CommonApplication.m11493l().getContentResolver(), "camera_ready") == 1 && (m5438b(this.f4473w).equals("com.sec.android.app.camera.Camera") || m5438b(this.f4473w).equals("com.sec.android.app.camera.Camcorder"))) {
            C3250y.m11442a("[NOTI] Galaxy camera exception. getClassName : " + m5438b(this.f4473w), getClass().getSimpleName());
            z3 = true;
        } else {
            z3 = false;
        }
        try {
        } catch (Exception e2) {
            C3250y.m11442a("process for the Interaction Control " + m5438b(this.f4473w), getClass().getSimpleName());
        }
        boolean z4 = Settings.System.getInt(GlobalApplication.m11493l().getContentResolver(), "access_control_enabled", 0) == 1;
        if (C3250y.f11735c) {
            C3250y.m11453c("isEnableNoti: true isWebNoti:" + z + ", isRecording:" + zM5465c + ", isBlockingMode:" + zM5446n + ", isCameraPreview:" + z3 + ", isInteractionControl" + z4, this.f4459a);
        }
        if ((this.f4449A.m10977a("Setting show blackscreen popup", (Boolean) true).booleanValue() && !zM5465c && !zM5446n && !z4 && !z3) || z) {
            if (this.f4452D.isScreenOn() && !this.f4451C.inKeyguardRestrictedInputMode() && m5443k()) {
                C3250y.m11453c("keyguard off && foreground -> don't display popup", getClass().getSimpleName());
                return;
            }
            if (z) {
                Intent intent = new Intent(this.f4473w, (Class<?>) ScreenWebNotification.class);
                intent.putExtra("contents", str);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.addFlags(268435456);
                intent.addFlags(65536);
                this.f4473w.startActivity(intent);
                return;
            }
            if (this.f4452D.isScreenOn() && !m5473h() && this.f4449A.m10977a("Setting is simple popup", (Boolean) true).booleanValue()) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("Start screen notification Toast", this.f4459a);
                }
                if (this.f4463m > 0) {
                    C1111g c1111g = this.f4462l.get(0);
                    String str2 = new String(c1111g.f4499b);
                    String str3 = new String(c1111g.f4500c);
                    int iIntValue = new Integer(c1111g.f4504g).intValue();
                    boolean zBooleanValue = new Boolean(c1111g.f4512o).booleanValue();
                    Message messageObtainMessage = this.f4458J.obtainMessage();
                    messageObtainMessage.obj = new C1110f(this, str2, str3, iIntValue, zBooleanValue);
                    this.f4458J.sendMessage(messageObtainMessage);
                    return;
                }
                if (C3250y.f11737e) {
                    C3250y.m11442a("[EXCEPTION] current unread count is zero. Do not display toast.", this.f4459a);
                    return;
                }
                return;
            }
            Intent intent2 = new Intent(this.f4473w, (Class<?>) ScreenNotification2.class);
            intent2.putExtra("isUpdated", z2);
            intent2.addFlags(268435456);
            intent2.addFlags(65536);
            if (C3250y.f11735c) {
                C3250y.m11453c("Start screenNotification", this.f4459a);
            }
            this.f4473w.startActivity(intent2);
        }
    }

    /* renamed from: a */
    public void m5455a(String str, String str2, String str3, long j, EnumC1455w enumC1455w, int i, String str4, String str5, boolean z, long j2, String str6, int i2, int i3, long j3, String str7) throws Throwable {
        int i4;
        boolean zM5434a;
        Cursor cursor;
        Notification notification;
        C1072en.m5297a(str3, j, str, str2.length() > 5 ? str2.substring(0, 5) : str2, enumC1455w, getClass().getSimpleName());
        if (ExitAppDialogActivity.m1139a()) {
            return;
        }
        if (this.f4449A.m10977a("Setting Notification", (Boolean) true).booleanValue() || m5440f(i)) {
            long jCurrentTimeMillis = j2 <= 0 ? System.currentTimeMillis() : j2;
            if (!m5458a(str3) || this.f4451C.inKeyguardRestrictedInputMode()) {
                int i5 = f4441c;
                boolean zM5440f = m5440f(i);
                boolean zM5465c = m5465c();
                if (zM5440f) {
                    PendingIntent activity = PendingIntent.getActivity(CommonApplication.m11493l(), 0, m5437b(str3, str2), 268435456);
                    if (Build.VERSION.SDK_INT < 11) {
                        Notification notification2 = new Notification(R.drawable.chaton_quick_icon, str2, jCurrentTimeMillis);
                        notification2.setLatestEventInfo(this.f4473w, this.f4473w.getString(R.string.app_name), str2, activity);
                        notification = notification2;
                    } else {
                        Notification.Builder builder = new Notification.Builder(this.f4473w);
                        builder.setContentTitle(this.f4473w.getString(R.string.app_name)).setContentText(str2).setWhen(jCurrentTimeMillis).setTicker(str2).setLargeIcon(BitmapFactory.decodeResource(this.f4473w.getResources(), R.drawable.chaton_quick_icon)).setSmallIcon(R.drawable.chaton_quick_icon).setContentIntent(activity);
                        notification = Build.VERSION.SDK_INT < 16 ? builder.getNotification() : builder.build();
                    }
                    if (z) {
                        m5453a(notification);
                    } else {
                        notification.sound = null;
                        notification.vibrate = null;
                    }
                    if (zM5465c) {
                        notification.sound = null;
                        notification.vibrate = null;
                    }
                    this.f4475z.notify(-1, notification);
                    zM5434a = false;
                } else {
                    EnumC1108d enumC1108dM5472g = m5472g();
                    if (enumC1108dM5472g == EnumC1108d.MUTE_ON) {
                        if (C3250y.f11735c) {
                            C3250y.m11453c("Mute alert. Do not alert", this.f4459a);
                        }
                        i4 = f4443e;
                    } else {
                        if (enumC1108dM5472g == EnumC1108d.MUTE_EXPIRED) {
                            m5447o();
                        }
                        i4 = i5;
                    }
                    String strSubstring = C1075eq.m5326c(str2) ? str2.substring(1) : str2;
                    C1111g c1111g = new C1111g(this, str, strSubstring, str3, Long.valueOf(j2), str5.replaceAll("\n+", " "), i, enumC1455w.m6364a(), str4, str6, i2, j3, i3, str7, j, Query.MIXED.equals(strSubstring.split("\n")[0]));
                    zM5434a = m5434a(i4, c1111g, z);
                    if (zM5434a) {
                        return;
                    }
                    new C2946a().m10175a(this.f4462l);
                    int iM5431a = m5431a(enumC1455w);
                    try {
                        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1435c.f5363a, null, null, null, null);
                        if (cursorQuery != null) {
                            try {
                                if (cursorQuery.getCount() > 0) {
                                    while (cursorQuery.moveToNext()) {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("messageTypeFlag"));
                                        int i6 = TextUtils.isEmpty(string) ? 0 : Integer.parseInt(string, 2);
                                        if (i6 == 0 || (iM5431a & i6) == iM5431a) {
                                            Intent intent = new Intent();
                                            intent.setData(new Uri.Builder().scheme(cursorQuery.getString(cursorQuery.getColumnIndex("packageName"))).build());
                                            intent.setAction("com.sec.chaton.chat.PUSH_RECEIVED");
                                            intent.putExtra("message_id", Long.parseLong(c1111g.f4511n));
                                            intent.putExtra("message_type", c1111g.f4504g);
                                            intent.putExtra("inbox_no", c1111g.f4502e);
                                            intent.putExtra("sender_id", c1111g.f4498a);
                                            C3250y.m11453c("[B project] send broadcast, type: " + i6, this.f4459a);
                                            CommonApplication.m11493l().sendBroadcast(intent);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        str2 = strSubstring;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                    }
                }
                if (C3250y.f11735c) {
                    C3250y.m11453c("isEnableNoti:" + z, this.f4459a);
                }
                if (z) {
                    if (!C3171am.m11059c(GlobalApplication.m11493l())) {
                        m5432a(GlobalApplication.m11493l()).m5456a(str2, zM5440f, zM5434a);
                        return;
                    }
                    if (C3250y.f11735c) {
                        C3250y.m11453c("It is on call", this.f4459a);
                    }
                    this.f4472v = Settings.System.getInt(GlobalApplication.m11493l().getContentResolver(), "alertoncall_mode", 1);
                    if (this.f4472v == 0) {
                        C3250y.m11453c("[NOTI] ALERTONCALL_OFF", this.f4459a);
                    } else {
                        m5444l();
                    }
                    SensorManager sensorManager = (SensorManager) GlobalApplication.m11493l().getSystemService("sensor");
                    Sensor defaultSensor = sensorManager.getDefaultSensor(8);
                    if (defaultSensor != null) {
                        if (zM5440f) {
                            sensorManager.registerListener(new C1105ab(str2), defaultSensor, 0);
                        } else {
                            sensorManager.registerListener(new C1105ab(zM5434a), defaultSensor, 0);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: k */
    private boolean m5443k() {
        if (this.f4450B == null) {
            this.f4450B = (ActivityManager) this.f4473w.getSystemService("activity");
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.f4450B.getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(this.f4473w.getPackageName())) {
                String className = this.f4450B.getRunningTasks(1).get(0).topActivity.getClassName();
                return className.startsWith("com.sec.chaton") && !className.equals(ScreenNotification2.class.getName());
            }
        }
        return false;
    }

    /* renamed from: l */
    private void m5444l() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Uri actualDefaultRingtoneUri = null;
        String strM10979a = this.f4449A.m10979a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM10979a)) {
            if (!"Silent".equals(strM10979a)) {
                actualDefaultRingtoneUri = Uri.parse(strM10979a);
            }
        } else {
            actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f4473w, 2);
        }
        try {
            if (this.f4474y != null) {
                this.f4474y.release();
                this.f4474y = null;
            }
            this.f4474y = new MediaPlayer();
            if (this.f4474y != null) {
                this.f4474y.setAudioStreamType(0);
                this.f4474y.setDataSource(this.f4473w, actualDefaultRingtoneUri);
                this.f4474y.prepare();
                m5433a(this.f4474y);
                this.f4474y.start();
            }
        } catch (Exception e) {
            C3250y.m11453c("makeAlertSound() cated Exception : " + e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m5433a(MediaPlayer mediaPlayer) {
        AudioManager audioManager;
        if (mediaPlayer != null && (audioManager = (AudioManager) this.f4473w.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) != null && audioManager.getStreamVolume(0) > 0.0f) {
            C3250y.m11453c("makeAlertSoundOnCall() - am.getStreamVolume() volume = 0.4", getClass().getSimpleName());
            mediaPlayer.setVolume(0.4f, 0.4f);
        }
    }

    /* renamed from: f */
    private boolean m5440f(int i) {
        return i == EnumC1450r.WEB_AUTH.m6342a();
    }

    /* renamed from: a */
    public void m5453a(Notification notification) {
        Uri actualDefaultRingtoneUri;
        Uri actualDefaultRingtoneUri2 = null;
        String strM5474i = m5474i();
        if (strM5474i.equalsIgnoreCase("ALL")) {
            if (!C3171am.m11072j() || !C3171am.m11073k()) {
                notification.sound = null;
            } else {
                String strM10979a = this.f4449A.m10979a("Ringtone", (String) null);
                if (!TextUtils.isEmpty(strM10979a)) {
                    if (!"Silent".equals(strM10979a)) {
                        actualDefaultRingtoneUri2 = Uri.parse(strM10979a);
                    }
                } else {
                    actualDefaultRingtoneUri2 = RingtoneManager.getActualDefaultRingtoneUri(this.f4473w, 2);
                }
                notification.sound = actualDefaultRingtoneUri2;
            }
            notification.vibrate = new long[]{100, 1000, 1000};
        } else if (strM5474i.equalsIgnoreCase("MELODY")) {
            if (!C3171am.m11072j() || !C3171am.m11073k()) {
                notification.sound = null;
            } else {
                String strM10979a2 = this.f4449A.m10979a("Ringtone", (String) null);
                if (!TextUtils.isEmpty(strM10979a2)) {
                    actualDefaultRingtoneUri = !"Silent".equals(strM10979a2) ? Uri.parse(strM10979a2) : null;
                } else {
                    actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f4473w, 2);
                }
                notification.sound = actualDefaultRingtoneUri;
            }
            notification.vibrate = null;
        } else if (strM5474i.equalsIgnoreCase("VIBRATION")) {
            notification.vibrate = new long[]{100, 1000, 1000};
            notification.sound = null;
        } else if (strM5474i.equalsIgnoreCase("OFF")) {
            notification.sound = null;
            notification.vibrate = null;
        }
        if (this.f4449A.m10977a("LED Indicator", (Boolean) true).booleanValue()) {
            notification.ledARGB = -368876;
            notification.ledOnMS = HttpResponseCode.INTERNAL_SERVER_ERROR;
            notification.ledOffMS = 5000;
            notification.flags |= 1;
        }
    }

    /* renamed from: c */
    public boolean m5465c() {
        boolean zInKeyguardRestrictedInputMode;
        boolean zBooleanValue;
        AudioManager audioManager = (AudioManager) this.f4473w.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!this.f4449A.m10977a("Video Recording ON", (Boolean) false).booleanValue()) {
            return false;
        }
        try {
            zBooleanValue = ((Boolean) AudioManager.class.getMethod("isRecordActive", new Class[0]).invoke(audioManager, new Object[0])).booleanValue();
            try {
                C3250y.m11453c("isAudioRecording - " + zBooleanValue, getClass().getSimpleName());
                zInKeyguardRestrictedInputMode = this.f4451C.inKeyguardRestrictedInputMode();
                try {
                    C3250y.m11453c("KeyguardManager.inKeyguardRestrictedInputMode() - " + zInKeyguardRestrictedInputMode, getClass().getSimpleName());
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (NoSuchMethodException e3) {
                    C3250y.m11453c("[NOTI]NoSuchMethodException - isRecordActive mehtod is not available", getClass().getSimpleName());
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
    public void m5454a(String str, int i) throws Throwable {
        Cursor cursorQuery;
        if (C3250y.f11735c) {
            C3250y.m11453c("[NOTIPannel] ClearNoti. inbox No: " + str, this.f4459a);
        }
        if (this.f4460j == null || this.f4461k == null || this.f4462l == null) {
            C1379w.m6203a(new C1379w(), 0, new C1421l(null, f4444f, false));
            return;
        }
        this.f4460j.remove(str);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f4461k.size(); i2++) {
            if (!str.equals(this.f4461k.get(i2).f4491c)) {
                arrayList.add(this.f4461k.get(i2));
            }
        }
        this.f4461k.clear();
        this.f4461k.addAll(arrayList);
        arrayList.clear();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < this.f4462l.size(); i3++) {
            if (!str.equals(this.f4462l.get(i3).f4502e)) {
                arrayList2.add(this.f4462l.get(i3));
            }
        }
        this.f4462l.clear();
        this.f4462l.addAll(arrayList2);
        arrayList2.clear();
        this.f4463m = this.f4462l.size();
        if (this.f4463m > 0) {
            this.f4475z.notify(0, m5436b(f4444f, false));
        } else {
            this.f4475z.cancel(0);
        }
        new C2946a().m10174a(str, this.f4462l);
        if (C1493a.m6463a("main_icon_badge_feature")) {
            m5441g(this.f4463m);
        }
        if (i == f4447i) {
            return;
        }
        try {
            cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1435c.f5363a, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            Intent intent = new Intent();
                            intent.setData(new Uri.Builder().scheme(cursorQuery.getString(cursorQuery.getColumnIndex("packageName"))).build());
                            if (i == f4446h) {
                                intent.setAction("com.sec.chaton.chat.CHATROOM_CLOSE");
                            } else {
                                intent.setAction("com.sec.chaton.chat.MESSAGE_IS_READ");
                            }
                            intent.putExtra("inbox_no", str);
                            C3250y.m11453c("[B project] send broadcast, inboxNO : " + str + ", ack:" + i, this.f4459a);
                            CommonApplication.m11493l().sendBroadcast(intent);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: b */
    public static String m5438b(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
    }

    /* renamed from: b */
    public void m5461b(int i) {
        m5434a(i, (C1111g) null, false);
    }

    /* renamed from: a */
    private synchronized boolean m5434a(int i, C1111g c1111g, boolean z) {
        boolean zM5439b = false;
        synchronized (this) {
            if (i == f4441c || i == f4443e) {
                if (this.f4461k == null || this.f4460j == null || this.f4462l == null) {
                    C3250y.m11453c("update with task", this.f4459a);
                    C1379w.m6203a(new C1379w(), 0, new C1421l(null, i, z));
                } else {
                    zM5439b = m5439b(i, c1111g, z);
                }
            } else {
                C1379w.m6203a(new C1379w(), 0, new C1421l(null, i, z));
                C3250y.m11453c("update with task", this.f4459a);
            }
        }
        return zM5439b;
    }

    /* renamed from: a */
    public int m5448a(String str, String str2) {
        int i = 0;
        int i2 = -1;
        while (true) {
            int i3 = i;
            if (i3 < this.f4461k.size()) {
                if (str.equals(this.f4461k.get(i3).f4489a)) {
                    int i4 = i2;
                    for (int i5 = i3; i5 < this.f4461k.size(); i5++) {
                        if (str2.equals(this.f4461k.get(i5).f4491c)) {
                            i4 = i5;
                        }
                    }
                    i2 = i4;
                }
                i = i3 + 1;
            } else {
                return i2;
            }
        }
    }

    /* renamed from: m */
    private String m5445m() {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f4461k.size(); i++) {
            String str = this.f4461k.get(i).f4490b;
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append(!TextUtils.isEmpty((CharSequence) arrayList.get(i2)) ? (String) arrayList.get(i2) : CommonApplication.m11493l().getString(R.string.unknown)).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    /* renamed from: b */
    private boolean m5439b(int i, C1111g c1111g, boolean z) {
        this.f4460j.put(c1111g.f4502e, new C1113i(this, c1111g.f4507j, c1111g.f4508k, c1111g.f4506i, c1111g.f4505h, c1111g.f4509l));
        int iM5448a = m5448a(c1111g.f4498a, c1111g.f4502e);
        if (iM5448a >= 0) {
            this.f4461k.remove(iM5448a);
        }
        this.f4461k.add(0, new C1109e(this, c1111g.f4498a, c1111g.f4499b, c1111g.f4502e));
        boolean zM5435a = m5435a(c1111g);
        this.f4463m = this.f4462l.size();
        if (!zM5435a) {
            m5452a(i, z);
        }
        return zM5435a;
    }

    /* renamed from: a */
    public void m5452a(int i, boolean z) {
        Notification notificationM5436b = m5436b(i, z);
        try {
            this.f4475z.notify(0, notificationM5436b);
        } catch (SecurityException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, this.f4459a);
            }
            notificationM5436b.defaults |= 2;
            this.f4475z.notify(0, notificationM5436b);
        }
        if (C1493a.m6463a("main_icon_badge_feature")) {
            m5441g(this.f4463m);
        }
    }

    /* renamed from: g */
    private void m5441g(int i) {
        try {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i);
            intent.putExtra("badge_count_package_name", "com.sec.chaton");
            intent.putExtra("badge_count_class_name", "com.sec.chaton.HomeActivity");
            GlobalApplication.m11493l().sendBroadcast(intent);
        } catch (Exception e) {
            C3250y.m11443a(e, this.f4459a);
        }
    }

    /* renamed from: a */
    private boolean m5435a(C1111g c1111g) {
        for (int i = 0; i < this.f4463m; i++) {
            if (this.f4462l.get(i).f4511n.equals(c1111g.f4511n)) {
                this.f4462l.set(i, c1111g);
                if (C3250y.f11735c) {
                    C3250y.m11453c("MsgID has already exist: " + c1111g.f4511n, this.f4459a);
                }
                return true;
            }
        }
        this.f4462l.add(0, c1111g);
        return false;
    }

    /* renamed from: b */
    private Notification m5436b(int i, boolean z) {
        boolean zM5465c;
        Notification notificationM5466d;
        if (i == f4441c) {
            zM5465c = m5465c();
        } else {
            zM5465c = false;
        }
        if (Build.VERSION.SDK_INT < 11) {
            notificationM5466d = m5463c(i);
        } else {
            notificationM5466d = m5466d(i);
        }
        if (z) {
            if (i == f4443e) {
                notificationM5466d.sound = null;
                notificationM5466d.vibrate = null;
                if (C3250y.f11735c) {
                    C3250y.m11453c("[getNotification] It's on mute. sound:null, vibrate:null", this.f4459a);
                }
            } else {
                m5453a(notificationM5466d);
            }
        } else {
            notificationM5466d.sound = null;
            notificationM5466d.vibrate = null;
        }
        if (zM5465c) {
            notificationM5466d.sound = null;
            notificationM5466d.vibrate = null;
        }
        return notificationM5466d;
    }

    /* renamed from: b */
    private Intent m5437b(String str, String str2) {
        Intent intentM1171a = IntentControllerActivity.m1171a(CommonApplication.m11493l(), true);
        intentM1171a.setAction("com.sec.chaton.action.NOTI_WEB");
        intentM1171a.putExtra("callChatList", false);
        intentM1171a.putExtra("inboxNO", str);
        intentM1171a.putExtra("chatType", EnumC1450r.WEB_AUTH.m6342a());
        intentM1171a.putExtra("fromPush", 1);
        intentM1171a.putExtra("Content", str2);
        return intentM1171a;
    }

    /* renamed from: d */
    public Intent m5467d() {
        if (this.f4460j.size() == 1) {
            Intent intentM1171a = IntentControllerActivity.m1171a(CommonApplication.m11493l(), true);
            intentM1171a.setAction("com.sec.chaton.action.NOTI_MESSAGE");
            intentM1171a.putExtra("callChatList", true);
            switch (C1107c.f4481a[EnumC1450r.m6339a(this.f4462l.get(0).f4503f).ordinal()]) {
                case 1:
                case 2:
                    intentM1171a.putExtra("inboxNO", this.f4462l.get(0).f4502e);
                    intentM1171a.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                    intentM1171a.putExtra("fromPush", 1);
                    intentM1171a.putExtra("buddyNO", this.f4462l.get(0).f4498a);
                    break;
                case 3:
                    intentM1171a.putExtra("inboxNO", this.f4462l.get(0).f4502e);
                    intentM1171a.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
                    intentM1171a.putExtra("fromPush", 1);
                    intentM1171a.putExtra("buddyNO", this.f4462l.get(0).f4498a);
                    break;
                case 4:
                    intentM1171a.putExtra("inboxNO", this.f4462l.get(0).f4502e);
                    intentM1171a.putExtra("chatType", EnumC1450r.BROADCAST2.m6342a());
                    intentM1171a.putExtra("fromPush", 1);
                    intentM1171a.putExtra("buddyNO", this.f4462l.get(0).f4498a);
                    break;
            }
            return intentM1171a;
        }
        Intent intentM1171a2 = IntentControllerActivity.m1171a(CommonApplication.m11493l(), true);
        intentM1171a2.setAction("com.sec.chaton.action.NOTI_MESSAGE");
        intentM1171a2.putExtra("callChatTab", true);
        return intentM1171a2;
    }

    /* renamed from: e */
    public C1112h m5469e() {
        String string;
        boolean z = !this.f4449A.m10977a("Setting show receive message", (Boolean) true).booleanValue() || this.f4449A.m10979a("OFF", "OFF").equals("ON");
        if (this.f4462l.size() == 1) {
            string = CommonApplication.m11493l().getString(R.string.new_1_message_dont_preview);
        } else {
            string = CommonApplication.m11493l().getString(R.string.new_chaton_messages, Integer.valueOf(this.f4463m));
        }
        C1112h c1112h = new C1112h(this);
        c1112h.f4516c = this.f4462l.get(0).f4501d;
        if (c1112h.f4516c.longValue() <= 0) {
            c1112h.f4516c = Long.valueOf(System.currentTimeMillis());
        }
        if (z) {
            c1112h.f4514a = CommonApplication.m11493l().getString(R.string.app_name);
            c1112h.f4515b = string;
            return c1112h;
        }
        if (this.f4461k.size() > 1) {
            c1112h.f4514a = string;
            c1112h.f4515b = m5445m();
        } else if (this.f4463m > 1) {
            c1112h.f4514a = string;
            c1112h.f4515b = this.f4461k.get(0).f4490b;
        } else {
            c1112h.f4514a = this.f4462l.get(0).f4499b;
            if (TextUtils.isEmpty(c1112h.f4514a)) {
                c1112h.f4514a = CommonApplication.m11493l().getString(R.string.unknown);
            }
            c1112h.f4515b = m5449a(this.f4462l.get(0).f4504g, this.f4462l.get(0).f4500c, this.f4462l.get(0).f4498a, this.f4462l.get(0).f4512o);
        }
        return c1112h;
    }

    /* renamed from: c */
    public Notification m5463c(int i) {
        Notification notification;
        String str;
        boolean z = true;
        String strM10979a = this.f4449A.m10979a("OFF", "OFF");
        if (this.f4449A.m10977a("Setting show receive message", (Boolean) true).booleanValue() && !strM10979a.equals("ON")) {
            z = false;
        }
        C1112h c1112hM5469e = m5469e();
        PendingIntent activity = PendingIntent.getActivity(CommonApplication.m11493l(), 0, m5467d(), 268435456);
        if (i == f4442d || i == f4444f) {
            notification = new Notification(R.drawable.chaton_quick_icon, null, this.f4462l.get(0).f4501d.longValue());
        } else {
            if (!z) {
                str = this.f4462l.get(0).f4499b + " : " + m5449a(this.f4462l.get(0).f4504g, this.f4462l.get(0).f4500c, this.f4462l.get(0).f4498a, this.f4462l.get(0).f4512o);
            } else {
                str = this.f4462l.size() + " " + CommonApplication.m11493l().getString(R.string.message_dont_preview);
            }
            notification = new Notification(R.drawable.chaton_quick_icon, str, this.f4462l.get(0).f4501d.longValue());
        }
        notification.setLatestEventInfo(CommonApplication.m11493l(), c1112hM5469e.f4514a, c1112hM5469e.f4515b, activity);
        return notification;
    }

    /* renamed from: d */
    public Notification m5466d(int i) {
        Bitmap bitmapDecodeResource;
        String string;
        C1112h c1112hM5469e = m5469e();
        Notification.Builder builder = new Notification.Builder(CommonApplication.m11493l());
        boolean z = !this.f4449A.m10977a("Setting show receive message", (Boolean) true).booleanValue() || this.f4449A.m10979a("OFF", "OFF").equals("ON");
        if (z) {
            if (this.f4463m > 1) {
                string = this.f4463m + " " + CommonApplication.m11493l().getString(R.string.new_message_dont_preview);
            } else {
                string = CommonApplication.m11493l().getString(R.string.new_1_message_dont_preview);
            }
            bitmapDecodeResource = BitmapFactory.decodeResource(CommonApplication.m11493l().getResources(), R.drawable.chaton_quick_icon);
        } else {
            String str = this.f4462l.get(0).f4499b + " : " + m5449a(this.f4462l.get(0).f4504g, this.f4462l.get(0).f4500c, this.f4462l.get(0).f4498a, this.f4462l.get(0).f4512o);
            if (this.f4461k.size() == 1) {
                Bitmap bitmapM11236j = C3205bt.m11182a(CommonApplication.m11493l()).m11236j(this.f4462l.get(0).f4498a);
                if (bitmapM11236j == null || bitmapM11236j.isRecycled()) {
                    if (C3250y.f11735c) {
                        C3250y.m11453c("can not get profile image bitmap", this.f4459a);
                    }
                    bitmapDecodeResource = C3205bt.m11177a(CommonApplication.m11493l(), R.drawable.contacts_default_01);
                    string = str;
                } else {
                    bitmapDecodeResource = bitmapM11236j;
                    string = str;
                }
            } else {
                bitmapDecodeResource = BitmapFactory.decodeResource(CommonApplication.m11493l().getResources(), R.drawable.chaton_quick_icon);
                string = str;
            }
        }
        builder.setContentTitle(c1112hM5469e.f4514a).setContentText(c1112hM5469e.f4515b).setWhen(c1112hM5469e.f4516c.longValue()).setLargeIcon(bitmapDecodeResource).setContentIntent(PendingIntent.getActivity(CommonApplication.m11493l(), 0, m5467d(), 268435456)).setNumber(0).setSmallIcon(R.drawable.chaton_quick_icon);
        if (i != f4442d && i != f4444f) {
            builder.setTicker(string);
        }
        if (Build.VERSION.SDK_INT < 16) {
            return builder.getNotification();
        }
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle(builder);
        if (!z) {
            C1072en.m5307a(this.f4462l, this.f4459a);
            if (this.f4461k.size() == 1) {
                if (TextUtils.isEmpty(this.f4462l.get(0).f4499b)) {
                    this.f4462l.get(0).f4499b = CommonApplication.m11493l().getString(R.string.unknown);
                }
                inboxStyle.setBigContentTitle(this.f4462l.get(0).f4499b);
                for (int i2 = 0; i2 < this.f4462l.size(); i2++) {
                    C1111g c1111g = this.f4462l.get(i2);
                    inboxStyle.addLine(m5449a(c1111g.f4504g, c1111g.f4500c, c1111g.f4498a, this.f4462l.get(0).f4512o));
                }
            } else {
                inboxStyle.setBigContentTitle(c1112hM5469e.f4514a);
                for (int i3 = 0; i3 < this.f4462l.size(); i3++) {
                    C1111g c1111g2 = this.f4462l.get(i3);
                    if (TextUtils.isEmpty(c1111g2.f4499b)) {
                        c1111g2.f4499b = CommonApplication.m11493l().getString(R.string.unknown);
                    }
                    inboxStyle.addLine(c1111g2.f4499b + " : " + m5449a(c1111g2.f4504g, c1111g2.f4500c, c1111g2.f4498a, this.f4462l.get(0).f4512o));
                }
            }
        } else {
            inboxStyle.addLine(c1112hM5469e.f4515b);
        }
        String string2 = "";
        int i4 = this.f4463m - 7;
        if (i4 > 0) {
            string2 = i4 > 1 ? CommonApplication.m11493l().getResources().getString(R.string.more_messages, Integer.valueOf(i4)) : CommonApplication.m11493l().getString(R.string.one_more_message);
        }
        inboxStyle.setSummaryText(string2);
        return inboxStyle.build();
    }

    /* renamed from: e */
    public void m5470e(int i) {
        this.f4460j.clear();
        this.f4462l.clear();
        this.f4461k.clear();
        if (i == 0) {
            m5442j();
        }
    }

    /* renamed from: f */
    public void m5471f() {
        if (this.f4460j == null) {
            this.f4460j = new HashMap<>();
        }
        if (this.f4462l == null) {
            this.f4462l = new ArrayList<>();
        }
        if (this.f4461k == null) {
            this.f4461k = new ArrayList<>();
        }
    }

    /* renamed from: a */
    public String m5449a(int i, String str, String str2, boolean z) {
        String strM10162f = "";
        switch (C1107c.f4482b[EnumC1455w.m6358a(i).ordinal()]) {
            case 1:
                strM10162f = ApplinkMsgEntry.getDisplayMessage(str);
                break;
            case 2:
                if (C1075eq.m5326c(str)) {
                    str = str.substring(1);
                }
                strM10162f = str;
                break;
            case 3:
                if (z) {
                    strM10162f = CommonApplication.m11493l().getString(R.string.media_image_text);
                    break;
                } else {
                    strM10162f = CommonApplication.m11493l().getString(R.string.media_photo);
                    break;
                }
            case 4:
                if (z) {
                    strM10162f = CommonApplication.m11493l().getString(R.string.media_anicon_text);
                    break;
                } else {
                    strM10162f = CommonApplication.m11493l().getString(R.string.anicon_download_list_title);
                    break;
                }
            case 5:
                if (z) {
                    strM10162f = CommonApplication.m11493l().getString(R.string.media_video_text);
                    break;
                } else {
                    strM10162f = CommonApplication.m11493l().getString(R.string.media_video);
                    break;
                }
            case 6:
                strM10162f = CommonApplication.m11493l().getString(R.string.media_map);
                break;
            case 7:
                strM10162f = CommonApplication.m11493l().getString(R.string.media_voice);
                break;
            case 8:
                strM10162f = CommonApplication.m11493l().getString(R.string.media_contact);
                break;
            case 9:
                strM10162f = CommonApplication.m11493l().getString(R.string.media_event);
                break;
            case 10:
            case 11:
                strM10162f = CommonApplication.m11493l().getString(R.string.media_file);
                break;
            case 12:
                strM10162f = CommonApplication.m11493l().getString(R.string.poll_title);
                break;
            case 13:
                if (z) {
                    strM10162f = CommonApplication.m11493l().getString(R.string.media_animessage_text);
                    break;
                } else {
                    strM10162f = CommonApplication.m11493l().getString(R.string.media_animessage);
                    break;
                }
            case 14:
                SpecialBuddyShareContentsEntry specialBuddyShareContentsEntryM10152a = C2930k.m10152a(str, true);
                if (specialBuddyShareContentsEntryM10152a != null) {
                    strM10162f = specialBuddyShareContentsEntryM10152a.title;
                    break;
                }
                break;
            case 15:
                SpecialBuddyRecommendBuddyEntry specialBuddyRecommendBuddyEntryM10156b = C2930k.m10156b(str, true);
                if (specialBuddyRecommendBuddyEntryM10156b != null) {
                    strM10162f = specialBuddyRecommendBuddyEntryM10156b.name;
                    break;
                }
                break;
            case 16:
                strM10162f = C2930k.m10162f(str);
                break;
            default:
                strM10162f = CommonApplication.m11493l().getString(R.string.unknown);
                break;
        }
        if (strM10162f.length() > 100) {
            return strM10162f.substring(0, 100);
        }
        return strM10162f;
    }

    /* renamed from: a */
    public boolean m5457a(Long l) {
        Iterator<C1111g> it = this.f4462l.iterator();
        while (it.hasNext()) {
            C1111g next = it.next();
            if (next.f4511n.equals(Long.toString(l.longValue()))) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("Msg ID Exist, msgId:" + next.f4511n, this.f4459a);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public boolean m5468d(String str) {
        boolean z;
        if (this.f4460j.containsKey(str)) {
            z = true;
        } else {
            z = false;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("IsInboxNO Exist:" + z, this.f4459a);
        }
        return z;
    }

    /* renamed from: n */
    private boolean m5446n() {
        if (Settings.System.getInt(this.f4473w.getContentResolver(), "dormant_switch_onoff", 0) == 1 && Settings.System.getInt(this.f4473w.getContentResolver(), "dormant_disable_notifications", 0) == 1) {
            if (Settings.System.getInt(this.f4473w.getContentResolver(), "dormant_always", 0) == 1) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(11);
            int i2 = calendar.get(12);
            int i3 = Settings.System.getInt(this.f4473w.getContentResolver(), "dormant_start_hour", 0);
            int i4 = Settings.System.getInt(this.f4473w.getContentResolver(), "dormant_start_min", 0);
            int i5 = Settings.System.getInt(this.f4473w.getContentResolver(), "dormant_end_hour", 0);
            int i6 = Settings.System.getInt(this.f4473w.getContentResolver(), "dormant_end_min", 0);
            C3250y.m11453c("[NOTI] Blocking mode set time , current hour: " + i + ", current minute: " + i2 + ", start hour: " + i3 + ", start minute: " + i4 + ", end hour: " + i5 + ", end minute: " + i6, getClass().getSimpleName());
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

    /* renamed from: o */
    private void m5447o() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm");
        if (C3159aa.m10962a().m10978a("Setting mute type", (Integer) 3).intValue() == 2 && C3159aa.m10962a().m10977a("Setting mute repeat", (Boolean) false).booleanValue()) {
            long jM10976a = C3159aa.m10962a().m10976a("Setting mute hour start Long", 0L) + 86400000;
            long jM10976a2 = C3159aa.m10962a().m10976a("Setting mute hour end Long", 0L) + 86400000;
            C3159aa.m10962a().m10982a("Setting mute hour start Long", Long.valueOf(jM10976a));
            C3159aa.m10962a().m10982a("Setting mute hour end Long", Long.valueOf(jM10976a2));
            if (C3250y.f11735c) {
                Calendar.getInstance().setTimeInMillis(jM10976a);
                StringBuilder sb = new StringBuilder();
                sb.append("extend >start : ").append(simpleDateFormat.format(new Date(jM10976a))).append(" >end : ").append(simpleDateFormat.format(new Date(jM10976a2)));
                C3250y.m11453c("[deregiMuteAlert] " + sb.toString(), this.f4459a);
                return;
            }
            return;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("[deregiMuteAlert] Deregi mute", this.f4459a);
        }
        C3159aa.m10962a().m10984b("Setting mute type", (Integer) 3);
        C3159aa.m10962a().m10981a("Setting mute hour start Long");
        C3159aa.m10962a().m10981a("Setting mute hour end Long");
        C3159aa.m10962a().m10981a("Setting mute repeat");
    }

    /* renamed from: g */
    public EnumC1108d m5472g() {
        EnumC1108d enumC1108d;
        EnumC1108d enumC1108d2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm");
        int iIntValue = C3159aa.m10962a().m10978a("Setting mute type", (Integer) 3).intValue();
        EnumC1108d enumC1108d3 = EnumC1108d.MUTE_OFF;
        if (iIntValue == 0) {
            long jM10976a = C3159aa.m10962a().m10976a("Setting mute hour end Long", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (C3250y.f11735c) {
                C3250y.m11453c("[isAlertMute] endTime :" + jM10976a + " curretTime:" + jCurrentTimeMillis, this.f4459a);
            }
            if (jCurrentTimeMillis <= jM10976a) {
                return EnumC1108d.MUTE_ON;
            }
            return EnumC1108d.MUTE_EXPIRED;
        }
        if (iIntValue == 1) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            long jM10976a2 = C3159aa.m10962a().m10976a("Setting mute hour end Long", 0L);
            if (jCurrentTimeMillis2 <= jM10976a2) {
                enumC1108d2 = EnumC1108d.MUTE_ON;
            } else {
                enumC1108d2 = EnumC1108d.MUTE_EXPIRED;
            }
            if (C3250y.f11735c) {
                StringBuilder sb = new StringBuilder();
                sb.append(">current : ").append(simpleDateFormat.format(new Date(jCurrentTimeMillis2))).append(" >end : ").append(simpleDateFormat.format(new Date(jM10976a2)));
                C3250y.m11453c("[isAlertMute] " + sb.toString() + ", ret :" + enumC1108d2, this.f4459a);
                return enumC1108d2;
            }
            return enumC1108d2;
        }
        if (iIntValue == 2) {
            long jM10976a3 = C3159aa.m10962a().m10976a("Setting mute hour start Long", 0L);
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            long jM10976a4 = C3159aa.m10962a().m10976a("Setting mute hour end Long", 0L);
            if (C3159aa.m10962a().m10977a("Setting mute repeat", (Boolean) false).booleanValue()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(jM10976a4);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(jCurrentTimeMillis3);
                if (calendar.get(5) < calendar2.get(5)) {
                    int i = calendar2.get(5) - calendar.get(5);
                    jM10976a3 += 86400000 * i;
                    jM10976a4 += 86400000 * i;
                    if (C3250y.f11735c) {
                        C3250y.m11453c("[isAlertMute] increase end time by " + i + "startTime:" + jM10976a3 + ", endTime:" + jM10976a4, this.f4459a);
                    }
                    C3159aa.m10962a().m10982a("Setting mute hour start Long", Long.valueOf(jM10976a3));
                    C3159aa.m10962a().m10982a("Setting mute hour end Long", Long.valueOf(jM10976a4));
                }
            }
            long j = jM10976a4;
            long j2 = jM10976a3;
            if (j2 <= jCurrentTimeMillis3 && jCurrentTimeMillis3 <= j) {
                enumC1108d = EnumC1108d.MUTE_ON;
            } else if (j < jCurrentTimeMillis3) {
                enumC1108d = EnumC1108d.MUTE_EXPIRED;
            } else {
                enumC1108d = EnumC1108d.MUTE_OFF;
            }
            if (C3250y.f11735c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(">start : ").append(simpleDateFormat.format(new Date(j2))).append(" >current : ").append(simpleDateFormat.format(new Date(jCurrentTimeMillis3))).append(" >end : ").append(simpleDateFormat.format(new Date(j)));
                C3250y.m11453c("[isAlertMute] " + sb2.toString() + "ret:" + enumC1108d.m5475a(), this.f4459a);
                return enumC1108d;
            }
            return enumC1108d;
        }
        return enumC1108d3;
    }

    /* renamed from: h */
    public boolean m5473h() {
        return this.f4453E;
    }

    /* renamed from: a */
    public boolean m5459a(boolean z) {
        this.f4453E = z;
        return z;
    }

    /* renamed from: i */
    public String m5474i() {
        Vibrator vibrator;
        C3160ab c3160abM10962a = C3159aa.m10962a();
        String strM10979a = c3160abM10962a.m10979a("Set Type", "");
        if (TextUtils.isEmpty(strM10979a)) {
            c3160abM10962a.m10986b("Set Type", "ALL");
            if (Build.VERSION.SDK_INT <= 10 || ((vibrator = (Vibrator) CommonApplication.m11493l().getSystemService("vibrator")) != null && vibrator.hasVibrator())) {
                return "ALL";
            }
            c3160abM10962a.m10986b("Set Type", "MELODY");
            return "MELODY";
        }
        return strM10979a;
    }

    /* renamed from: a */
    private int m5431a(EnumC1455w enumC1455w) {
        int i = this.f4464n;
        switch (C1107c.f4482b[enumC1455w.ordinal()]) {
            case 2:
                return this.f4464n;
            case 3:
                return this.f4465o;
            case 4:
                return this.f4468r;
            case 5:
                return this.f4466p;
            case 6:
                return this.f4471u;
            case 7:
                return this.f4467q;
            case 8:
                return this.f4469s;
            case 9:
                return this.f4470t;
            default:
                return i;
        }
    }
}
