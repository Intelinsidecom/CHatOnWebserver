package com.sec.chaton.util;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC0651d;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ChatONNotificationManager.java */
/* renamed from: com.sec.chaton.util.g */
/* loaded from: classes.dex */
public class C1332g {

    /* renamed from: d */
    private static C1332g f4557d;

    /* renamed from: a */
    ActivityManager f4558a;

    /* renamed from: b */
    private int f4559b;

    /* renamed from: c */
    private Context f4560c;

    /* renamed from: e */
    private MediaPlayer f4561e;

    /* renamed from: f */
    private NotificationManager f4562f;

    /* renamed from: g */
    private SharedPreferences f4563g = C1323bs.m4575a();

    private C1332g(Context context) {
        this.f4560c = context;
        this.f4562f = (NotificationManager) this.f4560c.getSystemService("notification");
        this.f4558a = (ActivityManager) this.f4560c.getSystemService("activity");
    }

    /* renamed from: a */
    public static C1332g m4605a(Context context) {
        if (f4557d == null) {
            f4557d = new C1332g(context);
        }
        return f4557d;
    }

    /* renamed from: a */
    public void m4611a(String str, String str2, String str3, PendingIntent pendingIntent, long j, EnumC0651d enumC0651d, int i, int i2, String str4, long j2, String str5, boolean z) throws IllegalStateException, IllegalAccessException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        String string;
        String strSubstring;
        String string2;
        Uri actualDefaultRingtoneUri;
        boolean zInKeyguardRestrictedInputMode;
        boolean z2;
        Uri actualDefaultRingtoneUri2;
        C1341p.m4660c("[NOTI] composeAndShowNoti, sender: " + str + ", message: " + str2 + ", inboxNO: " + str3 + ", msgID: " + j + ", contentType: " + enumC0651d + ", unreadCount: " + i + ", Memory Address:" + this, getClass().getSimpleName());
        if (!ExitAppDialogActivity.m624a()) {
            if (!this.f4563g.getBoolean("Setting show receive message", true)) {
                strSubstring = i + " " + this.f4560c.getString(R.string.message_dont_preview);
                string2 = this.f4560c.getString(R.string.app_name);
            } else {
                if (enumC0651d != EnumC0651d.TEXT) {
                    String strM2977a = EnumC0651d.m2977a(enumC0651d);
                    if (!TextUtils.isEmpty(strM2977a)) {
                        string = String.format(strM2977a, str5);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str5).append(" : ").append(str2);
                        string = sb.toString();
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str5).append(" : ").append(str2);
                    string = sb2.toString();
                }
                strSubstring = string;
                string2 = str5;
            }
            if (strSubstring.length() > 100) {
                strSubstring = strSubstring.substring(0, 100);
            }
            Notification notification = new Notification(R.drawable.indi_chaton, strSubstring, 0L);
            notification.setLatestEventInfo(this.f4560c, string2, strSubstring, pendingIntent);
            C1341p.m4660c("[NOTI] composeAndShowNoti, buddyName: " + str5 + ", message: " + strSubstring + ", Intent Sender: " + pendingIntent.getIntentSender().toString() + "Memory Address:" + this, getClass().getSimpleName());
            String string3 = this.f4563g.getString("Set Type", "ALL");
            if (string3.equalsIgnoreCase("ALL")) {
                if (!C1336k.m4631h() || !C1336k.m4632i()) {
                    notification.sound = null;
                } else {
                    String string4 = this.f4563g.getString("Ringtone", null);
                    if (string4 != null) {
                        if (!"Silent".equals(string4)) {
                            actualDefaultRingtoneUri2 = Uri.parse(string4);
                        } else {
                            actualDefaultRingtoneUri2 = null;
                        }
                    } else {
                        actualDefaultRingtoneUri2 = RingtoneManager.getActualDefaultRingtoneUri(this.f4560c, 2);
                    }
                    notification.sound = actualDefaultRingtoneUri2;
                }
                notification.vibrate = new long[]{100, 1000, 1000};
            } else if (string3.equalsIgnoreCase("MELODY")) {
                if (!C1336k.m4631h() || !C1336k.m4632i()) {
                    notification.sound = null;
                } else {
                    String string5 = this.f4563g.getString("Ringtone", null);
                    if (string5 != null) {
                        if (!"Silent".equals(string5)) {
                            actualDefaultRingtoneUri = Uri.parse(string5);
                        } else {
                            actualDefaultRingtoneUri = null;
                        }
                    } else {
                        actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f4560c, 2);
                    }
                    notification.sound = actualDefaultRingtoneUri;
                }
                notification.vibrate = null;
            } else if (string3.equalsIgnoreCase("VIBRATION")) {
                notification.vibrate = new long[]{100, 1000, 1000};
                notification.sound = null;
            } else if (string3.equalsIgnoreCase("OFF")) {
                notification.sound = null;
                notification.vibrate = null;
            }
            notification.ledARGB = -33024;
            notification.ledOnMS = 500;
            notification.ledOffMS = 5000;
            notification.flags |= 1;
            AudioManager audioManager = (AudioManager) this.f4560c.getSystemService("audio");
            KeyguardManager keyguardManager = (KeyguardManager) this.f4560c.getSystemService("keyguard");
            boolean zBooleanValue = false;
            try {
                zBooleanValue = ((Boolean) AudioManager.class.getMethod("isRecordActive", new Class[0]).invoke(audioManager, new Object[0])).booleanValue();
                C1341p.m4660c("isAudioRecording - " + zBooleanValue, getClass().getSimpleName());
                zInKeyguardRestrictedInputMode = keyguardManager.inKeyguardRestrictedInputMode();
            } catch (IllegalAccessException e) {
                zInKeyguardRestrictedInputMode = false;
            } catch (IllegalArgumentException e2) {
                zInKeyguardRestrictedInputMode = false;
            } catch (NoSuchMethodException e3) {
                zInKeyguardRestrictedInputMode = false;
            } catch (InvocationTargetException e4) {
                zInKeyguardRestrictedInputMode = false;
            }
            try {
                C1341p.m4660c("KeyguardManager.inKeyguardRestrictedInputMode() - " + zInKeyguardRestrictedInputMode, getClass().getSimpleName());
            } catch (IllegalAccessException e5) {
            } catch (IllegalArgumentException e6) {
            } catch (NoSuchMethodException e7) {
                C1341p.m4660c("[NOTI]NoSuchMethodException - isRecordActive mehtod is not available", getClass().getSimpleName());
            } catch (InvocationTargetException e8) {
            }
            if (!this.f4563g.getBoolean("Video Recording ON", false) && (!zBooleanValue || zInKeyguardRestrictedInputMode)) {
                z2 = false;
            } else {
                notification.sound = null;
                notification.vibrate = null;
                z2 = true;
            }
            boolean z3 = true;
            if (GlobalApplication.f2413g) {
                if (GlobalApplication.f2412f != null) {
                    if (GlobalApplication.f2412f.equals(str3)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
            } else {
                z3 = true;
            }
            if (this.f4563g.getBoolean("Setting Notification", true) && z && (GlobalApplication.f2408b == null || !GlobalApplication.f2408b.equals(str3) || keyguardManager.inKeyguardRestrictedInputMode())) {
                this.f4562f.cancelAll();
                this.f4562f.notify((int) j2, notification);
                C1341p.m4660c("notiManager.notify( )", getClass().getSimpleName());
                if (this.f4563g.getBoolean("Setting show blackscreen popup", true) && z3 && !z2) {
                    if (GlobalApplication.f2409c) {
                        if (BlackScreenNotification.f4379a) {
                            Bundle bundle = new Bundle();
                            bundle.putString("Sender", str5);
                            bundle.putString("SenderID", str);
                            bundle.putString("SessionID", str4);
                            if (this.f4563g.getBoolean("Setting show receive message", true)) {
                                if (str2.length() > 100) {
                                    StringBuilder sb3 = new StringBuilder(str2);
                                    sb3.setLength(97);
                                    sb3.append("...");
                                    bundle.putString("Content", sb3.toString());
                                } else {
                                    bundle.putString("Content", str2);
                                }
                            } else {
                                bundle.putString("Content", i + " " + this.f4560c.getString(R.string.message_dont_preview));
                            }
                            bundle.putInt("MediaType", enumC0651d.m2978a());
                            bundle.putString("InboxNO", str3);
                            bundle.putInt("Chattype", i2);
                            bundle.putInt("InboxRawID", (int) j2);
                            if (GlobalApplication.f2410d != null) {
                                GlobalApplication.f2410d.m4448a(bundle);
                            } else {
                                C1341p.m4651a("composeAndShowNoti - blackScrrenNotification is null", getClass().getSimpleName());
                            }
                        } else if (ScreenOnNotification.f4431a) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("Sender", str5);
                            bundle2.putString("SenderID", str);
                            bundle2.putString("SessionID", str4);
                            if (this.f4563g.getBoolean("Setting show receive message", true)) {
                                if (str2.length() > 100) {
                                    StringBuilder sb4 = new StringBuilder(str2);
                                    sb4.setLength(97);
                                    sb4.append("...");
                                    bundle2.putString("Content", sb4.toString());
                                } else {
                                    bundle2.putString("Content", str2);
                                }
                            } else {
                                bundle2.putString("Content", i + " " + this.f4560c.getString(R.string.message_dont_preview));
                            }
                            bundle2.putInt("MediaType", enumC0651d.m2978a());
                            bundle2.putString("InboxNO", str3);
                            bundle2.putInt("Chattype", i2);
                            bundle2.putInt("InboxRawID", (int) j2);
                            if (GlobalApplication.f2411e != null) {
                                GlobalApplication.f2411e.m4483a(bundle2);
                            } else {
                                C1341p.m4651a("composeAndShowNoti - scrrenOnNotification is null", getClass().getSimpleName());
                            }
                        } else if (keyguardManager.inKeyguardRestrictedInputMode() || !m4607b()) {
                            C1341p.m4660c("KeyguardManager.inKeyguardRestrictedInputMode() - " + keyguardManager.inKeyguardRestrictedInputMode(), getClass().getSimpleName());
                            if (keyguardManager.inKeyguardRestrictedInputMode()) {
                                C1341p.m4660c("BlackScreen noti cause of KeyguardManager.inKeyguardRestrictedInputMode() - true", getClass().getSimpleName());
                                Intent intent = new Intent(this.f4560c, (Class<?>) BlackScreenNotification.class);
                                intent.putExtra("Sender", str5);
                                intent.putExtra("SenderID", str);
                                intent.putExtra("SessionID", str4);
                                if (this.f4563g.getBoolean("Setting show receive message", true)) {
                                    if (str2.length() > 100) {
                                        StringBuilder sb5 = new StringBuilder(str2);
                                        sb5.setLength(97);
                                        sb5.append("...");
                                        intent.putExtra("Content", sb5.toString());
                                    } else {
                                        intent.putExtra("Content", str2);
                                    }
                                } else {
                                    intent.putExtra("Content", i + " " + this.f4560c.getString(R.string.message_dont_preview));
                                }
                                intent.putExtra("MediaType", enumC0651d.m2978a());
                                intent.putExtra("InboxNO", str3);
                                intent.putExtra("Chattype", i2);
                                intent.putExtra("InboxRawID", (int) j2);
                                intent.addFlags(268435456);
                                intent.addFlags(67108864);
                                this.f4560c.startActivity(intent);
                            } else {
                                Intent intent2 = new Intent(this.f4560c, (Class<?>) ScreenOnNotification.class);
                                intent2.putExtra("Sender", str5);
                                intent2.putExtra("SenderID", str);
                                intent2.putExtra("SessionID", str4);
                                if (this.f4563g.getBoolean("Setting show receive message", true)) {
                                    if (str2.length() > 100) {
                                        StringBuilder sb6 = new StringBuilder(str2);
                                        sb6.setLength(97);
                                        sb6.append("...");
                                        intent2.putExtra("Content", sb6.toString());
                                    } else {
                                        intent2.putExtra("Content", str2);
                                    }
                                } else {
                                    intent2.putExtra("Content", i + " " + this.f4560c.getString(R.string.message_dont_preview));
                                }
                                intent2.putExtra("MediaType", enumC0651d.m2978a());
                                intent2.putExtra("InboxNO", str3);
                                intent2.putExtra("Chattype", i2);
                                intent2.putExtra("InboxRawID", (int) j2);
                                intent2.addFlags(268435456);
                                intent2.addFlags(67108864);
                                this.f4560c.startActivity(intent2);
                            }
                        } else {
                            return;
                        }
                    } else {
                        Intent intent3 = new Intent(this.f4560c, (Class<?>) BlackScreenNotification.class);
                        intent3.putExtra("Sender", str5);
                        intent3.putExtra("SenderID", str);
                        intent3.putExtra("SessionID", str4);
                        if (this.f4563g.getBoolean("Setting show receive message", true)) {
                            if (str2.length() > 100) {
                                StringBuilder sb7 = new StringBuilder(str2);
                                sb7.setLength(97);
                                sb7.append("...");
                                intent3.putExtra("Content", sb7.toString());
                            } else {
                                intent3.putExtra("Content", str2);
                            }
                        } else {
                            intent3.putExtra("Content", i + " " + this.f4560c.getString(R.string.message_dont_preview));
                        }
                        intent3.putExtra("MediaType", enumC0651d.m2978a());
                        intent3.putExtra("InboxNO", str3);
                        intent3.putExtra("Chattype", i2);
                        intent3.putExtra("InboxRawID", (int) j2);
                        intent3.addFlags(268435456);
                        intent3.addFlags(67108864);
                        this.f4560c.startActivity(intent3);
                    }
                }
            }
            if (C1336k.m4626c(this.f4560c)) {
                this.f4559b = Settings.System.getInt(GlobalApplication.m3100a().getContentResolver(), "alertoncall_mode", 1);
                if (this.f4559b == 0) {
                    C1341p.m4660c("[NOTI] ALERTONCALL_OFF", getClass().getSimpleName());
                } else {
                    m4608c();
                }
            }
        }
    }

    /* renamed from: a */
    public void m4610a(int i) {
        this.f4562f.cancel(i);
    }

    /* renamed from: a */
    public void m4609a() {
        this.f4562f.cancelAll();
    }

    /* renamed from: b */
    private boolean m4607b() {
        if (this.f4558a == null) {
            this.f4558a = (ActivityManager) this.f4560c.getSystemService("activity");
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.f4558a.getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(this.f4560c.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m4608c() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Uri actualDefaultRingtoneUri = null;
        String string = this.f4563g.getString("Ringtone", null);
        if (string != null) {
            if (!"Silent".equals(string)) {
                actualDefaultRingtoneUri = Uri.parse(string);
            }
        } else {
            actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f4560c, 2);
        }
        try {
            if (this.f4561e != null) {
                this.f4561e.release();
                this.f4561e = null;
            }
            this.f4561e = new MediaPlayer();
            if (this.f4561e != null) {
                this.f4561e.setAudioStreamType(0);
                this.f4561e.setDataSource(this.f4560c, actualDefaultRingtoneUri);
                this.f4561e.prepare();
                m4606a(this.f4561e);
                this.f4561e.start();
            }
        } catch (Exception e) {
            C1341p.m4660c("makeAlertSound() cated Exception : " + e, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m4606a(MediaPlayer mediaPlayer) {
        AudioManager audioManager;
        if (mediaPlayer != null && (audioManager = (AudioManager) this.f4560c.getSystemService("audio")) != null && audioManager.getStreamVolume(0) > 0.0f) {
            C1341p.m4660c("makeAlertSoundOnCall() - am.getStreamVolume() volume = 0.4", getClass().getSimpleName());
            mediaPlayer.setVolume(0.4f, 0.4f);
        }
    }
}
