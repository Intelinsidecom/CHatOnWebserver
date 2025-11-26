package com.sec.chaton.trunk;

import android.app.Activity;
import android.os.Handler;
import com.sec.chaton.trunk.p058a.C2949a;
import com.sec.chaton.trunk.p058a.p059a.C2950a;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.y */
/* loaded from: classes.dex */
public class C3071y extends AbstractC2948a {

    /* renamed from: c */
    private static final String f11008c = C3071y.class.getSimpleName();

    /* renamed from: d */
    private ITrunkCommentView f11009d;

    /* renamed from: e */
    private Activity f11010e;

    /* renamed from: f */
    private String f11011f;

    /* renamed from: g */
    private String f11012g;

    /* renamed from: h */
    private C2950a f11013h;

    /* renamed from: i */
    private C2949a f11014i;

    /* renamed from: j */
    private Handler f11015j;

    /* renamed from: k */
    private Handler f11016k = new HandlerC3072z(this);

    public C3071y(ITrunkCommentView iTrunkCommentView, Handler handler, String str, String str2) {
        this.f11009d = iTrunkCommentView;
        this.f11011f = str;
        this.f11012g = str2;
        this.f11015j = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: f */
    protected void mo10416f() {
        this.f11010e = this.f11009d.getActivity();
        this.f11014i = new C2949a(this.f11010e, this.f11016k);
        this.f11009d.mo10176a(new C2960aa(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: i */
    protected void mo10419i() {
        this.f11015j = null;
        if (this.f11013h != null) {
            this.f11013h.m5493c();
        }
    }
}
