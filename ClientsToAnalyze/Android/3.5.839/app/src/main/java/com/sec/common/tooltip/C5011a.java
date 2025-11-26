package com.sec.common.tooltip;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.sec.common.C4972c;
import com.sec.common.C4975d;

/* compiled from: ToolTip.java */
/* renamed from: com.sec.common.tooltip.a */
/* loaded from: classes.dex */
public class C5011a {

    /* renamed from: a */
    ToolTipView f18287a;

    /* renamed from: b */
    View f18288b;

    /* renamed from: c */
    int f18289c;

    /* renamed from: d */
    View f18290d;

    /* renamed from: e */
    int f18291e;

    /* renamed from: f */
    InterfaceC5014d f18292f;

    private C5011a(C5013c c5013c) {
        this.f18288b = c5013c.f18293a;
        this.f18289c = c5013c.f18294b;
        this.f18290d = c5013c.f18295c;
        this.f18291e = c5013c.f18296d;
        this.f18292f = c5013c.f18298f;
    }

    /* renamed from: b */
    private ToolTipLayout m19040b(Activity activity) {
        if (Build.VERSION.SDK_INT > 11) {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ToolTipLayout toolTipLayout = (ToolTipLayout) viewGroup.findViewById(C4972c.toolTipLayout);
            if (toolTipLayout != null) {
                return toolTipLayout;
            }
            activity.getLayoutInflater().inflate(C4975d.layout_tooltip_container, viewGroup, true);
            return (ToolTipLayout) viewGroup.findViewById(C4972c.toolTipLayout);
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public void m19042a(Activity activity) {
        if (Build.VERSION.SDK_INT > 11) {
            ToolTipLayout toolTipLayoutM19040b = m19040b(activity);
            m19041a();
            this.f18287a = (ToolTipView) activity.getLayoutInflater().inflate(C4975d.layout_tooltip_view, (ViewGroup) toolTipLayoutM19040b, false);
            this.f18287a.m19038a(this);
            this.f18287a.setTag(this);
            toolTipLayoutM19040b.addView(this.f18287a, -2, -2);
        }
    }

    /* renamed from: a */
    public void m19041a() {
        if (Build.VERSION.SDK_INT > 11 && this.f18287a != null) {
            this.f18287a.setTag(null);
            this.f18287a.m19039b();
            this.f18287a = null;
        }
    }
}
