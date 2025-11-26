package com.sec.chaton.util;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class MultiTouchLock extends LinearLayout {

    /* renamed from: a */
    private String f11465a;

    /* renamed from: b */
    private int f11466b;

    public MultiTouchLock(Context context) {
        super(context);
        this.f11465a = MultiTouchLock.class.getSimpleName();
        this.f11466b = -1;
    }

    public MultiTouchLock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11465a = MultiTouchLock.class.getSimpleName();
        this.f11466b = -1;
    }

    public MultiTouchLock(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11465a = MultiTouchLock.class.getSimpleName();
        this.f11466b = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        C3250y.m11450b("dispatchTouchEvent()", this.f11465a);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                C3250y.m11450b("dispatchTouchEvent(): action ==> ACTION_DOWN", this.f11465a);
                boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                this.f11466b = motionEvent.getPointerId(0);
                return zDispatchTouchEvent;
            case 1:
                C3250y.m11450b("dispatchTouchEvent(): action ==> ACTION_UP", this.f11465a);
                boolean zDispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                this.f11466b = -1;
                return zDispatchTouchEvent2;
            case 2:
                C3250y.m11450b("dispatchTouchEvent(): action ==> ACTION_MOVE", this.f11465a);
                return super.dispatchTouchEvent(motionEvent);
            case 3:
                C3250y.m11450b("dispatchTouchEvent(): action ==> ACTION_CANCEL", this.f11465a);
                boolean zDispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
                this.f11466b = -1;
                return zDispatchTouchEvent3;
            case 4:
            default:
                C3250y.m11450b("dispatchTouchEvent(): action ==> default", this.f11465a);
                return false;
            case 5:
                C3250y.m11450b("dispatchTouchEvent(): action ==> ACTION_POINTER_DOWN", this.f11465a);
                return false;
            case 6:
                C3250y.m11450b("dispatchTouchEvent(): action ==> ACTION_POINTER_UP", this.f11465a);
                int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                if (motionEvent.getPointerId(action) != this.f11466b) {
                    return false;
                }
                this.f11466b = motionEvent.getPointerId(action == 0 ? 1 : 0);
                return super.dispatchTouchEvent(motionEvent);
        }
    }
}
