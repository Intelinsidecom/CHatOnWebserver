package com.sec.chaton.trunk.p048b.p049a;

import android.content.ContentProviderResult;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.util.C1786r;
import org.apache.http.NameValuePair;

/* compiled from: MarkAsReadTask.java */
/* renamed from: com.sec.chaton.trunk.b.a.g */
/* loaded from: classes.dex */
public class C1549g extends AbstractRunnableC0532a {

    /* renamed from: d */
    private static final String f5608d = C1549g.class.getSimpleName();

    public C1549g(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        String value;
        String value2;
        String str = "";
        String str2 = "";
        for (NameValuePair nameValuePair : this.f2159a.m3396d()) {
            if (nameValuePair.getName().equals("itemid")) {
                String str3 = str2;
                value2 = nameValuePair.getValue();
                value = str3;
            } else if (nameValuePair.getName().equals("sessionid")) {
                value = nameValuePair.getValue();
                value2 = str;
            } else {
                value = str2;
                value2 = str;
            }
            str = value2;
            str2 = value;
        }
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("MarkAsRead ItemId: %s", str), f5608d);
        }
        try {
            ContentProviderResult contentProviderResult = C1584a.m5471a(GlobalApplication.m3260b(), C1584a.m5476e(str))[0];
            if (contentProviderResult.count.intValue() > 0) {
                C0660d.m3025b(GlobalApplication.m3260b().getContentResolver(), str2, contentProviderResult.count.intValue());
                return null;
            }
            return null;
        } catch (Exception e) {
            C1786r.m6056a(e, f5608d);
            return null;
        }
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
    }
}
