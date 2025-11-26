package com.sec.chaton.trunk.p043c.p044a;

import android.content.ContentProviderResult;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.util.C1341p;
import org.apache.http.NameValuePair;

/* compiled from: MarkAsReadTask.java */
/* renamed from: com.sec.chaton.trunk.c.a.f */
/* loaded from: classes.dex */
public class C1158f extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private static final String f4005a = C1158f.class.getSimpleName();

    public C1158f(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        String value;
        String value2;
        String str = "";
        String str2 = "";
        for (NameValuePair nameValuePair : this.f366c.m2531d()) {
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
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("MarkAsRead ItemId: %s", str), f4005a);
        }
        try {
            ContentProviderResult contentProviderResult = C1173b.m4237a(GlobalApplication.m3100a(), C1173b.m4241d(str))[0];
            if (contentProviderResult.count.intValue() > 0) {
                C0634n.m2910b(GlobalApplication.m3100a().getContentResolver(), str2, contentProviderResult.count.intValue());
                return null;
            }
            return null;
        } catch (Exception e) {
            C1341p.m4653a(e, f4005a);
            return null;
        }
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
    }
}
