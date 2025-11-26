package com.sec.chaton.chat;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.f */
/* loaded from: classes.dex */
class C1700f implements SlookAirButton.ItemSelectListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6302a;

    C1700f(ChatFragment chatFragment) {
        this.f6302a = chatFragment;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButton.ItemSelectListener
    public void onItemSelected(View view, int i, Object obj) {
        if (obj != null) {
            if (obj.toString().startsWith("[")) {
                this.f6302a.mo8232a(obj.toString());
            } else {
                this.f6302a.mo8233a(obj.toString(), (String) null);
            }
        }
    }
}
