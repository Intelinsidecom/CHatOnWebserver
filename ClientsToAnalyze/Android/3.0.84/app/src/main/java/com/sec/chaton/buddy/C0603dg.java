package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dg */
/* loaded from: classes.dex */
class C0603dg implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0599dc f2595a;

    C0603dg(AlertDialogC0599dc alertDialogC0599dc) {
        this.f2595a = alertDialogC0599dc;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (z && i == 3) {
            if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                this.f2595a.m4076e();
                AbstractC3271a.m11494a(this.f2595a.f2588k).mo11495a(R.string.pop_up_attention).mo11509b(this.f2595a.f2581d.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f2595a.f2587j.m11463a().toString())).mo11515d(R.string.dialog_ok, null).mo11512b();
                return;
            }
            String strReplace = this.f2595a.f2587j.m11463a().toString().trim().replace(",", "");
            if (this.f2595a.f2583f == null || this.f2595a.f2583f.length <= 0) {
                this.f2595a.m4076e();
                Intent intent = new Intent(this.f2595a.f2588k, (Class<?>) BuddyActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 10);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", this.f2595a.f2587j.m11463a().toString());
                if (this.f2595a.f2586i) {
                    intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                }
                this.f2595a.f2581d.startActivity(intent);
                return;
            }
            int iM6733a = C1594v.m6733a(GlobalApplication.m11493l());
            if (-3 == iM6733a || -2 == iM6733a) {
                C3641ai.m13210a(this.f2595a.f2581d, R.string.popup_no_network_connection, 0).show();
                this.f2595a.m4076e();
            } else {
                new C1330h(this.f2595a.f2590m).m5716a("group", false, (String) null, strReplace, this.f2595a.f2583f, 325);
                this.f2595a.m4074d();
            }
        }
    }
}
