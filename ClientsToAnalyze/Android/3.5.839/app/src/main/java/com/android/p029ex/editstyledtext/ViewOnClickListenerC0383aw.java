package com.android.p029ex.editstyledtext;

import android.util.Log;
import android.view.View;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.aw */
/* loaded from: classes.dex */
class ViewOnClickListenerC0383aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0376ap f940a;

    ViewOnClickListenerC0383aw(C0376ap c0376ap) {
        this.f940a = c0376ap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f940a.f933o.setBackgroundColor(view.getDrawingCacheBackgroundColor());
        if (this.f940a.f920b != null) {
            this.f940a.f920b.setView(null);
            this.f940a.f920b.dismiss();
            this.f940a.f920b = null;
            return;
        }
        Log.e("EditStyledText", "--- buildAndShowColorDialogue: can't find alertDialog");
    }
}
