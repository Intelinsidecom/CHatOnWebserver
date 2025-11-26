package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.trunk.database.C1586b;
import com.sec.chaton.trunk.database.C1587c;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.trunk.p048b.C1542a;
import com.sec.chaton.trunk.p048b.p049a.C1544b;
import com.sec.chaton.trunk.p048b.p049a.C1545c;
import com.sec.chaton.trunk.p048b.p049a.C1547e;
import com.sec.chaton.trunk.p048b.p049a.C1549g;
import com.sec.chaton.trunk.p048b.p049a.C1550h;
import com.sec.chaton.trunk.p050c.AsyncTaskC1570b;
import com.sec.chaton.trunk.p050c.C1569a;
import com.sec.chaton.trunk.p053e.C1592a;
import com.sec.chaton.trunk.p053e.C1597f;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.util.C1786r;
import java.io.File;
import java.net.MalformedURLException;

/* compiled from: TrunkItemPresenter.java */
/* renamed from: com.sec.chaton.trunk.ag */
/* loaded from: classes.dex */
public class C1521ag extends AbstractC1512a {

    /* renamed from: c */
    private static final String f5548c = C1521ag.class.getSimpleName();

    /* renamed from: d */
    private InterfaceC1600f f5549d;

    /* renamed from: e */
    private Activity f5550e;

    /* renamed from: f */
    private String f5551f;

    /* renamed from: g */
    private String f5552g;

    /* renamed from: h */
    private String f5553h;

    /* renamed from: i */
    private String f5554i;

    /* renamed from: j */
    private String f5555j;

    /* renamed from: k */
    private long f5556k;

    /* renamed from: l */
    private String f5557l;

    /* renamed from: m */
    private EnumC1599h f5558m;

    /* renamed from: n */
    private int f5559n;

    /* renamed from: o */
    private String f5560o;

    /* renamed from: p */
    private String f5561p;

    /* renamed from: q */
    private C1542a f5562q;

    /* renamed from: r */
    private Handler f5563r;

    /* renamed from: s */
    private C1547e f5564s;

    /* renamed from: t */
    private C1545c f5565t;

    /* renamed from: u */
    private AsyncTaskC1570b f5566u;

    /* renamed from: v */
    private C1544b f5567v;

    /* renamed from: w */
    private C1550h f5568w;

    /* renamed from: x */
    private C1549g f5569x;

    /* renamed from: y */
    private Handler f5570y = new HandlerC1522ah(this);

