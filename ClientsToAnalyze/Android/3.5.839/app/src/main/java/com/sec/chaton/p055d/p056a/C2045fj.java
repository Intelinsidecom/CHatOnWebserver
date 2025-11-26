package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p065io.entry.ViewPackageEntry;
import com.sec.chaton.p065io.entry.inner.Package;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: ViewPackageTask.java */
/* renamed from: com.sec.chaton.d.a.fj */
/* loaded from: classes.dex */
public class C2045fj extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7484b = C1957cc.class.getSimpleName();

    public C2045fj(C2454e c2454e) {
        super(c2454e);
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        C2404a.m10430a("01000011", "0003", c0778b);
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            ViewPackageEntry viewPackageEntry = (ViewPackageEntry) c0778b.m3110e();
            if (viewPackageEntry == null) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Http result object is null.", f7484b);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (C4904y.f17872b) {
                C4904y.m18639b("Save emoticon package to database.", f7484b);
            }
            Package r0 = viewPackageEntry._package;
            if (r0 != null && C4904y.f17872b) {
                C4904y.m18639b(r0.toString(), f7484b);
            }
            C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
        }
    }
}
