package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1070el;
import com.sec.chaton.chat.InterfaceC1093fh;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3159aa;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import java.util.Calendar;
import java.util.Date;

/* compiled from: AbstractBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0888a {

    /* renamed from: A */
    protected int f3780A;

    /* renamed from: B */
    protected int f3781B;

    /* renamed from: C */
    protected String f3782C;

    /* renamed from: D */
    protected String f3783D;

    /* renamed from: E */
    protected int f3784E;

    /* renamed from: c */
    protected Context f3789c;

    /* renamed from: d */
    protected View f3790d;

    /* renamed from: e */
    protected Cursor f3791e;

    /* renamed from: f */
    protected int f3792f;

    /* renamed from: g */
    protected boolean f3793g;

    /* renamed from: h */
    protected C1070el f3794h;

    /* renamed from: i */
    protected float f3795i;

    /* renamed from: j */
    protected C3326c f3796j;

    /* renamed from: k */
    protected InterfaceC1093fh f3797k;

    /* renamed from: l */
    protected EnumC1450r f3798l;

    /* renamed from: m */
    protected long f3799m;

    /* renamed from: n */
    protected String f3800n;

    /* renamed from: o */
    protected long f3801o;

    /* renamed from: p */
    protected String f3802p;

    /* renamed from: q */
    protected String f3803q;

    /* renamed from: r */
    protected String f3804r;

    /* renamed from: s */
    protected String f3805s;

    /* renamed from: t */
    protected String f3806t;

    /* renamed from: u */
    protected EnumC1455w f3807u;

    /* renamed from: v */
    protected String f3808v;

    /* renamed from: w */
    protected String f3809w;

    /* renamed from: x */
    protected String f3810x;

    /* renamed from: y */
    protected long f3811y;

    /* renamed from: z */
    protected int f3812z;

    /* renamed from: a */
    protected Calendar f3787a = Calendar.getInstance();

    /* renamed from: F */
    private Calendar f3785F = Calendar.getInstance();

    /* renamed from: b */
    protected Date f3788b = new Date();

    /* renamed from: G */
    private Date f3786G = new Date();

    /* renamed from: a */
    protected abstract void mo5087a();

    /* renamed from: a */
    public void m5089a(InterfaceC1093fh interfaceC1093fh) {
        this.f3797k = interfaceC1093fh;
    }

    /* renamed from: a */
    public final void m5088a(Context context, EnumC1450r enumC1450r, View view, Cursor cursor, C1070el c1070el, boolean z, C3326c c3326c, float f) {
        this.f3789c = context;
        this.f3798l = enumC1450r;
        this.f3790d = view;
        this.f3791e = cursor;
        this.f3792f = this.f3791e.getPosition();
        this.f3794h = c1070el;
        this.f3793g = z;
        this.f3795i = f;
        this.f3796j = c3326c;
        this.f3799m = this.f3791e.getLong(this.f3791e.getColumnIndex("message_sever_id"));
        this.f3800n = this.f3791e.getString(this.f3791e.getColumnIndex("message_inbox_no"));
        this.f3801o = this.f3791e.getLong(this.f3791e.getColumnIndex("_id"));
        this.f3781B = this.f3791e.getInt(this.f3791e.getColumnIndex("message_read_status"));
        this.f3807u = EnumC1455w.m6358a(this.f3791e.getInt(this.f3791e.getColumnIndex("message_content_type")));
        this.f3811y = this.f3791e.getLong(this.f3791e.getColumnIndex("message_time"));
        this.f3802p = this.f3791e.getString(this.f3791e.getColumnIndex("message_content"));
        this.f3803q = this.f3791e.getString(this.f3791e.getColumnIndex("message_content_translated"));
        this.f3804r = this.f3791e.getString(this.f3791e.getColumnIndex("message_from_lang"));
        this.f3805s = this.f3791e.getString(this.f3791e.getColumnIndex("message_to_lang"));
        this.f3806t = this.f3791e.getString(this.f3791e.getColumnIndex("message_is_spoken"));
        this.f3780A = this.f3791e.getInt(this.f3791e.getColumnIndex("message_type"));
        this.f3808v = this.f3791e.getString(this.f3791e.getColumnIndex("message_sender"));
        this.f3809w = this.f3791e.getString(this.f3791e.getColumnIndex("message_download_uri"));
        this.f3810x = this.f3791e.getString(this.f3791e.getColumnIndex("message_formatted"));
        this.f3812z = this.f3791e.getInt(this.f3791e.getColumnIndex("message_is_failed"));
        this.f3782C = this.f3791e.getString(this.f3791e.getColumnIndex("buddy_no"));
        this.f3783D = this.f3791e.getString(this.f3791e.getColumnIndex("buddy_name"));
        this.f3784E = this.f3791e.getInt(this.f3791e.getColumnIndex("buddy_profile_status"));
        c1070el.f4271az = this.f3802p;
        c1070el.f4245aG = this.f3803q;
        c1070el.f4243aE = this.f3800n;
        c1070el.f4239aA = this.f3811y;
        c1070el.f4240aB = this.f3791e.getString(this.f3791e.getColumnIndex("message_session_id"));
        c1070el.f4241aC = this.f3799m;
        c1070el.f4242aD = this.f3791e.getInt(this.f3791e.getColumnIndex("message_read_status"));
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(this.f3808v)) {
            c1070el.f4244aF = true;
        } else {
            c1070el.f4244aF = false;
        }
        if (TextUtils.isEmpty(this.f3783D)) {
            this.f3783D = GlobalApplication.m6451b().getString(R.string.unknown);
        }
        this.f3788b = new Date(this.f3811y);
        this.f3787a.setTime(this.f3788b);
        m5091d_();
        mo5087a();
    }

    /* renamed from: a */
    public void mo5090a(boolean z) {
    }

    /* renamed from: d_ */
    protected void m5091d_() {
        this.f3786G.setTime(0L);
        if (this.f3812z != 0 || this.f3780A == 0) {
            this.f3794h.f4212A.setVisibility(8);
            return;
        }
        if (this.f3791e.getCount() > 1) {
            int position = this.f3791e.getPosition();
            if (this.f3791e.getPosition() != 0) {
                this.f3791e.moveToPosition(this.f3791e.getPosition() - 1);
            } else {
                this.f3791e.moveToPosition(this.f3791e.getPosition() + 1);
            }
            this.f3786G.setTime(this.f3791e.getLong(this.f3791e.getColumnIndex("message_time")));
            this.f3791e.moveToPosition(position);
        }
        this.f3785F.setTime(this.f3786G);
        if (this.f3791e.getPosition() == 0 || this.f3787a.get(1) != this.f3785F.get(1) || this.f3787a.get(2) != this.f3785F.get(2) || this.f3787a.get(5) != this.f3785F.get(5)) {
            this.f3794h.f4212A.setVisibility(0);
            this.f3794h.f4274d.setText(DateFormat.getDateFormat(CommonApplication.m11493l()).format(this.f3788b));
        } else {
            this.f3794h.f4212A.setVisibility(8);
        }
    }
}
