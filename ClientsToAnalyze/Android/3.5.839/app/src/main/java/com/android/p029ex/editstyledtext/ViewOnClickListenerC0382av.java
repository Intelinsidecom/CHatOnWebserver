package com.android.p029ex.editstyledtext;

import android.util.Log;
import android.view.View;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC0382av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0376ap f939a;

    ViewOnClickListenerC0382av(C0376ap c0376ap) {
        this.f939a = c0376ap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f939a.f933o.setItemColor(view.getDrawingCacheBackgroundColor());
        if (this.f939a.f920b != null) {
            this.f939a.f920b.setView(null);
            this.f939a.f920b.dismiss();
            this.f939a.f920b = null;
            return;
        }
        Log.e("EditStyledText", "--- buildAndShowColorDialogue: can't find alertDialog");
    }
}
