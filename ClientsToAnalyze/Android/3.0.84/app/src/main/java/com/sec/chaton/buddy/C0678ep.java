package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.ep */
/* loaded from: classes.dex */
class C0678ep implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f2900a;

    C0678ep(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f2900a = buddyProfileEditNameActivity;
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
            C3250y.m11458g("onUpdateComplete()", BuddyProfileEditNameActivity.f1999a);
            C3641ai.m13210a(this.f2900a.f2004f, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            this.f2900a.f2005g.setText((String) obj);
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
