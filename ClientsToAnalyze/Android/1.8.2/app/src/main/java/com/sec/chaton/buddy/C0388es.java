package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: GroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.es */
/* loaded from: classes.dex */
class C0388es implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ GroupProfileFragment f1546a;

    C0388es(GroupProfileFragment groupProfileFragment) {
        this.f1546a = groupProfileFragment;
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
            C1786r.m6067f("onUpdateComplete()", GroupProfileFragment.f1212a);
            C2153y.m7535a(this.f1546a.f1217f, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            this.f1546a.f1221j.setText((String) obj);
        }
        this.f1546a.f1226o.m2037a(false);
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
