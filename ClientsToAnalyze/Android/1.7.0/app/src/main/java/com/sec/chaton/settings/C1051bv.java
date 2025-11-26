package com.sec.chaton.settings;

import android.R;
import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.p029f.C0685b;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: SettingFragment.java */
/* renamed from: com.sec.chaton.settings.bv */
/* loaded from: classes.dex */
class C1051bv implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1061ce f3662a;

    C1051bv(HandlerC1061ce handlerC1061ce) {
        this.f3662a = handlerC1061ce;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (C1057ca.m3940c(this.f3662a.f3706a) == 20) {
            this.f3662a.f3706a.f3689f = 0;
            new AlertDialogBuilderC1625m(this.f3662a.f3706a.getActivity()).setMessage(C0685b.m3053a(this.f3662a.f3706a.getActivity())).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
        }
        return false;
    }
}
