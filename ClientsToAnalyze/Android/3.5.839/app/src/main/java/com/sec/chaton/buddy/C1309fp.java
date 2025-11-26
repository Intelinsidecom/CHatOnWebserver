package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.fp */
/* loaded from: classes.dex */
class C1309fp implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f4845a;

    C1309fp(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f4845a = buddyProfileEditNameActivity;
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
            C4904y.m18639b("onUpdateComplete()", BuddyProfileEditNameActivity.f3891n);
            C5179v.m19810a(this.f4845a.f3898s, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            this.f4845a.f3899t.setText((String) obj);
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
