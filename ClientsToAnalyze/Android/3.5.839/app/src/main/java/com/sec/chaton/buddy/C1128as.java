package com.sec.chaton.buddy;

import android.content.ContentValues;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2294n;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: BuddyEditNickNameFragment.java */
/* renamed from: com.sec.chaton.buddy.as */
/* loaded from: classes.dex */
class C1128as implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ BuddyEditNickNameFragment f4346a;

    C1128as(BuddyEditNickNameFragment buddyEditNickNameFragment) {
        this.f4346a = buddyEditNickNameFragment;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        switch (i) {
            case 2:
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                    if (this.f4346a.f3568k.isShowing()) {
                        this.f4346a.f3568k.dismiss();
                    }
                    AbstractC4932a.m18733a(this.f4346a.f3571n).mo18734a(R.string.pop_up_attention).mo18749b(this.f4346a.f3571n.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f4346a.f3562e.getText().toString().trim())).mo18756d(R.string.dialog_ok, null).mo18752b();
                    break;
                } else {
                    ContentValues contentValues = new ContentValues();
                    String strTrim = this.f4346a.f3562e.getText().toString().trim();
                    contentValues.put("group_name", strTrim);
                    this.f4346a.f3567j.startUpdate(1, strTrim, C2294n.f8205a, contentValues, "_id = ? ", new String[]{this.f4346a.f3565h});
                    break;
                }
                break;
            case 3:
                this.f4346a.f3571n.finish();
                break;
        }
    }
}
