package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.common.CommonApplication;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.in */
/* loaded from: classes.dex */
class C1388in extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyRecommendListFragment f4994a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1388in(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment, Handler handler) {
        super(handler);
        this.f4994a = specialBuddyRecommendListFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2228ap.f7956a, null, "type='100'", null, "buddy_name ASC");
        this.f4994a.f4177j = cursorQuery.getCount();
        if (this.f4994a.f4170c != null) {
            this.f4994a.f4170c.notifyDataSetChanged();
        }
        if (this.f4994a.f4177j == 0) {
            this.f4994a.f4180m.setVisibility(8);
            if (this.f4994a.f4171d != null) {
                this.f4994a.f4171d.setEmptyView(this.f4994a.f4172e);
            }
            this.f4994a.f4177j = 0;
            this.f4994a.f4176i.clear();
        } else {
            this.f4994a.f4176i.clear();
            while (cursorQuery != null && cursorQuery.moveToNext()) {
                C1391iq c1391iq = new C1391iq(this.f4994a, cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no")), cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name")));
                if (cursorQuery.getCount() == 1) {
                    this.f4994a.f4180m.setVisibility(0);
                    C2496n.m10765a(this.f4994a.f4180m, c1391iq.f4997a, EnumC2498p.ROUND);
                }
                this.f4994a.f4176i.add(c1391iq);
            }
        }
        cursorQuery.close();
    }
}
