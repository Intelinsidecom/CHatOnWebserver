package com.sec.vip.amschaton;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class AMSViewerActivity extends AMSActivity {

    /* renamed from: l */
    protected RunnableC3442bq f12351l = null;

    /* renamed from: m */
    protected LinearLayout f12352m = null;

    /* renamed from: n */
    protected int f12353n = 0;

    /* renamed from: o */
    protected boolean f12354o = false;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C3250y.m11453c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() throws IllegalStateException {
        C3250y.m11453c("[onDestroy]", getClass().getName());
        if (this.f12351l != null && !C3584q.m12778a().m12812f() && !C3410al.m12173a().m12207j()) {
            this.f12351l.m12331b(this.f12354o);
            this.f12351l.m12333d();
        }
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        C3250y.m11453c("[onResume]", getClass().getName());
        m11972a();
        super.onResume();
    }
}
