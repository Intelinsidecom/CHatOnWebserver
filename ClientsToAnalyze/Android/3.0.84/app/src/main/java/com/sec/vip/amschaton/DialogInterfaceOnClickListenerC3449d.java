package com.sec.vip.amschaton;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* compiled from: AMSBgColorSelectionDialog.java */
/* renamed from: com.sec.vip.amschaton.d */
/* loaded from: classes.dex */
public class DialogInterfaceOnClickListenerC3449d implements DialogInterface.OnClickListener {

    /* renamed from: b */
    private Context f12614b;

    /* renamed from: c */
    private View f12615c;

    /* renamed from: d */
    private InterfaceC3274d f12616d;

    /* renamed from: f */
    private ImageView[] f12618f;

    /* renamed from: g */
    private ImageView f12619g;

    /* renamed from: a */
    protected C3576i f12613a = null;

    /* renamed from: e */
    private int f12617e = -16777216;

    /* renamed from: h */
    private int[] f12620h = {R.id.btn_color01, R.id.btn_color02, R.id.btn_color03, R.id.btn_color04, R.id.btn_color05, R.id.btn_color06, R.id.btn_color07, R.id.btn_color08, R.id.btn_color09, R.id.btn_color10, R.id.btn_color11, R.id.btn_color12, R.id.btn_color13, R.id.btn_color14};

    /* renamed from: i */
    private int[] f12621i = {R.color.ams_ics_default_color01, R.color.ams_ics_default_color02, R.color.ams_ics_default_color03, R.color.ams_ics_default_color04, R.color.ams_ics_default_color05, R.color.ams_ics_default_color06, R.color.ams_ics_default_color07, R.color.ams_ics_default_color08, R.color.ams_ics_default_color09, R.color.ams_ics_default_color11, R.color.ams_ics_default_color12, R.color.ams_ics_default_color13, R.color.ams_ics_default_color14, R.color.ams_ics_default_color15};

    /* renamed from: j */
    private InterfaceC3434bi f12622j = null;

    /* renamed from: k */
    private View.OnClickListener f12623k = new ViewOnClickListenerC3450e(this);

    /* renamed from: l */
    private View.OnClickListener f12624l = new ViewOnClickListenerC3451f(this);

    public DialogInterfaceOnClickListenerC3449d(Context context) {
        this.f12618f = null;
        this.f12619g = null;
        this.f12614b = context;
        this.f12615c = LayoutInflater.from(context).inflate(R.layout.layout_ams_bg_color, (ViewGroup) null);
        this.f12618f = new ImageView[14];
        for (int i = 0; i < 14; i++) {
            this.f12618f[i] = (ImageView) this.f12615c.findViewById(this.f12620h[i]);
            this.f12618f[i].setOnClickListener(this.f12623k);
        }
        this.f12619g = (ImageView) this.f12615c.findViewById(R.id.btn_color15);
        this.f12619g.setOnClickListener(this.f12624l);
        m12341a(m12345c(this.f12617e), true);
    }

    /* renamed from: a */
    public void m12350a() {
        this.f12616d = AbstractC3271a.m11494a(this.f12614b).mo11502a(true).mo11495a(R.string.ams_background_color).mo11508b(this.f12615c).mo11514c(R.string.dialog_cancel, this).mo11505a();
    }

    /* renamed from: a */
    public void m12351a(int i) {
        this.f12617e = i;
        m12341a(-1, false);
        m12341a(m12345c(this.f12617e), true);
    }

    /* renamed from: b */
    public int m12353b() {
        return this.f12617e;
    }

    /* renamed from: c */
    public void m12355c() {
        if (this.f12616d == null) {
            m12350a();
        }
        this.f12616d.show();
    }

    /* renamed from: d */
    public void m12356d() {
        if (this.f12613a != null) {
            this.f12613a.m12775e();
        }
        this.f12616d.dismiss();
    }

    /* renamed from: a */
    public void m12352a(InterfaceC3434bi interfaceC3434bi) {
        this.f12622j = interfaceC3434bi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12341a(int i, boolean z) {
        if (i < 14) {
            if (i < 0) {
                for (int i2 = 0; i2 < 14; i2++) {
                    this.f12618f[i2].setSelected(false);
                }
                if (this.f12619g != null) {
                    this.f12619g.setSelected(z);
                    return;
                }
                return;
            }
            this.f12618f[i].setSelected(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m12345c(int i) {
        for (int i2 = 0; i2 < 14; i2++) {
            if (i == this.f12614b.getResources().getColor(this.f12621i[i2])) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: e */
    public boolean m12357e() {
        if (this.f12613a != null) {
            return this.f12613a.m12773c();
        }
        return false;
    }

    /* renamed from: f */
    public int m12358f() {
        return this.f12613a != null ? this.f12613a.m12772b() : this.f12617e;
    }

    /* renamed from: b */
    public void m12354b(int i) {
        this.f12613a = new C3576i(this.f12614b);
        this.f12613a.m12770a(i);
        this.f12613a.m12771a(new C3574g(this));
        this.f12613a.m12774d();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12622j != null) {
            this.f12622j.mo12234a();
        }
        dialogInterface.dismiss();
    }
}
