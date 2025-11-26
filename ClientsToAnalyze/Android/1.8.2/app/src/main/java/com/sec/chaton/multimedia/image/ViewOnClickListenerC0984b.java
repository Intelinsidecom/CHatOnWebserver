package com.sec.chaton.multimedia.image;

import android.content.Intent;
import android.view.View;
import com.sec.vip.amschaton.AMSPlayerActivity;

/* compiled from: ViewOriginalImage.java */
/* renamed from: com.sec.chaton.multimedia.image.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0984b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOriginalImage f3643a;

    ViewOnClickListenerC0984b(ViewOriginalImage viewOriginalImage) {
        this.f3643a = viewOriginalImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3643a.f3606d, (Class<?>) AMSPlayerActivity.class);
        intent.putExtra("AMS_FILE_PATH", this.f3643a.f3605c);
        intent.putExtra("VIEWER_MODE", 1002);
        this.f3643a.startActivity(intent);
    }
}
