package com.sec.chaton.chat;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.p027e.EnumC1455w;
import java.io.File;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cr */
/* loaded from: classes.dex */
class C1022cr implements SlookAirButton.ItemSelectListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4105a;

    C1022cr(ChatFragment chatFragment) {
        this.f4105a = chatFragment;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButton.ItemSelectListener
    public void onItemSelected(View view, int i, Object obj) {
        if (obj != null) {
            this.f4105a.m4765a(new File(obj.toString()), EnumC1455w.IMAGE, (String) null, (String) null, false);
        }
    }
}
