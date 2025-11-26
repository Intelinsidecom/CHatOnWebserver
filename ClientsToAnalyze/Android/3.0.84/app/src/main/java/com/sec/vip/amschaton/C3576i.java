package com.sec.vip.amschaton;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* compiled from: AMSColorPickerDialog.java */
/* renamed from: com.sec.vip.amschaton.i */
/* loaded from: classes.dex */
public class C3576i implements InterfaceC3433bh {

    /* renamed from: a */
    private Context f13028a;

    /* renamed from: b */
    private View f13029b;

    /* renamed from: c */
    private InterfaceC3274d f13030c;

    /* renamed from: f */
    private int f13033f;

    /* renamed from: g */
    private int f13034g;

    /* renamed from: d */
    private ColorPickerView f13031d = null;

    /* renamed from: e */
    private int f13032e = -1;

    /* renamed from: h */
    private InterfaceC3434bi f13035h = null;

    public C3576i(Context context) {
        this.f13033f = 0;
        this.f13034g = 0;
        this.f13028a = context;
        this.f13029b = LayoutInflater.from(context).inflate(R.layout.layout_ams_color_picker, (ViewGroup) null);
        this.f13033f = this.f13028a.getResources().getDimensionPixelSize(R.dimen.ams_ics2_color_picker_content_width);
        this.f13034g = this.f13028a.getResources().getDimensionPixelSize(R.dimen.ams_ics2_color_picker_content_height);
        m12768f();
    }

    /* renamed from: a */
    public void m12769a() {
        this.f13030c = AbstractC3271a.m11494a(this.f13028a).mo11502a(true).mo11508b(this.f13029b).mo11495a(R.string.ams_background_color).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3578k(this)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3577j(this)).mo11505a();
    }

    /* renamed from: f */
    private void m12768f() {
        this.f13031d = new ColorPickerView(this.f13028a, this.f13033f, this.f13034g, -1);
        this.f13031d.setColorChangedListener(this);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f13031d.setLayerType(1, null);
        }
        LinearLayout linearLayout = new LinearLayout(this.f13028a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f13033f, this.f13034g));
        linearLayout.addView(this.f13031d);
        ((LinearLayout) this.f13029b.findViewById(R.id.layout_color_picker)).addView(linearLayout);
    }

    /* renamed from: a */
    public void m12770a(int i) {
        this.f13032e = i;
        this.f13031d.setColor(this.f13032e);
    }

    /* renamed from: b */
    public int m12772b() {
        return this.f13032e;
    }

    /* renamed from: c */
    public boolean m12773c() {
        return this.f13030c.isShowing();
    }

    /* renamed from: d */
    public void m12774d() {
        if (this.f13030c == null) {
            m12769a();
        }
        this.f13030c.show();
    }

    /* renamed from: e */
    public void m12775e() {
        this.f13030c.dismiss();
    }

    /* renamed from: a */
    public void m12771a(InterfaceC3434bi interfaceC3434bi) {
        this.f13035h = interfaceC3434bi;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3433bh
    /* renamed from: b */
    public boolean mo12289b(int i) {
        this.f13032e = i;
        return false;
    }
}
