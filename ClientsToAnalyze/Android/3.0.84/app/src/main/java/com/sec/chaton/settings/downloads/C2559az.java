package com.sec.chaton.settings.downloads;

import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.util.C3159aa;
import com.sec.common.CommonApplication;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EmbededSoundFileDataInfo.java */
/* renamed from: com.sec.chaton.settings.downloads.az */
/* loaded from: classes.dex */
public class C2559az {

    /* renamed from: a */
    public static String f9719a = C2559az.class.getSimpleName();

    /* renamed from: t */
    private static Map<String, C2559az> f9720t;

    /* renamed from: m */
    public String f9732m;

    /* renamed from: o */
    public String f9734o;

    /* renamed from: q */
    public String f9736q;

    /* renamed from: r */
    int f9737r;

    /* renamed from: s */
    public String f9738s;

    /* renamed from: b */
    public final int f9721b = 0;

    /* renamed from: c */
    public final Integer f9722c = 0;

    /* renamed from: d */
    public final int f9723d = 0;

    /* renamed from: e */
    public final String f9724e = EnumC1399aq.Sound.m6252a();

    /* renamed from: f */
    public final int f9725f = 1;

    /* renamed from: g */
    public final int f9726g = 1;

    /* renamed from: h */
    public final long f9727h = Long.MAX_VALUE;

    /* renamed from: i */
    public final long f9728i = 0;

    /* renamed from: j */
    public final String f9729j = "";

    /* renamed from: k */
    public final String f9730k = "";

    /* renamed from: l */
    public final String f9731l = "";

    /* renamed from: n */
    public Long f9733n = 0L;

    /* renamed from: p */
    public final String f9735p = "";

    /* renamed from: a */
    public static boolean m9507a(String str) {
        return Integer.parseInt(str) < 0;
    }

    /* renamed from: a */
    public static Map<String, C2559az> m9506a() {
        if (f9720t == null) {
            f9720t = new HashMap();
            f9720t.put("-1", new C2559az("-1", "ChatON melody", R.raw.chaton_melody));
            f9720t.put("-2", new C2559az("-2", "ChatON original", R.raw.chaton_orignal));
            f9720t.put("-3", new C2559az("-3", "Horn", R.raw.horn));
            f9720t.put("-4", new C2559az("-4", "Piano's ambience", R.raw.piano_ambience));
            f9720t.put("-5", new C2559az("-5", "Glass wiper", R.raw.glass_wiper));
        }
        return f9720t;
    }

    C2559az(String str, String str2, int i) throws JSONException {
        this.f9732m = str;
        this.f9734o = str2;
        this.f9737r = i;
        this.f9738s = "android.resource://" + CommonApplication.m11493l().getPackageName() + "/" + i;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filesize", this.f9733n);
            jSONObject.put("samplefileurl", "");
            this.f9736q = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m9508b() {
        String strM10979a = C3159aa.m10962a().m10979a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM10979a) && strM10979a.startsWith("android.resource://")) {
            C3159aa.m10962a().m10981a("Ringtone");
        }
    }
}
