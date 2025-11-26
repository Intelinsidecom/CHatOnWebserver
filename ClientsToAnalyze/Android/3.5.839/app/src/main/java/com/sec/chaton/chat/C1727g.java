package com.sec.chaton.chat;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.p057e.EnumC2214ab;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.g */
/* loaded from: classes.dex */
class C1727g implements SlookAirButton.ItemSelectListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6378a;

    C1727g(ChatFragment chatFragment) {
        this.f6378a = chatFragment;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButton.ItemSelectListener
    public void onItemSelected(View view, int i, Object obj) {
        if (obj != null) {
            this.f6378a.m7934a(new File(obj.toString()), EnumC2214ab.IMAGE, (String) null, (String) null, false);
        }
    }
}
