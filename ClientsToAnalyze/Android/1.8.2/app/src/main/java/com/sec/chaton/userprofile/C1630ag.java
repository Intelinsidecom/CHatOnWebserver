package com.sec.chaton.userprofile;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;

/* compiled from: MyPageInteraction.java */
/* renamed from: com.sec.chaton.userprofile.ag */
/* loaded from: classes.dex */
class C1630ag implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ MyPageInteraction f6117a;

    C1630ag(MyPageInteraction myPageInteraction) {
        this.f6117a = myPageInteraction;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        this.f6117a.m5644a(cursor);
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
