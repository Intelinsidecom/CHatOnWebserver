package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.util.C3205bt;
import com.sec.common.CommonApplication;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.ii */
/* loaded from: classes.dex */
class C0779ii extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyRecommendListFragment f3051a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0779ii(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment, Handler handler) {
        super(handler);
        this.f3051a = specialBuddyRecommendListFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1388af.f5186a, null, "type='100'", null, "buddy_name ASC");
        this.f3051a.f2332k = cursorQuery.getCount();
        if (this.f3051a.f2325d != null) {
            this.f3051a.f2325d.notifyDataSetChanged();
        }
        if (this.f3051a.f2332k == 0) {
            this.f3051a.f2335n.setVisibility(8);
            if (this.f3051a.f2326e != null) {
                this.f3051a.f2326e.setEmptyView(this.f3051a.f2327f);
            }
            this.f3051a.f2332k = 0;
            this.f3051a.f2331j.clear();
        } else {
            this.f3051a.f2331j.clear();
            while (cursorQuery != null && cursorQuery.moveToNext()) {
                C0784in c0784in = new C0784in(this.f3051a, cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no")), cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name")));
                if (cursorQuery.getCount() == 1) {
                    this.f3051a.f2335n.setVisibility(0);
                    C3205bt.m11182a(this.f3051a.f2337p).m11210a(this.f3051a.f2335n, c0784in.f3056a);
                }
                this.f3051a.f2331j.add(c0784in);
            }
        }
        cursorQuery.close();
    }
}
