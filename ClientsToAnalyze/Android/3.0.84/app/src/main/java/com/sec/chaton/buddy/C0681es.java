package com.sec.chaton.buddy;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1416g;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.widget.C3641ai;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.es */
/* loaded from: classes.dex */
class C0681es implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2903a;

    C0681es(BuddyProfileFragment buddyProfileFragment) {
        this.f2903a = buddyProfileFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (!z) {
            this.f2903a.m3685m();
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C1379w.m6203a(new C1379w(), 2, new C1416g(this.f2903a.f2104g, this.f2903a.f2116s, 2, true));
                    return;
                } else {
                    C1379w.m6203a(new C1379w(), 2, new C1416g(this.f2903a.f2104g, this.f2903a.f2116s, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            this.f2903a.m3685m();
            C3641ai.m13211a(this.f2903a.getActivity(), this.f2903a.getActivity().getResources().getString(R.string.buddy_profile_block_toast_success, this.f2903a.f2118u), 0).show();
            FragmentActivity activity = this.f2903a.getActivity();
            this.f2903a.getActivity();
            activity.setResult(-1);
            this.f2903a.getActivity().finish();
        }
    }
}
