package com.sec.chaton.settings.tellfriends.common;

/* compiled from: SnsManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.p */
/* loaded from: classes.dex */
public abstract class AbstractC2800p {

    /* renamed from: a */
    private String f10303a;

    /* renamed from: e */
    protected int f10304e = -1;

    /* renamed from: f */
    protected Object f10305f;

    /* renamed from: g */
    final /* synthetic */ AbstractC2799o f10306g;

    /* renamed from: a */
    protected abstract int mo9862a();

    public AbstractC2800p(AbstractC2799o abstractC2799o, String str) {
        this.f10306g = abstractC2799o;
        this.f10305f = null;
        this.f10303a = str;
        this.f10305f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Object m10018b() {
        return this.f10305f;
    }

    public String toString() {
        return this.f10303a + " result:" + this.f10304e + "(" + this.f10305f + ")";
    }
}
