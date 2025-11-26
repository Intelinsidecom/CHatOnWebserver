package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1013al;
import com.sec.chaton.EnumC1014am;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.co */
/* loaded from: classes.dex */
class C1178co implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4405a;

    C1178co(BuddyFragment buddyFragment) {
        this.f4405a = buddyFragment;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        if (this.f4405a.getActivity() != null && z) {
            if (i == 2) {
                this.f4405a.getActivity().finish();
                this.f4405a.m6517f(true);
                C5179v.m19811a(this.f4405a.getActivity(), this.f4405a.getResources().getString(R.string.buddy_new_group_created), 0).show();
            } else if (i == 10) {
                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_PURPOSE_ARG", String.valueOf(obj));
                this.f4405a.getActivity().setResult(-1, intent);
                this.f4405a.getActivity().finish();
            }
            C0991aa.m6037a().m18962d(C1013al.m6086a(EnumC1014am.ADDED));
        }
    }
}
