package com.sec.vip.amschaton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* compiled from: AMSSendDialog.java */
/* renamed from: com.sec.vip.amschaton.ad */
/* loaded from: classes.dex */
public class C3402ad {

    /* renamed from: a */
    private Context f12466a;

    /* renamed from: b */
    private View f12467b;

    /* renamed from: c */
    private InterfaceC3274d f12468c;

    /* renamed from: d */
    private LinearLayout f12469d;

    /* renamed from: e */
    private CheckBox f12470e;

    /* renamed from: f */
    private TextView f12471f;

    /* renamed from: g */
    private boolean f12472g = false;

    /* renamed from: h */
    private InterfaceC3409ak f12473h = null;

    public C3402ad(Context context) {
        this.f12469d = null;
        this.f12470e = null;
        this.f12471f = null;
        this.f12466a = context;
        this.f12467b = LayoutInflater.from(context).inflate(R.layout.layout_ams_send_popup, (ViewGroup) null);
        this.f12469d = (LinearLayout) this.f12467b.findViewById(R.id.layout_send_method_list);
        this.f12470e = (CheckBox) this.f12467b.findViewById(R.id.checkbox_with_text);
        this.f12471f = (TextView) this.f12467b.findViewById(R.id.text_with_text);
        m12165c();
        this.f12470e.setChecked(this.f12472g);
        this.f12470e.setOnClickListener(new ViewOnClickListenerC3403ae(this));
        this.f12470e.setOnCheckedChangeListener(new C3404af(this));
        this.f12471f.setOnClickListener(new ViewOnClickListenerC3405ag(this));
        this.f12471f.setOnTouchListener(new ViewOnTouchListenerC3406ah(this));
    }

    /* renamed from: a */
    public void m12169a() {
        this.f12468c = AbstractC3271a.m11494a(this.f12466a).mo11502a(true).mo11508b(this.f12467b).mo11495a(R.string.ams_title_send).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3407ai(this)).mo11505a();
        this.f12468c.setCanceledOnTouchOutside(false);
    }

    /* renamed from: b */
    public void m12172b() {
        if (this.f12468c == null) {
            m12169a();
        }
        this.f12468c.show();
    }

    /* renamed from: a */
    public void m12170a(InterfaceC3409ak interfaceC3409ak) {
        this.f12473h = interfaceC3409ak;
    }

    /* renamed from: a */
    public boolean m12171a(int i, int i2, boolean z) {
        if (this.f12469d == null) {
            return false;
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f12466a.getSystemService("layout_inflater");
        View viewInflate = layoutInflater.inflate(R.layout.layout_ams_send_popup_item, (ViewGroup) this.f12469d, false);
        ((TextView) viewInflate.findViewById(R.id.text_send_method_item)).setText(i2);
        viewInflate.setId(i);
        viewInflate.setBackgroundResource(R.drawable.listview_selector);
        viewInflate.setOnClickListener(new ViewOnClickListenerC3408aj(this));
        this.f12469d.addView(viewInflate);
        if (z) {
            this.f12469d.addView(layoutInflater.inflate(R.layout.layout_common_divider5, (ViewGroup) this.f12469d, false));
        }
        return true;
    }

    /* renamed from: c */
    private void m12165c() {
        this.f12472g = this.f12466a.getSharedPreferences("AMSPref", 1).getBoolean("AMS_SEND_DIALOG_WITH_MESSAGE", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12166d() {
        this.f12466a.getSharedPreferences("AMSPref", 3).edit().putBoolean("AMS_SEND_DIALOG_WITH_MESSAGE", this.f12472g).commit();
    }
}
