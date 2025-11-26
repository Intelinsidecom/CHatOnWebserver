package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1729gb;
import com.sec.chaton.chat.C1730gc;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.chat.InterfaceC1773hs;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2216ad;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.MessageListItem;
import com.sec.chaton.util.C4809aa;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/* compiled from: AbstractBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1506a {

    /* renamed from: A */
    protected int f5840A;

    /* renamed from: B */
    protected int f5841B;

    /* renamed from: C */
    protected String f5842C;

    /* renamed from: D */
    protected String f5843D;

    /* renamed from: E */
    protected int f5844E;

    /* renamed from: F */
    protected EnumC2301u f5845F;

    /* renamed from: G */
    protected boolean f5846G;

    /* renamed from: H */
    protected String f5847H;

    /* renamed from: I */
    protected EnumC2216ad f5848I;

    /* renamed from: J */
    protected C4108aq f5849J;

    /* renamed from: K */
    protected MessageListItem f5850K;

    /* renamed from: N */
    private int f5853N;

    /* renamed from: c */
    protected Context f5856c;

    /* renamed from: d */
    protected View f5857d;

    /* renamed from: e */
    protected Cursor f5858e;

    /* renamed from: f */
    protected int f5859f;

    /* renamed from: g */
    protected boolean f5860g;

    /* renamed from: h */
    protected C1729gb f5861h;

    /* renamed from: i */
    protected float f5862i;

    /* renamed from: j */
    protected C5007c f5863j;

    /* renamed from: k */
    protected InterfaceC1773hs f5864k;

    /* renamed from: l */
    protected EnumC2300t f5865l;

    /* renamed from: m */
    protected long f5866m;

    /* renamed from: n */
    protected String f5867n;

    /* renamed from: o */
    protected long f5868o;

    /* renamed from: p */
    protected String f5869p;

    /* renamed from: q */
    protected String f5870q;

    /* renamed from: r */
    protected String f5871r;

    /* renamed from: s */
    protected String f5872s;

    /* renamed from: t */
    protected String f5873t;

    /* renamed from: u */
    protected EnumC2214ab f5874u;

    /* renamed from: v */
    protected String f5875v;

    /* renamed from: w */
    protected String f5876w;

    /* renamed from: x */
    protected String f5877x;

    /* renamed from: y */
    protected long f5878y;

    /* renamed from: z */
    protected int f5879z;

    /* renamed from: a */
    protected Calendar f5854a = Calendar.getInstance();

    /* renamed from: L */
    private final Calendar f5851L = Calendar.getInstance();

    /* renamed from: b */
    protected Date f5855b = new Date();

    /* renamed from: M */
    private final Date f5852M = new Date();

    /* renamed from: a */
    protected abstract void mo8357a();

    /* renamed from: a */
    public void m8358a(int i) {
        this.f5853N = i;
    }

    /* renamed from: a */
    public void m8360a(InterfaceC1773hs interfaceC1773hs) {
        this.f5864k = interfaceC1773hs;
    }

    /* renamed from: a */
    public final void m8359a(Context context, EnumC2300t enumC2300t, View view, Cursor cursor, C1729gb c1729gb, boolean z, C5007c c5007c, float f, EnumC2301u enumC2301u) {
        this.f5845F = enumC2301u;
        this.f5856c = context;
        this.f5865l = enumC2300t;
        this.f5857d = view;
        this.f5858e = cursor;
        this.f5859f = this.f5858e.getPosition();
        this.f5861h = c1729gb;
        this.f5860g = z;
        this.f5862i = f;
        this.f5863j = c5007c;
        this.f5849J = new C4108aq(this.f5856c, cursor, new C1730gc(cursor), 0, (Pattern) null, false);
        this.f5866m = this.f5849J.f15246E;
        this.f5867n = this.f5849J.f15251J;
        this.f5868o = this.f5849J.f15245D;
        this.f5841B = this.f5849J.f15264W;
        this.f5874u = this.f5849J.f15248G;
        this.f5878y = this.f5849J.f15247F;
        this.f5869p = this.f5849J.f15257P;
        this.f5870q = this.f5849J.f15258Q;
        this.f5871r = this.f5849J.f15260S;
        this.f5872s = this.f5849J.f15261T;
        this.f5873t = this.f5849J.f15262U;
        this.f5840A = this.f5849J.f15249H;
        this.f5875v = this.f5849J.f15254M;
        this.f5876w = this.f5849J.f15259R;
        this.f5877x = this.f5849J.f15252K;
        this.f5879z = this.f5849J.f15263V;
        this.f5842C = this.f5849J.f15253L;
        this.f5843D = this.f5849J.f15255N;
        this.f5844E = this.f5849J.f15256O;
        this.f5846G = "Y".equals(this.f5858e.getString(this.f5858e.getColumnIndex("is_buddy")));
        this.f5848I = this.f5849J.f15265X;
        c1729gb.f6422aM = this.f5869p;
        c1729gb.f6429aT = this.f5870q;
        c1729gb.f6427aR = this.f5867n;
        c1729gb.f6423aN = this.f5849J.f15247F;
        c1729gb.f6424aO = this.f5849J.f15250I;
        c1729gb.f6425aP = this.f5866m;
        c1729gb.f6426aQ = this.f5849J.f15264W;
        if (C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f5875v)) {
            c1729gb.f6428aS = true;
        } else {
            c1729gb.f6428aS = false;
        }
        c1729gb.f6430aU = this.f5848I;
        if (TextUtils.isEmpty(this.f5843D)) {
            this.f5843D = GlobalApplication.m10283b().getString(R.string.unknown);
        }
        this.f5855b = new Date(this.f5878y);
        this.f5854a.setTime(this.f5855b);
        mo8364e_();
        mo8357a();
        m8362c();
        m8363d();
    }

    /* renamed from: a */
    public void mo8361a(boolean z) {
    }

    /* renamed from: e_ */
    protected void mo8364e_() {
        this.f5852M.setTime(0L);
        if (this.f5879z != 0 || this.f5840A == 0) {
            this.f5861h.f6386D.setVisibility(8);
            return;
        }
        if (this.f5858e.getCount() > 1) {
            int position = this.f5858e.getPosition();
            if (this.f5858e.getPosition() != 0) {
                this.f5858e.moveToPosition(this.f5858e.getPosition() - 1);
            }
            this.f5852M.setTime(C1736gi.m8645b(this.f5858e));
            this.f5858e.moveToPosition(position);
        }
        this.f5851L.setTime(this.f5852M);
        if (this.f5858e.getPosition() == 0 || this.f5854a.get(1) != this.f5851L.get(1) || this.f5854a.get(2) != this.f5851L.get(2) || this.f5854a.get(5) != this.f5851L.get(5)) {
            this.f5861h.f6386D.setVisibility(0);
            this.f5861h.f6459d.setText(DateFormat.getDateFormat(CommonApplication.m18732r()).format(this.f5855b));
        } else {
            this.f5861h.f6386D.setVisibility(8);
        }
    }

    /* renamed from: c */
    protected void m8362c() {
        TextView[] textViewArr;
        if (this.f5861h.f6428aS) {
            textViewArr = new TextView[]{this.f5861h.f6397O, this.f5861h.f6399Q, this.f5861h.f6455ay, this.f5861h.f6410aA};
        } else {
            textViewArr = new TextView[]{this.f5861h.f6472q, this.f5861h.f6474s, this.f5861h.f6415aF, this.f5861h.f6417aH};
        }
        for (TextView textView : textViewArr) {
            C1736gi.m8641a(textView);
        }
    }

    /* renamed from: d */
    protected void m8363d() {
        if (this.f5861h.f6428aS) {
            if (this.f5861h.f6430aU == EnumC2216ad.WITHDRAW_SUCCESS) {
                if (Build.VERSION.SDK_INT >= 11) {
                    if (this.f5861h.f6402T.getVisibility() == 0) {
                        this.f5861h.f6402T.setAlpha(0.4f);
                    }
                    if (this.f5861h.f6449as.getVisibility() == 0) {
                        this.f5861h.f6449as.setAlpha(0.4f);
                    }
                    if (this.f5861h.f6405W.getVisibility() == 0) {
                        this.f5861h.f6405W.setAlpha(0.4f);
                    }
                    if (this.f5861h.f6454ax.getVisibility() == 0) {
                        this.f5861h.f6454ax.setAlpha(0.4f);
                    }
                    if (this.f5861h.f6407Y.getVisibility() == 0) {
                        this.f5861h.f6407Y.setAlpha(0.4f);
                    }
                }
                this.f5861h.f6397O.setTextColor(this.f5856c.getResources().getColor(R.color.recall_text_color));
                this.f5861h.f6399Q.setTextColor(this.f5856c.getResources().getColor(R.color.recall_text_color));
                return;
            }
            if (Build.VERSION.SDK_INT >= 11) {
                if (this.f5861h.f6402T.getVisibility() == 0) {
                    this.f5861h.f6402T.setAlpha(1.0f);
                }
                if (this.f5861h.f6449as.getVisibility() == 0) {
                    this.f5861h.f6449as.setAlpha(1.0f);
                }
                if (this.f5861h.f6405W.getVisibility() == 0) {
                    this.f5861h.f6405W.setAlpha(1.0f);
                }
                if (this.f5861h.f6454ax.getVisibility() == 0) {
                    this.f5861h.f6454ax.setAlpha(1.0f);
                }
                if (this.f5861h.f6407Y.getVisibility() == 0) {
                    this.f5861h.f6407Y.setAlpha(1.0f);
                }
            }
        }
    }
}
