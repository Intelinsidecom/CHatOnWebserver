package com.sec.chaton.trunk;

import android.app.Activity;
import android.os.Handler;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.trunk.p118a.C4565a;
import java.util.concurrent.Future;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.y */
/* loaded from: classes.dex */
public class C4691y extends AbstractC4564a {

    /* renamed from: c */
    private static final String f16957c = C4691y.class.getSimpleName();

    /* renamed from: d */
    private ITrunkCommentView f16958d;

    /* renamed from: e */
    private Activity f16959e;

    /* renamed from: f */
    private String f16960f;

    /* renamed from: g */
    private String f16961g;

    /* renamed from: h */
    private Future<C0778b> f16962h;

    /* renamed from: i */
    private C4565a f16963i;

    /* renamed from: j */
    private Handler f16964j;

    /* renamed from: k */
    private Handler f16965k = new HandlerC4692z(this);

    public C4691y(ITrunkCommentView iTrunkCommentView, Handler handler, String str, String str2) {
        this.f16958d = iTrunkCommentView;
        this.f16960f = str;
        this.f16961g = str2;
        this.f16964j = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: f */
    protected void mo17513f() {
        this.f16959e = this.f16958d.getActivity();
        this.f16963i = new C4565a(this.f16959e, this.f16965k);
        this.f16958d.mo17264a(new C4576aa(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: i */
    protected void mo17516i() {
        this.f16964j = null;
        if (this.f16962h != null) {
            this.f16962h.cancel(true);
        }
    }
}
