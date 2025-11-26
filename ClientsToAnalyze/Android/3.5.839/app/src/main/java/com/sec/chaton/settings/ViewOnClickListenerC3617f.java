package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.ChatONVUpgradeDialog;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC3617f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f13150a;

    /* renamed from: b */
    final /* synthetic */ AboutServiceFragment f13151b;

    ViewOnClickListenerC3617f(AboutServiceFragment aboutServiceFragment, int i) {
        this.f13151b = aboutServiceFragment;
        this.f13150a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (this.f13151b.getActivity() != null) {
            this.f13151b.f12460v = C4859bx.m18393b();
            this.f13151b.f12461w = C4859bx.m18396c();
            if (this.f13150a == AboutServiceFragment.f12440e) {
                if (!this.f13151b.f12461w) {
                    if (this.f13151b.f12460v) {
                        C4859bx.m18378a(2);
                        return;
                    } else {
                        C4859bx.m18403e(2);
                        return;
                    }
                }
                C4859bx.m18395c(2);
                return;
            }
            if (this.f13150a == 0) {
                if (!this.f13151b.f12460v) {
                    if (this.f13151b.f12461w) {
                        C4859bx.m18395c(this.f13150a);
                        return;
                    } else {
                        C4859bx.m18403e(this.f13150a);
                        return;
                    }
                }
                this.f13151b.f12462x = ProgressDialogC4926s.m18727a(this.f13151b.f12452m, null, this.f13151b.f12452m.getResources().getString(R.string.wait_sending));
                new C2122ca(this.f13151b.f12446g).m9472c();
                return;
            }
            if (this.f13150a == AboutServiceFragment.f12439d) {
                if (!this.f13151b.f12460v || !this.f13151b.f12461w) {
                    if (!this.f13151b.f12460v || this.f13151b.f12461w) {
                        if (!this.f13151b.f12460v && this.f13151b.f12461w) {
                            C4859bx.m18395c(1);
                            return;
                        } else {
                            C4859bx.m18403e(1);
                            return;
                        }
                    }
                    C4859bx.m18378a(1);
                    return;
                }
                Intent intent = new Intent(this.f13151b.f12452m, (Class<?>) ChatONVUpgradeDialog.class);
                intent.putExtra("isCritical", false);
                intent.putExtra("isFromHome", true);
                this.f13151b.startActivity(intent);
            }
        }
    }
}
