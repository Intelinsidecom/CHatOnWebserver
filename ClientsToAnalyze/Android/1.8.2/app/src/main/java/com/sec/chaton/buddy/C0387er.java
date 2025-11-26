package com.sec.chaton.buddy;

import android.content.ContentValues;
import com.sec.chaton.R;
import com.sec.chaton.p017e.C0692g;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.widget.C2153y;

/* compiled from: GroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.er */
/* loaded from: classes.dex */
class C0387er implements InterfaceC0677d {

    /* renamed from: a */
    final /* synthetic */ GroupProfileFragment f1545a;

    C0387er(GroupProfileFragment groupProfileFragment) {
        this.f1545a = groupProfileFragment;
    }

    @Override // com.sec.chaton.p017e.p019b.InterfaceC0677d
    /* renamed from: a */
    public void mo2365a(int i, boolean z, Object obj) {
        switch (i) {
            case 153:
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                    if (this.f1545a.f1233v == null) {
                        this.f1545a.f1233v = C2153y.m7536a(this.f1545a.f1217f, this.f1545a.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0);
                    }
                    this.f1545a.f1233v.show();
                    break;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_name", this.f1545a.f1231t);
                    this.f1545a.f1232u.startUpdate(1, this.f1545a.f1231t, C0692g.f2614a, contentValues, "_id = ? ", new String[]{String.valueOf(Long.parseLong(this.f1545a.f1229r))});
                    break;
                }
                break;
        }
    }
}
