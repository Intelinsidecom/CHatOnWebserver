package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.q */
/* loaded from: classes.dex */
class C1840q implements SlookWritingBuddy.ImageWritingListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6962a;

    C1840q(ChatFragment chatFragment) {
        this.f6962a = chatFragment;
    }

    @Override // com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener
    public void onImageReceived(Bitmap bitmap) {
        if (this.f6962a.f5548aq) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f6962a.f5624cN);
            abstractC4932aM18733a.mo18734a(R.string.writingbuddy_replace).mo18746b(R.string.writingbuddy_replace_message).mo18756d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC1841r(this, bitmap)).mo18747b(R.string.alert_dialog_cancel, (DialogInterface.OnClickListener) null);
            abstractC4932aM18733a.mo18745a().show();
            return;
        }
        this.f6962a.f5677dP = bitmap;
    }
}
