package com.sec.vip.amschaton;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.sec.chaton.R;

/* compiled from: AMSBgColorSelectionDialog.java */
/* renamed from: com.sec.vip.amschaton.m */
/* loaded from: classes.dex */
public class DialogC1548m extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private int f5377a;

    /* renamed from: b */
    private ImageView[] f5378b;

    /* renamed from: c */
    private int[] f5379c;

    /* renamed from: d */
    private int[] f5380d;

    /* renamed from: e */
    private InterfaceC1397bg f5381e;

    /* renamed from: f */
    private View.OnClickListener f5382f;

    public DialogC1548m(Context context) {
        super(context, R.style.AMSIcsDialogTheme);
        this.f5378b = null;
        this.f5379c = new int[]{R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14, R.id.btn_color15};
        this.f5380d = new int[]{R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color10, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};
        this.f5381e = null;
        this.f5382f = new ViewOnClickListenerC1390b(this);
        requestWindowFeature(1);
        setContentView(R.layout.ams_ics_layout_bg_color);
        this.f5378b = new ImageView[15];
        for (int i = 0; i < 15; i++) {
            this.f5378b[i] = (ImageView) findViewById(this.f5379c[i]);
            this.f5378b[i].setOnClickListener(this.f5382f);
        }
        m5616a(m5619b(this.f5377a), true);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);
    }

    /* renamed from: a */
    public void m5624a(int i) {
        m5616a(-1, false);
        this.f5377a = i;
        m5616a(m5619b(this.f5377a), true);
    }

    /* renamed from: a */
    public int m5623a() {
        return this.f5377a;
    }

    /* renamed from: a */
    public void m5625a(InterfaceC1397bg interfaceC1397bg) {
        this.f5381e = interfaceC1397bg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5616a(int i, boolean z) {
        if (i < 15) {
            if (i < 0) {
                for (int i2 = 0; i2 < 15; i2++) {
                    this.f5378b[i2].setSelected(false);
                }
                return;
            }
            this.f5378b[i].setSelected(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel /* 2131427356 */:
                if (this.f5381e != null) {
                    this.f5381e.mo4926a();
                }
                dismiss();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m5619b(int i) {
        for (int i2 = 0; i2 < 15; i2++) {
            if (i == getContext().getResources().getColor(this.f5380d[i2])) {
                return i2;
            }
        }
        return -1;
    }
}
