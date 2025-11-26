package com.sec.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.PopupMenu;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.t */
/* loaded from: classes.dex */
public class C1632t {

    /* renamed from: d */
    private static final boolean f5752d;

    /* renamed from: a */
    private Context f5753a;

    /* renamed from: b */
    private PopupMenu f5754b;

    /* renamed from: c */
    private View f5755c;

    /* renamed from: e */
    private InterfaceC1614b f5756e;

    /* renamed from: f */
    private boolean f5757f;

    static {
        f5752d = Build.VERSION.SDK_INT >= 14;
    }

    public C1632t(Activity activity) {
        this(activity, new C1609af(activity));
    }

    public C1632t(Fragment fragment) {
        this(fragment.getActivity(), new C1612ai(fragment));
    }

    private C1632t(Context context, InterfaceC1614b interfaceC1614b) {
        this.f5757f = false;
        this.f5753a = context;
        this.f5756e = interfaceC1614b;
    }

    /* renamed from: a */
    public void m5919a(View view) {
        if (f5752d) {
            if (this.f5754b == null || this.f5755c != view) {
                this.f5754b = new PopupMenu(this.f5753a, view);
                this.f5754b.setOnMenuItemClickListener(new C1611ah(this));
                this.f5754b.setOnDismissListener(new C1610ag(this, view));
                if (this.f5756e.mo5882a(this.f5754b.getMenu())) {
                    this.f5755c = view;
                } else {
                    return;
                }
            }
            if (this.f5756e.mo5885b(this.f5754b.getMenu())) {
                this.f5754b.show();
                this.f5757f = true;
                view.setSelected(true);
                return;
            }
            return;
        }
        this.f5756e.mo5881a();
    }

    /* renamed from: a */
    public void m5918a() {
        if (f5752d) {
            if (this.f5754b != null) {
                this.f5754b.dismiss();
                return;
            }
            return;
        }
        this.f5756e.mo5884b();
    }

    /* renamed from: b */
    public boolean m5920b() {
        return this.f5757f;
    }

    /* renamed from: c */
    public static boolean m5917c() {
        return f5752d;
    }
}
