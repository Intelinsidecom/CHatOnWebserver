package com.google.android.gcm;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class GCMBaseIntentService extends IntentService {

    /* renamed from: a */
    private static PowerManager.WakeLock f1627a;

    /* renamed from: b */
    private static final Object f1628b = GCMBaseIntentService.class;

    /* renamed from: d */
    private static int f1629d = 0;

    /* renamed from: e */
    private static final Random f1630e = new Random();

    /* renamed from: f */
    private static final int f1631f = (int) TimeUnit.SECONDS.toMillis(3600);

    /* renamed from: g */
    private static final String f1632g = Long.toBinaryString(f1630e.nextLong());

    /* renamed from: c */
    private final String[] f1633c;

    /* renamed from: a */
    protected abstract void mo2203a(Context context, Intent intent);

    /* renamed from: b */
    protected abstract void mo2206b(Context context, String str);

    /* renamed from: c */
    protected abstract void mo2207c(Context context, String str);

    /* renamed from: d */
    protected abstract void mo2208d(Context context, String str);

    protected GCMBaseIntentService() {
        this(m2198a("DynamicSenderIds"), null);
    }

    protected GCMBaseIntentService(String... strArr) {
        this(m2199a(strArr), strArr);
    }

    private GCMBaseIntentService(String str, String[] strArr) {
        super(str);
        this.f1633c = strArr;
    }

    /* renamed from: a */
    private static String m2198a(String str) {
        StringBuilder sbAppend = new StringBuilder().append("GCMIntentService-").append(str).append("-");
        int i = f1629d + 1;
        f1629d = i;
        String string = sbAppend.append(i).toString();
        Log.v("GCMBaseIntentService", "Intent service name: " + string);
        return string;
    }

    /* renamed from: a */
    private static String m2199a(String[] strArr) {
        return m2198a(C0693a.m2212a(strArr));
    }

    /* renamed from: a */
    protected String[] m2205a(Context context) {
        if (this.f1633c == null) {
            throw new IllegalStateException("sender id not set on constructor");
        }
        return this.f1633c;
    }

    /* renamed from: a */
    protected void m2202a(Context context, int i) {
    }

    /* renamed from: a */
    protected boolean m2204a(Context context, String str) {
        return true;
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) {
        try {
            Context applicationContext = getApplicationContext();
            String action = intent.getAction();
            if (action.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                C0693a.m2221d(applicationContext);
                m2201b(applicationContext, intent);
            } else if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                String stringExtra = intent.getStringExtra("message_type");
                if (stringExtra == null) {
                    mo2203a(applicationContext, intent);
                } else if (stringExtra.equals("deleted_messages")) {
                    String stringExtra2 = intent.getStringExtra("total_deleted");
                    if (stringExtra2 != null) {
                        try {
                            int i = Integer.parseInt(stringExtra2);
                            Log.v("GCMBaseIntentService", "Received deleted messages notification: " + i);
                            m2202a(applicationContext, i);
                        } catch (NumberFormatException e) {
                            Log.e("GCMBaseIntentService", "GCM returned invalid number of deleted messages: " + stringExtra2);
                        }
                    }
                } else {
                    Log.e("GCMBaseIntentService", "Received unknown special message: " + stringExtra);
                }
            } else if (action.equals("com.google.android.gcm.intent.RETRY")) {
                String stringExtra3 = intent.getStringExtra("token");
                if (!f1632g.equals(stringExtra3)) {
                    Log.e("GCMBaseIntentService", "Received invalid token: " + stringExtra3);
                    synchronized (f1628b) {
                        if (f1627a != null) {
                            Log.v("GCMBaseIntentService", "Releasing wakelock");
                            f1627a.release();
                        } else {
                            Log.e("GCMBaseIntentService", "Wakelock reference is null");
                        }
                    }
                    return;
                }
                if (C0693a.m2223f(applicationContext)) {
                    C0693a.m2220c(applicationContext);
                } else {
                    C0693a.m2219b(applicationContext, m2205a(applicationContext));
                }
            }
            synchronized (f1628b) {
                if (f1627a != null) {
                    Log.v("GCMBaseIntentService", "Releasing wakelock");
                    f1627a.release();
                } else {
                    Log.e("GCMBaseIntentService", "Wakelock reference is null");
                }
            }
        } catch (Throwable th) {
            synchronized (f1628b) {
                if (f1627a != null) {
                    Log.v("GCMBaseIntentService", "Releasing wakelock");
                    f1627a.release();
                } else {
                    Log.e("GCMBaseIntentService", "Wakelock reference is null");
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    static void m2200a(Context context, Intent intent, String str) {
        synchronized (f1628b) {
            if (f1627a == null) {
                f1627a = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
        }
        Log.v("GCMBaseIntentService", "Acquiring wakelock");
        f1627a.acquire();
        intent.setClassName(context, str);
        context.startService(intent);
    }

    /* renamed from: b */
    private void m2201b(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        String stringExtra2 = intent.getStringExtra("error");
        String stringExtra3 = intent.getStringExtra("unregistered");
        Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + stringExtra + ", error = " + stringExtra2 + ", unregistered = " + stringExtra3);
        if (stringExtra != null) {
            C0693a.m2225h(context);
            C0693a.m2211a(context, stringExtra);
            mo2207c(context, stringExtra);
            return;
        }
        if (stringExtra3 != null) {
            C0693a.m2225h(context);
            mo2208d(context, C0693a.m2224g(context));
            return;
        }
        Log.d("GCMBaseIntentService", "Registration error: " + stringExtra2);
        if ("SERVICE_NOT_AVAILABLE".equals(stringExtra2)) {
            if (m2204a(context, stringExtra2)) {
                int iM2226i = C0693a.m2226i(context);
                int iNextInt = f1630e.nextInt(iM2226i) + (iM2226i / 2);
                Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + iNextInt + " (" + iM2226i + ")");
                Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
                intent2.putExtra("token", f1632g);
                ((AlarmManager) context.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + iNextInt, PendingIntent.getBroadcast(context, 0, intent2, 0));
                if (iM2226i < f1631f) {
                    C0693a.m2214a(context, iM2226i * 2);
                    return;
                }
                return;
            }
            Log.d("GCMBaseIntentService", "Not retrying failed operation");
            return;
        }
        mo2206b(context, stringExtra2);
    }
}
