package com.sec.widget;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.util.C1786r;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ae */
/* loaded from: classes.dex */
class C2125ae extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f7766a;

    C2125ae(HorizontalListView horizontalListView) {
        this.f7766a = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.f7766a.m7474a(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.f7766a.m7475a(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f7766a.f7755v = true;
        this.f7766a.f7738d += (int) f;
        this.f7766a.requestLayout();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        C1786r.m6064d("onSingleTapConfirmed");
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        C1786r.m6064d("onLongPress");
        Rect rect = new Rect();
        int childCount = this.f7766a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f7766a.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f7766a.f7749o != null) {
                    this.f7766a.f7749o.onItemLongClick(this.f7766a, childAt, this.f7766a.f7741g + 1 + i, this.f7766a.f7736b.getItemId(i + this.f7766a.f7741g + 1));
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
        int childCount = this.f7766a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f7766a.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f7766a.f7747m != null) {
                    this.f7766a.f7747m.onItemSelected(this.f7766a, childAt, this.f7766a.f7741g + 1 + i, this.f7766a.f7736b.getItemId(i + this.f7766a.f7741g + 1));
                    return;
                }
                return;
            }
        }
    }
}
