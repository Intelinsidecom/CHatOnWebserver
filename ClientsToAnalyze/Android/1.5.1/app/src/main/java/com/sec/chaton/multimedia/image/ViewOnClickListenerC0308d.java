package com.sec.chaton.multimedia.image;

import android.view.View;

/* renamed from: com.sec.chaton.multimedia.image.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC0308d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOriginalImage f2181a;

    ViewOnClickListenerC0308d(ViewOriginalImage viewOriginalImage) {
        this.f2181a = viewOriginalImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2181a.finish();
    }
}
