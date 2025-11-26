package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.cb */
/* loaded from: classes.dex */
class C0317cb implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditActivity f1436a;

    C0317cb(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1436a = buddyGroupEditActivity;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                C1786r.m6067f("onUpdateComplete()", BuddyGroupEditActivity.f1032a);
                C1786r.m6067f(this.f1436a.f1040H.toString() + " : " + this.f1436a.f1040H.getVisibility(), BuddyGroupEditActivity.f1032a);
                this.f1436a.f1040H.setVisibility(8);
                C1786r.m6067f(this.f1436a.f1040H.toString() + " : " + this.f1436a.f1040H.getVisibility(), BuddyGroupEditActivity.f1032a);
                Toast.makeText(this.f1436a.f1062o, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
                this.f1436a.f1057j.m2315a((String) obj);
                this.f1436a.f1063p.setText(this.f1436a.f1057j.m2316b());
                this.f1436a.f1038F.setText(this.f1436a.f1057j.m2316b());
                C1786r.m6067f(this.f1436a.f1038F.toString() + " : " + this.f1436a.f1038F.getVisibility(), BuddyGroupEditActivity.f1032a);
                this.f1436a.f1038F.setVisibility(0);
                C1786r.m6067f(this.f1436a.f1038F.toString() + " : " + this.f1436a.f1038F.getVisibility(), BuddyGroupEditActivity.f1032a);
            }
            this.f1436a.m2085d();
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
