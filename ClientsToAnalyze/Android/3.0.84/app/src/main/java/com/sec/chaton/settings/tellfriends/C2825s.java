package com.sec.chaton.settings.tellfriends;

import android.os.Bundle;
import com.renren.android.C0212f;
import com.renren.android.C0214g;
import com.renren.android.Renren;
import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import java.io.IOException;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.s */
/* loaded from: classes.dex */
class C2825s extends AbstractC2800p {

    /* renamed from: c */
    protected String f10356c;

    /* renamed from: d */
    final /* synthetic */ C2819m f10357d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2825s(C2819m c2819m, String str) {
        super(c2819m, str);
        this.f10357d = c2819m;
        this.f10356c = null;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        return 0;
    }

    /* renamed from: a */
    protected int m10056a(Bundle bundle) throws XmlPullParserException, JSONException, IOException {
        String message;
        int i = -1;
        try {
            String strM522a = C2819m.f10344d.m522a(bundle);
            if (strM522a == null) {
                this.f10357d.m10015c("null response");
                i = -1000;
            } else {
                C0214g.m573a(strM522a, Renren.RESPONSE_FORMAT_JSON);
            }
            message = strM522a;
        } catch (C0212f e) {
            i = -1007;
            message = e.getMessage();
            e.printStackTrace();
        } catch (RuntimeException e2) {
            this.f10357d.m10015c("runtime exception " + e2.getMessage());
            String message2 = e2.getMessage();
            e2.printStackTrace();
            message = message2;
            i = -1000;
        }
        this.f10356c = message;
        this.f10305f = message;
        return i;
    }

    /* renamed from: b */
    protected String m10057b() {
        return this.f10356c;
    }
}
