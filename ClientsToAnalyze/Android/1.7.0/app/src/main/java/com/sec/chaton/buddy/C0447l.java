package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.l */
/* loaded from: classes.dex */
class C0447l implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1440a;

    C0447l(BuddyFragment buddyFragment) {
        this.f1440a = buddyFragment;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) {
        if (this.f1440a.getActivity() != null && z) {
            if (i == 2) {
                if (this.f1440a.f1103M != 6) {
                    this.f1440a.getActivity().finish();
                }
            } else if (i == 10) {
                Intent intent = new Intent();
                intent.putExtra("ACTIVITY_PURPOSE_ARG", String.valueOf(obj));
                this.f1440a.getActivity().setResult(-1, intent);
                this.f1440a.getActivity().finish();
            }
        }
    }
}
