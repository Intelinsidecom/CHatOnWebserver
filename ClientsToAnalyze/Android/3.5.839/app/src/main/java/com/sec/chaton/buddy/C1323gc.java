package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.net.Uri;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0993ac;
import com.sec.chaton.EnumC1005ad;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.widget.C5179v;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.gc */
/* loaded from: classes.dex */
class C1323gc implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4859a;

    C1323gc(BuddyProfileFragment buddyProfileFragment) {
        this.f4859a = buddyProfileFragment;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0623, code lost:
    
        r32.f4859a.f4015v = r2;
     */
    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo7100a(int r33, java.lang.Object r34, android.database.Cursor r35) {
        /*
            Method dump skipped, instructions count: 1715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.C1323gc.mo7100a(int, java.lang.Object, android.database.Cursor):void");
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
        if (i == 1) {
            C1106c c1106c = (C1106c) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                this.f4859a.f4009p.setText(this.f4859a.getString(R.string.buddy_profile_addfavorites_toast_success, c1106c.m7051b()));
                this.f4859a.f4009p.setDuration(0);
                this.f4859a.f4009p.show();
                this.f4859a.f4017x = true;
                this.f4859a.m6857a(this.f4859a.f4017x);
                return;
            }
            C5179v.m19811a(this.f4859a.f3954aU, this.f4859a.getResources().getString(R.string.buddy_profile_addfavorites_toast_failed), 0).show();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (i == 2) {
            C1106c c1106c = (C1106c) obj;
            if (i2 != -1) {
                this.f4859a.f4009p.setText(R.string.buddy_list_removefavorites_toast_success);
                this.f4859a.f4009p.setDuration(0);
                this.f4859a.f4009p.show();
                this.f4859a.f4017x = false;
                this.f4859a.m6857a(this.f4859a.f4017x);
                C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.REMOVE_FAVORITE, c1106c.m7046a()));
                return;
            }
            C5179v.m19811a(this.f4859a.f3954aU, this.f4859a.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
        }
    }
}
