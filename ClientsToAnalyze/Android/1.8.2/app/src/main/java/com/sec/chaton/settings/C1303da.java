package com.sec.chaton.settings;

import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;

/* compiled from: RelationHideFragment.java */
/* renamed from: com.sec.chaton.settings.da */
/* loaded from: classes.dex */
class C1303da implements InterfaceC0667k {

    /* renamed from: a */
    final /* synthetic */ RelationHideFragment f4870a;

    C1303da(RelationHideFragment relationHideFragment) {
        this.f4870a = relationHideFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (i == 0) {
            if (i2 != 1) {
                Toast.makeText(this.f4870a.f4710g, this.f4870a.getResources().getString(R.string.buddy_profile_saveprofile_toast_failed), 1).show();
                return;
            }
            this.f4870a.f4707d = this.f4870a.f4714k.query(C0688c.f2606a, null, "buddy_relation_hide = 'Y' ", null, null);
            if (this.f4870a.f4707d.getCount() == 0) {
                this.f4870a.f4711h.setVisibility(8);
                this.f4870a.f4715l.setVisibility(0);
            }
            this.f4870a.m4687a(this.f4870a.f4707d);
            this.f4870a.f4713j.notifyDataSetChanged();
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
