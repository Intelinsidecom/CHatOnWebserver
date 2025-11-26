package com.sec.chaton.trunk;

import android.app.Activity;
import android.os.Handler;
import com.sec.chaton.trunk.p048b.C1542a;
import com.sec.chaton.trunk.p048b.p049a.C1543a;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.v */
/* loaded from: classes.dex */
public class C1616v extends AbstractC1512a {

    /* renamed from: c */
    private static final String f5759c = C1616v.class.getSimpleName();

    /* renamed from: d */
    private ITrunkCommentView f5760d;

    /* renamed from: e */
    private Activity f5761e;

    /* renamed from: f */
    private String f5762f;

    /* renamed from: g */
    private String f5763g;

    /* renamed from: h */
    private C1543a f5764h;

    /* renamed from: i */
    private C1542a f5765i;

    /* renamed from: j */
    private Handler f5766j;

    /* renamed from: k */
    private Handler f5767k = new HandlerC1617w(this);

    public C1616v(ITrunkCommentView iTrunkCommentView, Handler handler, String str, String str2) {
        this.f5760d = iTrunkCommentView;
        this.f5762f = str;
        this.f5763g = str2;
        this.f5766j = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: f */
    protected void mo5359f() {
        this.f5761e = this.f5760d.getActivity();
        this.f5765i = new C1542a(this.f5761e, this.f5767k);
        this.f5760d.mo5225a(new C1618x(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: i */
    protected void mo5362i() {
        this.f5766j = null;
        if (this.f5764h != null) {
            this.f5764h.m2710c();
        }
    }
}
