package com.sec.chaton.p020c;

import android.content.Context;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3216cd;
import com.sec.chaton.util.EnumC3218cf;
import java.util.HashMap;

/* compiled from: NetworkConstant.java */
/* renamed from: com.sec.chaton.c.b */
/* loaded from: classes.dex */
public class C0817b {

    /* renamed from: a */
    public static final String[] f3129a = {"https://gld1.samsungchaton.com", "http://ec2-23-20-216-93.compute-1.amazonaws.com", "https://stg.gld1.samsungchaton.com", "https://stg.gld2.samsungchaton.com", "http://ec2-50-17-226-248.compute-1.amazonaws.com"};

    /* renamed from: b */
    public static final String[] f3130b = {"Production\n" + f3129a[0], "Staging\n" + f3129a[1], "Development\n" + f3129a[2], "SNS dev server\n" + f3129a[3]};

    /* renamed from: c */
    public static HashMap<String, Integer> f3131c = new C0818c();

    /* renamed from: d */
    public static HashMap<String, Integer> f3132d = new C0819d();

    /* renamed from: e */
    public static HashMap<String, Integer> f3133e = new C0820e();

    /* renamed from: f */
    public static HashMap<String, Integer> f3134f = new C0821f();

    /* renamed from: g */
    public static String f3135g = "http://m.facebook.com/dialog/";

    /* renamed from: h */
    public static String f3136h = "http://graph.facebook.com/";

    /* renamed from: i */
    public static String f3137i = "http://api.facebook.com/restserver.php";

    /* renamed from: j */
    public static String f3138j = "https://m.facebook.com/dialog/";

    /* renamed from: k */
    public static String f3139k = "https://graph.facebook.com/";

    /* renamed from: l */
    public static String f3140l = "https://api.facebook.com/restserver.php";

    /* renamed from: m */
    public static String f3141m = "http://twitter.com/oauth/authorize";

    /* renamed from: n */
    public static String f3142n = "https://twitter.com/oauth/authorize";

    /* renamed from: o */
    public static String f3143o = "http://graph.renren.com/renren_api/session_key";

    /* renamed from: p */
    public static String f3144p = "https://graph.renren.com/oauth/authorize";

    /* renamed from: q */
    public static String f3145q = "http://graph.renren.com/oauth/login_success.html";

    /* renamed from: r */
    public static String f3146r = "http://widget.renren.com/callback.html";

    /* renamed from: s */
    public static String f3147s = "http://www.connect.renren.com/feed/iphone/feedPrompt";

    /* renamed from: t */
    public static String f3148t = "http://api.renren.com/restserver.do";

    /* renamed from: u */
    public static String f3149u = "http://apps.renren.com/chaton";

    /* renamed from: v */
    public static String f3150v = "widget.renren.com";

    /* renamed from: a */
    public static String m4370a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(C3216cd.m11282b(EnumC3218cf.PRIMARY)).append(" : ").append(C3216cd.m11284c(EnumC3218cf.PRIMARY)).append("\n");
        sb.append(C3216cd.m11282b(EnumC3218cf.SECONDARY)).append(" : ").append(C3216cd.m11284c(EnumC3218cf.SECONDARY)).append("\n");
        sb.append(C2099k.m8297c((String) null)).append(" : ").append(C2099k.m8283a(-1)).append("\n");
        sb.append(C2099k.m8302d((String) null)).append(" : ").append(C2099k.m8291b(-1)).append("\n");
        sb.append((HeartBeat.m8259a() + 1) * 4).append(" / ").append(HeartBeat.m8263b() != 0).append("\n");
        if (C1302ao.m5595b()) {
            sb.append("Push Type : ").append("Public push").append("\n");
        } else {
            sb.append("Push Type : ").append("non Public push").append("\n");
        }
        sb.append("ChatON id : ").append(C3159aa.m10962a().m10979a("chaton_id", ""));
        boolean zM7918a = C1954g.m7916a().m7918a(GlobalApplication.m11493l(), EnumC1955h.ChatONV);
        sb.append("ChatON V installed : ").append(zM7918a).append("\n");
        if (zM7918a) {
            C0045a c0045a = new C0045a();
            sb.append("ChatON V activation : ").append(c0045a.m55d(GlobalApplication.m11493l())).append("\n");
            sb.append("ChatON V max number of video call : ").append(c0045a.m53b(GlobalApplication.m11493l(), true)).append("\n");
            sb.append("ChatON V max number of voice call : ").append(c0045a.m53b(GlobalApplication.m11493l(), false)).append("\n");
        }
        return sb.toString();
    }
}
