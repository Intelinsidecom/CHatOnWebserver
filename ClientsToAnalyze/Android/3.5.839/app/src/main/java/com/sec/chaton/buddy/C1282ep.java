package com.sec.chaton.buddy;

import android.content.ContentValues;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2294n;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ep */
/* loaded from: classes.dex */
class C1282ep implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4815a;

    C1282ep(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f4815a = buddyGroupProfileFragment;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        switch (i) {
            case 1:
                this.f4815a.f3801P.finish();
                break;
            case 2:
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                    if (this.f4815a.f3827x == null) {
                        this.f4815a.f3827x = C5179v.m19811a(this.f4815a.f3801P, this.f4815a.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f4815a.f3825v), 0);
                    }
                    this.f4815a.f3827x.show();
                    break;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_name", this.f4815a.f3825v);
                    this.f4815a.f3826w.startUpdate(1, this.f4815a.f3825v, C2294n.f8205a, contentValues, "_id = ? ", new String[]{String.valueOf(this.f4815a.f3812i.m7034a())});
                    break;
                }
                break;
        }
    }
}
