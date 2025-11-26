package com.sec.chaton.settings.tellfriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

/* compiled from: SNSIDSet.java */
/* renamed from: com.sec.chaton.settings.tellfriends.y */
/* loaded from: classes.dex */
public class C2831y {

    /* renamed from: a */
    public static String f10362a = "facebook";

    /* renamed from: b */
    public static String f10363b = "twitter";

    /* renamed from: c */
    public static String f10364c = "weibo";

    /* renamed from: d */
    public static String f10365d = "renren";

    /* renamed from: e */
    public static String f10366e = "SNSIDSetClass";

    /* renamed from: f */
    public static String f10367f = "FACEBOOK_ID_SET_STATUS";

    /* renamed from: g */
    public static String f10368g = "TWITTER_ID_SET_STATUS";

    /* renamed from: h */
    public static String f10369h = "WEIBO_ID_SET_STATUS";

    /* renamed from: i */
    public static String f10370i = "RENREN_ID_SET_STATUS";

    /* renamed from: k */
    private static Context f10371k;

    /* renamed from: l */
    private static C2831y f10372l;

    /* renamed from: m */
    private String f10374m = "";

    /* renamed from: j */
    Handler f10373j = new HandlerC2832z(this);

    /* renamed from: a */
    public static C2831y m10064a(Context context) {
        f10371k = context;
        if (f10372l == null) {
            f10372l = new C2831y();
        }
        return f10372l;
    }

    /* renamed from: a */
    public void m10066a(String str, boolean z) {
        SharedPreferences.Editor editorEdit = f10371k.getSharedPreferences(f10366e, 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }
}
