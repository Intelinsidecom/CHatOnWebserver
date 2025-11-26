package com.sec.chaton.sns.p114b;

import android.os.Bundle;
import com.renren.android.C0724f;
import com.renren.android.C0726g;
import com.renren.android.Renren;
import com.sec.chaton.sns.p113a.AbstractC4370g;
import java.io.IOException;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.sns.b.v */
/* loaded from: classes.dex */
class C4438v extends AbstractC4370g {

    /* renamed from: f */
    protected String f16013f;

    /* renamed from: g */
    final /* synthetic */ C4432p f16014g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4438v(C4432p c4432p, String str) {
        super(c4432p, str);
        this.f16014g = c4432p;
        this.f16013f = null;
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4370g
    /* renamed from: a */
    protected int mo16575a() {
        return 0;
    }

    /* renamed from: a */
    protected int m16814a(Bundle bundle) throws XmlPullParserException, JSONException, IOException {
        String message;
        int i = -1;
        try {
            String strM2254a = C4432p.f16001d.m2254a(bundle);
            if (strM2254a == null) {
                this.f16014g.m16572b("null response");
                i = -1000;
            } else {
                C0726g.m2305a(strM2254a, Renren.RESPONSE_FORMAT_JSON);
            }
            message = strM2254a;
        } catch (C0724f e) {
            i = -1007;
            message = e.getMessage();
            e.printStackTrace();
        } catch (RuntimeException e2) {
            this.f16014g.m16572b("runtime exception " + e2.getMessage());
            String message2 = e2.getMessage();
            e2.printStackTrace();
            message = message2;
            i = -1000;
        }
        this.f16013f = message;
        this.f15836b = message;
        return i;
    }

    /* renamed from: b */
    protected String m16815b() {
        return this.f16013f;
    }
}
