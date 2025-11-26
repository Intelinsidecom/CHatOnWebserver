package com.sec.chaton.sns.p113a;

import android.content.Context;
import android.content.SharedPreferences;
import com.sec.common.util.C5033j;

/* compiled from: SNSIDSet.java */
/* renamed from: com.sec.chaton.sns.a.e */
/* loaded from: classes.dex */
public class C4368e {

    /* renamed from: a */
    public static String f15815a = "facebook";

    /* renamed from: b */
    public static String f15816b = "twitter";

    /* renamed from: c */
    public static String f15817c = "weibo";

    /* renamed from: d */
    public static String f15818d = "odnoklassniki";

    /* renamed from: e */
    public static String f15819e = "renren";

    /* renamed from: f */
    public static String f15820f = "vk";

    /* renamed from: g */
    public static String f15821g = "SNSIDSetClass";

    /* renamed from: h */
    public static String f15822h = "FACEBOOK_ID_SET_STATUS";

    /* renamed from: i */
    public static String f15823i = "TWITTER_ID_SET_STATUS";

    /* renamed from: j */
    public static String f15824j = "WEIBO_ID_SET_STATUS";

    /* renamed from: k */
    public static String f15825k = "RENREN_ID_SET_STATUS";

    /* renamed from: l */
    public static String f15826l = "VKONTAKTE_ID_SET_STATUS";

    /* renamed from: m */
    public static String f15827m = "ODNOKLASSNIKI_ID_SET_STATUS";

    /* renamed from: n */
    private static Context f15828n;

    /* renamed from: o */
    private static C4368e f15829o;

    /* renamed from: a */
    public static C4368e m16564a(Context context) {
        f15828n = context;
        if (f15829o == null) {
            f15829o = new C4368e();
        }
        return f15829o;
    }

    /* renamed from: a */
    public void m16565a(String str, boolean z) {
        SharedPreferences.Editor editorEdit = f15828n.getSharedPreferences(f15821g, 0).edit();
        editorEdit.putBoolean(str, z);
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: a */
    public boolean m16566a(String str) {
        return f15828n.getSharedPreferences(f15821g, 0).getBoolean(str, false);
    }
}
