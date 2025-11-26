package com.sec.chaton.p033i.p034a;

import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.p037j.p039b.C1553b;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import com.sec.common.util.log.collector.C3352b;
import com.sec.common.util.log.collector.C3358h;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DebugHttpLog.java */
/* renamed from: com.sec.chaton.i.a.b */
/* loaded from: classes.dex */
public class C1533b extends C3352b {

    /* renamed from: e */
    private static final String f5621e = C1533b.class.getSimpleName();

    public C1533b() throws JSONException {
        this.f12097d = new JSONObject();
        try {
            this.f12097d.put("t", C3347i.m11774a());
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f5621e);
            }
        }
    }

    /* renamed from: a */
    public static void m6522a(String str, String str2, C0267d c0267d) {
        EnumC1587o enumC1587oM1351b;
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && c0267d != null && (enumC1587oM1351b = c0267d.m1351b()) != null && enumC1587oM1351b != EnumC1587o.SUCCESS) {
            String strM1356g = c0267d.m1356g();
            if (strM1356g == null) {
                strM1356g = "";
            }
            C1533b c1533b = new C1533b();
            c1533b.m11827c(str);
            c1533b.m11829d(String.format("%s%04d", str2, Integer.valueOf(c0267d.m1358i())));
            c1533b.m6524a(strM1356g);
            C3358h.m11842a().m11845a(c1533b);
            if (C3250y.f11734b) {
                C3250y.m11450b(c1533b.toString(), f5621e);
            }
        }
    }

    /* renamed from: a */
    public static void m6523a(String str, String str2, HttpURLConnection httpURLConnection) {
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && httpURLConnection != null) {
            try {
                String strM6591a = C1554c.m6591a(new BufferedInputStream(httpURLConnection.getErrorStream()));
                String strM6588a = C1553b.m6588a(strM6591a);
                C1533b c1533b = new C1533b();
                c1533b.m11827c(str);
                c1533b.m11829d(String.format("%s%04d", str2, String.format("%04d", Integer.valueOf(httpURLConnection.getResponseCode()))));
                if (C1553b.m6589b(strM6591a) != null) {
                    c1533b.m6524a(strM6588a);
                }
                C3358h.m11842a().m11845a(c1533b);
                if (C3250y.f11734b) {
                    C3250y.m11450b(c1533b.toString(), f5621e);
                }
            } catch (Exception e) {
                if (C3250y.f11734b) {
                    C3250y.m11443a(e, f5621e);
                }
            }
        }
    }

    /* renamed from: a */
    public void m6524a(String str) {
        try {
            this.f12097d.put("SC", str);
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f5621e);
            }
        }
    }

    public String toString() {
        return String.format("%s|%s|%s", this.f12095b, this.f12096c, this.f12097d.toString());
    }
}
