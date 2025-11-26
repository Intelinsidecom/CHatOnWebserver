package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.ip */
/* loaded from: classes.dex */
class C1390ip implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyRecommendListFragment f4996a;

    C1390ip(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment) {
        this.f4996a = specialBuddyRecommendListFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        this.f4996a.f4173f.dismiss();
        if (cursor == null) {
            this.f4996a.f4180m.setVisibility(8);
        }
        while (cursor != null && cursor.moveToNext()) {
            C1391iq c1391iq = new C1391iq(this.f4996a, cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")));
            this.f4996a.f4177j = cursor.getCount();
            if (this.f4996a.f4177j == 0) {
                this.f4996a.f4180m.setVisibility(8);
                if (this.f4996a.f4171d != null) {
                    this.f4996a.f4171d.setEmptyView(this.f4996a.f4172e);
                }
            } else if (this.f4996a.f4177j == 1) {
                C2496n.m10765a(this.f4996a.f4180m, c1391iq.f4997a, EnumC2498p.ROUND);
            }
            this.f4996a.f4176i.add(c1391iq);
        }
        if (this.f4996a.f4170c != null) {
            this.f4996a.f4170c.notifyDataSetChanged();
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
