package com.sec.chaton.buddy;

import android.content.Intent;
import android.database.Cursor;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1416g;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.widget.C3641ai;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cb */
/* loaded from: classes.dex */
class C0571cb implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2533a;

    C0571cb(BuddyFragment buddyFragment) {
        this.f2533a = buddyFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (!z) {
            this.f2533a.m3264Z();
            return;
        }
        if (i == 1) {
            if (obj instanceof Cursor) {
                Cursor cursor = (Cursor) obj;
                if (cursor.getCount() > 0) {
                    cursor.close();
                    C1379w.m6203a(new C1379w(), 2, new C1416g(this.f2533a.f1887r, this.f2533a.f1802an, 2, true));
                    return;
                } else {
                    C1379w.m6203a(new C1379w(), 2, new C1416g(this.f2533a.f1887r, this.f2533a.f1802an, 2, false));
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            if (this.f2533a.getActivity() != null) {
                this.f2533a.m3264Z();
                C3641ai.m13211a(this.f2533a.getActivity(), this.f2533a.getResources().getString(R.string.buddy_profile_block_toast_success, this.f2533a.f1802an.m3976c()), 0).show();
                this.f2533a.f1804ap.m4054b();
                return;
            }
            return;
        }
        if (i == 3) {
            if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0 || this.f2533a.f1791ac == 10 || this.f2533a.f1791ac != 11) {
            }
            return;
        }
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent();
            intent.putExtra(EmptyFragment.f2243c, EmptyFragment.f2241a);
            ((TabActivity) this.f2533a.getActivity()).m1312a(R.id.fragment_buddy, intent, EmptyFragment.class);
            this.f2533a.f1803ao.m4032a(-1, -1);
        }
    }
}
