package com.sec.chaton.p055d.p056a;

import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p065io.entry.GLDFeaturePolicyEntry;
import com.sec.chaton.p065io.entry.inner.GLDFeaturePolicyEntryList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.List;

/* compiled from: GldFeaturePolicyTask.java */
/* renamed from: com.sec.chaton.d.a.cx */
/* loaded from: classes.dex */
public class C1978cx extends AbstractC1900a {

    /* renamed from: b */
    private static final String f7268b = C1978cx.class.getSimpleName();

    public C1978cx(C2454e c2454e) {
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
        boolean z;
        boolean z2;
        boolean z3 = true;
        GLDFeaturePolicyEntry gLDFeaturePolicyEntry = (GLDFeaturePolicyEntry) c0778b.m3110e();
        if (gLDFeaturePolicyEntry != null) {
            List<GLDFeaturePolicyEntryList> list = gLDFeaturePolicyEntry.feature;
            String[] strArrSplit = C1427a.f5064b.split("[.]");
            CommonApplication.m18732r().getPackageManager();
            if (strArrSplit.length == 3) {
                int length = strArrSplit[2].length();
                if (length > 1 && (strArrSplit[2].substring(length - 1, length).equals("S") || strArrSplit[2].substring(length - 1, length).equals("L"))) {
                    z = false;
                } else if (Integer.parseInt(strArrSplit[2]) % 2 == 0) {
                    z = true;
                    z3 = false;
                } else {
                    z = false;
                    z3 = false;
                }
                z2 = z3;
                z3 = false;
            } else if (Integer.parseInt(strArrSplit[2]) % 2 == 0) {
                z = true;
                z2 = false;
            } else {
                z = false;
                z2 = false;
            }
            C2349a.m10300a(z2, z);
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i).name;
                String str2 = list.get(i).policy;
                C4904y.m18639b("Result Entry : Feature Name " + str, f7268b);
                C4904y.m18639b("Result Entry : Feature Policy " + str2, f7268b);
                C2349a.m10299a(str, str2, z3);
            }
        }
    }
}
