package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.widget.C3641ai;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fa */
/* loaded from: classes.dex */
class C0690fa implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2912a;

    C0690fa(BuddyProfileFragment buddyProfileFragment) {
        this.f2912a = buddyProfileFragment;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0587, code lost:
    
        r30.f2912a.f2119v = r2;
     */
    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onQueryComplete(int r31, java.lang.Object r32, android.database.Cursor r33) {
        /*
            Method dump skipped, instructions count: 1587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.C0690fa.onQueryComplete(int, java.lang.Object, android.database.Cursor):void");
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
        if (i == 1) {
            C0513c c0513c = (C0513c) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                this.f2912a.f2113p.setText(this.f2912a.getString(R.string.buddy_profile_addfavorites_toast_success, c0513c.m3976c()));
                this.f2912a.f2113p.setDuration(0);
                this.f2912a.f2113p.show();
                this.f2912a.f2121x = true;
                if (GlobalApplication.m6456e()) {
                    this.f2912a.m3677j();
                }
                this.f2912a.m3718a(this.f2912a.f2121x);
                return;
            }
            C3641ai.m13211a(this.f2912a.f2058aQ, this.f2912a.getResources().getString(R.string.buddy_profile_addfavorites_toast_failed), 0).show();
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (i == 2) {
            if (i2 != -1) {
                this.f2912a.f2113p.setText(R.string.buddy_list_removefavorites_toast_success);
                this.f2912a.f2113p.setDuration(0);
                this.f2912a.f2113p.show();
                this.f2912a.f2121x = false;
                if (GlobalApplication.m6456e()) {
                    this.f2912a.m3677j();
                }
                this.f2912a.m3718a(this.f2912a.f2121x);
                return;
            }
            C3641ai.m13211a(this.f2912a.f2058aQ, this.f2912a.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
        }
    }
}
