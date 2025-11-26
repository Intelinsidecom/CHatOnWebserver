package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC3683u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3682t f13288a;

    ViewOnClickListenerC3683u(C3682t c3682t) {
        this.f13288a = c3682t;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC4932a.m18733a(this.f13288a.f13282a.f12487n).mo18740a(this.f13288a.f13282a.getResources().getString(R.string.settings_account_sns_unlink)).mo18749b(this.f13288a.f13282a.getResources().getString(R.string.settings_account_sns_unlink_popup, this.f13288a.f13282a.m13334a(C4368e.f15818d) ? this.f13288a.f13282a.f12494u.mo16647b() : this.f13288a.f13282a.f12496w.mo16647b())).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3685w(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3684v(this)).mo18752b();
    }
}
