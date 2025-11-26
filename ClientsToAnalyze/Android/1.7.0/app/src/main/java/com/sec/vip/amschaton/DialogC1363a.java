package com.sec.vip.amschaton;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.sec.chaton.R;

/* compiled from: AMSColorPickerDialog.java */
/* renamed from: com.sec.vip.amschaton.a */
/* loaded from: classes.dex */
public class DialogC1363a extends Dialog implements View.OnClickListener, InterfaceC1384au {

    /* renamed from: a */
    private ColorPickerView f4777a;

    /* renamed from: b */
    private int f4778b;

    /* renamed from: c */
    private int f4779c;

    /* renamed from: d */
    private int f4780d;

    /* renamed from: e */
    private InterfaceC1397bg f4781e;

    public DialogC1363a(Context context) {
        super(context, R.style.AMSIcsDialogTheme);
        this.f4777a = null;
        this.f4778b = -1;
        this.f4779c = 0;
        this.f4780d = 0;
        this.f4781e = null;
        requestWindowFeature(1);
        setContentView(R.layout.ams_ics2_layout_color_picker);
        this.f4779c = getContext().getResources().getDimensionPixelSize(R.dimen.ams_ics2_color_picker_content_width);
        this.f4780d = getContext().getResources().getDimensionPixelSize(R.dimen.ams_ics2_color_picker_content_height);
        m4860b();
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);
    }

    /* renamed from: b */
    private void m4860b() {
        this.f4777a = new ColorPickerView(getContext(), this.f4779c, this.f4780d, -1);
        this.f4777a.setColorChangedListener(this);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f4777a.setLayerType(1, null);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f4779c, this.f4780d));
        linearLayout.addView(this.f4777a);
        ((LinearLayout) findViewById(R.id.layout_color_picker)).addView(linearLayout);
    }

    /* renamed from: a */
    public void m4862a(int i) {
        this.f4778b = i;
        this.f4777a.setColor(this.f4778b);
    }

    /* renamed from: a */
    public int m4861a() {
        return this.f4778b;
    }

    /* renamed from: a */
    public void m4863a(InterfaceC1397bg interfaceC1397bg) {
        this.f4781e = interfaceC1397bg;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel /* 2131427356 */:
                if (this.f4781e != null) {
                    this.f4781e.mo4926a();
                    break;
                }
                break;
            case R.id.btn_ok /* 2131427357 */:
                if (this.f4781e != null) {
                    this.f4781e.mo4927b();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.vip.amschaton.InterfaceC1384au
    /* renamed from: b */
    public boolean mo4864b(int i) {
        this.f4778b = i;
        return false;
    }
}
