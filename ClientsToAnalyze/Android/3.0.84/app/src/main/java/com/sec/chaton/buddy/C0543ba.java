package com.sec.chaton.buddy;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.widget.C3641ai;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.ba */
/* loaded from: classes.dex */
class C0543ba implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f2502a;

    C0543ba(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f2502a = buddyEditNickNameFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (i == 1) {
            if (i2 != 1) {
                this.f2502a.f1720m.finish();
                return;
            }
            C3641ai.m13210a(this.f2502a.f1709b, R.string.buddy_group_edit_renamegroup_toast_success, 0).show();
            Bundle bundle = new Bundle();
            Intent intent = this.f2502a.f1720m.getIntent();
            bundle.putString("PROFILE_GROUP_RENAME", this.f2502a.f1712e.getText().toString().trim());
            intent.putExtras(bundle);
            this.f2502a.f1720m.setResult(-1, intent);
            this.f2502a.f1720m.finish();
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
