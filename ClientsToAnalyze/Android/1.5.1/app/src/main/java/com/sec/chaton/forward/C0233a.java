package com.sec.chaton.forward;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;

/* renamed from: com.sec.chaton.forward.a */
/* loaded from: classes.dex */
class C0233a implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f1890a;

    C0233a(ChatForwardFragment chatForwardFragment) {
        this.f1890a = chatForwardFragment;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo530a(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            ChatForwardFragment.m2381d(this.f1890a.f1879f, cursor);
        } else if (i == 2) {
            ChatForwardFragment.m2380c(this.f1890a.f1880g, cursor);
        }
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo531a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: b */
    public void mo534b(int i, Object obj, int i2) {
    }
}
