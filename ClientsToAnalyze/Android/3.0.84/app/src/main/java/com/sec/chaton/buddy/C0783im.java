package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3205bt;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.im */
/* loaded from: classes.dex */
class C0783im implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyRecommendListFragment f3055a;

    C0783im(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment) {
        this.f3055a = specialBuddyRecommendListFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        this.f3055a.f2328g.dismiss();
        if (cursor == null) {
            this.f3055a.f2335n.setVisibility(8);
        }
        while (cursor != null && cursor.moveToNext()) {
            C0784in c0784in = new C0784in(this.f3055a, cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")));
            this.f3055a.f2332k = cursor.getCount();
            if (this.f3055a.f2332k == 0) {
                this.f3055a.f2335n.setVisibility(8);
                if (this.f3055a.f2326e != null) {
                    this.f3055a.f2326e.setEmptyView(this.f3055a.f2327f);
                }
            } else if (this.f3055a.f2332k == 1) {
                C3205bt.m11182a(this.f3055a.f2337p).m11210a(this.f3055a.f2335n, c0784in.f3056a);
            }
            this.f3055a.f2331j.add(c0784in);
        }
        if (this.f3055a.f2325d != null) {
            this.f3055a.f2325d.notifyDataSetChanged();
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
