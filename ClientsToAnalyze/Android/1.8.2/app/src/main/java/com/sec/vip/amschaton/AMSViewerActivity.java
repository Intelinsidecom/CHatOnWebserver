package com.sec.vip.amschaton;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class AMSViewerActivity extends AMSActivity {

    /* renamed from: l */
    protected RunnableC1880bm f6688l = null;

    /* renamed from: m */
    protected LinearLayout f6689m = null;

    /* renamed from: n */
    protected int f6690n = 0;

    /* renamed from: o */
    protected boolean f6691o = false;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        if (this.f6688l != null && !C2064n.m7173a().m7191d() && !C1849ai.m6394a().m6409e()) {
            this.f6688l.m6509b(this.f6691o);
            this.f6688l.m6511d();
        }
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1786r.m6063c("[onResume]", getClass().getName());
        m6261a();
        super.onResume();
    }

    /* renamed from: a */
    protected boolean mo6360a(boolean z) {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        if (f6617j) {
            this.f6690n = (getResources().getDimensionPixelSize(R.dimen.ams_ics_container_height) - getResources().getDimensionPixelSize(R.dimen.ams_ics_actionbar_height)) - getResources().getDimensionPixelSize(R.dimen.ams_ics_player_bottom_menu_height);
        } else {
            if (width >= height) {
                width = height;
            }
            this.f6690n = width;
        }
        C1786r.m6063c("[createViewer] mViewerSize = " + this.f6690n, getClass().getSimpleName());
        this.f6688l = new RunnableC1880bm(this);
        if (this.f6688l.m6506a(this.f6690n)) {
            return m6361g();
        }
        this.f6688l = null;
        return false;
    }

    /* renamed from: g */
    protected boolean m6361g() {
        if (this.f6689m != null) {
            this.f6689m.removeAllViews();
            this.f6689m = null;
        }
        this.f6689m = new LinearLayout(this);
        this.f6689m.setLayoutParams(new ViewGroup.LayoutParams(this.f6690n, this.f6690n));
        if (this.f6688l == null) {
            return false;
        }
        this.f6689m.addView(this.f6688l.m6515h());
        return true;
    }
}
