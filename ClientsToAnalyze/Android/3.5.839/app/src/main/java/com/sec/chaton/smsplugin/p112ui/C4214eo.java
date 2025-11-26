package com.sec.chaton.smsplugin.p112ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3878ac;
import com.sec.common.CommonApplication;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.eo */
/* loaded from: classes.dex */
class C4214eo implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15560a;

    C4214eo(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15560a = pluginComposeMessageActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int length;
        if (C3847e.m14661aL()) {
            length = C3878ac.m14958b(charSequence.toString());
        } else {
            length = charSequence.length();
        }
        if (!this.f15560a.f14950V.hasFocus() || length < C3847e.m14635S()) {
            this.f15560a.f14996ap.m14439a(charSequence, true);
        } else {
            Toast.makeText(CommonApplication.m18732r(), R.string.toast_text_max_Length, 0).show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
