package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.dy */
/* loaded from: classes.dex */
class C0660dy implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f2879a;

    C0660dy(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f2879a = buddyGroupProfileFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (i == 1 && i2 == 1) {
            C3250y.m11458g("onUpdateComplete()", BuddyGroupProfileFragment.f1908a);
            C3641ai.m13210a(this.f2879a.f1923O, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            this.f2879a.f1932g.m3961a((String) obj);
            this.f2879a.f1940o.setText(this.f2879a.f1932g.m3962b());
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
