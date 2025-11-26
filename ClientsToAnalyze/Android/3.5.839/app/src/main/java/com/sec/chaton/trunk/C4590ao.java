package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.trunk.database.C4667c;
import com.sec.chaton.trunk.database.p122a.C4664a;
import com.sec.chaton.trunk.p118a.C4565a;
import com.sec.chaton.trunk.p120b.AsyncTaskC4604b;
import com.sec.chaton.trunk.p120b.C4603a;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.Future;

/* compiled from: TrunkFullPresenter.java */
/* renamed from: com.sec.chaton.trunk.ao */
/* loaded from: classes.dex */
public class C4590ao extends AbstractC4564a {

    /* renamed from: c */
    private static final String f16703c = C4590ao.class.getSimpleName();

    /* renamed from: d */
    private InterfaceC4672f f16704d;

    /* renamed from: e */
    private Activity f16705e;

    /* renamed from: f */
    private String f16706f;

    /* renamed from: g */
    private String f16707g;

    /* renamed from: h */
    private String f16708h;

    /* renamed from: i */
    private String f16709i;

    /* renamed from: j */
    private String f16710j;

    /* renamed from: k */
    private EnumC4642g f16711k;

    /* renamed from: l */
    private String f16712l;

    /* renamed from: m */
    private String f16713m;

    /* renamed from: n */
    private String f16714n;

    /* renamed from: o */
    private C4565a f16715o;

    /* renamed from: p */
    private Handler f16716p;

    /* renamed from: q */
    private Future<C0778b> f16717q;

    /* renamed from: r */
    private AsyncTaskC4604b f16718r;

    /* renamed from: s */
    private Future<C0778b> f16719s;

    /* renamed from: t */
    private Handler f16720t = new HandlerC4591ap(this);

    public C4590ao(InterfaceC4672f interfaceC4672f, Handler handler, String str, String str2, String str3) {
        this.f16706f = str;
        this.f16707g = str2;
        this.f16708h = str3;
        this.f16704d = interfaceC4672f;
        this.f16716p = handler;
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: f */
    protected void mo17513f() {
        super.mo17513f();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkFullPresenter.onCreate()", f16703c);
        }
        this.f16705e = this.f16704d.mo17338a();
        this.f16715o = new C4565a(this.f16705e, this.f16720t);
        this.f16704d.mo17341a(new C4592aq(this));
        this.f16704d.mo17340a(new C4593ar(this));
        this.f16704d.mo17345b(new C4594as(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: g */
    protected void mo17514g() {
        super.mo17514g();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkFullPresenter.onResume()", f16703c);
        }
        m17547n();
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: h */
    protected void mo17515h() {
        super.mo17515h();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkFullPresenter.onPause()", f16703c);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC4564a
    /* renamed from: i */
    protected void mo17516i() {
        super.mo17516i();
        if (C4904y.f17872b) {
            C4904y.m18639b("TrunkFullPresenter.onDestroy()", f16703c);
        }
        if (this.f16717q != null) {
            this.f16717q.cancel(true);
        }
        if (this.f16719s != null) {
            this.f16719s.cancel(true);
        }
        if (this.f16718r != null) {
            this.f16718r.cancel(true);
        }
        this.f16718r = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17535a(int i, int i2) {
        if (m17512e()) {
            if (this.f16717q != null) {
                this.f16717q.cancel(true);
            }
            try {
                C4664a.m17659a(this.f16705e, C4664a.m17664e(this.f16708h));
            } catch (OperationApplicationException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f16703c);
                }
            } catch (RemoteException e2) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e2, f16703c);
                }
            }
            this.f16717q = this.f16715o.m17519a(this.f16707g, this.f16708h, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m17544k() {
        if (m17512e()) {
            if (this.f16719s != null) {
                this.f16719s.cancel(true);
            }
            this.f16719s = this.f16715o.m17518a(this.f16707g, this.f16708h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m17545l() throws Throwable {
        if (m17512e()) {
            try {
                String strM17538b = m17538b(this.f16706f);
                String strM17615a = C4641f.m17615a(this.f16710j);
                String strM19199a = C5052r.m19199a(strM17538b, File.separator, strM17615a);
                if (this.f16718r != null && this.f16718r.getStatus() != AsyncTask.Status.FINISHED) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Cancel previous download task.", f16703c);
                    }
                    this.f16718r.cancel(true);
                }
                if (this.f16711k == EnumC4642g.IMAGE) {
                    this.f16718r = C4603a.m17553a().m17554a(this.f16720t, this.f16710j, strM17538b, strM17615a, strM19199a, true);
                } else {
                    this.f16718r = C4603a.m17553a().m17554a(this.f16720t, this.f16710j, strM17538b, strM17615a, strM19199a, false);
                }
            } catch (MalformedURLException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f16703c);
                }
                this.f16718r = null;
            }
        }
    }

    /* renamed from: m */
    private Cursor m17546m() {
        return this.f16705e.getContentResolver().query(C4667c.f16901a, null, C5052r.m19199a("item_id", " = ?"), new String[]{this.f16708h}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m17547n() {
        Cursor cursor = null;
        if (m17512e()) {
            try {
                Cursor cursorM17546m = m17546m();
                if (cursorM17546m == null) {
                    if (cursorM17546m != null) {
                        cursorM17546m.close();
                        return;
                    }
                    return;
                }
                if (cursorM17546m.moveToNext()) {
                    this.f16709i = cursorM17546m.getString(cursorM17546m.getColumnIndex("sender_uid"));
                    this.f16710j = cursorM17546m.getString(cursorM17546m.getColumnIndex("down_url"));
                    this.f16714n = cursorM17546m.getString(cursorM17546m.getColumnIndex("item_description"));
                    try {
                        String strM17534a = m17534a(this.f16706f);
                        String strM17538b = m17538b(this.f16706f);
                        String strM17615a = C4641f.m17615a(this.f16710j);
                        this.f16712l = C5052r.m19199a(strM17534a, File.separator, strM17615a);
                        this.f16713m = C5052r.m19199a(strM17538b, File.separator, strM17615a);
                    } catch (MalformedURLException e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, f16703c);
                        }
                        this.f16713m = null;
                    }
                    this.f16711k = C4641f.m17614a(cursorM17546m.getString(cursorM17546m.getColumnIndex("content_type")), false);
                }
                if (cursorM17546m != null) {
                    cursorM17546m.close();
                }
                this.f16704d.mo17342a(this.f16709i);
                m17548o();
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: o */
    private void m17548o() {
        if (m17512e()) {
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("Redraw content image: ", this.f16713m), f16703c);
            }
            if (this.f16711k == EnumC4642g.IMAGE) {
                if (this.f16713m == null || this.f16713m.trim().equals("")) {
                    this.f16704d.mo17339a(this.f16711k, null, null);
                    return;
                } else {
                    this.f16704d.mo17339a(this.f16711k, new File(this.f16712l), this.f16713m);
                    return;
                }
            }
            if (this.f16711k == EnumC4642g.VIDEO) {
                if (this.f16713m == null || this.f16713m.trim().equals("")) {
                    this.f16704d.mo17339a(this.f16711k, null, null);
                } else {
                    this.f16704d.mo17339a(this.f16711k, null, this.f16713m);
                }
            }
        }
    }

    /* renamed from: a */
    private String m17534a(String str) {
        return C5052r.m19199a(C4636a.m17603a(), File.separator, str, File.separator, "thumbnail");
    }

    /* renamed from: b */
    private String m17538b(String str) {
        return C5052r.m19199a(C4636a.m17603a(), File.separator, str);
    }
}
