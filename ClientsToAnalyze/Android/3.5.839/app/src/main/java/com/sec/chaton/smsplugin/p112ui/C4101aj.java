package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.content.Intent;
import com.sec.chaton.smsplugin.p111h.C3897t;

/* compiled from: LinkActionChooserFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.aj */
/* loaded from: classes.dex */
final class C4101aj extends AbstractC4102ak {
    C4101aj(int i) {
        super(i);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.AbstractC4102ak
    /* renamed from: a */
    public void mo16294a(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) PluginComposeMessageActivity.class);
        intent.putExtra("exit_on_sent", true);
        intent.putExtra("forwarded_message", false);
        intent.putExtra("recipients", str2);
        intent.setClassName(activity, "com.sec.chaton.smsplugin.ui.ForwardMessageActivity");
        C3897t.m15050a(activity, intent);
    }
}
