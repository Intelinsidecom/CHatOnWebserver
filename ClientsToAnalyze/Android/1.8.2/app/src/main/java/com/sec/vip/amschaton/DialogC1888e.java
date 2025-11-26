package com.sec.vip.amschaton;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: AMSBgColorSelectionDialog.java */
/* renamed from: com.sec.vip.amschaton.e */
/* loaded from: classes.dex */
public class DialogC1888e extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private int f6889a;

    /* renamed from: b */
    private ImageView[] f6890b;

    /* renamed from: c */
    private int[] f6891c;

    /* renamed from: d */
    private int[] f6892d;

    /* renamed from: e */
    private InterfaceC1872be f6893e;

    /* renamed from: f */
    private View.OnClickListener f6894f;

    public DialogC1888e(Context context) {
        super(context, R.style.AMSIcsDialogTheme);
        this.f6890b = null;
        this.f6891c = new int[]{R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14, R.id.btn_color15};
        this.f6892d = new int[]{R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        this.f6893e = null;
        this.f6894f = new ViewOnClickListenerC1889f(this);
        requestWindowFeature(1);
        setContentView(R.layout.ams_ics_layout_bg_color);
        this.f6890b = new ImageView[15];
        for (int i = 0; i < 15; i++) {
            this.f6890b[i] = (ImageView) findViewById(this.f6891c[i]);
            this.f6890b[i].setOnClickListener(this.f6894f);
        }
        m6519a(m6522b(this.f6889a), true);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);
    }

    /* renamed from: a */
    public void m6527a(int i) {
        m6519a(-1, false);
        this.f6889a = i;
        m6519a(m6522b(this.f6889a), true);
    }

    /* renamed from: a */
    public int m6526a() {
        return this.f6889a;
    }

    /* renamed from: a */
    public void m6528a(InterfaceC1872be interfaceC1872be) {
        this.f6893e = interfaceC1872be;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6519a(int i, boolean z) {
        if (i < 15) {
            if (i < 0) {
                for (int i2 = 0; i2 < 15; i2++) {
                    this.f6890b[i2].setSelected(false);
                }
                return;
            }
            this.f6890b[i].setSelected(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel /* 2131492890 */:
                if (this.f6893e != null) {
                    this.f6893e.mo6437e_();
                }
                dismiss();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m6522b(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            if (i == getContext().getResources().getColor(this.f6892d[i2])) {
                return i2;
            }
        }
        return -1;
    }
}
