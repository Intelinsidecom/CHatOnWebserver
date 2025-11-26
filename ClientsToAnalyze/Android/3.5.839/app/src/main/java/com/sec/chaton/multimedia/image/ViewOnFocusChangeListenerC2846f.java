package com.sec.chaton.multimedia.image;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* compiled from: ImageEffectFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.f */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC2846f implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ ImageEffectFragment f10458a;

    ViewOnFocusChangeListenerC2846f(ImageEffectFragment imageEffectFragment) {
        this.f10458a = imageEffectFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        try {
            if (z) {
                ((ImageView) view.findViewById(R.id.filter_image_view)).setImageResource(R.drawable.gridview_selector_focused);
                ((TextView) view.findViewById(R.id.filter_name)).setTextColor(this.f10458a.f10194l);
            } else {
                ((ImageView) view.findViewById(R.id.filter_image_view)).setImageDrawable(null);
                ((TextView) view.findViewById(R.id.filter_name)).setTextColor(this.f10458a.f10193k);
            }
        } catch (Exception e) {
            C4904y.m18635a(e, ImageEffectFragment.f10183a);
        } catch (OutOfMemoryError e2) {
            C4904y.m18635a(e2, ImageEffectFragment.f10183a);
        }
    }
}
