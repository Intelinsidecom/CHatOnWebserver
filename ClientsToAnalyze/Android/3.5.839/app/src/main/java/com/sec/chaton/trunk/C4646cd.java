package com.sec.chaton.trunk;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.InterfaceC0028an;
import android.support.v4.content.C0091c;
import android.support.v4.content.C0094f;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.trunk.database.C4667c;
import com.sec.chaton.trunk.p118a.C4565a;
import com.sec.chaton.trunk.p118a.EnumC4575b;
import com.sec.chaton.trunk.p121c.C4638c;
import com.sec.chaton.trunk.p121c.InterfaceC4640e;
import com.sec.chaton.util.C4904y;
import java.util.concurrent.Future;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.cd */
/* loaded from: classes.dex */
public class C4646cd extends AbstractC4564a implements InterfaceC0028an<Cursor>, InterfaceC4640e {

    /* renamed from: c */
    private static final String f16842c = C4646cd.class.getSimpleName();

    /* renamed from: p */
    private static boolean f16843p = true;

    /* renamed from: d */
    private ITrunkView f16844d;

    /* renamed from: e */
    private Activity f16845e;

    /* renamed from: f */
    private EnumC4575b f16846f;

    /* renamed from: g */
    private String f16847g;

    /* renamed from: h */
    private boolean f16848h;

    /* renamed from: i */
    private C4565a f16849i;

    /* renamed from: j */
    private Future<C0778b> f16850j;

    /* renamed from: k */
    private Future<C0778b> f16851k;

    /* renamed from: l */
    private Handler f16852l;

    /* renamed from: m */
    private EnumC4575b f16853m;

    /* renamed from: n */
    private C0094f<Cursor> f16854n;

    /* renamed from: o */
    private boolean f16855o;

    /* renamed from: q */
    private C4651ci f16856q;

    /* renamed from: r */
    private Handler f16857r = new HandlerC4647ce(this);

    public C4646cd(ITrunkView iTrunkView, Handler handler, EnumC4575b enumC4575b, String str) {
        this.f16844d = iTrunkView;
        this.f16846f = enumC4575b;
        this.f16853m = this.f16846f;
        this.f16847g = str;
        this.f16852l = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: f */
    protected void mo17513f() {
        super.mo17513f();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkPresenter.onCreate()", f16842c);
        }
        this.f16845e = this.f16844d.getActivity();
        this.f16849i = new C4565a(this.f16845e, this.f16857r);
        this.f16844d.mo17268a(new C4648cf(this));
        this.f16844d.mo17266a(new C4649cg(this));
        this.f16844d.mo17267a(new C4650ch(this));
        if (f16843p) {
            f16843p = false;
            if (C4904y.f17873c) {
                C4904y.m18641c("Clear all trunk item.", f16842c);
            }
            Uri uriBuild = C4667c.f16901a.buildUpon().appendQueryParameter("effect", Boolean.FALSE.toString()).appendQueryParameter("rearrangeLoadMoreItem", Boolean.FALSE.toString()).build();
            this.f16856q = new C4651ci(this, this.f16845e.getContentResolver());
            this.f16856q.startDelete(0, null, uriBuild, null, null);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: g */
    protected void mo17514g() {
        super.mo17514g();
        this.f16855o = false;
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkPresenter.onResume()", f16842c);
        }
        C4638c.m17609a(this);
        m17635k();
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: h */
    protected void mo17515h() {
        super.mo17515h();
        this.f16855o = true;
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkPresenter.onPause()", f16842c);
        }
        if (this.f16854n != null && this.f16854n.m345l()) {
            this.f16854n.m350q();
        }
        C4638c.m17611b(this);
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: i */
    protected void mo17516i() {
        super.mo17516i();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkPresenter.onDestroy()", f16842c);
        }
        if (this.f16856q != null) {
            f16843p = true;
            this.f16856q.cancelOperation(0);
            this.f16856q = null;
        }
        if (this.f16854n != null) {
            this.f16844d.getLoaderManager().mo109a(0);
            this.f16854n = null;
        }
        if (this.f16850j != null) {
            this.f16850j.cancel(true);
            this.f16850j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m17635k() {
        if (m17512e() && this.f16856q == null) {
            if (this.f16847g == null || this.f16847g.trim().equals("")) {
                this.f16844d.mo17265a(null, this.f16846f);
                return;
            }
            if (this.f16854n == null) {
                this.f16854n = this.f16844d.getLoaderManager().mo108a(0, null, this);
                return;
            }
            if (!this.f16846f.equals(this.f16853m)) {
                this.f16853m = this.f16846f;
                this.f16854n = this.f16844d.getLoaderManager().mo111b(0, null, this);
            } else {
                if (!this.f16854n.m345l()) {
                    this.f16854n.m348o();
                }
                this.f16854n.m349p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m17637l() {
        if (this.f16846f == EnumC4575b.Recent) {
            this.f16846f = EnumC4575b.UnreadComment;
        } else if (this.f16846f == EnumC4575b.UnreadComment) {
            this.f16846f = EnumC4575b.Recent;
        }
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a */
    public C0094f<Cursor> mo112a(int i, Bundle bundle) {
        String str;
        String[] strArr;
        String str2;
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkPresenter.onCreateLoader()", f16842c);
        }
        if (this.f16846f == EnumC4575b.Recent) {
            str = "session_id = ?";
            strArr = new String[]{this.f16847g};
            str2 = "registration_time DESC";
        } else {
            str = "session_id = ?";
            strArr = new String[]{this.f16847g};
            str2 = "last_comment_time DESC";
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("Selection: %s", str), f16842c);
            for (String str3 : strArr) {
                C4904y.m18639b(String.format("SelectionArg: %s", str3), f16842c);
            }
            C4904y.m18639b(String.format("SortOrder: ", str2), f16842c);
        }
        return new C0091c(this.f16845e, C4667c.f16901a, null, str, strArr, str2);
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo114a(C0094f<Cursor> c0094f, Cursor cursor) {
        if (m17512e()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("TrunkPresenter.onLoadFinished()", f16842c);
                C4904y.m18639b(String.format("Loader id: %s", Integer.valueOf(c0094f.m344k())), f16842c);
                C4904y.m18639b(String.format("Cursor count: %s", Integer.valueOf(cursor.getCount())), f16842c);
            }
            this.f16844d.mo17265a(cursor, this.f16846f);
        }
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a */
    public void mo113a(C0094f<Cursor> c0094f) {
        if (m17512e()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("TrunkPresenter.onLoadReset()", f16842c);
            }
            this.f16844d.mo17265a(null, this.f16846f);
        }
    }

    @Override // com.sec.chaton.trunk.p121c.InterfaceC4640e
    /* renamed from: a */
    public void mo17343a(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("TrunkPresenter.onStorageStateChanged. externalStorageAvailable=%s", Boolean.valueOf(z)), f16842c);
        }
        m17635k();
    }
}
