package com.sec.chaton.settings.tellfriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p015d.C0633e;

/* compiled from: SNSIDSet.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ae */
/* loaded from: classes.dex */
public class C1350ae {

    /* renamed from: a */
    public static String f5157a = "facebook";

    /* renamed from: b */
    public static String f5158b = "twitter";

    /* renamed from: c */
    public static String f5159c = "weibo";

    /* renamed from: d */
    public static String f5160d = "SNSIDSetClass";

    /* renamed from: e */
    public static String f5161e = "FACEBOOK_ID_SET_STATUS";

    /* renamed from: f */
    public static String f5162f = "TWITTER_ID_SET_STATUS";

    /* renamed from: g */
    public static String f5163g = "WEIBO_ID_SET_STATUS";

    /* renamed from: i */
    private static Context f5164i;

    /* renamed from: j */
    private static C1350ae f5165j;

    /* renamed from: k */
    private String f5167k = "";

    /* renamed from: h */
    Handler f5166h = new HandlerC1351af(this, Looper.getMainLooper());

    /* renamed from: a */
    public static C1350ae m5081a(Context context) {
        f5164i = context;
        if (f5165j == null) {
            f5165j = new C1350ae();
        }
        return f5165j;
    }

    /* renamed from: a */
    public void m5083a(String str, String str2) {
        new C0633e(this.f5166h).m2862a(str, str2);
        this.f5167k = str;
    }

    /* renamed from: a */
    public void m5084a(String str, boolean z) {
        SharedPreferences.Editor editorEdit = f5164i.getSharedPreferences(f5160d, 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    /* renamed from: a */
    public boolean m5085a(String str) {
        return f5164i.getSharedPreferences(f5160d, 0).getBoolean(str, false);
    }
}
