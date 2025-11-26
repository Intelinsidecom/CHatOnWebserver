package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.util.C4822an;

/* compiled from: SmsLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.r */
/* loaded from: classes.dex */
public class C1036r extends AbstractC1019a {
    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        intent.getExtras();
        if (C2349a.m10301a("sms_feature")) {
            C3892o.m15034h();
            if (!C3847e.m14686ar()) {
                return false;
            }
            if (C4822an.m18218a() || C4822an.m18201K()) {
                C3892o.m15032f();
                return false;
            }
            return false;
        }
        return false;
    }
}
