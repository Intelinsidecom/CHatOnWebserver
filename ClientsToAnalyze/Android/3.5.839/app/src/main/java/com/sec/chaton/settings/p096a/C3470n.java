package com.sec.chaton.settings.p096a;

import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.util.C4809aa;
import com.sec.common.CommonApplication;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EmbededSoundFileDataInfo.java */
/* renamed from: com.sec.chaton.settings.a.n */
/* loaded from: classes.dex */
public class C3470n {

    /* renamed from: a */
    public static String f12935a = C3470n.class.getSimpleName();

    /* renamed from: t */
    private static Map<String, C3470n> f12936t;

    /* renamed from: m */
    public String f12948m;

    /* renamed from: o */
    public String f12950o;

    /* renamed from: q */
    public String f12952q;

    /* renamed from: r */
    int f12953r;

    /* renamed from: s */
    public String f12954s;

    /* renamed from: b */
    public final int f12937b = 0;

    /* renamed from: c */
    public final Integer f12938c = 0;

    /* renamed from: d */
    public final int f12939d = 0;

    /* renamed from: e */
    public final String f12940e = EnumC2258bd.Sound.m10123a();

    /* renamed from: f */
    public final int f12941f = 1;

    /* renamed from: g */
    public final int f12942g = 1;

    /* renamed from: h */
    public final long f12943h = Long.MAX_VALUE;

    /* renamed from: i */
    public final long f12944i = 0;

    /* renamed from: j */
    public final String f12945j = "";

    /* renamed from: k */
    public final String f12946k = "";

    /* renamed from: l */
    public final String f12947l = "";

    /* renamed from: n */
    public Long f12949n = 0L;

    /* renamed from: p */
    public final String f12951p = "";

    /* renamed from: a */
    public static boolean m13797a(String str) {
        return Integer.parseInt(str) < 0;
    }

    /* renamed from: a */
    public static Map<String, C3470n> m13796a() {
        if (f12936t == null) {
            f12936t = new HashMap();
            f12936t.put("-1", new C3470n("-1", "ChatON melody", R.raw.chaton_melody));
            f12936t.put("-2", new C3470n("-2", "ChatON original", R.raw.chaton_orignal));
            f12936t.put("-3", new C3470n("-3", "Horn", R.raw.horn));
            f12936t.put("-4", new C3470n("-4", "Piano's ambience", R.raw.piano_ambience));
            f12936t.put("-5", new C3470n("-5", "Glass wiper", R.raw.glass_wiper));
        }
        return f12936t;
    }

    C3470n(String str, String str2, int i) throws JSONException {
        this.f12948m = str;
        this.f12950o = str2;
        this.f12953r = i;
        this.f12954s = "android.resource://" + CommonApplication.m18732r().getPackageName() + "/" + i;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filesize", this.f12949n);
            jSONObject.put("samplefileurl", "");
            this.f12952q = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m13798b() {
        String strM18121a = C4809aa.m18104a().m18121a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM18121a) && strM18121a.startsWith("android.resource://")) {
            C4809aa.m18104a().m18123a("Ringtone");
        }
    }
}
