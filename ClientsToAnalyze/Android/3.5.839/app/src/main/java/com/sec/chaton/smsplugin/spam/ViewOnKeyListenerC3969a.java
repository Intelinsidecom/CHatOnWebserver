package com.sec.chaton.smsplugin.spam;

import android.view.KeyEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.a */
/* loaded from: classes.dex */
class ViewOnKeyListenerC3969a implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ManageSpamMessages f14400a;

    ViewOnKeyListenerC3969a(ManageSpamMessages manageSpamMessages) {
        this.f14400a = manageSpamMessages;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66 || this.f14400a.f14290h == 0) {
            return false;
        }
        this.f14400a.f14286d.getSelectedView().findViewById(R.id.spam_list_item_checkbox).performClick();
        return true;
    }
}
