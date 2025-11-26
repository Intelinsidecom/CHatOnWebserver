package com.sec.chaton.trunk.p048b.p049a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.util.C1786r;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: DeleteItemTask.java */
/* renamed from: com.sec.chaton.trunk.b.a.b */
/* loaded from: classes.dex */
public class C1544b extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f5602d = C1544b.class.getSimpleName();

    public C1544b(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        return null;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        String value;
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            Iterator it = this.f2159a.m3396d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                NameValuePair nameValuePair = (NameValuePair) it.next();
                if (nameValuePair.getName().equals("itemid")) {
                    value = nameValuePair.getValue();
                    break;
                }
            }
            if (C1786r.f6452b) {
                C1786r.m6061b(String.format("Delete trunk item in database: %s", value), f5602d);
            }
            C1584a.m5471a(GlobalApplication.m3260b(), C1584a.m5473b(value));
        }
    }
}
