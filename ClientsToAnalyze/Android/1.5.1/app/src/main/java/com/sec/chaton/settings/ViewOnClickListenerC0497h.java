package com.sec.chaton.settings;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import java.io.IOException;

/* renamed from: com.sec.chaton.settings.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC0497h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivitySkinChange f3189a;

    ViewOnClickListenerC0497h(ActivitySkinChange activitySkinChange) {
        this.f3189a = activitySkinChange;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.f3189a.f3063u.setImageBitmap(Bitmap.createScaledBitmap(ActivitySkinChange.m3157a(this.f3189a.f3043a, Uri.parse(this.f3189a.f3018B + "/skin_myskin.png_"), 800), 800, 800, true));
            this.f3189a.f3066x = "skin_myskin.png_";
            this.f3189a.f3063u.setVisibility(0);
            this.f3189a.f3046d.setSelected(false);
            this.f3189a.f3047e.setSelected(true);
            this.f3189a.f3048f.setSelected(false);
            this.f3189a.f3049g.setSelected(false);
            this.f3189a.f3050h.setSelected(false);
            this.f3189a.f3051i.setSelected(false);
            this.f3189a.f3052j.setSelected(false);
            this.f3189a.f3053k.setSelected(false);
            this.f3189a.f3054l.setSelected(false);
            this.f3189a.f3055m.setSelected(false);
            this.f3189a.f3056n.setSelected(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
