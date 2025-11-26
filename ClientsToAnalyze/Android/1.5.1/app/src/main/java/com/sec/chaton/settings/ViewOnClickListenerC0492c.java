package com.sec.chaton.settings;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import java.io.IOException;

/* renamed from: com.sec.chaton.settings.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC0492c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3184a;

    ViewOnClickListenerC0492c(ActivitySkinChange activitySkinChange) {
        this.f3184a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bitmap bitmapCreateScaledBitmap = null;
        try {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(ActivitySkinChange.m3157a(this.f3184a.f3043a, Uri.parse(this.f3184a.f3018B + "/" + view.getTag().toString()), 800), 800, 800, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f3184a.f3063u.setImageBitmap(bitmapCreateScaledBitmap);
        this.f3184a.f3063u.setVisibility(0);
        this.f3184a.f3066x = view.getTag().toString();
    }
}