    public C1521ag(InterfaceC1600f interfaceC1600f, Handler handler, String str, String str2, String str3) {
        this.f5551f = str;
        this.f5552g = str2;
        this.f5553h = str3;
        this.f5549d = interfaceC1600f;
        this.f5563r = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: f */
    protected void mo5359f() {
        super.mo5359f();
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkItemPresenter.onCreate()", f5548c);
        }
        this.f5550e = this.f5549d.mo5303a();
        this.f5562q = new C1542a(this.f5550e, this.f5570y);
        this.f5549d.mo5310a(new C1523ai(this));
        this.f5549d.mo5309a(new C1524aj(this));
        this.f5549d.mo5318c(new C1525ak(this));
        this.f5549d.mo5315b(new C1526al(this));
        this.f5549d.mo5308a(new C1527am(this));
        this.f5549d.mo5311a(new C1528an(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: g */
    protected void mo5360g() throws Throwable {
        super.mo5360g();
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkItemPresenter.onResume()", f5548c);
        }
        m5387p();
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: h */
    protected void mo5361h() {
        super.mo5361h();
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkItemPresenter.onPause()", f5548c);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC1512a
    /* renamed from: i */
    protected void mo5362i() {
        super.mo5362i();
        if (C1786r.f6452b) {
            C1786r.m6061b("TrunkItemPresenter.onDestroy()", f5548c);
        }
        if (this.f5564s != null) {
            this.f5564s.m2710c();
        }
        if (this.f5567v != null) {
            this.f5567v.m2710c();
        }
        if (this.f5565t != null) {
            this.f5565t.m2710c();
        }
        if (this.f5568w != null) {
            this.f5568w.m2710c();
        }
        if (this.f5566u != null) {
            this.f5566u.cancel(true);
        }
        this.f5566u = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5367a(int i, int i2) {
        if (m5358e()) {
            if (this.f5564s != null) {
                this.f5564s.m2710c();
            }
            try {
                C1584a.m5471a(this.f5550e, C1584a.m5478g(this.f5553h));
            } catch (OperationApplicationException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, f5548c);
                }
            } catch (RemoteException e2) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e2, f5548c);
                }
            }
            this.f5549d.mo5305a(this.f5559n, null);
            this.f5564s = this.f5562q.m5400a(this.f5552g, this.f5553h, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m5382k() {
        if (m5358e()) {
            if (this.f5567v != null) {
                this.f5567v.m2710c();
            }
            this.f5567v = this.f5562q.m5396a(this.f5552g, this.f5553h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5383l() {
        if (m5358e()) {
            if (this.f5569x != null) {
                this.f5569x.m2710c();
            }
            this.f5569x = this.f5562q.m5402b(this.f5552g, this.f5553h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5372a(String str, int i) {
        if (m5358e()) {
            if (this.f5565t != null) {
                this.f5565t.m2710c();
            }
            this.f5565t = this.f5562q.m5397a(this.f5552g, this.f5553h, str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5371a(String str) {
        if (m5358e()) {
            if (this.f5568w != null) {
                this.f5568w.m2710c();
            }
            this.f5568w = this.f5562q.m5403b(this.f5552g, this.f5553h, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5384m() {
        if (m5358e()) {
            try {
                String strM5376c = m5376c(this.f5551f);
                String strM5508b = C1598g.m5508b(this.f5557l);
                String strM5505a = C1597f.m5505a(strM5376c, File.separator, strM5508b);
                if (this.f5566u != null && this.f5566u.getStatus() != AsyncTask.Status.FINISHED) {
                    if (C1786r.f6452b) {
                        C1786r.m6061b("Cancel previous download task.", f5548c);
                    }
                    this.f5566u.cancel(true);
                }
                this.f5566u = C1569a.m5430a().m5431a(this.f5570y, this.f5557l, strM5376c, strM5508b, strM5505a);
            } catch (MalformedURLException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, f5548c);
                }
                this.f5566u = null;
            }
        }
    }

    /* renamed from: n */
    private Cursor m5385n() {
        return this.f5550e.getContentResolver().query(C1586b.f5697a, null, C1597f.m5505a("item_id", "=?"), new String[]{this.f5553h}, C1597f.m5505a("registration_time", " ASC"));
    }

    /* renamed from: o */
    private Cursor m5386o() {
        return this.f5550e.getContentResolver().query(C1587c.f5698a, null, C1597f.m5505a("item_id", " = ?"), new String[]{this.f5553h}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m5387p() throws Throwable {
        Cursor cursor;
        String string;
        if (!m5358e()) {
            return;
        }
        try {
            Cursor cursorM5386o = m5386o();
            if (cursorM5386o == null) {
                if (cursorM5386o != null) {
                    cursorM5386o.close();
                    return;
                }
                return;
            }
            try {
                if (cursorM5386o.moveToNext()) {
                    this.f5554i = cursorM5386o.getString(cursorM5386o.getColumnIndex("sender_uid"));
                    if ("ME".equals(this.f5554i)) {
                        this.f5555j = this.f5550e.getResources().getString(R.string.setting_interaction_me);
                    } else {
                        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0688c.f2606a, null, "buddy_no=?", new String[]{this.f5554i}, null);
                        if (cursorQuery != null) {
                            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name")) : null;
                            cursorQuery.close();
                        } else {
                            string = cursorM5386o.getString(cursorM5386o.getColumnIndex("sender_name"));
                        }
                        if (string != null) {
                            this.f5555j = string.trim();
                        } else {
                            this.f5555j = cursorM5386o.getString(cursorM5386o.getColumnIndex("sender_name"));
                        }
                    }
                    this.f5556k = cursorM5386o.getLong(cursorM5386o.getColumnIndex("registration_time"));
                    this.f5557l = cursorM5386o.getString(cursorM5386o.getColumnIndex("down_url"));
                    try {
                        String strM5374b = m5374b(this.f5551f);
                        String strM5376c = m5376c(this.f5551f);
                        String strM5508b = C1598g.m5508b(this.f5557l);
                        this.f5560o = C1597f.m5505a(strM5374b, File.separator, strM5508b);
                        this.f5561p = C1597f.m5505a(strM5376c, File.separator, strM5508b);
                    } catch (MalformedURLException e) {
                        if (C1786r.f6455e) {
                            C1786r.m6056a(e, f5548c);
                        }
                        this.f5561p = null;
                    }
                    this.f5558m = C1598g.m5506a(cursorM5386o.getString(cursorM5386o.getColumnIndex("content_type")));
                    this.f5559n = cursorM5386o.getInt(cursorM5386o.getColumnIndex("total_comment_count"));
                }
                if (cursorM5386o != null) {
                    cursorM5386o.close();
                }
                this.f5549d.mo5312a(this.f5554i);
                this.f5549d.mo5316b(this.f5555j);
                this.f5549d.mo5306a(this.f5556k);
                this.f5549d.mo5305a(this.f5559n, m5385n());
                m5388q();
            } catch (Throwable th) {
                th = th;
                cursor = cursorM5386o;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: q */
    private void m5388q() {
        if (m5358e()) {
            if (C1786r.f6452b) {
                C1786r.m6061b(C1597f.m5505a("Redraw content image: ", this.f5561p), f5548c);
            }
            if (this.f5558m == EnumC1599h.IMAGE) {
                if (this.f5561p == null || this.f5561p.trim().equals("")) {
                    this.f5549d.mo5307a(this.f5558m, null, null);
                    return;
                } else {
                    this.f5549d.mo5307a(this.f5558m, new File(this.f5560o), this.f5561p);
                    return;
                }
            }
            if (this.f5558m == EnumC1599h.VIDEO) {
                if (this.f5561p == null || this.f5561p.trim().equals("")) {
                    this.f5549d.mo5307a(this.f5558m, null, null);
                } else {
                    this.f5549d.mo5307a(this.f5558m, null, this.f5561p);
                }
            }
        }
    }

    /* renamed from: b */
    private String m5374b(String str) {
        return C1597f.m5505a(C1592a.m5494a(), File.separator, str, File.separator, "thumbnail");
    }

    /* renamed from: c */
    private String m5376c(String str) {
        return C1597f.m5505a(C1592a.m5494a(), File.separator, str);
    }
}
