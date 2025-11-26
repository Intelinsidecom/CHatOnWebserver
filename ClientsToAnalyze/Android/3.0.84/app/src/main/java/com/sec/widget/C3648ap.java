package com.sec.widget;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: HorizontalListView.java */
/* renamed from: com.sec.widget.ap */
/* loaded from: classes.dex */
class C3648ap extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ HorizontalListView f13525a;

    C3648ap(HorizontalListView horizontalListView) {
        this.f13525a = horizontalListView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return this.f13525a.m13130a(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        C3250y.m11454d("onFling");
        return this.f13525a.m13131a(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f13525a.f13419p = true;
        this.f13525a.f13407d += (int) f;
        this.f13525a.requestLayout();
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        C3250y.m11454d("onSingleTapConfirmed");
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        C3250y.m11454d("onLongPress");
        Rect rect = new Rect();
        int childCount = this.f13525a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f13525a.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f13525a.f13417n != null) {
                    this.f13525a.f13417n.onItemLongClick(this.f13525a, childAt, this.f13525a.f13409f + 1 + i, this.f13525a.f13405b.getItemId(i + this.f13525a.f13409f + 1));
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
        int childCount = this.f13525a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f13525a.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (this.f13525a.f13415l != null) {
                    this.f13525a.f13415l.onItemSelected(this.f13525a, childAt, this.f13525a.f13409f + 1 + i, this.f13525a.f13405b.getItemId(i + this.f13525a.f13409f + 1));
                    return;
                }
                return;
            }
        }
    }
}
