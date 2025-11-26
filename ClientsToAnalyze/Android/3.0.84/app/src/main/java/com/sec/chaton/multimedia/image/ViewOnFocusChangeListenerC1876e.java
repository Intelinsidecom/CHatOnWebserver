package com.sec.chaton.multimedia.image;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;

/* compiled from: ImageEffectFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.e */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1876e implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ ImageEffectFragment f7137a;

    ViewOnFocusChangeListenerC1876e(ImageEffectFragment imageEffectFragment) {
        this.f7137a = imageEffectFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        try {
            if (z) {
                ((ImageView) view.findViewById(R.id.filter_image_view)).setImageResource(R.drawable.gridview_selector_focused);
                ((TextView) view.findViewById(R.id.filter_name)).setTextColor(this.f7137a.f6896m);
            } else {
                ((ImageView) view.findViewById(R.id.filter_image_view)).setImageDrawable(null);
                ((TextView) view.findViewById(R.id.filter_name)).setTextColor(this.f7137a.f6895l);
            }
        } catch (Exception e) {
            C3250y.m11443a(e, ImageEffectFragment.f6884a);
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, ImageEffectFragment.f6884a);
        }
    }
}
