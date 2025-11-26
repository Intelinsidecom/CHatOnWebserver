package com.sec.chaton.userprofile;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.w */
/* loaded from: classes.dex */
class C1713w implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6227a;

    C1713w(MyPageFragment myPageFragment) {
        this.f6227a = myPageFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        this.f6227a.m5581a(cursor);
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
