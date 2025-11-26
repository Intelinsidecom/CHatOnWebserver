package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.model.GraphObject;
import com.facebook.p032b.C0476s;
import com.p137vk.sdk.api.VKApiConst;
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
public final class C0498bu {

    /* renamed from: b */
    private static volatile Executor f1240b;

    /* renamed from: c */
    private static volatile boolean f1241c;

    /* renamed from: a */
    private static final HashSet<EnumC0441ak> f1239a = new HashSet<>();

    /* renamed from: d */
    private static final Object f1242d = new Object();

    /* renamed from: e */
    private static final Uri f1243e = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");

    /* renamed from: f */
    private static final BlockingQueue<Runnable> f1244f = new LinkedBlockingQueue(10);

    /* renamed from: g */
    private static final ThreadFactory f1245g = new ThreadFactoryC0499bv();

    /* renamed from: a */
    public static final boolean m1810a(EnumC0441ak enumC0441ak) {
        synchronized (f1239a) {
        }
        return false;
    }

    /* renamed from: a */
    public static Executor m1808a() {
        synchronized (f1242d) {
            if (f1240b == null) {
                Executor executorM1812c = m1812c();
                if (executorM1812c == null) {
                    executorM1812c = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, f1244f, f1245g);
                }
                f1240b = executorM1812c;
            }
        }
        return f1240b;
    }

    /* renamed from: c */
    private static Executor m1812c() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
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
    public static boolean m1811b() {
        return f1241c;
    }

    /* renamed from: a */
    public static boolean m1809a(Context context, String str) throws JSONException {
        if (str == null) {
            return false;
        }
        try {
            String strM1807a = m1807a(context.getContentResolver());
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            String str2 = str + "ping";
            long jCurrentTimeMillis = sharedPreferences.getLong(str2, 0L);
            if (jCurrentTimeMillis == 0 && strM1807a != null) {
                Bundle bundle = new Bundle();
                bundle.putString(VKApiConst.FIELDS, "supports_attribution");
                C0443am c0443amM1579a = C0443am.m1579a((C0478ba) null, str, (InterfaceC0448ar) null);
                c0443amM1579a.m1613a(bundle);
                Object property = c0443amM1579a.m1617b().m1661b().getProperty("supports_attribution");
                if (!(property instanceof Boolean)) {
                    throw new JSONException(String.format("%s contains %s instead of a Boolean", "supports_attribution", property));
                }
                if (((Boolean) property).booleanValue()) {
                    GraphObject graphObjectCreate = GraphObject.Factory.create();
                    graphObjectCreate.setProperty("event", "MOBILE_APP_INSTALL");
                    graphObjectCreate.setProperty("attribution", strM1807a);
                    C0443am.m1580a((C0478ba) null, String.format("%s/activities", str), graphObjectCreate, (InterfaceC0448ar) null).m1617b();
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    jCurrentTimeMillis = System.currentTimeMillis();
                    editorEdit.putLong(str2, jCurrentTimeMillis);
                    editorEdit.commit();
                }
            }
            return jCurrentTimeMillis != 0;
        } catch (Exception e) {
            C0476s.m1715a("Facebook-publish", e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static String m1807a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(f1243e, new String[]{"aid"}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return null;
        }
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("aid"));
        cursorQuery.close();
        return string;
    }
}
