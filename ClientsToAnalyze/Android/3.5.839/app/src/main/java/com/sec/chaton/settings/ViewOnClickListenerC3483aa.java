package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC3483aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3682t f12971a;

    ViewOnClickListenerC3483aa(C3682t c3682t) {
        this.f12971a = c3682t;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC4932a.m18733a(this.f12971a.f13282a.f12487n).mo18740a(this.f12971a.f13282a.getResources().getString(R.string.settings_account_sns_unlink)).mo18749b(this.f12971a.f13282a.getResources().getString(R.string.settings_account_sns_unlink_popup, this.f12971a.f13282a.m13334a(C4368e.f15815a) ? this.f12971a.f13282a.f12494u.mo16647b() : this.f12971a.f13282a.f12495v.mo16647b())).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3485ac(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3484ab(this)).mo18752b();
    }
}
