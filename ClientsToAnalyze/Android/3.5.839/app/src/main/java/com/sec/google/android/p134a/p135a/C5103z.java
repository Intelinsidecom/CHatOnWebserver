package com.sec.google.android.p134a.p135a;

import android.util.Log;
import com.sec.google.android.p134a.C5104b;

/* compiled from: SendReq.java */
/* renamed from: com.sec.google.android.a.a.z */
/* loaded from: classes.dex */
public class C5103z extends C5083f {
    public C5103z() {
        try {
            m19400b(128);
            m19401c(18);
            m19465a("application/vnd.wap.multipart.related".getBytes());
            mo19318a(new C5082e("insert-address-token".getBytes()));
            m19470c(m19464p());
        } catch (C5104b e) {
            Log.e("SendReq", "Unexpected InvalidHeaderValueException.", e);
            throw new RuntimeException(e);
        }
    }

    /* renamed from: p */
    private byte[] m19464p() {
        return ("T" + Long.toHexString(System.currentTimeMillis())).getBytes();
    }

    C5103z(C5093p c5093p, C5086i c5086i) {
        super(c5093p, c5086i);
    }

    /* renamed from: f */
    public byte[] m19473f() {
        return this.f18558a.m19375b(132);
    }

    /* renamed from: a */
    public void m19465a(byte[] bArr) {
        this.f18558a.m19372a(bArr, 132);
    }

    /* renamed from: i */
    public int m19474i() {
        return this.f18558a.m19368a(134);
    }

    /* renamed from: d */
    public void m19471d(int i) throws C5104b {
        this.f18558a.m19369a(i, 134);
    }

    /* renamed from: j */
    public long m19475j() {
        return this.f18558a.m19378e(136);
    }

    /* renamed from: b */
    public void m19467b(long j) {
        this.f18558a.m19370a(j, 136);
    }

    /* renamed from: k */
    public long m19476k() {
        return this.f18558a.m19378e(142);
    }

    /* renamed from: c */
    public void m19469c(long j) {
        this.f18558a.m19370a(j, 142);
    }

    /* renamed from: l */
    public byte[] m19477l() {
        return this.f18558a.m19375b(138);
    }

    /* renamed from: b */
    public void m19468b(byte[] bArr) {
        this.f18558a.m19372a(bArr, 138);
    }

    /* renamed from: m */
    public int m19478m() {
        return this.f18558a.m19368a(144);
    }

    /* renamed from: e */
    public void m19472e(int i) throws C5104b {
        this.f18558a.m19369a(i, 144);
    }

    /* renamed from: a */
    public void m19466a(C5082e[] c5082eArr) {
        this.f18558a.m19373a(c5082eArr, 151);
    }

    /* renamed from: n */
    public byte[] m19479n() {
        return this.f18558a.m19375b(152);
    }

    /* renamed from: c */
    public void m19470c(byte[] bArr) {
        this.f18558a.m19372a(bArr, 152);
    }

    /* renamed from: o */
    public long m19480o() {
        return this.f18558a.m19378e(135);
    }

    @Override // com.sec.google.android.p134a.p135a.C5083f
    /* renamed from: e */
    public long mo19317e() {
        return this.f18558a.m19378e(192);
    }
}
