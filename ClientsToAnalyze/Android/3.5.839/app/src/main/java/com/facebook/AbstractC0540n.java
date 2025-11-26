package com.facebook;

import android.content.ActivityNotFoundException;
import android.content.Intent;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.n */
/* loaded from: classes.dex */
abstract class AbstractC0540n extends AbstractC0535i {

    /* renamed from: b */
    final /* synthetic */ C0502c f1355b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractC0540n(C0502c c0502c) {
        super(c0502c);
        this.f1355b = c0502c;
    }

    /* renamed from: a */
    protected boolean m1935a(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.f1355b.m1845f().mo1789a(intent, i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }
}
