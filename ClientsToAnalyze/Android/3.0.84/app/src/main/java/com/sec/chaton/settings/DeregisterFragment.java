package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.settings2.SettingActivity;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.HandlerC3176ar;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* loaded from: classes.dex */
public class DeregisterFragment extends Fragment implements InterfaceC0047c {

    /* renamed from: l */
    private static final String f9115l = SettingActivity.class.getSimpleName();

    /* renamed from: c */
    private TextView f9118c;

    /* renamed from: d */
    private CheckBox f9119d;

    /* renamed from: e */
    private Button f9120e;

    /* renamed from: g */
    private AbstractC1144a<?> f9122g;

    /* renamed from: h */
    private C1156ak f9123h;

    /* renamed from: i */
    private C1303ap f9124i;

    /* renamed from: k */
    private C0045a f9126k;

    /* renamed from: f */
    private ProgressDialog f9121f = null;

    /* renamed from: j */
    private InterfaceC3274d f9125j = null;

    /* renamed from: a */
    HandlerC3176ar f9116a = new HandlerC2501dh(this);

    /* renamed from: b */
    public Handler f9117b = new HandlerC2502di(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9124i = new C1303ap(this.f9117b);
        this.f9122g = C1302ao.m5594a();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_deregister_device, viewGroup, false);
        this.f9118c = (TextView) viewInflate.findViewById(R.id.deregister_textview);
        this.f9119d = (CheckBox) viewInflate.findViewById(R.id.agree_checkbox);
        this.f9120e = (Button) viewInflate.findViewById(R.id.ok_button);
        if (C3214cb.m11256a(getActivity()) && new C0045a().m55d(getActivity())) {
            this.f9118c.setText(getActivity().getResources().getString(R.string.multideivce_delete_account_chatonv));
        }
        this.f9119d.setOnCheckedChangeListener(new C2499df(this));
        this.f9120e.setOnClickListener(new ViewOnClickListenerC2500dg(this));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m9087b() {
        if (this.f9119d.isChecked()) {
            this.f9120e.setEnabled(true);
        } else {
            this.f9120e.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m9089c() {
        if (this.f9121f != null && this.f9121f.isShowing()) {
            this.f9121f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m9091d() {
        m9092e();
        this.f9125j = AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.deregister_device).mo11506b(R.string.toast_dereg_failed).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2503dj(this)).mo11512b();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C1954g.m7916a().m7918a(getActivity(), EnumC1955h.ChatONV) && this.f9126k != null) {
            this.f9126k.m51a(getActivity(), (InterfaceC0047c) null);
            C3250y.m11450b("onDestroy:mChatonV.setListener(null)", f9115l);
        }
        m9089c();
        m9092e();
    }

    /* renamed from: e */
    private void m9092e() {
        if (this.f9125j != null && this.f9125j.isShowing()) {
            this.f9125j.dismiss();
        }
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveRemoveAccount : " + z, f9115l);
        }
        if (z) {
            this.f9122g.mo5481b(this.f9116a);
            this.f9116a.m11090a(30000);
        } else {
            m9089c();
            m9091d();
        }
    }
}
