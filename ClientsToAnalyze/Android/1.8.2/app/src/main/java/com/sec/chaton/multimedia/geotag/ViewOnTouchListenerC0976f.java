package com.sec.chaton.multimedia.geotag;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.f */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0976f implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3595a;

    ViewOnTouchListenerC0976f(GeotagActivity geotagActivity) {
        this.f3595a = geotagActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getX() > this.f3595a.f3573k.getMeasuredWidth() - this.f3595a.f3573k.getPaddingRight()) {
            this.f3595a.f3572j.requestFocus();
            this.f3595a.m3846f();
            this.f3595a.m3853a(this.f3595a.f3573k.getText().toString());
        }
        return false;
    }
}
