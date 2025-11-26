package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.text.ClipboardManager;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: LinkActionChooserFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ag */
/* loaded from: classes.dex */
final class C4098ag extends AbstractC4102ak {
    C4098ag(int i) {
        super(i);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.AbstractC4102ak
    /* renamed from: a */
    public void mo16294a(Activity activity, String str, String str2) {
        ((ClipboardManager) GlobalApplication.m18732r().getSystemService("clipboard")).setText(str2);
    }
}
