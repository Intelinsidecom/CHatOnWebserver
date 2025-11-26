package com.sec.chaton.forward;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;

/* compiled from: ChatForwardFragment.java */
/* renamed from: com.sec.chaton.forward.a */
/* loaded from: classes.dex */
class C0748a implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f2764a;

    C0748a(ChatForwardFragment chatForwardFragment) {
        this.f2764a = chatForwardFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            ChatForwardFragment.m3249d(this.f2764a.f2751f, cursor);
        } else if (i == 2) {
            ChatForwardFragment.m3248c(this.f2764a.f2752g, cursor);
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
