package com.sec.chaton.trunk;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.sec.chaton.trunk.database.C1587c;
import com.sec.chaton.trunk.database.EnumC1588d;
import com.sec.chaton.trunk.p048b.C1542a;
import com.sec.chaton.trunk.p048b.EnumC1551b;
import com.sec.chaton.trunk.p048b.p049a.C1546d;
import com.sec.chaton.trunk.p053e.C1594c;
import com.sec.chaton.trunk.p053e.InterfaceC1596e;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.bc */
/* loaded from: classes.dex */
public class C1554bc extends AbstractC1512a implements LoaderManager.LoaderCallbacks, InterfaceC1596e {

    /* renamed from: c */
    private static final String f5617c = C1554bc.class.getSimpleName();

    /* renamed from: o */
    private static boolean f5618o = true;

    /* renamed from: d */
    private ITrunkView f5619d;

    /* renamed from: e */
    private Activity f5620e;

    /* renamed from: f */
    private EnumC1551b f5621f;

    /* renamed from: g */
    private String f5622g;

    /* renamed from: h */
    private boolean f5623h;

    /* renamed from: i */
    private C1542a f5624i;

    /* renamed from: j */
    private C1546d f5625j;

    /* renamed from: k */
    private Handler f5626k;

    /* renamed from: l */
    private EnumC1551b f5627l;

    /* renamed from: m */
    private Loader f5628m;

    /* renamed from: n */
    private boolean f5629n;

    /* renamed from: p */
    private C1558bg f5630p;

    /* renamed from: q */
    private Handler f5631q = new HandlerC1555bd(this);

    public C1554bc(ITrunkView iTrunkView, Handler handler, EnumC1551b enumC1551b, String str) {
        this.f5619d = iTrunkView;
        this.f5621f = enumC1551b;
        this.f5627l = this.f5621f;
        this.f5622g = str;
        this.f5626k = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: f */
    protected void mo5359f() {
        super.mo5359f();
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkPresenter.onCreate()", f5617c);
        }
        this.f5620e = this.f5619d.getActivity();
        this.f5624i = new C1542a(this.f5620e, this.f5631q);
        this.f5619d.mo5230a(new C1556be(this));
        this.f5619d.mo5229a(new C1557bf(this));
        if (f5618o) {
            f5618o = false;
            if (C1786r.f6453c) {
                C1786r.m6063c("Clear all trunk item.", f5617c);
            }
            Uri uriBuild = C1587c.f5698a.buildUpon().appendQueryParameter("effect", Boolean.FALSE.toString()).appendQueryParameter("rearrangeLoadMoreItem", Boolean.FALSE.toString()).build();
            this.f5630p = new C1558bg(this, this.f5620e.getContentResolver());
            this.f5630p.startDelete(0, null, uriBuild, null, null);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: g */
    protected void mo5360g() {
        super.mo5360g();
        this.f5629n = false;
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkPresenter.onResume()", f5617c);
        }
        C1594c.m5500a(this);
        m5423k();
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: h */
    protected void mo5361h() {
        super.mo5361h();
        this.f5629n = true;
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkPresenter.onPause()", f5617c);
        }
        if (this.f5628m != null && this.f5628m.isStarted()) {
            this.f5628m.stopLoading();
        }
        C1594c.m5502b(this);
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: i */
    protected void mo5362i() {
        super.mo5362i();
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkPresenter.onDestroy()", f5617c);
        }
        if (this.f5630p != null) {
            f5618o = true;
            this.f5630p.cancelOperation(0);
            this.f5630p = null;
        }
        if (this.f5628m != null) {
            this.f5619d.getLoaderManager().destroyLoader(0);
        }
        if (this.f5625j != null) {
            this.f5625j.m2710c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m5423k() {
        if (m5358e() && this.f5630p == null) {
            if (this.f5622g == null || this.f5622g.trim().equals("")) {
                this.f5619d.mo5228a((Cursor) null, this.f5621f);
                return;
            }
            if (this.f5628m == null) {
                this.f5628m = this.f5619d.getLoaderManager().initLoader(0, null, this);
                return;
            }
            if (!this.f5621f.equals(this.f5627l)) {
                this.f5627l = this.f5621f;
                this.f5628m = this.f5619d.getLoaderManager().restartLoader(0, null, this);
            } else {
                if (!this.f5628m.isStarted()) {
                    this.f5628m.startLoading();
                }
                this.f5628m.forceLoad();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5424l() {
        if (this.f5621f == EnumC1551b.Recent) {
            this.f5621f = EnumC1551b.UnreadComment;
        } else if (this.f5621f == EnumC1551b.UnreadComment) {
            this.f5621f = EnumC1551b.Recent;
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader onCreateLoader(int i, Bundle bundle) {
        String str;
        String[] strArr;
        String str2;
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkPresenter.onCreateLoader()", f5617c);
        }
        if (this.f5621f == EnumC1551b.Recent) {
            str = "session_id = ?";
            strArr = new String[]{this.f5622g};
            str2 = "registration_time DESC";
        } else {
            str = "session_id = ? AND item_type = ?";
            strArr = new String[]{this.f5622g, String.valueOf(EnumC1588d.Item.m5481a())};
            str2 = "last_comment_time DESC";
        }
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("Selection: %s", str), f5617c);
            for (String str3 : strArr) {
                C1786r.m6061b(String.format("SelectionArg: %s", str3), f5617c);
            }
            C1786r.m6061b(String.format("SortOrder: ", str2), f5617c);
        }
        return new CursorLoader(this.f5620e, C1587c.f5698a, null, str, strArr, str2);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, Cursor cursor) {
        if (m5358e()) {
            if (C1786r.f6452b) {
                C1786r.m6061b("TrunkPresenter.onLoadFinished()", f5617c);
                C1786r.m6061b(String.format("Loader id: %s", Integer.valueOf(loader.getId())), f5617c);
                C1786r.m6061b(String.format("Cursor count: %s", Integer.valueOf(cursor.getCount())), f5617c);
            }
            this.f5619d.mo5228a(cursor, this.f5621f);
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader loader) {
        if (m5358e()) {
            if (C1786r.f6452b) {
                C1786r.m6061b("TrunkPresenter.onLoadReset()", f5617c);
            }
            this.f5619d.mo5228a((Cursor) null, this.f5621f);
        }
    }

    @Override // com.sec.chaton.trunk.p053e.InterfaceC1596e
    /* renamed from: a */
    public void mo5313a(boolean z) {
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("TrunkPresenter.onStorageStateChanged. externalStorageAvailable=%s", Boolean.valueOf(z)), f5617c);
        }
        m5423k();
    }
}
