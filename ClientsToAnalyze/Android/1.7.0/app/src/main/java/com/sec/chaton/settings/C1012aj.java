package com.sec.chaton.settings;

import android.R;
import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.p029f.C0685b;
import com.sec.widget.AlertDialogBuilderC1625m;

/* compiled from: ActivityNoti.java */
/* renamed from: com.sec.chaton.settings.aj */
/* loaded from: classes.dex */
class C1012aj implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1018ap f3615a;

    C1012aj(HandlerC1018ap handlerC1018ap) {
        this.f3615a = handlerC1018ap;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (ActivityNoti.m3794a(this.f3615a.f3619a) == 20) {
            this.f3615a.f3619a.f3444f = 0;
            new AlertDialogBuilderC1625m(this.f3615a.f3619a).setMessage(C0685b.m3053a(this.f3615a.f3619a)).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
        }
        return false;
    }
}
