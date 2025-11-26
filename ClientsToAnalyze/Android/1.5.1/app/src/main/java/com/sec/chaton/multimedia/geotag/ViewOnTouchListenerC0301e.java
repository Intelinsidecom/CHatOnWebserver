package com.sec.chaton.multimedia.geotag;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.sec.chaton.multimedia.geotag.e */
/* loaded from: classes.dex */
class ViewOnTouchListenerC0301e implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ Drawable f2170a;

    /* renamed from: b */
    final /* synthetic */ GeotagActivity f2171b;

    ViewOnTouchListenerC0301e(GeotagActivity geotagActivity, Drawable drawable) {
        this.f2171b = geotagActivity;
        this.f2170a = drawable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (motionEvent.getX() > (this.f2171b.f2146g.getMeasuredWidth() - this.f2171b.f2146g.getPaddingRight()) - this.f2170a.getIntrinsicWidth()) {
            this.f2171b.f2145f.requestFocus();
            this.f2171b.m2547e();
            this.f2171b.m2553a(this.f2171b.f2146g.getText().toString());
        }
        return false;
    }
}
