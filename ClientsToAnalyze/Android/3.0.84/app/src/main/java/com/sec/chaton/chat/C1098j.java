package com.sec.chaton.chat;

import android.graphics.Bitmap;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.j */
/* loaded from: classes.dex */
class C1098j implements SlookWritingBuddy.ImageWritingListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4361a;

    C1098j(ChatFragment chatFragment) {
        this.f4361a = chatFragment;
    }

    @Override // com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener
    public void onImageReceived(Bitmap bitmap) {
        this.f4361a.f3694dn = bitmap;
    }
}
