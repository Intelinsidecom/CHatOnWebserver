package com.sec.chaton.chat;

import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.fr */
/* loaded from: classes.dex */
class C1718fr implements InterfaceC2243d {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1716fp f6329a;

    C1718fr(AlertDialogC1716fp alertDialogC1716fp) {
        this.f6329a = alertDialogC1716fp;
    }

    @Override // com.sec.chaton.p057e.p059b.InterfaceC2243d
    /* renamed from: a */
    public void mo7130a(int i, boolean z, Object obj) throws Resources.NotFoundException {
        if (z) {
            if (i == 3) {
                if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 0) {
                    if (this.f6329a.f6323c.f5817b == null || this.f6329a.f6323c.getResources() == null) {
                        return;
                    }
                    AbstractC4932a.m18733a(this.f6329a.f6323c.f5817b).mo18734a(R.string.pop_up_attention).mo18749b(this.f6329a.f6323c.f5817b.getResources().getString(R.string.buddy_group_list_addgroup_toast_exist, this.f6329a.f6324d.m18658a().toString())).mo18756d(R.string.dialog_ok, null).mo18752b();
                    return;
                }
                this.f6329a.m8536a(this.f6329a.f6324d.m18658a().toString());
                return;
            }
            if (i == 2) {
                if (EnumC2300t.m10207a(this.f6329a.f6323c.f5820e) == EnumC2300t.GROUPCHAT && this.f6329a.f6323c.f5823h.size() == this.f6329a.f6323c.f5821f.length && this.f6329a.f6323c.f5824i.size() == 0) {
                    if (C2198l.m9959l(GlobalApplication.m18732r().getContentResolver(), this.f6329a.f6323c.f5818c)) {
                        C4904y.m18641c("already exist relation inbox:" + this.f6329a.f6323c.f5818c, this.f6329a.f6321a);
                    } else {
                        C2198l.m9923a(GlobalApplication.m18732r().getContentResolver(), this.f6329a.f6323c.f5818c, ((Integer) obj).intValue(), EnumC2300t.m10207a(this.f6329a.f6323c.f5820e));
                    }
                }
                this.f6329a.f6323c.m8341d();
                ((InterfaceC1722fv) this.f6329a.f6323c.getActivity()).mo8333h();
                if (this.f6329a.f6323c.f5817b != null && this.f6329a.f6323c.getResources() != null) {
                    C5179v.m19811a(this.f6329a.f6325e, this.f6329a.f6323c.getResources().getString(R.string.buddy_new_group_created), 0).show();
                }
            }
        }
    }
}
