package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.content.Intent;
import android.hardware.motion.MotionRecognitionManager;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p111h.C3897t;

/* compiled from: LinkActionChooserFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ai */
/* loaded from: classes.dex */
final class C4100ai extends AbstractC4102ak {
    C4100ai(int i) {
        super(i);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.AbstractC4102ak
    /* renamed from: a */
    public void mo16294a(Activity activity, String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", C3782a.m14204a(str2, true).m14268j());
        intent.setFlags(MotionRecognitionManager.EVENT_SMART_SCROLL);
        C3897t.m15050a(activity, intent);
    }
}
