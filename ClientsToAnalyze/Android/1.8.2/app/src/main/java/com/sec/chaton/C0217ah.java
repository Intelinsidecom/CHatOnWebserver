package com.sec.chaton;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;

/* compiled from: HomeTabFragment.java */
/* renamed from: com.sec.chaton.ah */
/* loaded from: classes.dex */
class C0217ah implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f752a;

    C0217ah(HomeTabFragment homeTabFragment) {
        this.f752a = homeTabFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            HomeTabFragment.m618b(this.f752a.f243g, cursor);
        } else if (i == 2) {
            HomeTabFragment.m615a(this.f752a.f244h, cursor);
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
