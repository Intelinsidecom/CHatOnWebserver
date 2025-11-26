package android.support.v4.view;

import android.os.Build;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class MotionEventCompat {

    /* renamed from: a */
    static final InterfaceC0024b f144a;

    static {
        if (Build.VERSION.SDK_INT >= 5) {
            f144a = new C0032j();
        } else {
            f144a = new C0027e();
        }
    }

    /* renamed from: a */
    public static int m178a(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    /* renamed from: a */
    public static int m179a(MotionEvent motionEvent, int i) {
        return f144a.mo212a(motionEvent, i);
    }

    /* renamed from: b */
    public static int m180b(MotionEvent motionEvent, int i) {
        return f144a.mo213b(motionEvent, i);
    }

    /* renamed from: c */
    public static float m181c(MotionEvent motionEvent, int i) {
        return f144a.mo214c(motionEvent, i);
    }

    /* renamed from: d */
    public static float m182d(MotionEvent motionEvent, int i) {
        return f144a.mo215d(motionEvent, i);
    }
}
