package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.R;
import com.sec.chaton.p027e.C1446n;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.aw */
/* loaded from: classes.dex */
class C0538aw implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f2497a;

    C0538aw(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f2497a = buddyEditNickNameFragment;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        switch (i) {
            case 1:
                LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("buddy_tab_name_update"));
                break;
            case 2:
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                    if (this.f2497a.f1717j.isShowing()) {
                        this.f2497a.f1717j.dismiss();
                    }
                    AbstractC3271a.m11494a(this.f2497a.f1720m).mo11495a(R.string.pop_up_attention).mo11509b(this.f2497a.f1720m.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f2497a.f1712e.getText().toString().trim())).mo11515d(R.string.dialog_ok, null).mo11512b();
                    break;
                } else {
                    ContentValues contentValues = new ContentValues();
                    String strTrim = this.f2497a.f1712e.getText().toString().trim();
                    contentValues.put("group_name", strTrim);
                    this.f2497a.f1716i.startUpdate(1, strTrim, C1446n.f5378a, contentValues, "_id = ? ", new String[]{this.f2497a.f1714g});
                    break;
                }
                break;
            case 3:
                this.f2497a.f1720m.finish();
                break;
        }
    }
}
