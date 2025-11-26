package com.sec.chaton.sns.p113a;

/* compiled from: SnsManager.java */
/* renamed from: com.sec.chaton.sns.a.g */
/* loaded from: classes.dex */
public abstract class AbstractC4370g {

    /* renamed from: a */
    protected int f15835a = -1;

    /* renamed from: b */
    protected Object f15836b;

    /* renamed from: c */
    final /* synthetic */ AbstractC4369f f15837c;

    /* renamed from: d */
    private String f15838d;

    /* renamed from: a */
    protected abstract int mo16575a();

    public AbstractC4370g(AbstractC4369f abstractC4369f, String str) {
        this.f15837c = abstractC4369f;
        this.f15836b = null;
        this.f15838d = str;
        this.f15836b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Object m16574b() {
        return this.f15836b;
    }

    public String toString() {
        return this.f15838d + " result:" + this.f15835a + "(" + this.f15836b + ")";
    }
}
