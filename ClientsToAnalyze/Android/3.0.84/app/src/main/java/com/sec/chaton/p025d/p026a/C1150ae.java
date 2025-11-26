package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.util.Log;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.Compatibility;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: CompatibilityTask.java */
/* renamed from: com.sec.chaton.d.a.ae */
/* loaded from: classes.dex */
public class C1150ae extends AbstractC1145a {
    public C1150ae(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        ArrayList arrayList = new ArrayList();
        Compatibility compatibility = new Compatibility();
        compatibility.type = "mixed message";
        compatibility.value = "true";
        Compatibility compatibility2 = new Compatibility();
        compatibility2.type = "mixed image";
        compatibility2.value = "true";
        Compatibility compatibility3 = new Compatibility();
        compatibility3.type = "mixed video";
        compatibility3.value = "true";
        Compatibility compatibility4 = new Compatibility();
        compatibility4.type = "mixed geo";
        compatibility4.value = "true";
        Compatibility compatibility5 = new Compatibility();
        compatibility5.type = "mixed anicon";
        compatibility5.value = "true";
        Compatibility compatibility6 = new Compatibility();
        compatibility6.type = "mixed ams";
        compatibility6.value = "true";
        Compatibility compatibility7 = new Compatibility();
        compatibility7.type = "doc";
        compatibility7.value = "true";
        Compatibility compatibility8 = new Compatibility();
        compatibility8.type = "file";
        compatibility8.value = "true";
        Compatibility compatibility9 = new Compatibility();
        compatibility9.type = "ams";
        compatibility9.value = "true";
        Compatibility compatibility10 = new Compatibility();
        compatibility10.type = "anicon";
        compatibility10.value = "true";
        Compatibility compatibility11 = new Compatibility();
        compatibility11.type = "multidevice";
        compatibility11.value = "true";
        Compatibility compatibility12 = new Compatibility();
        compatibility12.type = "mirror msg push alert";
        compatibility12.value = "true";
        Compatibility compatibility13 = new Compatibility();
        compatibility13.type = "push encryption";
        compatibility13.value = "true";
        Compatibility compatibility14 = new Compatibility();
        compatibility14.type = "br2";
        compatibility14.value = "true";
        arrayList.add(compatibility7);
        arrayList.add(compatibility8);
        arrayList.add(compatibility9);
        arrayList.add(compatibility10);
        arrayList.add(compatibility11);
        arrayList.add(compatibility);
        arrayList.add(compatibility2);
        arrayList.add(compatibility3);
        arrayList.add(compatibility4);
        arrayList.add(compatibility5);
        arrayList.add(compatibility6);
        arrayList.add(compatibility12);
        if (C1493a.m6463a("push_message_encrypt_feature")) {
            arrayList.add(compatibility13);
        }
        if (C1493a.m6463a("broadcast2_feature")) {
            arrayList.add(compatibility14);
        }
        String strM11028b = new C3164af().m11028b(arrayList);
        C3250y.m11456e(strM11028b, getClass().getSimpleName());
        return strM11028b;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            C3159aa.m10962a().m10986b("compatibility", C0816a.f3112a);
        } else {
            C3250y.m11456e("httpEntry.getHttpResultCode : " + c0267d.m1351b(), getClass().getSimpleName());
            C3159aa.m10962a().m10986b("compatibility", "");
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C1533b.m6522a("01000099", "0201", c0267d);
            }
        }
        Log.wtf("CHATON_COMPATIBILITY", C3159aa.m10962a().m10979a("compatibility", "") + ", " + c0267d.m1351b());
    }
}
