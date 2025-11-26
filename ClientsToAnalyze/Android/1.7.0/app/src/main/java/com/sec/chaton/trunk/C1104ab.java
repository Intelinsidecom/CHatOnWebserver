package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.trunk.database.C1175c;
import com.sec.chaton.trunk.database.C1176d;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.trunk.p042b.AsyncTaskC1130a;
import com.sec.chaton.trunk.p042b.C1131b;
import com.sec.chaton.trunk.p043c.C1161b;
import com.sec.chaton.trunk.p043c.p044a.C1154b;
import com.sec.chaton.trunk.p043c.p044a.C1156d;
import com.sec.chaton.trunk.p043c.p044a.C1157e;
import com.sec.chaton.trunk.p043c.p044a.C1158f;
import com.sec.chaton.trunk.p043c.p044a.C1160h;
import com.sec.chaton.trunk.p045d.C1163a;
import com.sec.chaton.trunk.p045d.C1165c;
import com.sec.chaton.trunk.p045d.C1169g;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.io.File;
import java.net.MalformedURLException;

/* compiled from: TrunkItemPresenter.java */
/* renamed from: com.sec.chaton.trunk.ab */
/* loaded from: classes.dex */
public class C1104ab extends AbstractC1145bi {

    /* renamed from: c */
    private static final String f3861c = C1104ab.class.getSimpleName();

    /* renamed from: d */
    private InterfaceC1197w f3862d;

    /* renamed from: e */
    private Activity f3863e;

    /* renamed from: f */
    private String f3864f;

    /* renamed from: g */
    private String f3865g;

    /* renamed from: h */
    private String f3866h;

    /* renamed from: i */
    private String f3867i;

    /* renamed from: j */
    private String f3868j;

    /* renamed from: k */
    private long f3869k;

    /* renamed from: l */
    private String f3870l;

    /* renamed from: m */
    private EnumC1168f f3871m;

    /* renamed from: n */
    private int f3872n;

    /* renamed from: o */
    private String f3873o;

    /* renamed from: p */
    private String f3874p;

    /* renamed from: q */
    private C1161b f3875q;

    /* renamed from: r */
    private Handler f3876r;

    /* renamed from: s */
    private C1160h f3877s;

    /* renamed from: t */
    private C1154b f3878t;

    /* renamed from: u */
    private AsyncTaskC1130a f3879u;

    /* renamed from: v */
    private C1156d f3880v;

    /* renamed from: w */
    private C1157e f3881w;

    /* renamed from: x */
    private C1158f f3882x;

    /* renamed from: y */
    private Handler f3883y = new HandlerC1179e(this);

