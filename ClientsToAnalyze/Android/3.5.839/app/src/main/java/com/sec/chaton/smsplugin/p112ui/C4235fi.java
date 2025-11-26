package com.sec.chaton.smsplugin.p112ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.fi */
/* loaded from: classes.dex */
class C4235fi implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15589a;

    C4235fi(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15589a = pluginComposeMessageActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 0) {
            this.f15589a.f15054x = true;
            this.f15589a.f14981aa.setImageResource(R.drawable.v_bottom_btn_icon_add);
        } else {
            this.f15589a.f15054x = false;
            this.f15589a.f14981aa.setImageResource(R.drawable.input_ic_add);
        }
        this.f15589a.onUserInteraction();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f15589a.m15878E()) {
            this.f15589a.f14996ap.m14443a(this.f15589a.f14954Z.m16172c(), true);
            this.f15589a.m16105u();
            int length = editable.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                char cCharAt = editable.charAt(length);
                if (cCharAt == ' ') {
                    length--;
                } else if (cCharAt == ',') {
                }
            }
            this.f15589a.m15988ac();
            return;
        }
        C3890m.m14997c("Mms/compose", "RecipientsWatcher: afterTextChanged called with invisible mRecipientsEditor, error:" + new IllegalStateException("afterTextChanged called with invisible mRecipientsEditor"));
    }
}
