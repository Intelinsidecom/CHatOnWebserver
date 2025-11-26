package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: LinkActionChooserFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ak */
/* loaded from: classes.dex */
abstract class AbstractC4102ak {

    /* renamed from: a */
    private final int f15234a;

    /* renamed from: a */
    abstract void mo16294a(Activity activity, String str, String str2);

    AbstractC4102ak(int i) {
        this.f15234a = i;
    }

    public String toString() {
        return GlobalApplication.m10279a().getResources().getString(this.f15234a);
    }
}
