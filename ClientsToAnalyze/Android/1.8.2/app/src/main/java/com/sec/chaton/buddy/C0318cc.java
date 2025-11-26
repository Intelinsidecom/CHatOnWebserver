package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.C0692g;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.cc */
/* loaded from: classes.dex */
class C0318cc implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f1437a;

    C0318cc(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1437a = buddyGroupEditActivity;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        if (z) {
            if (i == 1) {
                this.f1437a.setResult(-1);
                this.f1437a.finish();
                return;
            }
            if (i == 3) {
                if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_name", this.f1437a.f1048P);
                    this.f1437a.f1046N.startUpdate(1, this.f1437a.f1048P, C0692g.f2614a, contentValues, "_id = ? ", new String[]{String.valueOf(this.f1437a.f1057j.m2313a())});
                    return;
                }
                Toast.makeText(this.f1437a, this.f1437a.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
                return;
            }
            if (i == 2) {
                this.f1437a.getSupportLoaderManager().restartLoader(this.f1437a.f1047O, null, this.f1437a.f1061n);
                this.f1437a.m2085d();
            } else if (i == 4) {
                this.f1437a.finish();
            }
        }
    }
}
