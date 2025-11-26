package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0776c;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import org.apache.http.Header;

/* compiled from: SendSMSTask.java */
/* renamed from: com.sec.chaton.d.a.bp */
/* loaded from: classes.dex */
public class C0575bp extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2302d;

    public C0575bp(Handler handler, C0798h c0798h, String str) {
        super(handler, c0798h);
        this.f2302d = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        Header[] headerArrM670c;
        if (c0101b.m664a() && c0101b.m665b() == EnumC0803m.ERROR && (headerArrM670c = c0101b.m670c("exptime")) != null) {
            String value = null;
            for (int i = 0; i < headerArrM670c.length; i++) {
                if (headerArrM670c[i].getName().equals("exptime")) {
                    value = headerArrM670c[i].getValue();
                }
            }
            C1786r.m6061b("Response exptime : " + value + " Method : " + this.f2302d, C0776c.class.getSimpleName());
            if (value != null) {
                if (this.f2302d.equals("SMS")) {
                    C1789u.m6079a("sms_expire_time", value);
                } else if (this.f2302d.equals("ACS")) {
                    C1789u.m6079a("acs_expire_time", value);
                }
            }
        }
    }
}
