package com.sec.chaton.util;

import android.text.TextUtils;
import com.sec.common.p125c.AbstractC4973a;
import java.io.IOException;

/* compiled from: ChatONLogWriter.java */
/* renamed from: com.sec.chaton.util.z */
/* loaded from: classes.dex */
public class C4905z extends AbstractC4973a {
    public C4905z(AbstractC4973a abstractC4973a) {
        super(abstractC4973a);
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: a */
    public void mo18649a(String str, String str2, Throwable th) throws IOException {
        String strM18631a = C4904y.m18631a(th);
        if ((!TextUtils.isEmpty(str2) && str2.contains("imei=")) || strM18631a.contains("imei=")) {
            super.m18894h(str, str2 + "\n" + strM18631a);
        } else {
            super.mo18649a(str, str2, th);
        }
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: a */
    public void mo18650a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super.mo18650a(z, z2, z3, z4, z5);
        C4904y.f17871a = z;
        C4904y.f17872b = z2;
        C4904y.f17873c = z3;
        C4904y.f17874d = z4;
        C4904y.f17875e = z5;
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: a */
    protected void mo18648a(String str, String str2) {
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: b */
    protected void mo18651b(String str, String str2) {
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: c */
    protected void mo18653c(String str, String str2) {
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: d */
    protected void mo18654d(String str, String str2) {
    }

    @Override // com.sec.common.p125c.AbstractC4973a
    /* renamed from: b */
    protected void mo18652b(String str, String str2, Throwable th) {
    }
}
