package com.sec.chaton;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bs */
/* loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC0507bs implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1646a;

    ViewTreeObserverOnGlobalLayoutListenerC0507bs(TabActivity tabActivity) {
        this.f1646a = tabActivity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        float f = -1.0f;
        if (this.f1646a.f743J != this.f1646a.f798v.getHeight() || this.f1646a.f744K != this.f1646a.f798v.getWidth()) {
            this.f1646a.f743J = this.f1646a.f798v.getHeight();
            this.f1646a.f744K = this.f1646a.f798v.getWidth();
            View viewFindViewById = this.f1646a.findViewById(R.id.splitView);
            if (GlobalApplication.m6457f() || TabActivity.m1252b((Context) this.f1646a)) {
                this.f1646a.f736C = this.f1646a.f798v.getWidth();
            } else {
                this.f1646a.f736C = this.f1646a.m1222O();
            }
            this.f1646a.f735B = this.f1646a.m1223P();
            this.f1646a.f737D = this.f1646a.findViewById(R.id.splitView_indicator);
            this.f1646a.f738E = this.f1646a.findViewById(R.id.splitView_indicator_default);
            this.f1646a.f739F = this.f1646a.findViewById(R.id.parent_fragment);
            this.f1646a.f740G = this.f1646a.findViewById(R.id.child_fragment);
            this.f1646a.f741H = (LinearLayout.LayoutParams) this.f1646a.f739F.getLayoutParams();
            this.f1646a.f742I = (LinearLayout.LayoutParams) this.f1646a.f740G.getLayoutParams();
            int i = this.f1646a.getResources().getConfiguration().orientation;
            if (viewFindViewById != null) {
                this.f1646a.f737D.setVisibility(8);
                View viewFindViewById2 = this.f1646a.findViewById(R.id.child_fragment);
                String str = "";
                if (this.f1646a.f778as == R.id.fragment_buddy || this.f1646a.f778as == R.id.fragment_msg_box) {
                    if (this.f1646a.f778as != R.id.fragment_buddy) {
                        if (this.f1646a.f778as == R.id.fragment_msg_box) {
                            str = "splitview_position_chat";
                        }
                    } else {
                        str = "splitview_position_buddy";
                    }
                    if (!str.equals("")) {
                        float fIntValue = C3159aa.m10962a().m10978a(str, (Integer) (-1)).intValue();
                        if (fIntValue == -1.0f) {
                            f = 0.25f;
                        } else {
                            f = fIntValue / 1000.0f;
                        }
                    }
                    this.f1646a.m1233a(f, Math.round(this.f1646a.f736C * f), this.f1646a.f736C, false);
                    return;
                }
                if (this.f1646a.f778as != R.id.fragment_user_profile) {
                    if (this.f1646a.f778as == R.id.fragment_plus) {
                        f = 1.0f;
                    }
                } else {
                    if (i == 1) {
                        this.f1646a.f755V.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
                        viewFindViewById2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
                        return;
                    }
                    f = 0.623f;
                }
                this.f1646a.f755V.setLayoutParams(new LinearLayout.LayoutParams(Math.round(this.f1646a.f736C * f), -1, 0.0f));
                viewFindViewById2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            }
        }
    }
}
