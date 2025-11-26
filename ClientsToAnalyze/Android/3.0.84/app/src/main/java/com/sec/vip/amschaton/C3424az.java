package com.sec.vip.amschaton;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.az */
/* loaded from: classes.dex */
public class C3424az extends C3421aw {

    /* renamed from: g */
    private int f12537g;

    /* renamed from: h */
    private ImageView[] f12538h;

    /* renamed from: i */
    private int f12539i;

    /* renamed from: j */
    private ImageView[] f12540j;

    /* renamed from: k */
    private ImageView f12541k;

    /* renamed from: l */
    private int[] f12542l;

    /* renamed from: m */
    private int[] f12543m;

    /* renamed from: n */
    private View f12544n;

    /* renamed from: o */
    private View.OnClickListener f12545o;

    /* renamed from: p */
    private View.OnClickListener f12546p;

    /* renamed from: q */
    private View.OnClickListener f12547q;

    public C3424az(Context context, int i, View view, boolean z) {
        super(context, i, z);
        this.f12537g = 2;
        this.f12539i = 0;
        this.f12540j = null;
        this.f12541k = null;
        this.f12542l = new int[]{R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14, R.id.btn_color15};
        this.f12543m = new int[]{R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        this.f12544n = null;
        this.f12545o = new ViewOnClickListenerC3429bd(this);
        this.f12546p = new ViewOnClickListenerC3430be(this);
        this.f12547q = new ViewOnClickListenerC3432bg(this);
        m12250a(view);
    }

    /* renamed from: a */
    private void m12250a(View view) {
        ((ImageView) m12243f().findViewById(R.id.btn_close_popup)).setOnClickListener(new ViewOnClickListenerC3426ba(this));
        this.f12538h = new ImageView[5];
        int[] iArr = {R.id.btn_text_size1, R.id.btn_text_size2, R.id.btn_text_size3, R.id.btn_text_size4, R.id.btn_text_size5};
        for (int i = 0; i < 5; i++) {
            this.f12538h[i] = (ImageView) m12243f().findViewById(iArr[i]);
            this.f12538h[i].setOnClickListener(this.f12545o);
        }
        m12249a(2, true);
        this.f12544n = ((ViewStub) m12243f().findViewById(R.id.stub_text_color)).inflate();
        this.f12540j = new ImageView[15];
        for (int i2 = 0; i2 < 15; i2++) {
            this.f12540j[i2] = (ImageView) this.f12544n.findViewById(this.f12542l[i2]);
            this.f12540j[i2].setOnClickListener(this.f12546p);
        }
        this.f12541k = (ImageView) this.f12544n.findViewById(R.id.btn_color16);
        this.f12541k.setOnClickListener(this.f12547q);
        m12254b(m12258d(this.f12539i), true);
        m12255b(view);
    }

    /* renamed from: b */
    private void m12255b(View view) {
        view.post(new RunnableC3428bc(this, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12260d() {
        dismiss();
    }

    /* renamed from: a */
    private void m12249a(int i, boolean z) {
        if (i >= 0 && i < 5) {
            this.f12538h[i].setSelected(z);
        }
    }

    /* renamed from: a */
    public void m12263a(int i) {
        m12249a(this.f12537g, false);
        this.f12537g = i;
        m12249a(this.f12537g, true);
    }

    /* renamed from: a */
    public int m12262a() {
        return this.f12537g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12254b(int i, boolean z) {
        if (i < 15) {
            if (i < 0) {
                for (int i2 = 0; i2 < 15; i2++) {
                    this.f12540j[i2].setSelected(false);
                }
                this.f12541k.setSelected(z);
                return;
            }
            this.f12540j[i].setSelected(z);
        }
    }

    /* renamed from: a */
    private void m12253a(boolean z) {
        for (int i = 0; i < 15; i++) {
            this.f12540j[i].setSelected(z);
        }
        this.f12541k.setSelected(z);
    }

    /* renamed from: b */
    public void m12265b(int i) {
        m12253a(false);
        this.f12539i = i;
        m12254b(m12258d(this.f12539i), true);
    }

    /* renamed from: b */
    public int m12264b() {
        return this.f12539i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m12258d(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            if (i == m12242e().getResources().getColor(this.f12543m[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public void m12267c(int i) {
        this.f12526d = new C3576i(m12242e());
        this.f12526d.m12770a(i);
        m12266c();
        this.f12526d.m12774d();
    }

    /* renamed from: c */
    public void m12266c() {
        this.f12526d.m12771a(new C3431bf(this));
    }
}
