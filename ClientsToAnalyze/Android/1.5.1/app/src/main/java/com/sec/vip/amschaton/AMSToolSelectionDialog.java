package com.sec.vip.amschaton;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class AMSToolSelectionDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    protected int f4081a;

    /* renamed from: b */
    protected int f4082b;

    /* renamed from: c */
    protected float f4083c;

    /* renamed from: d */
    protected int f4084d;

    /* renamed from: e */
    protected OnApplyListener f4085e;

    public AMSToolSelectionDialog(Context context, int i) {
        super(context, i);
        this.f4083c = 1.0f;
        this.f4084d = 0;
        this.f4085e = null;
        requestWindowFeature(1);
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        this.f4081a = defaultDisplay.getWidth();
        this.f4082b = defaultDisplay.getHeight();
        float f = this.f4081a / 480.0f;
        float f2 = this.f4082b / 800.0f;
        this.f4083c = f >= f2 ? f2 : f;
        this.f4084d = getContext().getResources().getDimensionPixelOffset(C0062R.dimen.ams_color_picker_height);
    }

    /* renamed from: a */
    public void m4108a(OnApplyListener onApplyListener) {
        this.f4085e = onApplyListener;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_ok /* 2131427351 */:
                if (this.f4085e != null) {
                    this.f4085e.mo4161b();
                }
                dismiss();
                break;
            case C0062R.id.btn_cancel /* 2131427352 */:
                if (this.f4085e != null) {
                    this.f4085e.mo4160a();
                }
                dismiss();
                break;
        }
    }
}
