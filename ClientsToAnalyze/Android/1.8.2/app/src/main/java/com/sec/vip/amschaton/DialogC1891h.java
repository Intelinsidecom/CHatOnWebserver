package com.sec.vip.amschaton;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.sec.chaton.R;

/* compiled from: AMSColorPickerDialog.java */
/* renamed from: com.sec.vip.amschaton.h */
/* loaded from: classes.dex */
public class DialogC1891h extends Dialog implements View.OnClickListener, InterfaceC1871bd {

    /* renamed from: a */
    private ColorPickerView f6896a;

    /* renamed from: b */
    private int f6897b;

    /* renamed from: c */
    private int f6898c;

    /* renamed from: d */
    private int f6899d;

    /* renamed from: e */
    private InterfaceC1872be f6900e;

    public DialogC1891h(Context context) {
        super(context, R.style.AMSIcsDialogTheme);
        this.f6896a = null;
        this.f6897b = -1;
        this.f6898c = 0;
        this.f6899d = 0;
        this.f6900e = null;
        requestWindowFeature(1);
        setContentView(R.layout.ams_ics2_layout_color_picker);
        this.f6898c = getContext().getResources().getDimensionPixelSize(R.dimen.ams_ics2_color_picker_content_width);
        this.f6899d = getContext().getResources().getDimensionPixelSize(R.dimen.ams_ics2_color_picker_content_height);
        m6532b();
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);
    }

    /* renamed from: b */
    private void m6532b() {
        this.f6896a = new ColorPickerView(getContext(), this.f6898c, this.f6899d, -1);
        this.f6896a.setColorChangedListener(this);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f6896a.setLayerType(1, null);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f6898c, this.f6899d));
        linearLayout.addView(this.f6896a);
        ((LinearLayout) findViewById(R.id.layout_color_picker)).addView(linearLayout);
    }

    /* renamed from: a */
    public void m6534a(int i) {
        this.f6897b = i;
        this.f6896a.setColor(this.f6897b);
    }

    /* renamed from: a */
    public int m6533a() {
        return this.f6897b;
    }

    /* renamed from: a */
    public void m6535a(InterfaceC1872be interfaceC1872be) {
        this.f6900e = interfaceC1872be;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel /* 2131492890 */:
                if (this.f6900e != null) {
                    this.f6900e.mo6437e_();
                    break;
                }
                break;
            case R.id.btn_ok /* 2131492891 */:
                if (this.f6900e != null) {
                    this.f6900e.mo6436d_();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC1871bd
    /* renamed from: b */
    public boolean mo6467b(int i) {
        this.f6897b = i;
        return false;
    }
}
