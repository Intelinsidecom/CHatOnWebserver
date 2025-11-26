package com.sec.chaton.trunk;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.sec.chaton.trunk.database.C1175c;
import com.sec.chaton.trunk.database.EnumC1177e;
import com.sec.chaton.trunk.p043c.C1161b;
import com.sec.chaton.trunk.p043c.EnumC1152a;
import com.sec.chaton.trunk.p043c.p044a.C1155c;
import com.sec.chaton.trunk.p045d.C1166d;
import com.sec.chaton.trunk.p045d.InterfaceC1164b;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.ac */
/* loaded from: classes.dex */
public class C1105ac extends AbstractC1145bi implements LoaderManager.LoaderCallbacks, InterfaceC1164b {

    /* renamed from: c */
    private static final String f3884c = C1105ac.class.getSimpleName();

    /* renamed from: o */
    private static boolean f3885o = true;

    /* renamed from: d */
    private ITrunkView f3886d;

    /* renamed from: e */
    private Activity f3887e;

    /* renamed from: f */
    private EnumC1152a f3888f;

    /* renamed from: g */
    private String f3889g;

    /* renamed from: h */
    private boolean f3890h;

    /* renamed from: i */
    private C1161b f3891i;

    /* renamed from: j */
    private C1155c f3892j;

    /* renamed from: k */
    private Handler f3893k;

    /* renamed from: l */
    private EnumC1152a f3894l;

    /* renamed from: m */
    private Loader f3895m;

    /* renamed from: n */
    private boolean f3896n;

    /* renamed from: p */
    private C1189o f3897p;

    /* renamed from: q */
    private Handler f3898q = new HandlerC1143bg(this);

    public C1105ac(ITrunkView iTrunkView, Handler handler, EnumC1152a enumC1152a, String str) {
        this.f3886d = iTrunkView;
        this.f3888f = enumC1152a;
        this.f3894l = this.f3888f;
        this.f3889g = str;
        this.f3893k = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: a */
    protected void mo4118a() {
        super.mo4118a();
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkPresenter.onCreate()", f3884c);
        }
        this.f3887e = this.f3886d.getActivity();
        this.f3891i = new C1161b(this.f3887e, this.f3898q);
        this.f3886d.mo3969a(new C1142bf(this));
        this.f3886d.mo3968a(new C1144bh(this));
        if (f3885o) {
            f3885o = false;
            if (C1341p.f4579c) {
                C1341p.m4660c("Clear all trunk item.", f3884c);
            }
            Uri uriBuild = C1175c.f4038a.buildUpon().appendQueryParameter("effect", Boolean.FALSE.toString()).appendQueryParameter("rearrangeLoadMoreItem", Boolean.FALSE.toString()).build();
            this.f3897p = new C1189o(this, this.f3887e.getContentResolver());
            this.f3897p.startDelete(0, null, uriBuild, null, null);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: b */
    protected void mo4119b() {
        super.mo4119b();
        this.f3896n = false;
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkPresenter.onResume()", f3884c);
        }
        C1166d.m4209a(this);
        m4138k();
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: c */
    protected void mo4120c() {
        super.mo4120c();
        this.f3896n = true;
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkPresenter.onPause()", f3884c);
        }
        if (this.f3895m != null && this.f3895m.isStarted()) {
            this.f3895m.stopLoading();
        }
        C1166d.m4211b(this);
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: d */
    protected void mo4121d() {
        super.mo4121d();
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkPresenter.onDestroy()", f3884c);
        }
        if (this.f3897p != null) {
            f3885o = true;
            this.f3897p.cancelOperation(0);
            this.f3897p = null;
        }
        if (this.f3895m != null) {
            this.f3886d.getLoaderManager().destroyLoader(0);
            this.f3895m = null;
        }
        if (this.f3892j != null) {
            this.f3892j.m686d();
            this.f3892j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m4138k() {
        if (m4179j() && this.f3897p == null) {
            if (this.f3889g == null || this.f3889g.trim().equals("")) {
                this.f3886d.mo3967a(null, this.f3888f);
                return;
            }
            if (this.f3895m == null) {
                this.f3895m = this.f3886d.getLoaderManager().initLoader(0, null, this);
                return;
            }
            if (!this.f3888f.equals(this.f3894l)) {
                this.f3894l = this.f3888f;
                this.f3895m = this.f3886d.getLoaderManager().restartLoader(0, null, this);
            } else {
                if (!this.f3895m.isStarted()) {
                    this.f3895m.startLoading();
                }
                this.f3895m.forceLoad();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m4139l() {
        if (this.f3888f == EnumC1152a.Recent) {
            this.f3888f = EnumC1152a.UnreadComment;
        } else if (this.f3888f == EnumC1152a.UnreadComment) {
            this.f3888f = EnumC1152a.Recent;
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader onCreateLoader(int i, Bundle bundle) {
        String str;
        String[] strArr;
        String str2;
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkPresenter.onCreateLoader()", f3884c);
        }
        if (this.f3888f == EnumC1152a.Recent) {
            str = "session_id = ?";
            strArr = new String[]{this.f3889g};
            str2 = "registration_time DESC";
        } else {
            str = "session_id = ? AND item_type = ?";
            strArr = new String[]{this.f3889g, String.valueOf(EnumC1177e.Item.m4254a())};
            str2 = "last_comment_time DESC";
        }
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("Selection: %s", str), f3884c);
            for (String str3 : strArr) {
                C1341p.m4658b(String.format("SelectionArg: %s", str3), f3884c);
            }
            C1341p.m4658b(String.format("SortOrder: ", str2), f3884c);
        }
        return new CursorLoader(this.f3887e, C1175c.f4038a, null, str, strArr, str2);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, Cursor cursor) {
        if (m4179j()) {
            if (C1341p.f4578b) {
                C1341p.m4658b("TrunkPresenter.onLoadFinished()", f3884c);
                C1341p.m4658b(String.format("Loader id: %s", Integer.valueOf(loader.getId())), f3884c);
                C1341p.m4658b(String.format("Cursor count: %s", Integer.valueOf(cursor.getCount())), f3884c);
            }
            this.f3886d.mo3967a(cursor, this.f3888f);
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader loader) {
        if (m4179j()) {
            if (C1341p.f4578b) {
                C1341p.m4658b("TrunkPresenter.onLoadReset()", f3884c);
            }
            this.f3886d.mo3967a(null, this.f3888f);
        }
    }

    @Override // com.sec.chaton.trunk.p045d.InterfaceC1164b
    /* renamed from: a */
    public void mo4049a(boolean z) {
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("TrunkPresenter.onStorageStateChanged. externalStorageAvailable=%s", Boolean.valueOf(z)), f3884c);
        }
        m4138k();
    }
}
