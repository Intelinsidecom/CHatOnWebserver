package com.samsung.spen.lib.input;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.spen.lib.input.core.SPenDetachmentReceiver;
import com.samsung.spensdk.applistener.SPenDetachmentListener;
import com.samsung.spensdk.applistener.SPenHoverListener;
import com.samsung.spensdk.applistener.SPenTouchListener;

/* loaded from: classes.dex */
public class SPenEventLibrary {

    /* renamed from: a */
    SPenDetachmentReceiver f2035a = null;

    public void setSPenTouchListener(View view, final SPenTouchListener sPenTouchListener) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.spen.lib.input.SPenEventLibrary.1

            /* renamed from: a */
            public boolean f2036a = false;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean zOnTouchPenEraser = false;
                if (sPenTouchListener != null) {
                    SPenEvent event = SPenLibrary.getEvent(motionEvent);
                    if (event.isFinger()) {
                        zOnTouchPenEraser = sPenTouchListener.onTouchFinger(view2, motionEvent);
                    } else if (event.isPen()) {
                        zOnTouchPenEraser = sPenTouchListener.onTouchPen(view2, motionEvent);
                    } else if (event.isEraserPen()) {
                        zOnTouchPenEraser = sPenTouchListener.onTouchPenEraser(view2, motionEvent);
                    }
                    boolean zIsSideButtonPressed = event.isSideButtonPressed();
                    if (!this.f2036a && zIsSideButtonPressed) {
                        sPenTouchListener.onTouchButtonDown(view2, motionEvent);
                    } else if (this.f2036a && !zIsSideButtonPressed) {
                        sPenTouchListener.onTouchButtonUp(view2, motionEvent);
                    }
                    this.f2036a = zIsSideButtonPressed;
                }
                return zOnTouchPenEraser;
            }
        });
    }

    public static boolean isHoverListenerSupport() {
        return Build.VERSION.RELEASE.startsWith("4.");
    }

    public static boolean isHoverIconSupport(Context context) {
        if (isHoverListenerSupport() && context != null) {
            return context.getPackageManager().hasSystemFeature("com.sec.feature.hovering_ui");
        }
        return false;
    }

    public void setSPenHoverListener(View view, SPenHoverListener sPenHoverListener) {
        if (!isHoverListenerSupport()) {
            Log.e("SPenEventLibrary", "S Pen Hover Listener cannot be supported under android ICS");
        } else {
            m1990a(view, sPenHoverListener);
        }
    }

    /* renamed from: a */
    private void m1990a(View view, final SPenHoverListener sPenHoverListener) {
        if (!isHoverListenerSupport()) {
            Log.e("SPenEventLibrary", "S Pen Hover Listener cannot be supported under android ICS");
        } else {
            view.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.spen.lib.input.SPenEventLibrary.2

                /* renamed from: a */
                public int f2039a = 0;

                @Override // android.view.View.OnHoverListener
                public boolean onHover(View view2, MotionEvent motionEvent) {
                    if (sPenHoverListener != null) {
                        boolean zOnHover = sPenHoverListener.onHover(view2, motionEvent);
                        int buttonState = motionEvent.getButtonState();
                        if (this.f2039a == 0 && buttonState == 2) {
                            sPenHoverListener.onHoverButtonDown(view2, motionEvent);
                        } else if (this.f2039a == 2 && buttonState == 0) {
                            sPenHoverListener.onHoverButtonUp(view2, motionEvent);
                        }
                        this.f2039a = buttonState;
                        return zOnHover;
                    }
                    return view2.onHoverEvent(motionEvent);
                }
            });
        }
    }

    public boolean registerSPenDetachmentListener(Context context, SPenDetachmentListener sPenDetachmentListener) {
        if (context == null || sPenDetachmentListener == null) {
            return false;
        }
        if (this.f2035a == null) {
            this.f2035a = new SPenDetachmentReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.samsung.pen.INSERT");
        context.registerReceiver(this.f2035a, intentFilter);
        this.f2035a.m1991a(sPenDetachmentListener);
        return true;
    }

    public boolean unregisterSPenDetachmentListener(Context context) {
        if (context == null) {
            return false;
        }
        if (this.f2035a != null) {
            context.unregisterReceiver(this.f2035a);
        }
        this.f2035a = null;
        return true;
    }
}
