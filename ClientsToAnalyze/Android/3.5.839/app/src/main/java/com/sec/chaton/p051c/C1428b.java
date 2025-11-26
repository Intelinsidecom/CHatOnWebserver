package com.sec.chaton.p051c;

import android.content.Context;
import com.coolots.sso.p030a.C0416a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.push.C3099k;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.EnumC4867ce;
import java.util.HashMap;

/* compiled from: NetworkConstant.java */
/* renamed from: com.sec.chaton.c.b */
/* loaded from: classes.dex */
public class C1428b {

    /* renamed from: a */
    public static final String[] f5095a = {"https://gld1.samsungchaton.com", "http://lb-due1wg1gd-1821392689.us-east-1.elb.amazonaws.com", "https://stg.gld1.samsungchaton.com", "https://stg.gld2.samsungchaton.com", "http://ec2-50-17-226-248.compute-1.amazonaws.com"};

    /* renamed from: b */
    public static final String[] f5096b = {"Production\n" + f5095a[0], "Staging\n" + f5095a[1], "Development\n" + f5095a[2], "SNS dev server\n" + f5095a[3]};

    /* renamed from: c */
    public static HashMap<String, Integer> f5097c = new C1429c();

    /* renamed from: d */
    public static HashMap<String, Integer> f5098d = new C1430d();

    /* renamed from: e */
    public static HashMap<String, Integer> f5099e = new C1431e();

    /* renamed from: f */
    public static HashMap<String, Integer> f5100f = new C1432f();

    /* renamed from: g */
    public static String f5101g = "/shop/purchase/sync";

    /* renamed from: h */
    public static String f5102h = "/shop/plusmenu/list";

    /* renamed from: i */
    public static String f5103i = "/shop/item/get-characters";

    /* renamed from: j */
    public static String f5104j = "/contents/sticker/install";

    /* renamed from: k */
    public static String f5105k = "/contents/item/style/install";

    /* renamed from: l */
    public static String f5106l = "/contents/item/ringtone/install";

    /* renamed from: m */
    public static String f5107m = "http://m.facebook.com/dialog/";

    /* renamed from: n */
    public static String f5108n = "http://graph.facebook.com/";

    /* renamed from: o */
    public static String f5109o = "http://api.facebook.com/restserver.php";

    /* renamed from: p */
    public static String f5110p = "https://m.facebook.com/dialog/";

    /* renamed from: q */
    public static String f5111q = "https://graph.facebook.com/";

    /* renamed from: r */
    public static String f5112r = "https://api.facebook.com/restserver.php";

    /* renamed from: s */
    public static String f5113s = "http://twitter.com/oauth/authorize";

    /* renamed from: t */
    public static String f5114t = "https://twitter.com/oauth/authorize";

    /* renamed from: u */
    public static String f5115u = "http://graph.renren.com/renren_api/session_key";

    /* renamed from: v */
    public static String f5116v = "https://graph.renren.com/oauth/authorize";

    /* renamed from: w */
    public static String f5117w = "http://graph.renren.com/oauth/login_success.html";

    /* renamed from: x */
    public static String f5118x = "http://widget.renren.com/callback.html";

    /* renamed from: y */
    public static String f5119y = "http://www.connect.renren.com/feed/iphone/feedPrompt";

    /* renamed from: z */
    public static String f5120z = "http://api.renren.com/restserver.do";

    /* renamed from: A */
    public static String f5085A = "http://apps.renren.com/chaton";

    /* renamed from: B */
    public static String f5086B = "widget.renren.com";

    /* renamed from: C */
    public static String f5087C = "http://odnoklassniki.ru/oauth/authorize";

    /* renamed from: D */
    public static String f5088D = "https://odnoklassniki.ru/oauth/authorize";

    /* renamed from: E */
    public static String f5089E = "https://oauth.vk.com/authorize";

    /* renamed from: F */
    public static String f5090F = "https://oauth.vk.com/blank.html";

    /* renamed from: G */
    public static String f5091G = "5.7";

    /* renamed from: H */
    public static String f5092H = "itemId";

    /* renamed from: I */
    public static String f5093I = "langcd";

    /* renamed from: J */
    public static String f5094J = "cntrycd";

    /* renamed from: a */
    public static String m7525a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(C4865cc.m18449b(EnumC4867ce.PRIMARY)).append(" : ").append(C4865cc.m18451c(EnumC4867ce.PRIMARY)).append("\n");
        sb.append(C4865cc.m18449b(EnumC4867ce.SECONDARY)).append(" : ").append(C4865cc.m18451c(EnumC4867ce.SECONDARY)).append("\n");
        sb.append(C3099k.m12640c((String) null)).append(" : ").append(C3099k.m12626a(-1)).append("\n");
        sb.append(C3099k.m12645d((String) null)).append(" : ").append(C3099k.m12634b(-1)).append("\n");
        sb.append((HeartBeat.m12602a() + 1) * 4).append(" / ").append(HeartBeat.m12606b() != 0).append("\n");
        if (C2093az.m9338b()) {
            sb.append("Push Type : ").append("Public push").append("\n");
        } else {
            sb.append("Push Type : ").append("non Public push").append("\n");
        }
        sb.append("ChatON id : ").append(C4809aa.m18104a().m18121a("chaton_id", ""));
        boolean zM12192a = C2948h.m12190a().m12192a(GlobalApplication.m18732r(), EnumC2949i.ChatONV);
        sb.append("ChatON V installed : ").append(zM12192a).append("\n");
        if (zM12192a) {
            C0416a c0416a = new C0416a();
            sb.append("ChatON V activation : ").append(c0416a.m1495d(GlobalApplication.m18732r())).append("\n");
            sb.append("ChatON V max number of video call : ").append(c0416a.m1493b(GlobalApplication.m18732r(), true)).append("\n");
            sb.append("ChatON V max number of voice call : ").append(c0416a.m1493b(GlobalApplication.m18732r(), false)).append("\n");
        }
        return sb.toString();
    }
}
