package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.widget.C3641ai;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cd */
/* loaded from: classes.dex */
class C0573cd implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2535a;

    C0573cd(BuddyFragment buddyFragment) {
        this.f2535a = buddyFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (this.f2535a.getActivity() != null && z) {
            if (i == 2) {
                this.f2535a.getActivity().finish();
                this.f2535a.m3371d(true);
                C3641ai.m13211a(this.f2535a.getActivity(), this.f2535a.getResources().getString(R.string.buddy_new_group_created), 0).show();
            } else if (i == 10) {
                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_PURPOSE_ARG", String.valueOf(obj));
                this.f2535a.getActivity().setResult(-1, intent);
                this.f2535a.getActivity().finish();
            }
        }
    }
}
