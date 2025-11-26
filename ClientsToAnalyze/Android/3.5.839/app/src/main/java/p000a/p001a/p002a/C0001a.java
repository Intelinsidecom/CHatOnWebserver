package p000a.p001a.p002a;

import android.net.Uri;

/* compiled from: StreamProviderConstants.java */
/* renamed from: a.a.a.a */
/* loaded from: classes.dex */
public class C0001a {

    /* renamed from: a */
    public static final Uri f0a = Uri.parse("content://sstream.app.provider.StoryProvider");

    /* renamed from: b */
    public static final Uri f1b = Uri.parse(f0a + "/story");

    /* renamed from: c */
    public static final Uri f2c = Uri.parse(f1b + "/delete");

    /* renamed from: d */
    public static final Uri f3d = Uri.parse(f1b + "/delete_bulk");

    /* renamed from: e */
    public static final String[] f4e = {"id", "stream_id", "application_name", "category", "type", "title", "body", "image_url", "image_hints", "image_height", "image_width", "author_name", "author_image_url", "author_image_height", "author_image_width", "time_stamp", "more", "source"};
}
