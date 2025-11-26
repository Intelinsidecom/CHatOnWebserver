package com.sec.widget;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ac */
/* loaded from: classes.dex */
class C5140ac extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f18832a;

    C5140ac(HorizontalListView horizontalListView) {
        this.f18832a = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.f18832a.m19663a(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        C4904y.m18644d("onFling");
        return this.f18832a.m19664a(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f18832a.f18786p = true;
        this.f18832a.f18774d += (int) f;
        this.f18832a.requestLayout();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        C4904y.m18644d("onSingleTapConfirmed");
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        C4904y.m18644d("onLongPress");
        Rect rect = new Rect();
        int childCount = this.f18832a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f18832a.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f18832a.f18784n != null) {
                    this.f18832a.f18784n.onItemLongClick(this.f18832a, childAt, this.f18832a.f18776f + 1 + i, this.f18832a.f18772b.getItemId(i + this.f18832a.f18776f + 1));
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
        int childCount = this.f18832a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f18832a.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f18832a.f18782l != null) {
                    this.f18832a.f18782l.onItemSelected(this.f18832a, childAt, this.f18832a.f18776f + 1 + i, this.f18832a.f18772b.getItemId(i + this.f18832a.f18776f + 1));
                    return;
                }
                return;
            }
        }
    }
}
