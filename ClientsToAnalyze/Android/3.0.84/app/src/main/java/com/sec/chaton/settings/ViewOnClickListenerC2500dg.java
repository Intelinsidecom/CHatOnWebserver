package com.sec.chaton.settings;

import android.view.View;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;

/* compiled from: DeregisterFragment.java */
/* renamed from: com.sec.chaton.settings.dg */
/* loaded from: classes.dex */
class ViewOnClickListenerC2500dg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeregisterFragment f9390a;

    ViewOnClickListenerC2500dg(DeregisterFragment deregisterFragment) {
        this.f9390a = deregisterFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9390a.f9121f = ProgressDialogC3265l.m11489a(this.f9390a.getActivity(), null, this.f9390a.getResources().getString(R.string.deregister_device));
        this.f9390a.f9121f.setCancelable(false);
        if (C3214cb.m11256a(this.f9390a.getActivity())) {
            this.f9390a.f9126k = new C0045a();
            if (this.f9390a.f9126k.m55d(this.f9390a.getActivity())) {
                this.f9390a.f9126k.m51a(this.f9390a.getActivity(), this.f9390a);
                C3214cb.m11260b(this.f9390a.getActivity(), this.f9390a.f9126k);
                return;
            } else {
                if (C3250y.f11734b) {
                    C3250y.m11450b("ChatONV was NOT registered", DeregisterFragment.f9115l);
                }
                this.f9390a.f9122g.mo5481b(this.f9390a.f9116a);
                this.f9390a.f9116a.m11090a(30000);
                return;
            }
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("ChatONV was NOT installed", DeregisterFragment.f9115l);
        }
        this.f9390a.f9122g.mo5481b(this.f9390a.f9116a);
        this.f9390a.f9116a.m11090a(30000);
    }
}
