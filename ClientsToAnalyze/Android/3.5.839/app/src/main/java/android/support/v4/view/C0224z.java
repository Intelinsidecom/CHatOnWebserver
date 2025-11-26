package android.support.v4.view;

import android.os.Build;
import android.view.MotionEvent;

/* compiled from: MotionEventCompat.java */
/* renamed from: android.support.v4.view.z */
/* loaded from: classes.dex */
public class C0224z {

    /* renamed from: a */
    static final InterfaceC0142ac f487a;

    static {
        if (Build.VERSION.SDK_INT >= 5) {
            f487a = new C0141ab();
        } else {
            f487a = new C0140aa();
        }
    }

    /* renamed from: a */
    public static int m741a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    /* renamed from: b */
    public static int m743b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    /* renamed from: a */
    public static int m742a(MotionEvent motionEvent, int i) {
        return f487a.mo598a(motionEvent, i);
    }

    /* renamed from: b */
    public static int m744b(MotionEvent motionEvent, int i) {
        return f487a.mo599b(motionEvent, i);
    }

    /* renamed from: c */
    public static float m745c(MotionEvent motionEvent, int i) {
        return f487a.mo600c(motionEvent, i);
    }

    /* renamed from: d */
    public static float m747d(MotionEvent motionEvent, int i) {
        return f487a.mo601d(motionEvent, i);
    }

    /* renamed from: c */
    public static int m746c(MotionEvent motionEvent) {
        return f487a.mo597a(motionEvent);
    }
}
