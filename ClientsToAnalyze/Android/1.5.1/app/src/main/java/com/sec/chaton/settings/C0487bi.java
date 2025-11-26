package com.sec.chaton.settings;

import android.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.Preference;
import com.sec.chaton.constant.NetworkConstant;

/* renamed from: com.sec.chaton.settings.bi */
/* loaded from: classes.dex */
class C0487bi implements Preference.OnPreferenceClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0479ba f3178a;

    C0487bi(HandlerC0479ba handlerC0479ba) {
        this.f3178a = handlerC0479ba;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (ActivitySettings.m3146j(this.f3178a.f3170a) == 10) {
            this.f3178a.f3170a.f3005l = 0;
            new AlertDialog.Builder(this.f3178a.f3170a).setMessage(NetworkConstant.m1973a(this.f3178a.f3170a)).setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) null).show();
        }
        return false;
    }
}
