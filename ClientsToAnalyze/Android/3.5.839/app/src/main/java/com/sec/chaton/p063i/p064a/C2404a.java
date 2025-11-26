package com.sec.chaton.p063i.p064a;

import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p067j.p069b.C2432b;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import com.sec.common.util.log.collector.C5037b;
import com.sec.common.util.log.collector.C5038c;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DebugHttpLog.java */
/* renamed from: com.sec.chaton.i.a.a */
/* loaded from: classes.dex */
public class C2404a extends C5037b {

    /* renamed from: f */
    private static final String f8544f = C2404a.class.getSimpleName();

    public C2404a() throws JSONException {
        this.f18361e = new JSONObject();
        try {
            this.f18361e.put("t", C5034k.m19090a());
        } catch (JSONException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f8544f);
            }
        }
    }

    /* renamed from: a */
    public static void m10430a(String str, String str2, C0778b c0778b) {
        EnumC2464o enumC2464oM3107b;
        if (!C5038c.m19168q() || !C5038c.m19167p() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || c0778b == null || (enumC2464oM3107b = c0778b.m3107b()) == null || enumC2464oM3107b == EnumC2464o.SUCCESS || c0778b.m3112g() == null) {
        }
    }

    /* renamed from: a */
    public static void m10431a(String str, String str2, HttpURLConnection httpURLConnection) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && httpURLConnection != null) {
            try {
                C2432b.m10533a(C2433c.m10535a(new BufferedInputStream(httpURLConnection.getErrorStream())));
            } catch (Exception e) {
                if (C4904y.f17872b) {
                    C4904y.m18635a(e, f8544f);
                }
            }
        }
    }

    public String toString() {
        return String.format("%s|%s|%s", this.f18358b, this.f18359c, this.f18361e.toString());
    }
}
