package com.sec.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.PopupMenu;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.f */
/* loaded from: classes.dex */
public class C2134f {

    /* renamed from: a */
    private Context f7779a;

    /* renamed from: b */
    private PopupMenu f7780b;

    /* renamed from: c */
    private View f7781c;

    /* renamed from: d */
    private InterfaceC2138j f7782d;

    public C2134f(Activity activity) {
        this(activity, new C2135g(activity));
    }

    private C2134f(Context context, InterfaceC2138j interfaceC2138j) {
        this.f7779a = context;
        this.f7782d = interfaceC2138j;
    }

    /* renamed from: a */
    public void m7488a(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.f7780b == null || this.f7781c != view) {
                this.f7780b = new PopupMenu(this.f7779a, view);
                this.f7780b.setOnMenuItemClickListener(new C2136h(this));
                this.f7780b.setOnDismissListener(new C2137i(this, view));
                if (this.f7782d.mo7490a(this.f7780b.getMenu())) {
                    this.f7781c = view;
                } else {
                    return;
                }
            }
            if (this.f7782d.mo7492b(this.f7780b.getMenu())) {
                this.f7780b.show();
                view.setSelected(true);
                return;
            }
            return;
        }
        this.f7782d.mo7489a();
    }
}
