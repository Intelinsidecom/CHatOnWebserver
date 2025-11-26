package com.sec.chaton.settings;

import android.widget.ListAdapter;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.util.C4809aa;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.o */
/* loaded from: classes.dex */
class RunnableC3677o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3664l f13277a;

    RunnableC3677o(C3664l c3664l) {
        this.f13277a = c3664l;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f13277a.f13240a.f12473H.isFinishing()) {
            this.f13277a.f13240a.m13348g();
            if (this.f13277a.f13240a.f12486m != 3) {
                if (this.f13277a.f13240a.f12486m != 4) {
                    if (this.f13277a.f13240a.f12486m == 5) {
                        C4809aa.m18108a("register_vk_sns_type", C4368e.f15820f);
                    }
                } else {
                    C4809aa.m18108a("register_od_sns_type", C4368e.f15818d);
                }
            } else {
                C4809aa.m18108a("register_fb_sns_type", C4368e.f15815a);
            }
            this.f13277a.f13240a.m13335b();
            if (this.f13277a.f13240a.f12485k != null) {
                this.f13277a.f13240a.f12485k.notifyDataSetChanged();
                if (this.f13277a.f13240a.f12484j != null) {
                    this.f13277a.f13240a.f12484j.setAdapter((ListAdapter) this.f13277a.f13240a.f12485k);
                }
            }
        }
    }
}
