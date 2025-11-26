package com.sec.chaton.userprofile;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;

/* renamed from: com.sec.chaton.userprofile.l */
/* loaded from: classes.dex */
class C0588l implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    final /* synthetic */ UserProfileFragment f3585a;

    C0588l(UserProfileFragment userProfileFragment) {
        this.f3585a = userProfileFragment;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo530a(int i, Object obj, Cursor cursor) {
        this.f3585a.m3389a(cursor);
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
