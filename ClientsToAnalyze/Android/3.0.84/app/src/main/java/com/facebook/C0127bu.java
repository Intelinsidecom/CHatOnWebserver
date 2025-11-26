package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.model.GraphObject;
import com.facebook.p008b.C0105s;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* compiled from: Settings.java */
/* renamed from: com.facebook.bu */
/* loaded from: classes.dex */
public final class C0127bu {

    /* renamed from: b */
    private static volatile Executor f271b;

    /* renamed from: c */
    private static volatile boolean f272c;

    /* renamed from: a */
    private static final HashSet<EnumC0070ak> f270a = new HashSet<>();

    /* renamed from: d */
    private static final Object f273d = new Object();

    /* renamed from: e */
    private static final Uri f274e = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");

    /* renamed from: f */
    private static final BlockingQueue<Runnable> f275f = new LinkedBlockingQueue(10);

    /* renamed from: g */
    private static final ThreadFactory f276g = new ThreadFactoryC0128bv();

    /* renamed from: a */
    public static final boolean m367a(EnumC0070ak enumC0070ak) {
        synchronized (f270a) {
        }
        return false;
    }

    /* renamed from: a */
    public static Executor m365a() {
        synchronized (f273d) {
            if (f271b == null) {
                Executor executorM369c = m369c();
                if (executorM369c == null) {
                    executorM369c = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, f275f, f276g);
                }
                f271b = executorM369c;
            }
        }
        return f271b;
    }

    /* renamed from: c */
    private static Executor m369c() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field field = AsyncTask.class.getField("THREAD_POOL_EXECUTOR");
            if (field == null) {
                return null;
            }
            try {
                Object obj = field.get(null);
                if (obj != null && (obj instanceof Executor)) {
                    return (Executor) obj;
                }
                return null;
            } catch (IllegalAccessException e) {
                return null;
            }
        } catch (NoSuchFieldException e2) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m368b() {
        return f272c;
    }

    /* renamed from: a */
    public static boolean m366a(Context context, String str) throws JSONException {
        if (str == null) {
            return false;
        }
        try {
            String strM364a = m364a(context.getContentResolver());
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            String str2 = str + "ping";
            long jCurrentTimeMillis = sharedPreferences.getLong(str2, 0L);
            if (jCurrentTimeMillis == 0 && strM364a != null) {
                Bundle bundle = new Bundle();
                bundle.putString("fields", "supports_attribution");
                C0072am c0072amM135a = C0072am.m135a((C0107ba) null, str, (InterfaceC0077ar) null);
                c0072amM135a.m169a(bundle);
                Object property = c0072amM135a.m173b().m217b().getProperty("supports_attribution");
                if (!(property instanceof Boolean)) {
                    throw new JSONException(String.format("%s contains %s instead of a Boolean", "supports_attribution", property));
                }
                if (((Boolean) property).booleanValue()) {
                    GraphObject graphObjectCreate = GraphObject.Factory.create();
                    graphObjectCreate.setProperty("event", "MOBILE_APP_INSTALL");
                    graphObjectCreate.setProperty("attribution", strM364a);
                    C0072am.m136a((C0107ba) null, String.format("%s/activities", str), graphObjectCreate, (InterfaceC0077ar) null).m173b();
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    jCurrentTimeMillis = System.currentTimeMillis();
                    editorEdit.putLong(str2, jCurrentTimeMillis);
                    editorEdit.commit();
                }
            }
            return jCurrentTimeMillis != 0;
        } catch (Exception e) {
            C0105s.m271a("Facebook-publish", e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static String m364a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(f274e, new String[]{"aid"}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return null;
        }
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("aid"));
        cursorQuery.close();
        return string;
    }
}
