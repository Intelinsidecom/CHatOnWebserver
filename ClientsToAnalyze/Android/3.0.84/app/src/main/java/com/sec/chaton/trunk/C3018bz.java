package com.sec.chaton.trunk;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.sec.chaton.trunk.database.C3047c;
import com.sec.chaton.trunk.p058a.C2949a;
import com.sec.chaton.trunk.p058a.EnumC2959b;
import com.sec.chaton.trunk.p058a.p059a.C2953d;
import com.sec.chaton.trunk.p058a.p059a.C2957h;
import com.sec.chaton.trunk.p061c.C3022c;
import com.sec.chaton.trunk.p061c.InterfaceC3024e;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.bz */
/* loaded from: classes.dex */
public class C3018bz extends AbstractC2948a implements LoaderManager.LoaderCallbacks<Cursor>, InterfaceC3024e {

    /* renamed from: c */
    private static final String f10879c = C3018bz.class.getSimpleName();

    /* renamed from: p */
    private static boolean f10880p = true;

    /* renamed from: d */
    private ITrunkView f10881d;

    /* renamed from: e */
    private Activity f10882e;

    /* renamed from: f */
    private EnumC2959b f10883f;

    /* renamed from: g */
    private String f10884g;

    /* renamed from: h */
    private boolean f10885h;

    /* renamed from: i */
    private C2949a f10886i;

    /* renamed from: j */
    private C2953d f10887j;

    /* renamed from: k */
    private C2957h f10888k;

    /* renamed from: l */
    private Handler f10889l;

    /* renamed from: m */
    private EnumC2959b f10890m;

    /* renamed from: n */
    private Loader<Cursor> f10891n;

    /* renamed from: o */
    private boolean f10892o;

    /* renamed from: q */
    private C3031ce f10893q;

    /* renamed from: r */
    private Handler f10894r = new HandlerC3027ca(this);

    public C3018bz(ITrunkView iTrunkView, Handler handler, EnumC2959b enumC2959b, String str) {
        this.f10881d = iTrunkView;
        this.f10883f = enumC2959b;
        this.f10890m = this.f10883f;
        this.f10884g = str;
        this.f10889l = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: f */
    protected void mo10416f() {
        super.mo10416f();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkPresenter.onCreate()", f10879c);
        }
        this.f10882e = this.f10881d.getActivity();
        this.f10886i = new C2949a(this.f10882e, this.f10894r);
        this.f10881d.mo10180a(new C3028cb(this));
        this.f10881d.mo10178a(new C3029cc(this));
        this.f10881d.mo10179a(new C3030cd(this));
        if (f10880p) {
            f10880p = false;
            if (C3250y.f11735c) {
                C3250y.m11453c("Clear all trunk item.", f10879c);
            }
            Uri uriBuild = C3047c.f10952a.buildUpon().appendQueryParameter("effect", Boolean.FALSE.toString()).appendQueryParameter("rearrangeLoadMoreItem", Boolean.FALSE.toString()).build();
            this.f10893q = new C3031ce(this, this.f10882e.getContentResolver());
            this.f10893q.startDelete(0, null, uriBuild, null, null);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: g */
    protected void mo10417g() {
        super.mo10417g();
        this.f10892o = false;
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkPresenter.onResume()", f10879c);
        }
        C3022c.m10532a(this);
        m10520k();
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: h */
    protected void mo10418h() {
        super.mo10418h();
        this.f10892o = true;
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkPresenter.onPause()", f10879c);
        }
        if (this.f10891n != null && this.f10891n.isStarted()) {
            this.f10891n.stopLoading();
        }
        C3022c.m10534b(this);
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: i */
    protected void mo10419i() {
        super.mo10419i();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkPresenter.onDestroy()", f10879c);
        }
        if (this.f10893q != null) {
            f10880p = true;
            this.f10893q.cancelOperation(0);
            this.f10893q = null;
        }
        if (this.f10891n != null) {
            this.f10881d.getLoaderManager().destroyLoader(0);
            this.f10891n = null;
        }
        if (this.f10887j != null) {
            this.f10887j.m5493c();
            this.f10887j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10520k() {
        if (m10415e() && this.f10893q == null) {
            if (this.f10884g == null || this.f10884g.trim().equals("")) {
                this.f10881d.mo10177a(null, this.f10883f);
                return;
            }
            if (this.f10891n == null) {
                this.f10891n = this.f10881d.getLoaderManager().initLoader(0, null, this);
                return;
            }
            if (!this.f10883f.equals(this.f10890m)) {
                this.f10890m = this.f10883f;
                this.f10891n = this.f10881d.getLoaderManager().restartLoader(0, null, this);
            } else {
                if (!this.f10891n.isStarted()) {
                    this.f10891n.startLoading();
                }
                this.f10891n.forceLoad();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m10522l() {
        if (this.f10883f == EnumC2959b.Recent) {
            this.f10883f = EnumC2959b.UnreadComment;
        } else if (this.f10883f == EnumC2959b.UnreadComment) {
            this.f10883f = EnumC2959b.Recent;
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String str;
        String[] strArr;
        String str2;
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkPresenter.onCreateLoader()", f10879c);
        }
        if (this.f10883f == EnumC2959b.Recent) {
            str = "session_id = ?";
            strArr = new String[]{this.f10884g};
            str2 = "registration_time DESC";
        } else {
            str = "session_id = ?";
            strArr = new String[]{this.f10884g};
            str2 = "last_comment_time DESC";
        }
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("Selection: %s", str), f10879c);
            for (String str3 : strArr) {
                C3250y.m11450b(String.format("SelectionArg: %s", str3), f10879c);
            }
            C3250y.m11450b(String.format("SortOrder: ", str2), f10879c);
        }
        return new CursorLoader(this.f10882e, C3047c.f10952a, null, str, strArr, str2);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (m10415e()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("TrunkPresenter.onLoadFinished()", f10879c);
                C3250y.m11450b(String.format("Loader id: %s", Integer.valueOf(loader.getId())), f10879c);
                C3250y.m11450b(String.format("Cursor count: %s", Integer.valueOf(cursor.getCount())), f10879c);
            }
            this.f10881d.mo10177a(cursor, this.f10883f);
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        if (m10415e()) {
            if (C3250y.f11734b) {
                C3250y.m11450b("TrunkPresenter.onLoadReset()", f10879c);
            }
            this.f10881d.mo10177a(null, this.f10883f);
        }
    }

    @Override // com.sec.chaton.trunk.p061c.InterfaceC3024e
    /* renamed from: a */
    public void mo10245a(boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("TrunkPresenter.onStorageStateChanged. externalStorageAvailable=%s", Boolean.valueOf(z)), f10879c);
        }
        m10520k();
    }
}