    public C1104ab(InterfaceC1197w interfaceC1197w, Handler handler, String str, String str2, String str3) {
        this.f3864f = str;
        this.f3865g = str2;
        this.f3866h = str3;
        this.f3862d = interfaceC1197w;
        this.f3876r = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: a */
    protected void mo4118a() {
        super.mo4118a();
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkItemPresenter.onCreate()", f3861c);
        }
        this.f3863e = this.f3862d.mo4040a();
        this.f3875q = new C1161b(this.f3863e, this.f3883y);
        this.f3862d.mo4043a(new C1181g(this));
        this.f3862d.mo4046a(new C1180f(this));
        this.f3862d.mo4054c(new C1129b(this));
        this.f3862d.mo4051b(new C1096a(this));
        this.f3862d.mo4047a(new C1162d(this));
        this.f3862d.mo4045a(new C1151c(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: b */
    protected void mo4119b() {
        super.mo4119b();
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkItemPresenter.onResume()", f3861c);
        }
        m4116p();
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: c */
    protected void mo4120c() {
        super.mo4120c();
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkItemPresenter.onPause()", f3861c);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC1145bi
    /* renamed from: d */
    protected void mo4121d() {
        super.mo4121d();
        if (C1341p.f4578b) {
            C1341p.m4658b("TrunkItemPresenter.onDestroy()", f3861c);
        }
        if (this.f3877s != null) {
            this.f3877s.m686d();
        }
        if (this.f3880v != null) {
            this.f3880v.m686d();
        }
        if (this.f3878t != null) {
            this.f3878t.m686d();
        }
        if (this.f3881w != null) {
            this.f3881w.m686d();
        }
        if (this.f3879u != null) {
            this.f3879u.cancel(true);
        }
        this.f3879u = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4096a(int i, int i2) {
        if (m4179j()) {
            if (this.f3877s != null) {
                this.f3877s.m686d();
            }
            try {
                C1173b.m4237a(this.f3863e, C1173b.m4243f(this.f3866h));
            } catch (OperationApplicationException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, f3861c);
                }
            } catch (RemoteException e2) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e2, f3861c);
                }
            }
            this.f3862d.mo4041a(this.f3872n, null);
            this.f3877s = this.f3875q.m4199a(this.f3865g, this.f3866h, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m4111k() {
        if (m4179j()) {
            if (this.f3880v != null) {
                this.f3880v.m686d();
            }
            this.f3880v = this.f3875q.m4197a(this.f3865g, this.f3866h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m4112l() {
        if (m4179j()) {
            if (this.f3882x != null) {
                this.f3882x.m686d();
            }
            this.f3882x = this.f3875q.m4201b(this.f3865g, this.f3866h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4101a(String str, int i) {
        if (m4179j()) {
            if (this.f3878t != null) {
                this.f3878t.m686d();
            }
            this.f3878t = this.f3875q.m4194a(this.f3865g, this.f3866h, str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4100a(String str) {
        if (m4179j()) {
            if (this.f3881w != null) {
                this.f3881w.m686d();
            }
            this.f3881w = this.f3875q.m4200b(this.f3865g, this.f3866h, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m4113m() {
        if (m4179j()) {
            try {
                String strM4105c = m4105c(this.f3864f);
                String strM4206b = C1165c.m4206b(this.f3870l);
                String strM4203a = C1163a.m4203a(strM4105c, File.separator, strM4206b);
                if (this.f3879u != null && this.f3879u.getStatus() != AsyncTask.Status.FINISHED) {
                    if (C1341p.f4578b) {
                        C1341p.m4658b("Cancel previous download task.", f3861c);
                    }
                    this.f3879u.cancel(true);
                }
                this.f3879u = C1131b.m4159a().m4160a(this.f3883y, this.f3870l, strM4105c, strM4206b, strM4203a);
            } catch (MalformedURLException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, f3861c);
                }
                this.f3879u = null;
            }
        }
    }

    /* renamed from: n */
    private Cursor m4114n() {
        return this.f3863e.getContentResolver().query(C1176d.f4039a, null, C1163a.m4203a("item_id", "=?"), new String[]{this.f3866h}, C1163a.m4203a("registration_time", " ASC"));
    }

    /* renamed from: o */
    private Cursor m4115o() {
        return this.f3863e.getContentResolver().query(C1175c.f4038a, null, C1163a.m4203a("item_id", " = ?"), new String[]{this.f3866h}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m4116p() {
        Cursor cursor = null;
        if (m4179j()) {
            try {
                Cursor cursorM4115o = m4115o();
                if (cursorM4115o == null) {
                    if (cursorM4115o != null) {
                        cursorM4115o.close();
                        return;
                    }
                    return;
                }
                if (cursorM4115o.moveToNext()) {
                    this.f3867i = cursorM4115o.getString(cursorM4115o.getColumnIndex("sender_uid"));
                    if ("ME".equals(this.f3867i)) {
                        this.f3868j = this.f3863e.getResources().getString(R.string.setting_interaction_me);
                        C1323bs.m4575a().getString("msisdn", "");
                    } else {
                        this.f3868j = cursorM4115o.getString(cursorM4115o.getColumnIndex("sender_name"));
                    }
                    this.f3869k = cursorM4115o.getLong(cursorM4115o.getColumnIndex("registration_time"));
                    this.f3870l = cursorM4115o.getString(cursorM4115o.getColumnIndex("down_url"));
                    try {
                        String strM4103b = m4103b(this.f3864f);
                        String strM4105c = m4105c(this.f3864f);
                        String strM4206b = C1165c.m4206b(this.f3870l);
                        this.f3873o = C1163a.m4203a(strM4103b, File.separator, strM4206b);
                        this.f3874p = C1163a.m4203a(strM4105c, File.separator, strM4206b);
                    } catch (MalformedURLException e) {
                        if (C1341p.f4581e) {
                            C1341p.m4653a(e, f3861c);
                        }
                        this.f3874p = null;
                    }
                    this.f3871m = C1165c.m4204a(cursorM4115o.getString(cursorM4115o.getColumnIndex("content_type")));
                    this.f3872n = cursorM4115o.getInt(cursorM4115o.getColumnIndex("total_comment_count"));
                }
                if (cursorM4115o != null) {
                    cursorM4115o.close();
                }
                this.f3862d.mo4048a(this.f3867i);
                this.f3862d.mo4052b(this.f3868j);
                this.f3862d.mo4042a(this.f3869k);
                this.f3862d.mo4041a(this.f3872n, m4114n());
                m4117q();
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: q */
    private void m4117q() {
        if (m4179j()) {
            if (C1341p.f4578b) {
                C1341p.m4658b(C1163a.m4203a("Redraw content image: ", this.f3874p), f3861c);
            }
            if (this.f3871m == EnumC1168f.IMAGE) {
                if (this.f3874p == null || this.f3874p.trim().equals("")) {
                    this.f3862d.mo4044a(this.f3871m, null, null);
                    return;
                } else {
                    this.f3862d.mo4044a(this.f3871m, new File(this.f3873o), this.f3874p);
                    return;
                }
            }
            if (this.f3871m == EnumC1168f.VIDEO) {
                if (this.f3874p == null || this.f3874p.trim().equals("")) {
                    this.f3862d.mo4044a(this.f3871m, null, null);
                } else {
                    this.f3862d.mo4044a(this.f3871m, null, this.f3874p);
                }
            }
        }
    }

    /* renamed from: b */
    private String m4103b(String str) {
        return C1163a.m4203a(C1169g.m4216a(), File.separator, str, File.separator, "thumbnail");
    }

    /* renamed from: c */
    private String m4105c(String str) {
        return C1163a.m4203a(C1169g.m4216a(), File.separator, str);
    }
}
