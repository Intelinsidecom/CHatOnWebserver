package com.sec.chaton.settings;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.widget.C1619g;

/* compiled from: RelationHideFragment.java */
/* renamed from: com.sec.chaton.settings.bg */
/* loaded from: classes.dex */
class C1036bg implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ RelationHideFragment f3640a;

    C1036bg(RelationHideFragment relationHideFragment) {
        this.f3640a = relationHideFragment;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        if (this.f3640a.f3584k != null && this.f3640a.f3584k.getCount() != 0) {
            this.f3640a.f3584k.notifyDataSetChanged();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
        if (i == 0) {
            if (i2 != 1) {
                C1619g.m5889a(this.f3640a.f3581h, this.f3640a.getResources().getString(R.string.buddy_profile_saveprofile_toast_failed), 1).show();
                return;
            }
            this.f3640a.f3578e = this.f3640a.f3585l.query(C0667t.f2310a, null, "buddy_relation_hide = 'Y' ", null, null);
            if (this.f3640a.f3578e.getCount() == 0) {
                this.f3640a.f3582i.setVisibility(8);
                this.f3640a.f3586m.setVisibility(0);
            }
            this.f3640a.m3893a(this.f3640a.f3578e);
            this.f3640a.f3584k.notifyDataSetChanged();
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
    }
}
