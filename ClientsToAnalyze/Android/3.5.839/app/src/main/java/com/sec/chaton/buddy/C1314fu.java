package com.sec.chaton.buddy;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2246g;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.widget.C5179v;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fu */
/* loaded from: classes.dex */
class C1314fu implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4850a;

    C1314fu(BuddyProfileFragment buddyProfileFragment) {
        this.f4850a = buddyProfileFragment;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        if (!z) {
            this.f4850a.m6832j();
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C2212z.m10068a(new C2212z(), 2, new C2246g(this.f4850a.f4001h, this.f4850a.f4012s, 2, true));
                    return;
                } else {
                    C2212z.m10068a(new C2212z(), 2, new C2246g(this.f4850a.f4001h, this.f4850a.f4012s, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            this.f4850a.m6832j();
            C5179v.m19811a(this.f4850a.getActivity(), this.f4850a.getActivity().getResources().getString(R.string.buddy_profile_block_toast_success, this.f4850a.f4014u), 0).show();
            FragmentActivity activity = this.f4850a.getActivity();
            this.f4850a.getActivity();
            activity.setResult(-1);
            this.f4850a.getActivity().finish();
        }
    }
}
