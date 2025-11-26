package com.facebook;

import android.content.ActivityNotFoundException;
import android.content.Intent;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.n */
/* loaded from: classes.dex */
abstract class AbstractC0169n extends AbstractC0164i {

    /* renamed from: b */
    final /* synthetic */ C0131c f385b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractC0169n(C0131c c0131c) {
        super(c0131c);
        this.f385b = c0131c;
    }

    /* renamed from: a */
    protected boolean m492a(Intent intent, int i) {
        if (intent == null) {
            return false;
        }
        try {
            this.f385b.m402f().mo346a(intent, i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }
}
