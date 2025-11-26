package com.sec.chaton.multimedia.image;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.sec.chaton.util.C4904y;

/* compiled from: GestureDetectorListener.java */
/* renamed from: com.sec.chaton.multimedia.image.b */
/* loaded from: classes.dex */
public class C2842b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    ViewOnTouchListenerC2837av f10437a;

    public C2842b(ViewOnTouchListenerC2837av viewOnTouchListenerC2837av) {
        this.f10437a = viewOnTouchListenerC2837av;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (C4904y.f17872b) {
                    C4904y.m18639b("ACTION_DOUBLE_TAP", getClass().getSimpleName());
                }
                this.f10437a.m11929a(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f10437a.m11933c();
        return true;
    }
}
