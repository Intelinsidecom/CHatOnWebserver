package com.sec.widget;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.util.C1341p;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.y */
/* loaded from: classes.dex */
class C1637y extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f5784a;

    C1637y(HorizontalListView horizontalListView) {
        this.f5784a = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.f5784a.m5870a(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        C1341p.m4659c("onFling");
        return this.f5784a.m5871a(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f5784a.f5688p = true;
        this.f5784a.f5676d += (int) f;
        this.f5784a.requestLayout();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        C1341p.m4659c("onSingleTapConfirmed");
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        C1341p.m4659c("onLongPress");
        Rect rect = new Rect();
        int childCount = this.f5784a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f5784a.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f5784a.f5686n != null) {
                    this.f5784a.f5686n.onItemLongClick(this.f5784a, childAt, this.f5784a.f5678f + 1 + i, this.f5784a.f5674b.getItemId(i + this.f5784a.f5678f + 1));
                    return;
                }
                return;
            }
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        super.onShowPress(motionEvent);
        Rect rect = new Rect();
        int childCount = this.f5784a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f5784a.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f5784a.f5684l != null) {
                    this.f5784a.f5684l.onItemSelected(this.f5784a, childAt, this.f5784a.f5678f + 1 + i, this.f5784a.f5674b.getItemId(i + this.f5784a.f5678f + 1));
                    return;
                }
                return;
            }
        }
    }
}
