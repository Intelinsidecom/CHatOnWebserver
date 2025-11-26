package com.sec.chaton.trunk;

import android.app.Activity;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.trunk.database.C3046b;
import com.sec.chaton.trunk.database.C3047c;
import com.sec.chaton.trunk.database.p062a.C3044a;
import com.sec.chaton.trunk.p058a.C2949a;
import com.sec.chaton.trunk.p058a.p059a.C2951b;
import com.sec.chaton.trunk.p058a.p059a.C2952c;
import com.sec.chaton.trunk.p058a.p059a.C2954e;
import com.sec.chaton.trunk.p058a.p059a.C2956g;
import com.sec.chaton.trunk.p058a.p059a.C2958i;
import com.sec.chaton.trunk.p060b.AsyncTaskC2988b;
import com.sec.chaton.trunk.p060b.C2987a;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;
import java.io.File;
import java.net.MalformedURLException;

/* compiled from: TrunkItemPresenter.java */
/* renamed from: com.sec.chaton.trunk.az */
/* loaded from: classes.dex */
public class C2985az extends AbstractC2948a {

    /* renamed from: c */
    private static final String f10784c = C2985az.class.getSimpleName();

    /* renamed from: A */
    private String f10785A;

    /* renamed from: B */
    private String f10786B;

    /* renamed from: C */
    private Handler f10787C = new HandlerC2993ba(this);

    /* renamed from: d */
    private InterfaceC3055i f10788d;

    /* renamed from: e */
    private Activity f10789e;

    /* renamed from: f */
    private String f10790f;

    /* renamed from: g */
    private String f10791g;

    /* renamed from: h */
    private String f10792h;

    /* renamed from: i */
    private String f10793i;

    /* renamed from: j */
    private Bitmap f10794j;

    /* renamed from: k */
    private String f10795k;

    /* renamed from: l */
    private long f10796l;

    /* renamed from: m */
    private String f10797m;

    /* renamed from: n */
    private EnumC3026g f10798n;

    /* renamed from: o */
    private int f10799o;

    /* renamed from: p */
    private String f10800p;

    /* renamed from: q */
    private String f10801q;

    /* renamed from: r */
    private String f10802r;

    /* renamed from: s */
    private C2949a f10803s;

    /* renamed from: t */
    private Handler f10804t;

    /* renamed from: u */
    private C2954e f10805u;

    /* renamed from: v */
    private C2952c f10806v;

    /* renamed from: w */
    private AsyncTaskC2988b f10807w;

    /* renamed from: x */
    private C2951b f10808x;

    /* renamed from: y */
    private C2958i f10809y;

    /* renamed from: z */
    private C2956g f10810z;

