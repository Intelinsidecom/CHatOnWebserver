package com.sec.google.android.p134a;

import java.util.ArrayList;

/* compiled from: ContentType.java */
/* renamed from: com.sec.google.android.a.a */
/* loaded from: classes.dex */
public class C5077a {

    /* renamed from: a */
    private static final ArrayList<String> f18514a = new ArrayList<>();

    /* renamed from: b */
    private static final ArrayList<String> f18515b = new ArrayList<>();

    /* renamed from: c */
    private static final ArrayList<String> f18516c = new ArrayList<>();

    /* renamed from: d */
    private static final ArrayList<String> f18517d = new ArrayList<>();

    static {
        f18514a.add("text/plain");
        f18514a.add("text/html");
        f18514a.add("text/x-vCalendar");
        f18514a.add("text/x-vCard");
        f18514a.add("image/jpeg");
        f18514a.add("image/gif");
        f18514a.add("image/vnd.wap.wbmp");
        f18514a.add("image/png");
        f18514a.add("image/jpg");
        f18514a.add("audio/aac");
        f18514a.add("audio/amr");
        f18514a.add("audio/imelody");
        f18514a.add("audio/mid");
        f18514a.add("audio/midi");
        f18514a.add("audio/mp3");
        f18514a.add("audio/mpeg3");
        f18514a.add("audio/mpeg");
        f18514a.add("audio/mpg");
        f18514a.add("audio/x-mid");
        f18514a.add("audio/x-midi");
        f18514a.add("audio/x-mp3");
        f18514a.add("audio/x-mpeg3");
        f18514a.add("audio/x-mpeg");
        f18514a.add("audio/x-mpg");
        f18514a.add("audio/3gpp");
        f18514a.add("application/ogg");
        f18514a.add("video/3gpp");
        f18514a.add("video/3gpp2");
        f18514a.add("video/h263");
        f18514a.add("video/mp4");
        f18514a.add("application/smil");
        f18514a.add("application/vnd.wap.xhtml+xml");
        f18514a.add("application/xhtml+xml");
        f18514a.add("application/vnd.oma.drm.content");
        f18514a.add("application/vnd.oma.drm.message");
        f18515b.add("image/jpeg");
        f18515b.add("image/gif");
        f18515b.add("image/vnd.wap.wbmp");
        f18515b.add("image/png");
        f18515b.add("image/jpg");
        f18516c.add("audio/aac");
        f18516c.add("audio/amr");
        f18516c.add("audio/imelody");
        f18516c.add("audio/mid");
        f18516c.add("audio/midi");
        f18516c.add("audio/mp3");
        f18516c.add("audio/mpeg3");
        f18516c.add("audio/mpeg");
        f18516c.add("audio/mpg");
        f18516c.add("audio/mp4");
        f18516c.add("audio/x-mid");
        f18516c.add("audio/x-midi");
        f18516c.add("audio/x-mp3");
        f18516c.add("audio/x-mpeg3");
        f18516c.add("audio/x-mpeg");
        f18516c.add("audio/x-mpg");
        f18516c.add("audio/3gpp");
        f18516c.add("application/ogg");
        f18517d.add("video/3gpp");
        f18517d.add("video/3gpp2");
        f18517d.add("video/h263");
        f18517d.add("video/mp4");
    }

    /* renamed from: a */
    public static boolean m19286a(String str) {
        return str != null && str.startsWith("text/");
    }

    /* renamed from: b */
    public static boolean m19288b(String str) {
        return str != null && str.startsWith("image/");
    }

    /* renamed from: c */
    public static boolean m19290c(String str) {
        return str != null && str.startsWith("audio/");
    }

    /* renamed from: d */
    public static boolean m19291d(String str) {
        return str != null && str.startsWith("video/");
    }

    /* renamed from: e */
    public static boolean m19292e(String str) {
        return str != null && str.startsWith("text/x-vCard");
    }

    /* renamed from: f */
    public static boolean m19293f(String str) {
        return str != null && str.startsWith("text/x-vCalendar");
    }

    /* renamed from: g */
    public static boolean m19294g(String str) {
        return str != null && (str.equals("application/vnd.oma.drm.content") || str.equals("application/vnd.oma.drm.message"));
    }

    /* renamed from: a */
    public static ArrayList<String> m19285a() {
        return (ArrayList) f18515b.clone();
    }

    /* renamed from: b */
    public static ArrayList<String> m19287b() {
        return (ArrayList) f18516c.clone();
    }

    /* renamed from: c */
    public static ArrayList<String> m19289c() {
        return (ArrayList) f18517d.clone();
    }
}
