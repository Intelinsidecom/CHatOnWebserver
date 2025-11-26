package com.sec.chaton.buddy;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.widget.C5179v;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.aw */
/* loaded from: classes.dex */
class C1132aw implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f4350a;

    C1132aw(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f4350a = buddyEditNickNameFragment;
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
        if (i == 1) {
            if (i2 != 1) {
                this.f4350a.f3571n.finish();
                return;
            }
            C5179v.m19810a(this.f4350a.f3559b, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            Bundle bundle = new Bundle();
            Intent intent = this.f4350a.f3571n.getIntent();
            bundle.putString("PROFILE_GROUP_RENAME", this.f4350a.f3562e.getText().toString().trim());
            intent.putExtras(bundle);
            this.f4350a.f3571n.setResult(-1, intent);
            this.f4350a.f3571n.finish();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
