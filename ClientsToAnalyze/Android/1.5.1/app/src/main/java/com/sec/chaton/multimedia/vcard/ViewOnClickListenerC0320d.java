package com.sec.chaton.multimedia.vcard;

import android.view.View;

/* renamed from: com.sec.chaton.multimedia.vcard.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0320d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ReadVCardActivity f2377a;

    ViewOnClickListenerC0320d(ReadVCardActivity readVCardActivity) {
        this.f2377a = readVCardActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2377a.finish();
    }
}
