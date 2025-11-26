package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.trunk.database.C4666b;
import com.sec.chaton.trunk.database.C4667c;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.trunk.p118a.C4565a;
import com.sec.chaton.trunk.p120b.AsyncTaskC4604b;
import com.sec.chaton.trunk.p120b.C4603a;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.Future;

/* compiled from: TrunkItemPresenter.java */
/* renamed from: com.sec.chaton.trunk.bc */
/* loaded from: classes.dex */
public class C4611bc extends AbstractC4564a {

    /* renamed from: c */
    private static final String f16761c = C4611bc.class.getSimpleName();

    /* renamed from: A */
    private String f16762A;

    /* renamed from: B */
    private Handler f16763B = new HandlerC4612bd(this);

    /* renamed from: d */
    private InterfaceC4675i f16764d;

    /* renamed from: e */
    private Activity f16765e;

    /* renamed from: f */
    private String f16766f;

    /* renamed from: g */
    private String f16767g;

    /* renamed from: h */
    private String f16768h;

    /* renamed from: i */
    private String f16769i;

    /* renamed from: j */
    private String f16770j;

    /* renamed from: k */
    private long f16771k;

    /* renamed from: l */
    private String f16772l;

    /* renamed from: m */
    private EnumC4642g f16773m;

    /* renamed from: n */
    private int f16774n;

    /* renamed from: o */
    private String f16775o;

    /* renamed from: p */
    private String f16776p;

    /* renamed from: q */
    private String f16777q;

    /* renamed from: r */
    private C4565a f16778r;

    /* renamed from: s */
    private Handler f16779s;

    /* renamed from: t */
    private Future<C0778b> f16780t;

    /* renamed from: u */
    private Future<C0778b> f16781u;

    /* renamed from: v */
    private AsyncTaskC4604b f16782v;

    /* renamed from: w */
    private Future<C0778b> f16783w;

    /* renamed from: x */
    private Future<C0778b> f16784x;

    /* renamed from: y */
    private Future<C0778b> f16785y;

    /* renamed from: z */
    private String f16786z;

