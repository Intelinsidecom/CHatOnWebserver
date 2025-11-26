package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.co */
/* loaded from: classes.dex */
class C0330co implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f1472a;

    C0330co(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f1472a = buddyProfileEditNameActivity;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (i == 1 && i2 == 1) {
            C1786r.m6067f("onUpdateComplete()", BuddyProfileEditNameActivity.f1074a);
            C2153y.m7535a(this.f1472a.f1079i, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            this.f1472a.f1080j.setText((String) obj);
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
