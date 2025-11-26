package android.support.v4.view;

import android.hardware.motion.MotionRecognitionManager;
import android.os.Bundle;
import android.support.v4.view.p009a.C0110a;
import android.support.v4.view.p009a.C0137x;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: ViewPager.java */
/* renamed from: android.support.v4.view.ca */
/* loaded from: classes.dex */
class C0194ca extends C0109a {

    /* renamed from: b */
    final /* synthetic */ ViewPager f479b;

    C0194ca(ViewPager viewPager) {
        this.f479b = viewPager;
    }

    @Override // android.support.v4.view.C0109a
    /* renamed from: d */
    public void mo439d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo439d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        C0137x c0137xM592a = C0137x.m592a();
        c0137xM592a.m594a(m698b());
        if (accessibilityEvent.getEventType() == 4096 && this.f479b.f421h != null) {
            c0137xM592a.m593a(this.f479b.f421h.mo612b());
            c0137xM592a.m595b(this.f479b.f422i);
            c0137xM592a.m596c(this.f479b.f422i);
        }
    }

    @Override // android.support.v4.view.C0109a
    /* renamed from: a */
    public void mo433a(View view, C0110a c0110a) {
        super.mo433a(view, c0110a);
        c0110a.m453b(ViewPager.class.getName());
        c0110a.m471i(m698b());
        if (this.f479b.canScrollHorizontally(1)) {
            c0110a.m444a(4096);
        }
        if (this.f479b.canScrollHorizontally(-1)) {
            c0110a.m444a(MotionRecognitionManager.EVENT_FLAT);
        }
    }

    @Override // android.support.v4.view.C0109a
    /* renamed from: a */
    public boolean mo435a(View view, int i, Bundle bundle) {
        if (super.mo435a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (!this.f479b.canScrollHorizontally(1)) {
                    return false;
                }
                this.f479b.setCurrentItem(this.f479b.f422i + 1);
                return true;
            case MotionRecognitionManager.EVENT_FLAT /* 8192 */:
                if (!this.f479b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.f479b.setCurrentItem(this.f479b.f422i - 1);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: b */
    private boolean m698b() {
        return this.f479b.f421h != null && this.f479b.f421h.mo612b() > 1;
    }
}
