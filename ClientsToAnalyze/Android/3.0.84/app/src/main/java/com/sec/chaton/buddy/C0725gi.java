package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gi */
/* loaded from: classes.dex */
class C0725gi implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2969a;

    C0725gi(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2969a = buddyRecommendFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
        C3250y.m11459h("onUpdateComplete", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        C3250y.m11459h("onQueryComplete", getClass().getSimpleName());
        try {
            if (!this.f2969a.f2205r && this.f2969a.f2178J != null) {
                switch (i) {
                    case 1:
                        this.f2969a.f2200m = cursor.getCount();
                        if (this.f2969a.f2190c != null) {
                            this.f2969a.f2190c.notifyDataSetChanged();
                        }
                        if (this.f2969a.f2200m <= 0) {
                            this.f2969a.f2191d.removeFooterView(this.f2969a.f2180L);
                            this.f2969a.f2191d.addFooterView(this.f2969a.f2180L);
                            break;
                        } else {
                            this.f2969a.f2191d.removeFooterView(this.f2969a.f2180L);
                            break;
                        }
                    case 2:
                        if (cursor.getCount() != 0) {
                            this.f2969a.f2213z.setVisibility(0);
                            this.f2969a.f2169A.setOnClickListener(this.f2969a.f2182N);
                            this.f2969a.f2171C.removeAllViews();
                            this.f2969a.m3773a(cursor, obj);
                            break;
                        } else {
                            this.f2969a.f2213z.setVisibility(8);
                            break;
                        }
                    default:
                        if (cursor != null) {
                            cursor.close();
                            break;
                        }
                        break;
                }
                if (cursor == null) {
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
        C3250y.m11459h("onInsertComplete", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
        C3250y.m11459h("onDeleteComplete", getClass().getSimpleName());
    }
}
