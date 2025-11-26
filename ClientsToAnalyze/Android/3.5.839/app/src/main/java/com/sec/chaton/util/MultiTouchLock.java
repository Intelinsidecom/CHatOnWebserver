package com.sec.chaton.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class MultiTouchLock extends LinearLayout {

    /* renamed from: a */
    private String f17566a;

    /* renamed from: b */
    private int f17567b;

    public MultiTouchLock(Context context) {
        super(context);
        this.f17566a = MultiTouchLock.class.getSimpleName();
        this.f17567b = -1;
    }

    public MultiTouchLock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17566a = MultiTouchLock.class.getSimpleName();
        this.f17567b = -1;
    }

    @TargetApi(11)
    public MultiTouchLock(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17566a = MultiTouchLock.class.getSimpleName();
        this.f17567b = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        C4904y.m18639b("dispatchTouchEvent()", this.f17566a);
        switch (motionEvent.getAction() & 255) {
            case 0:
                C4904y.m18639b("dispatchTouchEvent(): action ==> ACTION_DOWN", this.f17566a);
                boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                this.f17567b = motionEvent.getPointerId(0);
                return zDispatchTouchEvent;
            case 1:
                C4904y.m18639b("dispatchTouchEvent(): action ==> ACTION_UP", this.f17566a);
                boolean zDispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                this.f17567b = -1;
                return zDispatchTouchEvent2;
            case 2:
                C4904y.m18639b("dispatchTouchEvent(): action ==> ACTION_MOVE", this.f17566a);
                return super.dispatchTouchEvent(motionEvent);
            case 3:
                C4904y.m18639b("dispatchTouchEvent(): action ==> ACTION_CANCEL", this.f17566a);
                boolean zDispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
                this.f17567b = -1;
                return zDispatchTouchEvent3;
            case 4:
            default:
                C4904y.m18639b("dispatchTouchEvent(): action ==> default", this.f17566a);
                return false;
            case 5:
                C4904y.m18639b("dispatchTouchEvent(): action ==> ACTION_POINTER_DOWN", this.f17566a);
                return false;
            case 6:
                C4904y.m18639b("dispatchTouchEvent(): action ==> ACTION_POINTER_UP", this.f17566a);
                int action = (motionEvent.getAction() & 65280) >> 8;
                if (motionEvent.getPointerId(action) != this.f17567b) {
                    return false;
                }
                this.f17567b = motionEvent.getPointerId(action == 0 ? 1 : 0);
                return super.dispatchTouchEvent(motionEvent);
        }
    }
}
