package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1013al;
import com.sec.chaton.EnumC1014am;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ev */
/* loaded from: classes.dex */
class C1288ev implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4821a;

    C1288ev(BuddyGroupProfileFragment buddyGroupProfileFragment) {
        this.f4821a = buddyGroupProfileFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        if (i == 1 && i2 == 1) {
            C4904y.m18639b("onUpdateComplete()", BuddyGroupProfileFragment.f3785a);
            C5179v.m19810a(this.f4821a.f3801P, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            this.f4821a.f3812i.m7035a((String) obj);
            this.f4821a.f3820q.setText(this.f4821a.f3812i.m7036b());
            C0991aa.m6037a().m18962d(C1013al.m6086a(EnumC1014am.NAME_CHANGED));
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
