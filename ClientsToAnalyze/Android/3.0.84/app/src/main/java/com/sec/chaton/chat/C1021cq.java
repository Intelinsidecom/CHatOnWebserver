package com.sec.chaton.chat;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cq */
/* loaded from: classes.dex */
class C1021cq implements SlookAirButton.ItemSelectListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4104a;

    C1021cq(ChatFragment chatFragment) {
        this.f4104a = chatFragment;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButton.ItemSelectListener
    public void onItemSelected(View view, int i, Object obj) {
        if (obj != null) {
            if (obj.toString().startsWith("[")) {
                this.f4104a.mo4977a(obj.toString());
            } else {
                this.f4104a.mo4986b(obj.toString());
            }
        }
    }
}
