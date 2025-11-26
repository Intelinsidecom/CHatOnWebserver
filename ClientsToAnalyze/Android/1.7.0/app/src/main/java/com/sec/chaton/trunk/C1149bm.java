package com.sec.chaton.trunk;

import android.app.Activity;
import android.os.Handler;
import com.sec.chaton.trunk.p043c.C1161b;
import com.sec.chaton.trunk.p043c.p044a.C1153a;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.bm */
/* loaded from: classes.dex */
public class C1149bm extends AbstractC1145bi {

    /* renamed from: c */
    private static final String f3982c = C1149bm.class.getSimpleName();

    /* renamed from: d */
    private ITrunkCommentView f3983d;

    /* renamed from: e */
    private Activity f3984e;

    /* renamed from: f */
    private String f3985f;

    /* renamed from: g */
    private String f3986g;

    /* renamed from: h */
    private C1153a f3987h;

    /* renamed from: i */
    private C1161b f3988i;

    /* renamed from: j */
    private Handler f3989j;

    /* renamed from: k */
    private Handler f3990k = new HandlerC1190p(this);

    public C1149bm(ITrunkCommentView iTrunkCommentView, Handler handler, String str, String str2) {
        this.f3983d = iTrunkCommentView;
        this.f3985f = str;
        this.f3986g = str2;
        this.f3989j = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: a */
    protected void mo4118a() {
        this.f3984e = this.f3983d.getActivity();
        this.f3988i = new C1161b(this.f3984e, this.f3990k);
        this.f3983d.mo3966a(new C1191q(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: d */
    protected void mo4121d() {
        this.f3989j = null;
        if (this.f3987h != null) {
            this.f3987h.m686d();
        }
    }
}
