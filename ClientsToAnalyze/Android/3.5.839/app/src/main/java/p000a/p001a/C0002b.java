package p000a.p001a;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import p000a.p001a.p002a.C0001a;
import p000a.p001a.p003b.C0006d;

/* compiled from: SStreamContentManager.java */
/* renamed from: a.a.b */
/* loaded from: classes.dex */
public class C0002b {

    /* renamed from: a */
    private static boolean f5a = false;

    /* renamed from: b */
    private static boolean f6b = true;

    /* renamed from: a */
    private static boolean m4a(Context context) {
        if (!f5a) {
            f5a = true;
            try {
                switch (context.getPackageManager().getApplicationEnabledSetting("sstream.app")) {
                    case 0:
                    case 1:
                        f6b = true;
                        break;
                    default:
                        f6b = false;
                        break;
                }
            } catch (IllegalArgumentException e) {
                f6b = false;
            }
        }
        if (!f6b) {
            Log.d("SStreamContentManager", "SStream is disabled  or not installed");
        }
        return f6b;
    }

    /* renamed from: a */
    public static void m2a(Context context, C0006d c0006d) {
        if (m4a(context)) {
            context.getContentResolver().insert(C0001a.f1b, m0a(c0006d));
        }
    }

    /* renamed from: a */
    public static void m3a(Context context, String str, String str2) {
        if (m4a(context)) {
            if (str2 == null) {
                throw new NullPointerException("streamId is missing");
            }
            context.getContentResolver().delete(C0001a.f3d, "application_name=? AND stream_id=?", new String[]{"", str, str2});
        }
    }

    /* renamed from: a */
    public static String m1a(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null || data.getScheme() == null || !data.getScheme().equals("sstream") || data.getHost() == null || !data.getHost().equals("storyitem")) {
            return null;
        }
        String lastPathSegment = data.getLastPathSegment();
        System.out.println("StoryItem " + lastPathSegment);
        return lastPathSegment;
    }

    /* renamed from: b */
    public static boolean m6b(Intent intent) {
        Uri data;
        boolean z = false;
        if (intent != null && (data = intent.getData()) != null && data.getScheme() != null && data.getScheme().equals("sstream") && data.getHost() != null && data.getHost().equals("storyitem")) {
            if (data.getQueryParameter("more") != null && data.getQueryParameter("more").equals("true")) {
                z = true;
            }
            System.out.println("isMore " + z);
        }
        return z;
    }

    /* renamed from: a */
    private static ContentValues m0a(C0006d c0006d) throws C0000a {
        m5b(c0006d);
        ContentValues contentValues = new ContentValues();
        long jM18f = c0006d.m18f();
        if (jM18f >= Math.pow(10.0d, 12.0d)) {
            jM18f /= 1000;
        }
        contentValues.put("id", c0006d.m15c());
        contentValues.put("stream_id", c0006d.m20h());
        contentValues.put("category", c0006d.m13a());
        contentValues.put("application_name", c0006d.m21i());
        contentValues.put("title", c0006d.m14b());
        contentValues.put("body", c0006d.m17e());
        contentValues.put("type", c0006d.m22j().toString());
        contentValues.put("author_name", c0006d.m16d().m7a());
        contentValues.put("time_stamp", Long.valueOf(jM18f));
        contentValues.put("more", Integer.valueOf(c0006d.m23k()));
        contentValues.put("source", c0006d.m24l());
        if (c0006d.m19g() != null) {
            contentValues.put("image_url", c0006d.m19g().m9a());
            contentValues.put("image_hints", c0006d.m19g().m12d());
            contentValues.put("image_height", Integer.valueOf(c0006d.m19g().m11c()));
            contentValues.put("image_width", Integer.valueOf(c0006d.m19g().m10b()));
        }
        if (c0006d.m16d().m8b() != null) {
            contentValues.put("author_image_url", c0006d.m16d().m8b().m9a());
            contentValues.put("author_image_height", Integer.valueOf(c0006d.m16d().m8b().m11c()));
            contentValues.put("author_image_width", Integer.valueOf(c0006d.m16d().m8b().m10b()));
        }
        return contentValues;
    }

    /* renamed from: b */
    private static void m5b(C0006d c0006d) throws C0000a {
        if (c0006d == null) {
            throw new C0000a("StoryItem is null");
        }
        String str = "";
        if (c0006d.m15c() == null) {
            str = "id";
        }
        if (c0006d.m20h() == null) {
            str = String.valueOf(str) + (str.isEmpty() ? "streamId" : ", streamId");
        }
        if (c0006d.m21i() == null) {
            str = String.valueOf(str) + (str.isEmpty() ? "appPackage" : ", appPackage");
        }
        if (!str.isEmpty()) {
            throw new C0000a(String.format("StoryItem is incomplete. The following properties are missing: %s", str));
        }
    }
}
