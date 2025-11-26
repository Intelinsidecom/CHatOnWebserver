package com.sec.chaton.smsplugin.p112ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.common.CommonApplication;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.en */
/* loaded from: classes.dex */
class C4213en implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15559a;

    C4213en(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15559a = pluginComposeMessageActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        PluginComposeMessageActivity.m16048c("s.length():" + charSequence.length() + " (MmsConfig.getMaxTextLimit():" + C3847e.m14709o());
        PluginComposeMessageActivity.m16048c("count:" + i2 + " after:" + i3);
        if ((charSequence.length() - i2) + i3 > C3847e.m14709o() - 1 && i3 != 0) {
            Toast.makeText(CommonApplication.m18732r(), R.string.toast_text_max_Length, 0).show();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f15559a.onUserInteraction();
        this.f15559a.f14996ap.m14438a(charSequence);
        this.f15559a.m15988ac();
        this.f15559a.m15964a(charSequence);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
