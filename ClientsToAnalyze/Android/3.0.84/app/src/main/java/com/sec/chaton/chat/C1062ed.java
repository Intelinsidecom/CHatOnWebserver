package com.sec.chaton.chat;

import com.sec.chaton.R;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.ed */
/* loaded from: classes.dex */
class C1062ed implements InterfaceC1413d {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1060eb f4180a;

    C1062ed(AlertDialogC1060eb alertDialogC1060eb) {
        this.f4180a = alertDialogC1060eb;
    }

    @Override // com.sec.chaton.p027e.p029b.InterfaceC1413d
    /* renamed from: a */
    public void mo4048a(int i, boolean z, Object obj) {
        if (z) {
            if (i == 3) {
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                    if (this.f4180a.f4173c.f3760b == null || this.f4180a.f4173c.getResources() == null) {
                        return;
                    }
                    AbstractC3271a.m11494a(this.f4180a.f4173c.f3760b).mo11495a(R.string.pop_up_attention).mo11509b(this.f4180a.f4174d.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f4180a.f4175e.m11463a().toString())).mo11515d(R.string.dialog_ok, null).mo11512b();
                    return;
                }
                this.f4180a.m5269a(this.f4180a.f4175e.m11463a().toString());
                return;
            }
            if (i == 2) {
                if (this.f4180a.f4173c.f3767i.size() == this.f4180a.f4173c.f3765g.length) {
                    if (C1370n.m6145i(this.f4180a.f4173c.getActivity().getContentResolver(), this.f4180a.f4173c.f3762d)) {
                        C3250y.m11453c("already exist relation inbox:" + this.f4180a.f4173c.f3762d, this.f4180a.f4171a);
                    } else {
                        C1370n.m6118a(this.f4180a.f4173c.getActivity().getContentResolver(), this.f4180a.f4173c.f3762d, ((Integer) obj).intValue(), EnumC1450r.m6339a(this.f4180a.f4173c.f3764f));
                    }
                }
                this.f4180a.f4174d.finish();
                if (this.f4180a.f4173c.f3760b != null && this.f4180a.f4173c.getResources() != null) {
                    C3641ai.m13211a(this.f4180a.f4176f, this.f4180a.f4173c.getResources().getString(R.string.buddy_new_group_created), 0).show();
                }
            }
        }
    }
}