    public C2985az(InterfaceC3055i interfaceC3055i, Handler handler, String str, String str2, String str3, String str4, String str5) {
        this.f10790f = str;
        this.f10791g = str2;
        this.f10792h = str3;
        this.f10788d = interfaceC3055i;
        this.f10804t = handler;
        this.f10785A = str4;
        this.f10786B = str5;
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: f */
    protected void mo10416f() {
        super.mo10416f();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkItemPresenter.onCreate()", f10784c);
        }
        this.f10789e = this.f10788d.mo10313a();
        this.f10803s = new C2949a(this.f10789e, this.f10787C);
        this.f10788d.mo10320a(new C2994bb(this));
        this.f10788d.mo10319a(new C2995bc(this));
        this.f10788d.mo10327c(new C2996bd(this));
        this.f10788d.mo10324b(new C2997be(this));
        this.f10788d.mo10318a(new C2998bf(this));
        this.f10788d.mo10321a(new C2999bg(this));
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: g */
    protected void mo10417g() {
        super.mo10417g();
        this.f10789e.getWindow().setSoftInputMode(3);
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkItemPresenter.onResume()", f10784c);
        }
        if (!TextUtils.isEmpty(this.f10792h)) {
            m10478p();
        } else {
            this.f10788d.mo10323b();
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: h */
    protected void mo10418h() {
        super.mo10418h();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkItemPresenter.onPause()", f10784c);
        }
    }

    @Override // com.sec.chaton.trunk.AbstractC2948a
    /* renamed from: i */
    protected void mo10419i() {
        super.mo10419i();
        if (C3250y.f11734b) {
            C3250y.m11450b("TrunkItemPresenter.onDestroy()", f10784c);
        }
        if (this.f10805u != null) {
            this.f10805u.m5493c();
        }
        if (this.f10808x != null) {
            this.f10808x.m5493c();
        }
        if (this.f10806v != null) {
            this.f10806v.m5493c();
        }
        if (this.f10809y != null) {
            this.f10809y.m5493c();
        }
        if (this.f10807w != null) {
            this.f10807w.cancel(true);
        }
        this.f10807w = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10457a(int i, int i2) {
        if (m10415e()) {
            if (this.f10805u != null) {
                this.f10805u.m5493c();
            }
            if (!TextUtils.isEmpty(this.f10792h)) {
                try {
                    C3044a.m10564a(this.f10789e, C3044a.m10570f(this.f10792h));
                } catch (OperationApplicationException e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f10784c);
                    }
                } catch (RemoteException e2) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e2, f10784c);
                    }
                }
            }
            this.f10788d.mo10314a(this.f10799o, null);
            if (!TextUtils.isEmpty(this.f10792h)) {
                this.f10805u = this.f10803s.m10425a(this.f10791g, this.f10792h, i, i2);
            } else {
                this.f10805u = this.f10803s.m10426a(this.f10791g, this.f10785A, this.f10786B, 100, 239);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10473k() {
        if (m10415e()) {
            if (this.f10808x != null) {
                this.f10808x.m5493c();
            }
            this.f10808x = this.f10803s.m10421a(this.f10791g, this.f10792h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m10474l() {
        TrunkDetailActivity trunkDetailActivity;
        if (m10415e()) {
            if (this.f10810z != null) {
                this.f10810z.m5493c();
            }
            if (TextUtils.isEmpty(this.f10792h) && (trunkDetailActivity = (TrunkDetailActivity) this.f10789e) != null) {
                this.f10792h = trunkDetailActivity.f10518a;
            }
            if (!TextUtils.isEmpty(this.f10792h)) {
                this.f10810z = this.f10803s.m10429b(this.f10791g, this.f10792h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10461a(String str, int i) {
        if (m10415e()) {
            if (this.f10806v != null) {
                this.f10806v.m5493c();
            }
            this.f10806v = this.f10803s.m10422a(this.f10791g, this.f10792h, str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10460a(String str) {
        if (m10415e()) {
            if (this.f10809y != null) {
                this.f10809y.m5493c();
            }
            this.f10809y = this.f10803s.m10430b(this.f10791g, this.f10792h, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m10475m() throws Throwable {
        if (m10415e()) {
            try {
                String strM10466c = m10466c(this.f10790f);
                String strM10538a = C3025f.m10538a(this.f10797m);
                String strM11849a = C3364o.m11849a(strM10466c, File.separator, strM10538a);
                if (this.f10807w != null && this.f10807w.getStatus() != AsyncTask.Status.FINISHED) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("Cancel previous download task.", f10784c);
                    }
                    this.f10807w.cancel(true);
                }
                if (this.f10798n == EnumC3026g.IMAGE) {
                    this.f10807w = C2987a.m10482a().m10483a(this.f10787C, this.f10797m, strM10466c, strM10538a, strM11849a, true);
                } else {
                    this.f10807w = C2987a.m10482a().m10483a(this.f10787C, this.f10797m, strM10466c, strM10538a, strM11849a, false);
                }
            } catch (MalformedURLException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f10784c);
                }
                this.f10807w = null;
            }
        }
    }

    /* renamed from: n */
    private Cursor m10476n() {
        return this.f10789e.getContentResolver().query(C3046b.f10951a, null, C3364o.m11849a("item_id", "=?"), new String[]{this.f10792h}, C3364o.m11849a("registration_time", " ASC"));
    }

    /* renamed from: o */
    private Cursor m10477o() {
        return this.f10789e.getContentResolver().query(C3047c.f10952a, null, C3364o.m11849a("item_id", " = ?"), new String[]{this.f10792h}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m10478p() {
        Cursor cursor = null;
        if (m10415e()) {
            try {
                Cursor cursorM10477o = m10477o();
                if (cursorM10477o == null) {
                    if (cursorM10477o != null) {
                        cursorM10477o.close();
                        return;
                    }
                    return;
                }
                if (cursorM10477o.moveToNext()) {
                    this.f10793i = cursorM10477o.getString(cursorM10477o.getColumnIndex("sender_uid"));
                    if ("ME".equals(this.f10793i)) {
                        this.f10795k = this.f10789e.getResources().getString(R.string.setting_interaction_me);
                        this.f10794j = C3205bt.m11182a(this.f10789e).m11236j(C3159aa.m10962a().m10979a("chaton_id", ""));
                    } else {
                        this.f10795k = cursorM10477o.getString(cursorM10477o.getColumnIndex("sender_name"));
                        if (this.f10793i != null) {
                            this.f10794j = C3205bt.m11182a(this.f10789e).m11236j(this.f10793i);
                        }
                    }
                    this.f10796l = cursorM10477o.getLong(cursorM10477o.getColumnIndex("registration_time"));
                    this.f10797m = cursorM10477o.getString(cursorM10477o.getColumnIndex("down_url"));
                    this.f10802r = cursorM10477o.getString(cursorM10477o.getColumnIndex("item_description"));
                    try {
                        String strM10463b = m10463b(this.f10790f);
                        String strM10466c = m10466c(this.f10790f);
                        String strM10538a = C3025f.m10538a(this.f10797m);
                        this.f10800p = C3364o.m11849a(strM10463b, File.separator, strM10538a);
                        this.f10801q = C3364o.m11849a(strM10466c, File.separator, strM10538a);
                    } catch (MalformedURLException e) {
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e, f10784c);
                        }
                        this.f10801q = null;
                    }
                    this.f10798n = C3025f.m10537a(cursorM10477o.getString(cursorM10477o.getColumnIndex("content_type")), false);
                    this.f10799o = cursorM10477o.getInt(cursorM10477o.getColumnIndex("total_comment_count"));
                }
                if (cursorM10477o != null) {
                    cursorM10477o.close();
                }
                this.f10788d.mo10325b(this.f10802r);
                this.f10788d.mo10322a(this.f10793i);
                this.f10788d.mo10316a(this.f10794j);
                this.f10788d.mo10328c(this.f10795k);
                this.f10788d.mo10315a(this.f10796l);
                this.f10788d.mo10314a(this.f10799o, m10476n());
                m10479q();
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: q */
    private void m10479q() {
        if (m10415e()) {
            if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("Redraw content image: ", this.f10801q), f10784c);
            }
            if (this.f10798n == EnumC3026g.IMAGE) {
                if (this.f10801q == null || this.f10801q.trim().equals("")) {
                    this.f10788d.mo10317a(this.f10798n, null, null);
                    return;
                } else {
                    this.f10788d.mo10317a(this.f10798n, new File(this.f10800p), this.f10801q);
                    return;
                }
            }
            if (this.f10798n == EnumC3026g.VIDEO) {
                if (this.f10801q == null || this.f10801q.trim().equals("")) {
                    this.f10788d.mo10317a(this.f10798n, null, null);
                } else {
                    this.f10788d.mo10317a(this.f10798n, null, this.f10801q);
                }
            }
        }
    }

    /* renamed from: b */
    private String m10463b(String str) {
        return C3364o.m11849a(C3020a.m10526a(), File.separator, str, File.separator, "thumbnail");
    }

    /* renamed from: c */
    private String m10466c(String str) {
        return C3364o.m11849a(C3020a.m10526a(), File.separator, str);
    }
}
