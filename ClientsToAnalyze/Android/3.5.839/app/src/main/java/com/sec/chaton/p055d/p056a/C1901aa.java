package com.sec.chaton.p055d.p056a;

import android.util.Log;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.Compatibility;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: CompatibilityTask.java */
/* renamed from: com.sec.chaton.d.a.aa */
/* loaded from: classes.dex */
public class C1901aa extends AbstractC1900a {
    public C1901aa(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
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
        compatibility11.type = "glympse";
        compatibility11.value = "true";
        Compatibility compatibility12 = new Compatibility();
        compatibility12.type = "hugefile";
        compatibility12.value = "true";
        Compatibility compatibility13 = new Compatibility();
        compatibility13.type = "multidevice";
        compatibility13.value = "true";
        Compatibility compatibility14 = new Compatibility();
        compatibility14.type = "mirror msg push alert";
        compatibility14.value = "true";
        Compatibility compatibility15 = new Compatibility();
        compatibility15.type = "push encryption";
        compatibility15.value = "true";
        Compatibility compatibility16 = new Compatibility();
        compatibility16.type = "br2";
        compatibility16.value = "true";
        Compatibility compatibility17 = new Compatibility();
        compatibility17.type = "multidevice active connection";
        compatibility17.value = "true";
        Compatibility compatibility18 = new Compatibility();
        compatibility18.type = "forward message";
        compatibility18.value = "true";
        Compatibility compatibility19 = new Compatibility();
        compatibility19.type = "mirror ack";
        compatibility19.value = "true";
        Compatibility compatibility20 = new Compatibility();
        compatibility20.type = "sms invite";
        compatibility20.value = "true";
        Compatibility compatibility21 = new Compatibility();
        compatibility21.type = "group block";
        compatibility21.value = "true";
        Compatibility compatibility22 = new Compatibility();
        compatibility22.type = "feed push";
        compatibility22.value = "true";
        Compatibility compatibility23 = new Compatibility();
        compatibility23.type = "push connection alert";
        compatibility23.value = "true";
        Compatibility compatibility24 = new Compatibility();
        compatibility24.type = "topic chat";
        compatibility24.value = "true";
        Compatibility compatibility25 = new Compatibility();
        compatibility25.type = "group title change";
        compatibility25.value = "true";
        arrayList.add(compatibility7);
        arrayList.add(compatibility8);
        arrayList.add(compatibility9);
        arrayList.add(compatibility10);
        arrayList.add(compatibility13);
        arrayList.add(compatibility);
        arrayList.add(compatibility2);
        arrayList.add(compatibility3);
        arrayList.add(compatibility4);
        arrayList.add(compatibility5);
        arrayList.add(compatibility6);
        arrayList.add(compatibility11);
        arrayList.add(compatibility12);
        arrayList.add(compatibility14);
        if (C2349a.m10301a("push_message_encrypt_feature")) {
            arrayList.add(compatibility15);
        }
        if (C2349a.m10301a("broadcast2_feature")) {
            arrayList.add(compatibility16);
        }
        if (C2349a.m10301a("active_connection_feature")) {
            arrayList.add(compatibility17);
        }
        arrayList.add(compatibility18);
        arrayList.add(compatibility20);
        if (C2349a.m10301a("mirror_ack_feature")) {
            arrayList.add(compatibility19);
        }
        arrayList.add(compatibility21);
        arrayList.add(compatibility22);
        arrayList.add(compatibility23);
        arrayList.add(compatibility24);
        if (C2349a.m10301a("chat_message_withdraw")) {
            Compatibility compatibility26 = new Compatibility();
            compatibility26.type = "message cancel";
            compatibility26.value = "true";
            arrayList.add(compatibility26);
        }
        arrayList.add(compatibility25);
        String strM18174b = new C4815ag().m18174b(arrayList);
        C4904y.m18646e(strM18174b, getClass().getSimpleName());
        return strM18174b;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            C4809aa.m18104a().m18128b("compatibility", C1427a.f5063a);
        } else {
            C4904y.m18646e("httpEntry.getHttpResultCode : " + c0778b.m3107b(), getClass().getSimpleName());
            C4809aa.m18104a().m18128b("compatibility", "");
            C2404a.m10430a("01000099", "0201", c0778b);
        }
        Log.wtf("CHATON_COMPATIBILITY", C4809aa.m18104a().m18121a("compatibility", "") + ", " + c0778b.m3107b());
    }
}
