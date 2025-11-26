package com.sec.chaton.settings;

import android.widget.ListAdapter;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.InterfaceC4377ac;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.r */
/* loaded from: classes.dex */
class C3680r implements InterfaceC4377ac {

    /* renamed from: a */
    final /* synthetic */ AccountFragment f13280a;

    C3680r(AccountFragment accountFragment) {
        this.f13280a = accountFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: a */
    public void mo13845a() {
        C4904y.m18639b("onComplete() \t- Logout", AccountFragment.f12465l);
        this.f13280a.m13348g();
        if (this.f13280a.f12476b.intValue() == 201) {
            C4368e.m16564a(this.f13280a.f12487n.getApplicationContext()).m16565a(C4368e.f15815a, false);
            C4809aa.m18108a("register_fb_sns_type", "");
            if (this.f13280a.m13334a(C4368e.f15815a)) {
                C4809aa.m18108a("register_sns_type", "");
            }
        } else if (this.f13280a.f12476b.intValue() == 203) {
            C4368e.m16564a(this.f13280a.f12487n.getApplicationContext()).m16565a(C4368e.f15818d, false);
            C4809aa.m18108a("register_od_sns_type", "");
            if (this.f13280a.m13334a(C4368e.f15818d)) {
                C4809aa.m18108a("register_sns_type", "");
            }
        } else if (this.f13280a.f12476b.intValue() == 202) {
            C4368e.m16564a(this.f13280a.f12487n.getApplicationContext()).m16565a(C4368e.f15820f, false);
            C4809aa.m18108a("register_vk_sns_type", "");
            if (this.f13280a.m13334a(C4368e.f15820f)) {
                C4809aa.m18108a("register_sns_type", "");
            }
        }
        this.f13280a.m13335b();
        if (this.f13280a.f12485k != null) {
            this.f13280a.f12485k.notifyDataSetChanged();
            if (this.f13280a.f12484j != null) {
                this.f13280a.f12484j.setAdapter((ListAdapter) this.f13280a.f12485k);
            }
        }
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: b */
    public void mo13846b() {
        C4904y.m18639b("onCancelled() \t- Logout", AccountFragment.f12465l);
        this.f13280a.m13348g();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4377ac
    /* renamed from: c */
    public void mo13847c() {
        C4904y.m18634a("onError() \t- Logout", AccountFragment.f12465l);
        this.f13280a.m13348g();
    }
}
