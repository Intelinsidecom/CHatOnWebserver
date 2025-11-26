package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.settings.DeleteAccountPreference;
import com.sec.chaton.util.C3197bl;

/* compiled from: DeleteAccountPreference.java */
/* renamed from: com.sec.chaton.settings.da */
/* loaded from: classes.dex */
class ViewOnClickListenerC2494da implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeleteAccountPreference f9384a;

    ViewOnClickListenerC2494da(DeleteAccountPreference deleteAccountPreference) {
        this.f9384a = deleteAccountPreference;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            try {
                new DeleteAccountPreference.DeleteAMSAlertDialog().show(DeleteAccountPreference.f9102a, "delete_dialog");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
