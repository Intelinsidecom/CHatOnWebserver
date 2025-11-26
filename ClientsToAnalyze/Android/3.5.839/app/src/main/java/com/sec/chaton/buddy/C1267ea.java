package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.ea */
/* loaded from: classes.dex */
class C1267ea implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1262dw f4800a;

    C1267ea(AlertDialogC1262dw alertDialogC1262dw) {
        this.f4800a = alertDialogC1262dw;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) {
        if (z && i == 3) {
            if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                this.f4800a.m7426e();
                AbstractC4932a.m18733a(this.f4800a.f4792k).mo18734a(R.string.pop_up_attention).mo18749b(this.f4800a.f4785d.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f4800a.f4786e)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1268eb(this)).mo18752b();
                return;
            }
            String strReplace = this.f4800a.f4791j.m18658a().toString().trim().replace(",", "");
            if (this.f4800a.f4787f == null || this.f4800a.f4787f.length <= 0) {
                this.f4800a.m7426e();
                Intent intent = new Intent(this.f4800a.f4792k, (Class<?>) BuddyActivity2.class);
                intent.putExtra("ACTIVITY_PURPOSE", 10);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", strReplace);
                if (this.f4800a.f4790i) {
                    intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                }
                this.f4800a.f4785d.startActivity(intent);
                return;
            }
            int iM10677a = C2471v.m10677a(GlobalApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f4800a.f4785d, R.string.popup_no_network_connection, 0).show();
                this.f4800a.m7426e();
            } else {
                new C2128i(this.f4800a.f4794m).m9489a("group", false, (String) null, strReplace, this.f4800a.f4787f, 325);
                this.f4800a.m7424d();
            }
        }
    }
}
