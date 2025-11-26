package com.sec.chaton.util;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class MultiTouchLock extends LinearLayout {

    /* renamed from: a */
    private String f6287a;

    /* renamed from: b */
    private int f6288b;

    public MultiTouchLock(Context context) {
        super(context);
        this.f6287a = MultiTouchLock.class.getSimpleName();
        this.f6288b = -1;
    }

    public MultiTouchLock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6287a = MultiTouchLock.class.getSimpleName();
        this.f6288b = -1;
    }

    public MultiTouchLock(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6287a = MultiTouchLock.class.getSimpleName();
        this.f6288b = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        C1786r.m6061b("dispatchTouchEvent()", this.f6287a);
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                C1786r.m6061b("dispatchTouchEvent(): action ==> ACTION_DOWN", this.f6287a);
                boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                this.f6288b = motionEvent.getPointerId(0);
                return zDispatchTouchEvent;
            case 1:
                C1786r.m6061b("dispatchTouchEvent(): action ==> ACTION_UP", this.f6287a);
                boolean zDispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                this.f6288b = -1;
                return zDispatchTouchEvent2;
            case 2:
                C1786r.m6061b("dispatchTouchEvent(): action ==> ACTION_MOVE", this.f6287a);
                return super.dispatchTouchEvent(motionEvent);
            case 3:
                C1786r.m6061b("dispatchTouchEvent(): action ==> ACTION_CANCEL", this.f6287a);
                boolean zDispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
                this.f6288b = -1;
                return zDispatchTouchEvent3;
            case 4:
            default:
                C1786r.m6061b("dispatchTouchEvent(): action ==> default", this.f6287a);
                return false;
            case 5:
                C1786r.m6061b("dispatchTouchEvent(): action ==> ACTION_POINTER_DOWN", this.f6287a);
                return false;
            case 6:
                C1786r.m6061b("dispatchTouchEvent(): action ==> ACTION_POINTER_UP", this.f6287a);
                int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                if (motionEvent.getPointerId(action) != this.f6288b) {
                    return false;
                }
                this.f6288b = motionEvent.getPointerId(action == 0 ? 1 : 0);
                return super.dispatchTouchEvent(motionEvent);
        }
    }
}
