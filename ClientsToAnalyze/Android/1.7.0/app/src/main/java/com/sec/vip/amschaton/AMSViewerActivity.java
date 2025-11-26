package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class AMSViewerActivity extends AMSActivity {

    /* renamed from: a */
    protected RunnableC1550o f4701a = null;

    /* renamed from: b */
    protected LinearLayout f4702b = null;

    /* renamed from: c */
    protected int f4703c = 0;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        if (this.f4701a != null && !C1364aa.m4865a().m4883d() && !C1561z.m5654a().m5669e()) {
            this.f4701a.m5638d();
            this.f4701a.m5639e();
        }
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C1341p.m4660c("[onResume]", getClass().getName());
        m4739b();
        super.onResume();
    }

    /* renamed from: a */
    protected boolean mo4836a(boolean z) throws Resources.NotFoundException {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        if (f4630l) {
            this.f4703c = (getResources().getDimensionPixelSize(R.dimen.ams_ics_container_height) - getResources().getDimensionPixelSize(R.dimen.ams_ics_actionbar_height)) - getResources().getDimensionPixelSize(R.dimen.ams_ics_player_bottom_menu_height);
        } else {
            if (width >= height) {
                width = height;
            }
            this.f4703c = width;
        }
        C1341p.m4660c("[createViewer] mViewerSize = " + this.f4703c, getClass().getSimpleName());
        this.f4701a = new RunnableC1550o(this);
        if (!this.f4701a.m5634a(this.f4703c)) {
            this.f4701a = null;
            return false;
        }
        m4835a();
        return true;
    }

    /* renamed from: a */
    protected void m4835a() {
        if (this.f4702b != null) {
            this.f4702b.removeAllViews();
            this.f4702b = null;
        }
        this.f4702b = new LinearLayout(this);
        this.f4702b.setLayoutParams(new ViewGroup.LayoutParams(this.f4703c, this.f4703c));
        this.f4702b.addView(this.f4701a.m5643i());
    }
}
