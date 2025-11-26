package com.sec.chaton.buddy;

import android.content.ContentValues;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C0661n;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.widget.C1619g;

/* compiled from: BuddyGroupProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.aj */
/* loaded from: classes.dex */
class C0375aj implements InterfaceC0641d {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileActivity f1343a;

    C0375aj(BuddyGroupProfileActivity buddyGroupProfileActivity) {
        this.f1343a = buddyGroupProfileActivity;
    }

    @Override // com.sec.chaton.p025d.p027b.InterfaceC0641d
    /* renamed from: a */
    public void mo2364a(int i, boolean z, Object obj) {
        switch (i) {
            case 1:
                this.f1343a.finish();
                break;
            case 2:
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                    if (this.f1343a.f1188n == null) {
                        this.f1343a.f1188n = C1619g.m5889a(this.f1343a.f1183i, this.f1343a.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0);
                    }
                    this.f1343a.f1188n.show();
                    break;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_name", this.f1343a.f1186l);
                    this.f1343a.f1187m.startUpdate(1, this.f1343a.f1186l, C0661n.f2288a, contentValues, "_id = ? ", new String[]{String.valueOf(this.f1343a.f1181f.m2347a())});
                    break;
                }
                break;
        }
    }
}
