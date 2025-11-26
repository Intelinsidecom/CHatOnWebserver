package com.sec.chaton.buddy;

import android.content.ContentValues;
import com.sec.chaton.R;
import com.sec.chaton.p027e.C1446n;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.widget.C3641ai;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dt */
/* loaded from: classes.dex */
class C0655dt implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f2874a;

    C0655dt(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f2874a = buddyGroupProfileFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        switch (i) {
            case 1:
                this.f2874a.f1923O.finish();
                break;
            case 2:
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                    if (this.f2874a.f1948w == null) {
                        this.f2874a.f1948w = C3641ai.m13211a(this.f2874a.f1923O, this.f2874a.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f2874a.f1946u), 0);
                    }
                    this.f2874a.f1948w.show();
                    break;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_name", this.f2874a.f1946u);
                    this.f2874a.f1947v.startUpdate(1, this.f2874a.f1946u, C1446n.f5378a, contentValues, "_id = ? ", new String[]{String.valueOf(this.f2874a.f1932g.m3960a())});
                    break;
                }
                break;
        }
    }
}
