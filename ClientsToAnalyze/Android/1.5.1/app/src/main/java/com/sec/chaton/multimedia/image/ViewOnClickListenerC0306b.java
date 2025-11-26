package com.sec.chaton.multimedia.image;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.multimedia.image.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0306b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOriginalImage f2179a;

    ViewOnClickListenerC0306b(ViewOriginalImage viewOriginalImage) {
        this.f2179a = viewOriginalImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("SEND", true);
        intent.putExtra("URI", this.f2179a.f2175a);
        this.f2179a.setResult(-1, intent);
        this.f2179a.finish();
    }
}
