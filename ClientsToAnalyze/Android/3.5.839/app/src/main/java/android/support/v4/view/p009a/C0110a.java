package android.support.v4.view.p009a;

import android.graphics.Rect;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Build;
import android.view.View;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* renamed from: android.support.v4.view.a.a */
/* loaded from: classes.dex */
public class C0110a {

    /* renamed from: a */
    private static final InterfaceC0116c f449a;

    /* renamed from: b */
    private final Object f450b;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f449a = new C0119f();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            f449a = new C0118e();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            f449a = new C0117d();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f449a = new C0115b();
        } else {
            f449a = new C0120g();
        }
    }

    /* renamed from: a */
    static C0110a m441a(Object obj) {
        if (obj != null) {
            return new C0110a(obj);
        }
        return null;
    }

    public C0110a(Object obj) {
        this.f450b = obj;
    }

    /* renamed from: a */
    public Object m443a() {
        return this.f450b;
    }

    /* renamed from: a */
    public static C0110a m440a(C0110a c0110a) {
        return m441a(f449a.mo495a(c0110a.f450b));
    }

    /* renamed from: a */
    public void m446a(View view) {
        f449a.mo508c(this.f450b, view);
    }

    /* renamed from: b */
    public void m452b(View view) {
        f449a.mo498a(this.f450b, view);
    }

    /* renamed from: b */
    public int m449b() {
        return f449a.mo501b(this.f450b);
    }

    /* renamed from: a */
    public void m444a(int i) {
        f449a.mo496a(this.f450b, i);
    }

    /* renamed from: b */
    public void m450b(int i) {
        f449a.mo530b(this.f450b, i);
    }

    /* renamed from: c */
    public int m455c() {
        return f449a.mo533r(this.f450b);
    }

    /* renamed from: c */
    public void m457c(View view) {
        f449a.mo503b(this.f450b, view);
    }

    /* renamed from: a */
    public void m445a(Rect rect) {
        f449a.mo497a(this.f450b, rect);
    }

    /* renamed from: b */
    public void m451b(Rect rect) {
        f449a.mo507c(this.f450b, rect);
    }

    /* renamed from: c */
    public void m456c(Rect rect) {
        f449a.mo502b(this.f450b, rect);
    }

    /* renamed from: d */
    public void m460d(Rect rect) {
        f449a.mo512d(this.f450b, rect);
    }

    /* renamed from: d */
    public boolean m462d() {
        return f449a.mo519g(this.f450b);
    }

    /* renamed from: e */
    public boolean m464e() {
        return f449a.mo520h(this.f450b);
    }

    /* renamed from: f */
    public boolean m466f() {
        return f449a.mo523k(this.f450b);
    }

    /* renamed from: a */
    public void m448a(boolean z) {
        f449a.mo510c(this.f450b, z);
    }

    /* renamed from: g */
    public boolean m468g() {
        return f449a.mo524l(this.f450b);
    }

    /* renamed from: b */
    public void m454b(boolean z) {
        f449a.mo513d(this.f450b, z);
    }

    /* renamed from: h */
    public boolean m470h() {
        return f449a.mo534s(this.f450b);
    }

    /* renamed from: c */
    public void m459c(boolean z) {
        f449a.mo531h(this.f450b, z);
    }

    /* renamed from: i */
    public boolean m472i() {
        return f449a.mo535t(this.f450b);
    }

    /* renamed from: d */
    public void m461d(boolean z) {
        f449a.mo532i(this.f450b, z);
    }

    /* renamed from: j */
    public boolean m473j() {
        return f449a.mo528p(this.f450b);
    }

    /* renamed from: e */
    public void m463e(boolean z) {
        f449a.mo518g(this.f450b, z);
    }

    /* renamed from: k */
    public boolean m474k() {
        return f449a.mo521i(this.f450b);
    }

    /* renamed from: f */
    public void m465f(boolean z) {
        f449a.mo500a(this.f450b, z);
    }

    /* renamed from: l */
    public boolean m475l() {
        return f449a.mo525m(this.f450b);
    }

    /* renamed from: g */
    public void m467g(boolean z) {
        f449a.mo515e(this.f450b, z);
    }

    /* renamed from: m */
    public boolean m476m() {
        return f449a.mo522j(this.f450b);
    }

    /* renamed from: h */
    public void m469h(boolean z) {
        f449a.mo505b(this.f450b, z);
    }

    /* renamed from: n */
    public boolean m477n() {
        return f449a.mo526n(this.f450b);
    }

    /* renamed from: o */
    public boolean m478o() {
        return f449a.mo527o(this.f450b);
    }

    /* renamed from: i */
    public void m471i(boolean z) {
        f449a.mo517f(this.f450b, z);
    }

    /* renamed from: p */
    public CharSequence m479p() {
        return f449a.mo514e(this.f450b);
    }

    /* renamed from: a */
    public void m447a(CharSequence charSequence) {
        f449a.mo509c(this.f450b, charSequence);
    }

    /* renamed from: q */
    public CharSequence m480q() {
        return f449a.mo506c(this.f450b);
    }

    /* renamed from: b */
    public void m453b(CharSequence charSequence) {
        f449a.mo499a(this.f450b, charSequence);
    }

    /* renamed from: r */
    public CharSequence m481r() {
        return f449a.mo516f(this.f450b);
    }

    /* renamed from: s */
    public CharSequence m482s() {
        return f449a.mo511d(this.f450b);
    }

    /* renamed from: c */
    public void m458c(CharSequence charSequence) {
        f449a.mo504b(this.f450b, charSequence);
    }

    /* renamed from: t */
    public void m483t() {
        f449a.mo529q(this.f450b);
    }

    /* renamed from: u */
    public String m484u() {
        return f449a.mo536u(this.f450b);
    }

    public int hashCode() {
        if (this.f450b == null) {
            return 0;
        }
        return this.f450b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0110a c0110a = (C0110a) obj;
            return this.f450b == null ? c0110a.f450b == null : this.f450b.equals(c0110a.f450b);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m445a(rect);
        sb.append("; boundsInParent: " + rect);
        m456c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(m479p());
        sb.append("; className: ").append(m480q());
        sb.append("; text: ").append(m481r());
        sb.append("; contentDescription: ").append(m482s());
        sb.append("; viewId: ").append(m484u());
        sb.append("; checkable: ").append(m462d());
        sb.append("; checked: ").append(m464e());
        sb.append("; focusable: ").append(m466f());
        sb.append("; focused: ").append(m468g());
        sb.append("; selected: ").append(m473j());
        sb.append("; clickable: ").append(m474k());
        sb.append("; longClickable: ").append(m475l());
        sb.append("; enabled: ").append(m476m());
        sb.append("; password: ").append(m477n());
        sb.append("; scrollable: " + m478o());
        sb.append("; [");
        int iM449b = m449b();
        while (iM449b != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iM449b);
            iM449b &= iNumberOfTrailingZeros ^ (-1);
            sb.append(m442c(iNumberOfTrailingZeros));
            if (iM449b != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: c */
    private static String m442c(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case MotionRecognitionManager.EVENT_VOLUME_DOWN /* 512 */:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case MotionRecognitionManager.EVENT_TILT_TO_UNLOCK /* 2048 */:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case MotionRecognitionManager.EVENT_FLAT /* 8192 */:
                return "ACTION_SCROLL_BACKWARD";
            case MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND /* 16384 */:
                return "ACTION_COPY";
            case MotionRecognitionManager.EVENT_SMART_ALERT_SETTING /* 32768 */:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER /* 131072 */:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
