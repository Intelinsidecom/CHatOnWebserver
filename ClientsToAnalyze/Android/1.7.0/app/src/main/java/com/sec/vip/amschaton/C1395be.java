package com.sec.vip.amschaton;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.be */
/* loaded from: classes.dex */
public class C1395be extends C1560y {

    /* renamed from: e */
    private int f4888e;

    /* renamed from: f */
    private ImageView[] f4889f;

    /* renamed from: g */
    private int f4890g;

    /* renamed from: h */
    private ImageView[] f4891h;

    /* renamed from: i */
    private ImageView f4892i;

    /* renamed from: j */
    private int[] f4893j;

    /* renamed from: k */
    private int[] f4894k;

    /* renamed from: l */
    private View f4895l;

    /* renamed from: m */
    private DialogC1363a f4896m;

    /* renamed from: n */
    private View.OnClickListener f4897n;

    /* renamed from: o */
    private View.OnClickListener f4898o;

    /* renamed from: p */
    private View.OnClickListener f4899p;

    public C1395be(Context context, int i, View view, boolean z) {
        super(context, i, z);
        this.f4888e = 2;
        this.f4890g = 0;
        this.f4891h = null;
        this.f4892i = null;
        this.f4893j = new int[]{R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14, R.id.btn_color15};
        this.f4894k = new int[]{R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        this.f4895l = null;
        this.f4896m = null;
        this.f4897n = new ViewOnClickListenerC1371ah(this);
        this.f4898o = new ViewOnClickListenerC1370ag(this);
        this.f4899p = new ViewOnClickListenerC1374ak(this);
        m4986a(view);
    }

    /* renamed from: a */
    private void m4986a(View view) {
        ((ImageView) m5650b().findViewById(R.id.btn_close_popup)).setOnClickListener(new ViewOnClickListenerC1373aj(this));
        this.f4889f = new ImageView[5];
        int[] iArr = {R.id.btn_text_size1, R.id.btn_text_size2, R.id.btn_text_size3, R.id.btn_text_size4, R.id.btn_text_size5};
        for (int i = 0; i < 5; i++) {
            this.f4889f[i] = (ImageView) m5650b().findViewById(iArr[i]);
            this.f4889f[i].setOnClickListener(this.f4897n);
        }
        m4985a(2, true);
        this.f4895l = ((ViewStub) m5650b().findViewById(R.id.stub_text_color)).inflate();
        this.f4891h = new ImageView[15];
        for (int i2 = 0; i2 < 15; i2++) {
            this.f4891h[i2] = (ImageView) this.f4895l.findViewById(this.f4893j[i2]);
            this.f4891h[i2].setOnClickListener(this.f4898o);
        }
        this.f4892i = (ImageView) this.f4895l.findViewById(R.id.btn_color16);
        this.f4892i.setOnClickListener(this.f4899p);
        m4990b(m4993c(this.f4890g), true);
        m4991b(view);
    }

    /* renamed from: b */
    private void m4991b(View view) {
        view.post(new RunnableC1372ai(this, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4998g() {
        dismiss();
    }

    /* renamed from: a */
    private void m4985a(int i, boolean z) {
        if (i >= 0 && i < 5) {
            this.f4889f[i].setSelected(z);
        }
    }

    /* renamed from: a */
    public void m4999a(int i) {
        m4985a(this.f4888e, false);
        this.f4888e = i;
        m4985a(this.f4888e, true);
    }

    /* renamed from: e */
    public int m5001e() {
        return this.f4888e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4990b(int i, boolean z) {
        if (i < 15) {
            if (i < 0) {
                for (int i2 = 0; i2 < 15; i2++) {
                    this.f4891h[i2].setSelected(false);
                }
                this.f4892i.setSelected(z);
                return;
            }
            this.f4891h[i].setSelected(z);
        }
    }

    /* renamed from: a */
    private void m4989a(boolean z) {
        for (int i = 0; i < 15; i++) {
            this.f4891h[i].setSelected(z);
        }
        this.f4892i.setSelected(z);
    }

    /* renamed from: b */
    public void m5000b(int i) {
        m4989a(false);
        this.f4890g = i;
        m4990b(m4993c(this.f4890g), true);
    }

    /* renamed from: f */
    public int m5002f() {
        return this.f4890g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m4993c(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            if (i == m5646a().getResources().getColor(this.f4894k[i2])) {
                return i2;
            }
        }
        return -1;
    }
}
