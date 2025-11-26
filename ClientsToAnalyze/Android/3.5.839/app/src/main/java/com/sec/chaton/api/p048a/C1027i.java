package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* compiled from: LinkProcessorManager.java */
/* renamed from: com.sec.chaton.api.a.i */
/* loaded from: classes.dex */
public class C1027i {

    /* renamed from: a */
    private static final String f3327a = C1027i.class.getSimpleName();

    /* renamed from: b */
    private AbstractC1019a[] f3328b;

    public C1027i(AbstractC1019a[] abstractC1019aArr) {
        if (abstractC1019aArr == null || abstractC1019aArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f3328b = abstractC1019aArr;
    }

    /* renamed from: a */
    public boolean m6130a(Activity activity, Intent intent) {
        for (AbstractC1019a abstractC1019a : this.f3328b) {
            if (abstractC1019a.mo6112a(activity, intent)) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Handeled by " + abstractC1019a, f3327a);
                }
                return true;
            }
        }
        if (!C4904y.f17872b) {
            return false;
        }
        C4904y.m18639b("Can't find link processor.", f3327a);
        return false;
    }
}
