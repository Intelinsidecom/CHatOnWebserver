package com.sec.vip.amschaton;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.av */
/* loaded from: classes.dex */
public class C1862av extends C1860at {

    /* renamed from: f */
    private int f6823f;

    /* renamed from: g */
    private ImageView[] f6824g;

    /* renamed from: h */
    private int f6825h;

    /* renamed from: i */
    private ImageView[] f6826i;

    /* renamed from: j */
    private ImageView f6827j;

    /* renamed from: k */
    private int[] f6828k;

    /* renamed from: l */
    private int[] f6829l;

    /* renamed from: m */
    private View f6830m;

    /* renamed from: n */
    private View.OnClickListener f6831n;

    /* renamed from: o */
    private View.OnClickListener f6832o;

    /* renamed from: p */
    private View.OnClickListener f6833p;

    public C1862av(Context context, int i, View view, boolean z) {
        super(context, i, z);
        this.f6823f = 2;
        this.f6825h = 0;
        this.f6826i = null;
        this.f6827j = null;
        this.f6828k = new int[]{R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14, R.id.btn_color15};
        this.f6829l = new int[]{R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        this.f6830m = null;
        this.f6831n = new ViewOnClickListenerC1866az(this);
        this.f6832o = new ViewOnClickListenerC1868ba(this);
        this.f6833p = new ViewOnClickListenerC1870bc(this);
        m6449a(view);
    }

    /* renamed from: a */
    private void m6449a(View view) {
        ((ImageView) m6444f().findViewById(R.id.btn_close_popup)).setOnClickListener(new ViewOnClickListenerC1863aw(this));
        this.f6824g = new ImageView[5];
        int[] iArr = {R.id.btn_text_size1, R.id.btn_text_size2, R.id.btn_text_size3, R.id.btn_text_size4, R.id.btn_text_size5};
        for (int i = 0; i < 5; i++) {
            this.f6824g[i] = (ImageView) m6444f().findViewById(iArr[i]);
            this.f6824g[i].setOnClickListener(this.f6831n);
        }
        m6448a(2, true);
        this.f6830m = ((ViewStub) m6444f().findViewById(R.id.stub_text_color)).inflate();
        this.f6826i = new ImageView[15];
        for (int i2 = 0; i2 < 15; i2++) {
            this.f6826i[i2] = (ImageView) this.f6830m.findViewById(this.f6828k[i2]);
            this.f6826i[i2].setOnClickListener(this.f6832o);
        }
        this.f6827j = (ImageView) this.f6830m.findViewById(R.id.btn_color16);
        this.f6827j.setOnClickListener(this.f6833p);
        m6453b(m6457d(this.f6825h), true);
        m6454b(view);
    }

    /* renamed from: b */
    private void m6454b(View view) {
        view.post(new RunnableC1865ay(this, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6459d() {
        dismiss();
    }

    /* renamed from: a */
    private void m6448a(int i, boolean z) {
        if (i >= 0 && i < 5) {
            this.f6824g[i].setSelected(z);
        }
    }

    /* renamed from: a */
    public void m6462a(int i) {
        m6448a(this.f6823f, false);
        this.f6823f = i;
        m6448a(this.f6823f, true);
    }

    /* renamed from: a */
    public int m6461a() {
        return this.f6823f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6453b(int i, boolean z) {
        if (i < 15) {
            if (i < 0) {
                for (int i2 = 0; i2 < 15; i2++) {
                    this.f6826i[i2].setSelected(false);
                }
                this.f6827j.setSelected(z);
                return;
            }
            this.f6826i[i].setSelected(z);
        }
    }

    /* renamed from: a */
    private void m6452a(boolean z) {
        for (int i = 0; i < 15; i++) {
            this.f6826i[i].setSelected(z);
        }
        this.f6827j.setSelected(z);
    }

    /* renamed from: b */
    public void m6464b(int i) {
        m6452a(false);
        this.f6825h = i;
        m6453b(m6457d(this.f6825h), true);
    }

    /* renamed from: b */
    public int m6463b() {
        return this.f6825h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m6457d(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            if (i == m6443e().getResources().getColor(this.f6829l[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public void m6466c(int i) {
        this.f6815d = new DialogC1891h(m6443e());
        this.f6815d.m6534a(i);
        m6465c();
        this.f6815d.show();
    }

    /* renamed from: c */
    public void m6465c() {
        this.f6815d.m6535a(new C1869bb(this));
    }
}
