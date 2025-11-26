package com.sec.chaton;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;

/* renamed from: com.sec.chaton.l */
/* loaded from: classes.dex */
class C0244l implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f1920a;

    C0244l(HomeTabFragment homeTabFragment) {
        this.f1920a = homeTabFragment;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo530a(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            HomeTabFragment.m389d(this.f1920a.f305g, cursor);
        } else if (i == 2) {
            HomeTabFragment.m388c(this.f1920a.f306h, cursor);
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
