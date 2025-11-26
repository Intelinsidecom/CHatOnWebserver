package com.sec.vip.cropimage;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1327bw;
import com.sec.widget.C1619g;

/* compiled from: ImageModify.java */
/* renamed from: com.sec.vip.cropimage.k */
/* loaded from: classes.dex */
class ViewOnClickListenerC1594k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImageModify f5614a;

    ViewOnClickListenerC1594k(ImageModify imageModify) {
        this.f5614a = imageModify;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!C1327bw.m4595a()) {
            if (this.f5614a.f5446F == null) {
                this.f5614a.f5446F = C1619g.m5888a(this.f5614a.getBaseContext(), R.string.sdcard_not_found, 0);
            }
            this.f5614a.f5446F.show();
            return;
        }
        this.f5614a.m5701g();
    }
}