    public C4611bc(InterfaceC4675i interfaceC4675i, Handler handler, String str, String str2, String str3, String str4, String str5) {
        this.f16766f = str;
        this.f16767g = str2;
        this.f16768h = str3;
        this.f16764d = interfaceC4675i;
        this.f16779s = handler;
        this.f16786z = str4;
        this.f16762A = str5;
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: f */
    protected void mo17513f() {
        super.mo17513f();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkItemPresenter.onCreate()", f16761c);
        }
        this.f16765e = this.f16764d.mo17409a();
        this.f16778r = new C4565a(this.f16765e, this.f16763B);
        this.f16764d.mo17415a(new C4613be(this));
        this.f16764d.mo17414a(new C4614bf(this));
        this.f16764d.mo17422c(new C4615bg(this));
        this.f16764d.mo17419b(new C4616bh(this));
        this.f16764d.mo17413a(new C4617bi(this));
        this.f16764d.mo17416a(new C4618bj(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: g */
    protected void mo17514g() {
        super.mo17514g();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkItemPresenter.onResume()", f16761c);
        }
        if (!TextUtils.isEmpty(this.f16768h)) {
            m17594q();
        } else {
            this.f16764d.mo17418b();
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: h */
    protected void mo17515h() {
        super.mo17515h();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkItemPresenter.onPause()", f16761c);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: i */
    protected void mo17516i() {
        super.mo17516i();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkItemPresenter.onDestroy()", f16761c);
        }
        if (this.f16780t != null) {
            this.f16780t.cancel(true);
        }
        if (this.f16783w != null) {
            this.f16783w.cancel(true);
        }
        if (this.f16781u != null) {
            this.f16781u.cancel(true);
        }
        if (this.f16784x != null) {
            this.f16784x.cancel(true);
        }
        if (this.f16782v != null) {
            this.f16782v.cancel(true);
        }
        this.f16782v = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17573a(int i, int i2) {
        if (m17512e()) {
            if (this.f16780t != null) {
                this.f16780t.cancel(true);
            }
            if (!TextUtils.isEmpty(this.f16768h)) {
                try {
                    C4664a.m17659a(this.f16765e, C4664a.m17664e(this.f16768h));
                } catch (OperationApplicationException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f16761c);
                    }
                } catch (RemoteException e2) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, f16761c);
                    }
                }
            }
            this.f16764d.mo17410a(this.f16774n, null);
            if (!TextUtils.isEmpty(this.f16768h)) {
                this.f16780t = this.f16778r.m17519a(this.f16767g, this.f16768h, i, i2);
            } else {
                this.f16780t = this.f16778r.m17522a(this.f16767g, this.f16786z, this.f16762A, 100, 239);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m17589l() {
        if (m17512e()) {
            if (this.f16783w != null) {
                this.f16783w.cancel(true);
            }
            this.f16783w = this.f16778r.m17518a(this.f16767g, this.f16768h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m17590m() {
        TrunkDetailActivity trunkDetailActivity;
        if (m17512e()) {
            if (this.f16785y != null) {
                this.f16785y.cancel(true);
            }
            if (TextUtils.isEmpty(this.f16768h) && (trunkDetailActivity = (TrunkDetailActivity) this.f16765e) != null) {
                this.f16768h = trunkDetailActivity.f16459n;
            }
            if (!TextUtils.isEmpty(this.f16768h)) {
                this.f16785y = this.f16778r.m17526b(this.f16767g, this.f16768h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17577a(String str, int i) {
        if (m17512e()) {
            if (this.f16781u != null) {
                this.f16781u.cancel(true);
            }
            this.f16781u = this.f16778r.m17521a(this.f16767g, this.f16768h, str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17576a(String str) {
        if (m17512e()) {
            if (this.f16784x != null) {
                this.f16784x.cancel(true);
            }
            this.f16784x = this.f16778r.m17527b(this.f16767g, this.f16768h, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m17591n() throws Throwable {
        if (m17512e()) {
            try {
                String strM17582c = m17582c(this.f16766f);
                String strM17615a = C4641f.m17615a(this.f16772l);
                String strM19199a = C5052r.m19199a(strM17582c, File.separator, strM17615a);
                if (this.f16782v != null && this.f16782v.getStatus() != AsyncTask.Status.FINISHED) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Cancel previous download task.", f16761c);
                    }
                    this.f16782v.cancel(true);
                }
                if (this.f16773m == EnumC4642g.IMAGE) {
                    this.f16782v = C4603a.m17553a().m17554a(this.f16763B, this.f16772l, strM17582c, strM17615a, strM19199a, true);
                } else {
                    this.f16782v = C4603a.m17553a().m17554a(this.f16763B, this.f16772l, strM17582c, strM17615a, strM19199a, false);
                }
            } catch (MalformedURLException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f16761c);
                }
                this.f16782v = null;
            }
        }
    }

    /* renamed from: o */
    private Cursor m17592o() {
        return this.f16765e.getContentResolver().query(C4666b.f16900a, null, C5052r.m19199a("item_id", "=?"), new String[]{this.f16768h}, C5052r.m19199a("registration_time", " ASC"));
    }

    /* renamed from: p */
    private Cursor m17593p() {
        return this.f16765e.getContentResolver().query(C4667c.f16901a, null, C5052r.m19199a("item_id", " = ?"), new String[]{this.f16768h}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m17594q() {
        Cursor cursor = null;
        if (m17512e()) {
            try {
                Cursor cursorM17593p = m17593p();
                if (cursorM17593p == null) {
                    if (cursorM17593p != null) {
                        cursorM17593p.close();
                        return;
                    }
                    return;
                }
                if (cursorM17593p.moveToNext()) {
                    this.f16769i = cursorM17593p.getString(cursorM17593p.getColumnIndex("sender_uid"));
                    if ("ME".equals(this.f16769i)) {
                        this.f16770j = this.f16765e.getResources().getString(R.string.setting_interaction_me);
                        C4809aa.m18104a().m18121a("chaton_id", "");
                    } else {
                        this.f16770j = cursorM17593p.getString(cursorM17593p.getColumnIndex("sender_name"));
                    }
                    this.f16771k = cursorM17593p.getLong(cursorM17593p.getColumnIndex("registration_time"));
                    this.f16772l = cursorM17593p.getString(cursorM17593p.getColumnIndex("down_url"));
                    this.f16777q = cursorM17593p.getString(cursorM17593p.getColumnIndex("item_description"));
                    try {
                        String strM17580b = m17580b(this.f16766f);
                        String strM17582c = m17582c(this.f16766f);
                        String strM17615a = C4641f.m17615a(this.f16772l);
                        this.f16775o = C5052r.m19199a(strM17580b, File.separator, strM17615a);
                        this.f16776p = C5052r.m19199a(strM17582c, File.separator, strM17615a);
                    } catch (MalformedURLException e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, f16761c);
                        }
                        this.f16776p = null;
                    }
                    this.f16773m = C4641f.m17614a(cursorM17593p.getString(cursorM17593p.getColumnIndex("content_type")), false);
                    this.f16774n = cursorM17593p.getInt(cursorM17593p.getColumnIndex("total_comment_count"));
                }
                if (cursorM17593p != null) {
                    cursorM17593p.close();
                }
                this.f16764d.mo17420b(this.f16777q);
                this.f16764d.mo17417a(this.f16769i);
                this.f16764d.mo17423c(this.f16769i);
                this.f16764d.mo17425d(this.f16770j);
                this.f16764d.mo17411a(this.f16771k);
                this.f16764d.mo17410a(this.f16774n, m17592o());
                m17595r();
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: j */
    public void m17596j() {
        Cursor cursor = null;
        try {
            Cursor cursorM17593p = m17593p();
            if (cursorM17593p == null) {
                if (cursorM17593p != null) {
                    cursorM17593p.close();
                }
            } else {
                if (cursorM17593p.moveToNext()) {
                    this.f16774n = cursorM17593p.getInt(cursorM17593p.getColumnIndex("total_comment_count"));
                }
                if (cursorM17593p != null) {
                    cursorM17593p.close();
                }
                this.f16764d.mo17410a(this.f16774n, m17592o());
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: r */
    private void m17595r() {
        if (m17512e()) {
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("Redraw content image: ", this.f16776p), f16761c);
            }
            if (this.f16773m == EnumC4642g.IMAGE) {
                if (this.f16776p == null || this.f16776p.trim().equals("")) {
                    this.f16764d.mo17412a(this.f16773m, null, null);
                    return;
                } else {
                    this.f16764d.mo17412a(this.f16773m, new File(this.f16775o), this.f16776p);
                    return;
                }
            }
            if (this.f16773m == EnumC4642g.VIDEO) {
                if (this.f16776p == null || this.f16776p.trim().equals("")) {
                    this.f16764d.mo17412a(this.f16773m, null, null);
                } else {
                    this.f16764d.mo17412a(this.f16773m, null, this.f16776p);
                }
            }
        }
    }

    /* renamed from: b */
    private String m17580b(String str) {
        return C5052r.m19199a(C4636a.m17603a(), File.separator, str, File.separator, "thumbnail");
    }

    /* renamed from: c */
    private String m17582c(String str) {
        return C5052r.m19199a(C4636a.m17603a(), File.separator, str);
    }
}
