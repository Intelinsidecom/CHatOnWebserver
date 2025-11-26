package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;

/* compiled from: BuddyGroupProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.ag */
/* loaded from: classes.dex */
class C0372ag implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileActivity f1340a;

    C0372ag(BuddyGroupProfileActivity buddyGroupProfileActivity) {
        this.f1340a = buddyGroupProfileActivity;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
        if (i == 1 && i2 == 1) {
            C1341p.m4663f("onUpdateComplete()", BuddyGroupProfileActivity.f1176a);
            C1619g.m5888a(this.f1340a.f1183i, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            this.f1340a.f1181f.m2348a((String) obj);
            this.f1340a.f1184j.setText(this.f1340a.f1181f.m2349b());
            this.f1340a.f1180e.setText(this.f1340a.getString(R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(this.f1340a.f1193s)}));
            this.f1340a.f1180e.setButtonEnabled(true);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
    }
}
